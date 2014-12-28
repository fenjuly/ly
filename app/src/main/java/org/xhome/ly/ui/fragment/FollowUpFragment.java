package org.xhome.ly.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.dd.CircularProgressButton;
import com.doomonafireball.betterpickers.numberpicker.NumberPickerBuilder;
import com.doomonafireball.betterpickers.numberpicker.NumberPickerDialogFragment;
import com.fourmob.datetimepicker.date.DatePickerDialog;
import com.google.gson.Gson;
import com.rengwuxian.materialedittext.MaterialEditText;

import org.json.JSONException;
import org.json.JSONObject;
import org.xhome.ly.R;
import org.xhome.ly.api.Api;
import org.xhome.ly.bean.FollowUp;
import org.xhome.ly.bean.Response;
import org.xhome.ly.network.GsonRequest;
import org.xhome.ly.network.RequestManager;
import org.xhome.ly.util.SharePerferenceUtils;
import org.xhome.ly.util.ToastUtils;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import me.drakeet.materialdialog.MaterialDialog;

/**
 * Created by liurongchan on 14/12/26.
 */
public class FollowUpFragment extends Fragment {

    private static final String DATEPICKER_TAG = "datepicker";

    private static final String[] SUIFANGFANGFA = {"电话", "信件", "复诊"};

    EditText suiFangShiJian;
    EditText suiFangFangFa;
    EditText fangSuFangPuFaZuoZhengJu;
    MaterialEditText zhengJuLaiYuan;
    EditText shuHouKangNingZhiLiao;
    MaterialEditText shuHouBingFaZheng;
    EditText shuHouXinLvShiChang;
    MaterialEditText shuHouAads;
    MaterialEditText shuHouQiTaYongYao;
    EditText shuHouChaoSheng;
    EditText shuHouZuoFangXueShuan;
    EditText jianCeFangFa;
    CircularProgressButton confirm;


    String suifangshijian;
    String suifangfangfa;
    String fangsufangpufazuozhengju;
    String zhengjulaiyuan;
    String shuhoukangningzhiliao;
    String shuhoubingfazheng;
    String shuhouxinlvshichang;
    String shuhouaads;
    String shuhouqitayongyao;
    String shuhouchaosheng;
    String shuhouzuofangxueshuan;
    String jiancefangfa;

    String zhengjutext = "";
    String zhengjulaiyuantext = "";

    String xinlvshichangtext = "";
    String fashengshijiantext = "";

    String shijiantext = "";
    String latext = "";
    String lvtext = "";
    String lveftext = "";


    private FollowUp followUp;

    public static FollowUpFragment newInstance() {
        FollowUpFragment followUpFragment = new FollowUpFragment();
        return followUpFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(
                R.layout.suifang, container, false);
        followUp = new FollowUp();

        suiFangShiJian = (EditText) rootView.findViewById(R.id.suifangshijian);
        suiFangFangFa = (EditText) rootView.findViewById(R.id.suifangfangfa);
        fangSuFangPuFaZuoZhengJu = (EditText) rootView.findViewById(R.id.fangsufangpufazuozhengju);
        zhengJuLaiYuan = (MaterialEditText) rootView.findViewById(R.id.zhengjulaiyuan);
        shuHouKangNingZhiLiao = (EditText) rootView.findViewById(R.id.shuhoukangningzhiliao);
        shuHouBingFaZheng = (MaterialEditText) rootView.findViewById(R.id.shuhoubingfazheng);
        shuHouXinLvShiChang = (EditText) rootView.findViewById(R.id.shuhouxinlvshichang);
        shuHouAads = (MaterialEditText) rootView.findViewById(R.id.shuhouaads);
        shuHouQiTaYongYao = (MaterialEditText) rootView.findViewById(R.id.shuhouqitayongyao);
        shuHouChaoSheng = (EditText) rootView.findViewById(R.id.shuhouchaosheng);
        shuHouZuoFangXueShuan = (EditText) rootView.findViewById(R.id.shuhouzuofangxueshuan);
        jianCeFangFa = (EditText) rootView.findViewById(R.id.jiancefangfa);
        confirm = (CircularProgressButton) rootView.findViewById(R.id.confirm);

        suiFangShiJian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar calendar = Calendar.getInstance();
                final DatePickerDialog datePickerDialog = DatePickerDialog
                        .newInstance(new SuiFangShiJianDatePickrDialogListener(), calendar.
                                get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), false);
                datePickerDialog.setYearRange(1985, 2028);
                datePickerDialog.show(getActivity().getSupportFragmentManager(), DATEPICKER_TAG);
            }
        });

        suiFangFangFa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                        getActivity(),
                        android.R.layout.simple_list_item_1
                );
               for (int i = 0; i < SUIFANGFANGFA.length; i++) {
                   arrayAdapter.add(SUIFANGFANGFA[i]);
               }
                ListView listView = new ListView(getActivity());
                float scale = getResources().getDisplayMetrics().density;
                int dpAsPixels = (int) (8 * scale + 0.5f);
                listView.setPadding(0, dpAsPixels, 0, dpAsPixels);
                listView.setDividerHeight(0);
                listView.setAdapter(arrayAdapter);
                final MaterialDialog alert = new MaterialDialog(getActivity())
                        .setTitle("随访时间")
                        .setContentView(listView);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                        suiFangFangFa.setText(SUIFANGFANGFA[position]);
                        alert.dismiss();
                    }
                });
                alert.show();
            }
        });

        fangSuFangPuFaZuoZhengJu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                View v = LayoutInflater.from(getActivity()).inflate(R.layout.fangsufangpufazuozhengju, null);
                final MaterialDialog alert = new MaterialDialog(getActivity())
                        .setTitle("房速/房扑发作证据")
                        .setContentView(v);
                final EditText zhengju = (EditText) v.findViewById(R.id.zhengju);
                final EditText zhengjulaiyuan = (EditText) v.findViewById(R.id.zhengjulaiyuan);
                CircularProgressButton confirm = (CircularProgressButton) v.findViewById(R.id.confirm);
                alert.show();
                confirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        zhengjutext = zhengju.getText().toString();
                        zhengjulaiyuantext = zhengjulaiyuan.getText().toString();
                        fangSuFangPuFaZuoZhengJu.setText("证据:" + zhengjutext
                        + "\n\n" + "证据来源:" + zhengjulaiyuantext);
                        alert.dismiss();
                    }
                });

            }
        });

        shuHouXinLvShiChang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                View v = LayoutInflater.from(getActivity()).inflate(R.layout.shuhouxinlvshichang, null);
                final MaterialDialog alert = new MaterialDialog(getActivity())
                        .setTitle("术后心率失常")
                        .setContentView(v);
                final EditText xinlvshichang = (EditText) v.findViewById(R.id.xinlvshichang);
                final EditText fashengshijian = (EditText) v.findViewById(R.id.fashengshijian);
                CircularProgressButton confirm = (CircularProgressButton) v.findViewById(R.id.confirm);
                alert.show();
                fashengshijian.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        NumberPickerBuilder numberPickerBuilder = new NumberPickerBuilder()
                                .setFragmentManager(getFragmentManager())
                                .setStyleResId(R.style.BetterPickersDialogFragment_Light);
                        numberPickerBuilder.show();
                        numberPickerBuilder.addNumberPickerDialogHandler(new NumberPickerDialogFragment.NumberPickerDialogHandler() {
                            @Override
                            public void onDialogNumberSet(int reference, int number, double decimal, boolean isNegative, double fullNumber) {
                                fashengshijiantext = number + "天";
                                fashengshijian.setText(fashengshijiantext);
                            }
                        });
                    }
                });
                confirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        xinlvshichangtext = xinlvshichang.getText().toString();
                        shuHouXinLvShiChang.setText("心率失常:" + xinlvshichangtext + "\n\n"
                        + "发生时间:" + fashengshijiantext);
                        alert.dismiss();
                    }
                });

            }
        });

        shuHouChaoSheng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                View v = LayoutInflater.from(getActivity()).inflate(R.layout.shuhouchaosheng, null);
                final MaterialDialog alert = new MaterialDialog(getActivity())
                        .setTitle("术后超声")
                        .setContentView(v);
                final EditText shijian = (EditText) v.findViewById(R.id.shijian);
                final EditText la = (EditText) v.findViewById(R.id.la);
                final EditText lv = (EditText) v.findViewById(R.id.lv);
                final EditText lvef = (EditText) v.findViewById(R.id.lvef);


                CircularProgressButton confirm = (CircularProgressButton) v.findViewById(R.id.confirm);
                alert.show();
                shijian.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        NumberPickerBuilder numberPickerBuilder = new NumberPickerBuilder()
                                .setFragmentManager(getFragmentManager())
                                .setStyleResId(R.style.BetterPickersDialogFragment_Light);
                        numberPickerBuilder.show();
                        numberPickerBuilder.addNumberPickerDialogHandler(new NumberPickerDialogFragment.NumberPickerDialogHandler() {
                            @Override
                            public void onDialogNumberSet(int reference, int number, double decimal, boolean isNegative, double fullNumber) {
                                shijiantext = number + "月";
                                shijian.setText(shijiantext);
                            }
                        });
                    }
                });

                la.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        NumberPickerBuilder numberPickerBuilder = new NumberPickerBuilder()
                                .setFragmentManager(getFragmentManager())
                                .setStyleResId(R.style.BetterPickersDialogFragment_Light);
                        numberPickerBuilder.show();
                        numberPickerBuilder.addNumberPickerDialogHandler(new NumberPickerDialogFragment.NumberPickerDialogHandler() {
                            @Override
                            public void onDialogNumberSet(int reference, int number, double decimal, boolean isNegative, double fullNumber) {
                                latext = fullNumber + "mm";
                                la.setText(latext);
                            }
                        });
                    }
                });

                lv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        NumberPickerBuilder numberPickerBuilder = new NumberPickerBuilder()
                                .setFragmentManager(getFragmentManager())
                                .setStyleResId(R.style.BetterPickersDialogFragment_Light);
                        numberPickerBuilder.show();
                        numberPickerBuilder.addNumberPickerDialogHandler(new NumberPickerDialogFragment.NumberPickerDialogHandler() {
                            @Override
                            public void onDialogNumberSet(int reference, int number, double decimal, boolean isNegative, double fullNumber) {
                                lvtext = fullNumber + "mm";
                                lv.setText(lvtext);
                            }
                        });
                    }
                });

                lvef.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        NumberPickerBuilder numberPickerBuilder = new NumberPickerBuilder()
                                .setFragmentManager(getFragmentManager())
                                .setStyleResId(R.style.BetterPickersDialogFragment_Light);
                        numberPickerBuilder.show();
                        numberPickerBuilder.addNumberPickerDialogHandler(new NumberPickerDialogFragment.NumberPickerDialogHandler() {
                            @Override
                            public void onDialogNumberSet(int reference, int number, double decimal, boolean isNegative, double fullNumber) {
                                lveftext = fullNumber + "%";
                                lvef.setText(lveftext);
                            }
                        });
                    }
                });

                confirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        shuHouChaoSheng.setText("时间:" + shijiantext + "\n\n"
                                + "LA:" + latext + "\n\n"
                                + "LV:" + lvtext + "\n\n"
                                + "LVEF:" + lveftext );
                        alert.dismiss();
                    }
                });

            }
        });

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (suiFangFangFa.getText().toString().equals("")) {
                    ToastUtils.showLong("随访方法不能为空");
                } else {
                    saveFollowUp();
                    JSONObject jsonObject = null;
                    try {
                        jsonObject = new JSONObject(new Gson().toJson(followUp));
                        if (followUp.getFollowUpTime() != null) {
                            long millis = followUp.getFollowUpTime().getTime();
                            jsonObject.remove("followUpTime");
                            jsonObject.put("followUpTime", String.valueOf(millis));
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    Map<String, String> headers = new HashMap<String, String>();
                    headers.put("Authentication", SharePerferenceUtils.getInformation(SharePerferenceUtils.AUTHENTICATION));
                    confirm.setProgress(50);
                    executeRequest(new GsonRequest(Request.Method.POST, Api.FOLLOWUP + "?interrogationRecordId="
                                    + SharePerferenceUtils.getInformation("interrogationRecordId"),
                            jsonObject.toString(), responseListener(), errorListener(),
                            Response.class, headers));
                }

            }
        });

        return rootView;
    }

    private void saveFollowUp() {
        if (followUp != null) {
            suifangfangfa = suiFangFangFa.getText().toString();
            followUp.setFollowUpMethod(suifangfangfa);
            followUp.setOnsetEvidence(zhengjutext);
            followUp.setEvidenceSource(zhengjulaiyuantext);
            shuhoubingfazheng = shuHouBingFaZheng.getText().toString();
            followUp.setPostoperativeComplications(shuhoubingfazheng);
            followUp.setPostoperativeArrhythmias(xinlvshichangtext);
            followUp.setPostoperativeArrhythmiasTime(fashengshijiantext);
            shuhouaads = shuHouAads.getText().toString();
            followUp.setPostoperatieAdds(shuhouaads);
            shuhouqitayongyao = shuHouQiTaYongYao.getText().toString();
            followUp.setPostoperatieMedication(shuhouqitayongyao);
            shuhoukangningzhiliao = shuHouKangNingZhiLiao.getText().toString();// need to do !!!!

            followUp.setEchocardiographicTime(shijiantext);
            followUp.setPostoperatieLa(latext);
            followUp.setPostoperatieLv(lvtext);
            followUp.setPostoperatieLvef(lveftext);
            shuhouzuofangxueshuan = shuHouZuoFangXueShuan.getText().toString();
            followUp.setLeftThrombosis(shuhouzuofangxueshuan);
            jiancefangfa = jianCeFangFa.getText().toString();
            followUp.setCheckMethod(jiancefangfa);
        }
    }

    private class SuiFangShiJianDatePickrDialogListener implements DatePickerDialog.OnDateSetListener {

        @Override
        public void onDateSet(DatePickerDialog datePickerDialog, int year, int month, int day) {
            month ++;
            Date date = new Date(year - 1900, month, day);
            followUp.setFollowUpTime(date);
            suiFangShiJian.setText(year+ "年" + month + "月" + day + "日");
        }
    }

    private void executeRequest(Request request) {
        RequestManager.addRequest(request, this);
    }

    private com.android.volley.Response.Listener<Response> responseListener() {
        return new com.android.volley.Response.Listener<Response>() {
            @Override
            public void onResponse(Response response) {
                int status = response.getStatus();
                if (status == 0) {
                    confirm.setProgress(100);
                    confirm.setIdleText("成功");
                } else {
                    confirm.setProgress(0);
                    confirm.setIdleText("失败");
                }
            }
        };
    }

    private com.android.volley.Response.ErrorListener errorListener() {
        return new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                ToastUtils.showLong(error.getMessage());
            }
        };
    }
}
