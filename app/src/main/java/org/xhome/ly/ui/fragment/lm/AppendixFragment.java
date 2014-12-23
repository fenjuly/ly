package org.xhome.ly.ui.fragment.lm;

import android.app.ProgressDialog;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.daimajia.numberprogressbar.NumberProgressBar;
import com.dd.CircularProgressButton;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.kbeanie.imagechooser.api.ChooserType;
import com.kbeanie.imagechooser.api.ChosenImage;
import com.kbeanie.imagechooser.api.ImageChooserListener;
import com.kbeanie.imagechooser.api.ImageChooserManager;
import com.rengwuxian.materialedittext.MaterialEditText;

import org.json.JSONException;
import org.json.JSONObject;
import org.xhome.ly.R;
import org.xhome.ly.api.Api;
import org.xhome.ly.bean.Case1;
import org.xhome.ly.bean.Response;
import org.xhome.ly.network.GsonRequest;
import org.xhome.ly.network.UploadPicture;
import org.xhome.ly.util.SharePerferenceUtils;
import org.xhome.ly.util.TaskUtils;
import org.xhome.ly.util.ToastUtils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import me.drakeet.materialdialog.MaterialDialog;

/**
 * Created by liurongchan on 14/12/3.
 */
public class AppendixFragment extends BaseFragment implements ImageChooserListener {

    private static AppendixFragment fragment;

    public ImageChooserManager imageChooserManager;
    public ProgressDialog progressDialog;
    private String picUrl = "";
    private String originalPicUrl = "";
    private String filePath;
    private int chooserType;

    ImageView pic;
    FloatingActionButton floatingActionButton;
    LinearLayout linearLayout;
    NumberProgressBar numberProgressBar;
    TextView progressText;
    LinearLayout progressArea;

    CircularProgressButton confirm;
    CircularProgressButton upload;
    MaterialEditText beiZhu;

    public static AppendixFragment newInstance(Case1 case1) {
        if (fragment == null) {
            fragment = new AppendixFragment();
        }
        Bundle bundle = fragment.getArguments();
        if (bundle == null) {
            bundle = new Bundle();
            bundle.putString("case1", new Gson().toJson(case1));
            fragment.setArguments(bundle);
        } else {
            bundle.putString("case1", new Gson().toJson(case1));
        }

        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(
                R.layout.fulu, container, false);
        init();
        confirm = (CircularProgressButton) rootView.findViewById(R.id.confirm);
        upload = (CircularProgressButton) rootView.findViewById(R.id.upload);
        beiZhu = (MaterialEditText) rootView.findViewById(R.id.beizhu);
        numberProgressBar = (NumberProgressBar) rootView.findViewById(R.id.number_progress_bar);
        progressText = (TextView) rootView.findViewById(R.id.progress_text);
        progressArea = (LinearLayout) rootView.findViewById(R.id.progress_area);
        pic = (ImageView) rootView.findViewById(R.id.pic);
        floatingActionButton = (FloatingActionButton) rootView.findViewById(R.id.addpic);
        linearLayout = (LinearLayout) rootView.findViewById(R.id.pic_area);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                        getActivity(),
                        android.R.layout.simple_list_item_1
                );
                arrayAdapter.add("用相机拍一张");
                arrayAdapter.add("从相册选择");
                ListView listView = new ListView(getActivity());
                float scale = getResources().getDisplayMetrics().density;
                int dpAsPixels = (int) (8 * scale + 0.5f);
                listView.setPadding(0, dpAsPixels, 0, dpAsPixels);
                listView.setDividerHeight(0);
                listView.setAdapter(arrayAdapter);
                final MaterialDialog alert = new MaterialDialog(getActivity())
                        .setTitle("选择类型")
                        .setContentView(listView);
                alert.show();
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                        switch (position) {
                            case 0:
                                takePicture();
                                break;
                            case 1:
                                chooseImage();
                                break;
                            default:
                                break;
                        }
                        alert.dismiss();
                    }
                });

            }
        });

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveCase1();

                JSONObject jsonObject = null;
                try {
                     jsonObject = new JSONObject(new Gson().toJson(case1));
                    if (case1.getOperationData() != null) {
                        long millis = case1.getOperationData().getTime();
                        jsonObject.remove("operationData");
                        jsonObject.put("operationData", String.valueOf(millis));
                    }
                    jsonObject.remove("_id");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                Map<String, String> headers = new HashMap<String, String>();
                headers.put("Authentication", SharePerferenceUtils.getInformation(SharePerferenceUtils.AUTHENTICATION));
                confirm.setProgress(50);
                executeRequest(new GsonRequest(Request.Method.POST, Api.CASE1+ "?doctorId="+ SharePerferenceUtils.getInformation(SharePerferenceUtils.DOCTOR_ID)+"&patientId=" + SharePerferenceUtils.getInformation(SharePerferenceUtils.PATIENT_ID),
                        jsonObject.toString(), responseListener(), errorListener(),
                        Response.class, headers));
            }
        });

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveCase1();
                if (case1.getKeyword2() == null || case1.getKeyword2().equals("")) {
                    ToastUtils.showLong("没有图片需要上传");
                    getActivity().finish();
                } else {
                    progressArea.setVisibility(View.VISIBLE);
                    TaskUtils.executeAsyncTask(new UploadTask());
                }
            }
        });
        return rootView;
    }

    private com.android.volley.Response.Listener<Response> responseListener() {
        return new com.android.volley.Response.Listener<Response>() {
            @Override
            public void onResponse(Response response) {
                int status = response.getStatus();
                if (status == 0) {
                    float mInterrogationRecordId = Float.valueOf(response.getBody().toString());
                    int interrogationRecordId = (int) mInterrogationRecordId;
                    SharePerferenceUtils.addOther("interrogationRecordId", String.valueOf(interrogationRecordId));
                    confirm.setProgress(100);
                    YoYo.with(Techniques.FadeOutUp)
                            .duration(2000)
                            .playOn(confirm);
                    confirm.setVisibility(View.GONE);

                    upload.setVisibility(View.VISIBLE);

                } else {
                    confirm.setProgress(0);
                    confirm.setIdleText("失败");
                }
            }
        };
    }



    @Override
    public void onImageChosen(final ChosenImage image) {
        getActivity().runOnUiThread(new Runnable() {

            @Override
            public void run() {
                progressDialog.dismiss();
                if (image != null) {
                    picUrl = image.getFileThumbnailSmall();
                    originalPicUrl = image.getFilePathOriginal();
                    ImageView imageView = new ImageView(linearLayout.getContext());
                    imageView.setImageURI(Uri.parse(picUrl));
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(160, 160);
                    imageView.setLayoutParams(layoutParams);
                    linearLayout.addView(imageView);
                }
            }
        });
    }

    @Override
    public void onError(final String reason) {
        getActivity().runOnUiThread(new Runnable() {

            @Override
            public void run() {
                progressDialog.dismiss();
                Toast.makeText(getActivity(), reason, Toast.LENGTH_SHORT);
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public void reinitializeImageChooser() {
        imageChooserManager = new ImageChooserManager(getActivity(), chooserType,
                "ly", true);
        imageChooserManager.setImageChooserListener(this);
        imageChooserManager.reinitialize(filePath);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt("chooser_type", chooserType);
        outState.putString("media_path", filePath);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if (!isInActivity) {
            isInActivity = true;

        }

        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey("chooser_type")) {
                chooserType = savedInstanceState.getInt("chooser_type");
            }

            if (savedInstanceState.containsKey("media_path")) {
                filePath = savedInstanceState.getString("media_path");
            }
        }
       if (case1.getKeyword1() != null && !case1.getKeyword1().equals("")) {
           String[] strs = case1.getKeyword1().split(";");
           for (String url : strs) {
               ImageView imageView = new ImageView(linearLayout.getContext());
               imageView.setImageURI(Uri.parse(url));
               LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(160, 160);
               imageView.setLayoutParams(layoutParams);
               linearLayout.addView(imageView);
           }
       }
    }

    private void chooseImage() {
        chooserType = ChooserType.REQUEST_PICK_PICTURE;
        imageChooserManager = new ImageChooserManager(getActivity(),
                ChooserType.REQUEST_PICK_PICTURE, "ly", true);
        imageChooserManager.setImageChooserListener(this);
        try {
            progressDialog = ProgressDialog.show(getActivity(), null, "请稍等");
            filePath = imageChooserManager.choose();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void takePicture() {
        chooserType = ChooserType.REQUEST_CAPTURE_PICTURE;
        imageChooserManager = new ImageChooserManager(getActivity(),
                ChooserType.REQUEST_CAPTURE_PICTURE, "ly", true);
        imageChooserManager.setImageChooserListener(this);
        try {
            progressDialog = ProgressDialog.show(getActivity(), null, "请稍等");
            filePath = imageChooserManager.choose();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveCase1() {
        if (case1 != null) {

            String keyword1 = case1.getKeyword1();
            if (!picUrl.equals("")) {
                if (keyword1  == null || keyword1.equals("")) {
                    case1.setKeyword1(picUrl);
                } else {
                    case1.setKeyword1(keyword1 + ";" + picUrl);
                }
            }

            String keyword2 = case1.getKeyword2();
            if (!originalPicUrl.equals("")) {
                if (keyword2  == null || keyword2.equals("") ) {
                    case1.setKeyword2(originalPicUrl);
                } else {
                    case1.setKeyword2(keyword2 + ";" + originalPicUrl);
                }
            }
            originalPicUrl = "";
            picUrl = "";
            case1.setGlobalRemarks(beiZhu.getText().toString());
            case1DataChangedListener.OnCase1DataChanged(case1);
        }
    }

    private class UploadTask extends AsyncTask<Integer, Integer, Integer[]> {
        int currentTask = 0;
        @Override
        protected Integer[] doInBackground(Integer... objects) {
            int[] statuses = new int[]{1, 1, 1, 1, 1, 1};
            String keyword2 = case1.getKeyword2();
            if (keyword2 != null && !keyword2.equals("")) {
                String[] strs = keyword2.split(";");
                final int length = strs.length;
                for (int i = 0; i < length; i++) {
                    currentTask++;

                    statuses[i] = UploadPicture.uploadFile(new File(strs[i]), new UploadPicture.UploadProgressChangeListner() {
                        @Override
                        public void onProgressChanged(int progress) {
                            publishProgress(progress);
                        }
                        @Override
                        public void onOneTaskEnded() {
                            publishProgress(currentTask, length);
                        }
                    });
                    Log.e("status", String.valueOf(statuses[i]));
                }
            }
            return toObject(statuses);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            if (values.length == 1) {
                numberProgressBar.setProgress(values[0]);
            } else {
                progressText.setText("当前第" + values[0] + "个，共" + values[1] + "个");
            }
        }

        @Override
        protected void onPostExecute(Integer[] integers) {
            super.onPostExecute(integers);
            int[] statuses = toPrimitive(integers);
            boolean success = true;
            for (int i = 0; i < statuses.length; i++) {
                if (statuses[i] != 1) {
                    success = false;
                    Toast.makeText(getActivity(), "第" + i + "个失败", Toast.LENGTH_SHORT);
                }
            }
            if (success) {
                getActivity().finish();
                ToastUtils.showLong("上传成功");
            }
        }
    }

    private static Integer[] toObject(int[] intArray) {

        Integer[] result = new Integer[intArray.length];
        for (int i = 0; i < intArray.length; i++) {
            result[i] = Integer.valueOf(intArray[i]);
        }
        return result;
    }

    private static int[] toPrimitive(Integer[] IntegerArray) {

        int[] result = new int[IntegerArray.length];
        for (int i = 0; i < IntegerArray.length; i++) {
            result[i] = IntegerArray[i].intValue();
        }
        return result;
    }
}
