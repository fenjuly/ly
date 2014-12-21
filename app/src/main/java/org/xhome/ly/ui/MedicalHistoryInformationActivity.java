package org.xhome.ly.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import com.android.volley.Request;
import com.dd.CircularProgressButton;
import com.fourmob.datetimepicker.date.DatePickerDialog;
import com.google.gson.Gson;
import com.rengwuxian.materialedittext.MaterialEditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xhome.ly.R;
import org.xhome.ly.api.Api;
import org.xhome.ly.bean.MedicalHistory;
import org.xhome.ly.bean.Response;
import org.xhome.ly.network.GsonRequest;
import org.xhome.ly.ui.adapter.History1Adapter;
import org.xhome.ly.ui.adapter.History2Adapter;
import org.xhome.ly.util.SharePerferenceUtils;
import org.xhome.ly.util.ToastUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import me.drakeet.materialdialog.MaterialDialog;

/**
 * Created by liurongchan on 14/12/14.
 */
public class MedicalHistoryInformationActivity extends BaseActivity {

    public static final String DATEPICKER_TAG = "datepicker";

    private ProgressDialog progressDialog;

    ImageView addXinZangBingShouShuShi;
    ImageView addJiChuJiBing;
    ListView listView1;
    ListView listView2;
    CircularProgressButton confirm;

    MedicalHistory medicalHistory;



    String patientId;
    List<MedicalHistory> medicalHistories1 = new ArrayList<MedicalHistory>();
    List<MedicalHistory> medicalHistories2 = new ArrayList<MedicalHistory>();
    History1Adapter history1Adapter;
    History2Adapter history2Adapter;


    //case position
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medical_history);
        position = getIntent().getIntExtra("caseNumber", 0);
        patientId = SharePerferenceUtils.getInformation(SharePerferenceUtils.PATIENT_ID);
        addXinZangBingShouShuShi = (ImageView) findViewById(R.id.add_xinzangbingshoushushi);
        addJiChuJiBing = (ImageView) findViewById(R.id.add_jichubingqing);
        listView1 = (ListView) findViewById(R.id.history1);
        listView2 = (ListView) findViewById(R.id.history2);
        confirm = (CircularProgressButton) findViewById(R.id.next);
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Authentication", SharePerferenceUtils.getInformation(SharePerferenceUtils.AUTHENTICATION));
        progressDialog = ProgressDialog.show(this, null, "正在加载数据，请稍等");
        executeRequest(new GsonRequest(Request.Method.GET, String.format(Api.MEDICAL_HISTORY, patientId),
                new com.android.volley.Response.Listener<Response>() {
                    @Override
                    public void onResponse(Response response) {
                        int status = response.getStatus();
                        if (status == 0) {
                            transformJsonArrayTiMedicalHistories(response.getBody().toString());
                            history1Adapter = new History1Adapter(MedicalHistoryInformationActivity.this, medicalHistories1);
                            listView1.setAdapter(history1Adapter);
                            history2Adapter = new History2Adapter(MedicalHistoryInformationActivity.this, medicalHistories2);
                            listView2.setAdapter(history2Adapter);
                            progressDialog.dismiss();
                        }
                    }
                }, errorListener(),
                Response.class, headers));

        addXinZangBingShouShuShi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                medicalHistory = new MedicalHistory();
                medicalHistory.setTypeName("心脏手术史");
                View v = LayoutInflater.from(MedicalHistoryInformationActivity.this).inflate(R.layout.xinzangshoushushi, null);
                final MaterialDialog alert = new MaterialDialog(MedicalHistoryInformationActivity.this)
                        .setTitle("心脏手术史")
                        .setContentView(v);
                alert.show();
                final EditText shoushushijian = (EditText) v.findViewById(R.id.shoushushijian);
                final MaterialEditText shoushuxiangqing = (MaterialEditText) v.findViewById(R.id.shoushuxiangqing);
                CircularProgressButton confirm = (CircularProgressButton) v.findViewById(R.id.confirm);

                shoushushijian.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        final Calendar calendar = Calendar.getInstance();
                        final DatePickerDialog datePickerDialog = DatePickerDialog
                                .newInstance(new DatePickerDialog.OnDateSetListener() {
                                    @Override
                                    public void onDateSet(DatePickerDialog datePickerDialog, int year, int month, int day) {
                                        Date date = new Date(year - 1900, month, day);
                                        medicalHistory.setOprateTime(date);
                                        shoushushijian.setText(year+ "年" + month + "月" + day + "日");
                                    }
                                }, calendar.
                                        get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), false);
                        datePickerDialog.setYearRange(1985, 2028);
                        datePickerDialog.show(getSupportFragmentManager(), DATEPICKER_TAG);
                    }
                });

                confirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        medicalHistory.setDetail(replaceBlank(shoushuxiangqing.getText().toString()));
                        String detial = medicalHistory.getDetail();
                        if (detial == null || detial.equals("")) {
                            medicalHistory.setDetail("无");
                        }
                        JSONObject jsonObject = null;
                        try {
                            jsonObject = new JSONObject(new Gson().toJson(medicalHistory));
                            if (medicalHistory.getOprateTime() != null) {
                                long millis = medicalHistory.getOprateTime().getTime();
                                jsonObject.remove("oprateTime");
                                jsonObject.put("oprateTime", String.valueOf(millis));
                            } else {
                                Calendar cal = Calendar.getInstance();
                                int year = cal.get(Calendar.YEAR);
                                int month = cal.get(Calendar.MONTH);
                                int day = cal.get(Calendar.DATE);
                                Date date = new Date(year - 1900, month, day);
                                medicalHistory.setOprateTime(date);
                                long millis = date.getTime();
                                jsonObject.remove("oprateTime");
                                jsonObject.put("oprateTime", String.valueOf(millis));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        Map<String, String> headers = new HashMap<String, String>();
                        headers.put("Authentication", SharePerferenceUtils.getInformation(SharePerferenceUtils.AUTHENTICATION));
                        executeRequest(new GsonRequest(Request.Method.POST, String.format(Api.MEDICAL_HISTORY, patientId),
                                jsonObject.toString(),
                                new com.android.volley.Response.Listener<Response>() {
                                    @Override
                                    public void onResponse(Response response) {
                                        int status = response.getStatus();
                                        if (status == 0) {
                                            medicalHistories1.add(medicalHistory);
                                            history1Adapter.refresh(medicalHistories1);
                                            ToastUtils.showLong("添加病史成功");
                                        } else {
                                            ToastUtils.showLong("添加病史失败");
                                        }
                                    }
                                }, errorListener(),
                                Response.class, headers));
                        alert.dismiss();
                    }
                });
            }
        });


        addJiChuJiBing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                medicalHistory = new MedicalHistory();
                medicalHistory.setTypeName("基础疾病");
                View v = LayoutInflater.from(MedicalHistoryInformationActivity.this).inflate(R.layout.jichujibing, null);
                final MaterialDialog alert = new MaterialDialog(MedicalHistoryInformationActivity.this)
                        .setTitle("基础疾病")
                        .setContentView(v);
                alert.show();
                final EditText shoushushijian = (EditText) v.findViewById(R.id.shoushushijian);

                final MaterialEditText shoushuxiangqing = (MaterialEditText) v.findViewById(R.id.shoushuxiangqing);
                CircularProgressButton confirm = (CircularProgressButton) v.findViewById(R.id.confirm);

                shoushushijian.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        final Calendar calendar = Calendar.getInstance();
                        final DatePickerDialog datePickerDialog = DatePickerDialog
                                .newInstance(new DatePickerDialog.OnDateSetListener() {
                                    @Override
                                    public void onDateSet(DatePickerDialog datePickerDialog, int year, int month, int day) {
                                        Date date = new Date(year - 1900, month, day);
                                        medicalHistory.setOprateTime(date);
                                        shoushushijian.setText(year+ "年" + month + "月" + day + "日");
                                    }
                                }, calendar.
                                        get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), false);
                        datePickerDialog.setYearRange(1985, 2028);
                        datePickerDialog.show(getSupportFragmentManager(), DATEPICKER_TAG);
                    }
                });

                confirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        medicalHistory.setDetail(replaceBlank(shoushuxiangqing.getText().toString()));
                        String detail = medicalHistory.getDetail();
                        Log.e("detail", detail);
                        if (detail == null || detail.equals("")) {
                            medicalHistory.setDetail("无");
                        }
                        JSONObject jsonObject = null;
                        try {
                            jsonObject = new JSONObject(new Gson().toJson(medicalHistory));
                            if (medicalHistory.getOprateTime() != null) {
                                long millis = medicalHistory.getOprateTime().getTime();
                                jsonObject.remove("oprateTime");
                                jsonObject.put("oprateTime", String.valueOf(millis));
                            } else {
                                Calendar cal = Calendar.getInstance();
                                int year = cal.get(Calendar.YEAR);
                                int month = cal.get(Calendar.MONTH);
                                int day = cal.get(Calendar.DATE);
                                Date date = new Date(year - 1900, month, day);
                                medicalHistory.setOprateTime(date);
                                long millis = date.getTime();
                                jsonObject.remove("oprateTime");
                                jsonObject.put("oprateTime", String.valueOf(millis));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        Map<String, String> headers = new HashMap<String, String>();
                        headers.put("Authentication", SharePerferenceUtils.getInformation(SharePerferenceUtils.AUTHENTICATION));
                        executeRequest(new GsonRequest(Request.Method.POST, String.format(Api.MEDICAL_HISTORY, patientId),
                                jsonObject.toString(),
                                new com.android.volley.Response.Listener<Response>() {
                                    @Override
                                    public void onResponse(Response response) {
                                        int status = response.getStatus();
                                        if (status == 0) {
                                            medicalHistories2.add(medicalHistory);
                                            history2Adapter.refresh(medicalHistories2);
                                            ToastUtils.showLong("添加病史成功");
                                        } else {
                                            ToastUtils.showLong("添加病史失败");
                                        }
                                    }
                                }, errorListener(),
                                Response.class, headers));
                        alert.dismiss();
                    }
                });
            }
        });

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (position) {
                    case 0:
                        Intent intent = new Intent(MedicalHistoryInformationActivity.this, Case1InformationActivity.class);
                        startActivity(intent);
                        finish();
                        break;
                    case 1:
                        break;
                    case 2:
                        Intent intent2 = new Intent(MedicalHistoryInformationActivity.this, Case2InformationActivity.class);
                        startActivity(intent2);
                        finish();
                        break;
                    default:
                        break;
                }
            }
        });

    }

    private void transformJsonArrayTiMedicalHistories (String jsonArray) {
        try {
            JSONArray j = new JSONArray(jsonArray);
            for (int i = 0; i < j.length(); i++) {
                JSONObject jsonObject = j.getJSONObject(i);
                Date date = new Date(jsonObject.getLong("oprateTime"));
                jsonObject.remove("oprateTime");
                MedicalHistory medicalHistory = new Gson().fromJson(jsonObject.toString(), MedicalHistory.class);
                medicalHistory.setOprateTime(date);
                if (medicalHistory.getTypeName().equals("心脏手术史")) {
                    medicalHistories1.add(medicalHistory);
                } else {
                    medicalHistories2.add(medicalHistory);
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private String replaceBlank(String str)
    {
        Pattern p = Pattern.compile("\\s*|t|r|n");
        Matcher m = p.matcher(str);
        String after = m.replaceAll("");
        return after;
    }

}
