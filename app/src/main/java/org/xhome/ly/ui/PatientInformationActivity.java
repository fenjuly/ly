package org.xhome.ly.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.android.volley.Request;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.dd.CircularProgressButton;
import com.google.gson.Gson;
import com.rengwuxian.materialedittext.MaterialEditText;

import org.json.JSONException;
import org.json.JSONObject;
import org.xhome.ly.R;
import org.xhome.ly.api.Api;
import org.xhome.ly.bean.Patient;
import org.xhome.ly.bean.Response;
import org.xhome.ly.network.GsonRequest;
import org.xhome.ly.util.SharePerferenceUtils;
import org.xhome.ly.util.ToastUtils;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import me.drakeet.materialdialog.MaterialDialog;

/**
 * Created by liurongchan on 14/12/6.
 */
public class PatientInformationActivity extends BaseActivity {

    private static final String[] xueli = {"小学", "初中", "高中", "大专", "硕士", "博士及以上"};

    MaterialEditText xingMing;
    MaterialEditText shenFenZheng;
    MaterialEditText xingBie;
    MaterialEditText nianLing;
    MaterialEditText chuShengNianYue;
    MaterialEditText dianHua;
    MaterialEditText jiaTingZhuZhi;
    EditText         wenHuaChengDu;
    MaterialEditText zhiYe;
    MaterialEditText bingLiBianHao;
    CircularProgressButton confirm;

    public ProgressDialog progressDialog;

    String xingming;
    String shenfenzheng;
    String xingbie;
    String nianling;
    String chushengnianyue;
    String dianhua;
    String jiatingzhuzhi;
    String wenhuachengdu;
    String zhiye;
    String binglibianhao;

    String year;
    String month;
    String day;
    int age;

    //case position
    private int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patient_information);
        setTitleColor(getResources().getColor(R.color.white));
        setTitle("病人信息");
        position = getIntent().getIntExtra("caseNumber", 0);
        xingMing = (MaterialEditText) findViewById(R.id.name);
        shenFenZheng = (MaterialEditText) findViewById(R.id.id_card);
        xingBie = (MaterialEditText) findViewById(R.id.sex);
        nianLing = (MaterialEditText) findViewById(R.id.age);
        chuShengNianYue = (MaterialEditText) findViewById(R.id.birthday);
        dianHua = (MaterialEditText) findViewById(R.id.phone_number);
        jiaTingZhuZhi = (MaterialEditText) findViewById(R.id.address);
        wenHuaChengDu = (EditText) findViewById(R.id.culture_degree);
        zhiYe = (MaterialEditText) findViewById(R.id.profession);
        bingLiBianHao = (MaterialEditText) findViewById(R.id.case_number);
        confirm = (CircularProgressButton) findViewById(R.id.confirm);

        shenFenZheng.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                shenfenzheng = shenFenZheng.getText().toString();
                if (!b && shenfenzheng.length() == 18) {
                    if (isJO(Integer.valueOf(shenfenzheng.substring(16, 17)))) {
                        xingBie.setText("女");
                    } else {
                        xingBie.setText("男");
                    }
                    Calendar cal = Calendar.getInstance();
                    int y = cal.get(Calendar.YEAR);
                    year = shenfenzheng.substring(6, 10);
                    month = shenfenzheng.substring(10, 12);
                    day = shenfenzheng.substring(12, 14);
                    age = y - Integer.valueOf(year);
                    nianLing.setText(String.valueOf(age));
                    chuShengNianYue.setText(year + "年" + month + "月" + day + "日");

                    progressDialog = ProgressDialog.show(PatientInformationActivity.this, null, "正在查询病人是否存在,请稍等");

                    Map<String, String> headers = new HashMap<String, String>();
                    headers.put("Authentication", SharePerferenceUtils.getInformation(SharePerferenceUtils.AUTHENTICATION));
                    executeRequest(new GsonRequest(Request.Method.GET, Api.PATIENT + "?idCard=" + shenfenzheng,
                            new com.android.volley.Response.Listener<Response>() {
                                @Override
                                public void onResponse(Response response) {
                                    int status = response.getStatus();
                                    if (status == 0) {
                                        progressDialog.dismiss();
                                        float mPatientId = Float.valueOf(response.getBody().toString());
                                        int patientId = (int) mPatientId;
                                        SharePerferenceUtils.addOther(SharePerferenceUtils.PATIENT_ID, String.valueOf(patientId));
                                        ToastUtils.showLong("此病人已存在，跳转到病史页面");
                                        Intent intent = new Intent(PatientInformationActivity.this, MedicalHistoryInformationActivity.class);
                                        intent.putExtra("caseNumber", position);
                                        startActivity(intent);
                                        finish();
                                    } else {
                                        progressDialog.dismiss();
                                        ToastUtils.showLong("病人不存在");
                                    }
                                }
                            }, errorListener(),
                            Response.class, headers));
                }
            }
        });

        wenHuaChengDu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                        PatientInformationActivity.this,
                        android.R.layout.simple_list_item_1
                );
                for (int i = 0; i < xueli.length; i++) {
                    arrayAdapter.add(xueli[i]);
                }
                ListView listView = new ListView(PatientInformationActivity.this);
                float scale = getResources().getDisplayMetrics().density;
                int dpAsPixels = (int) (8 * scale + 0.5f);
                listView.setPadding(0, dpAsPixels, 0, dpAsPixels);
                listView.setDividerHeight(0);
                listView.setAdapter(arrayAdapter);
                final MaterialDialog alert = new MaterialDialog(PatientInformationActivity.this)
                        .setTitle("选择类型")
                        .setContentView(listView);
                alert.show();
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                        wenHuaChengDu.setText(xueli[position]);
                        alert.dismiss();
                    }
                });

            }
        });

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (shenFenZheng.getText().toString().length() != 18) {
                    shenFenZheng.setError("身份证不对");
                } else if (xingMing.getText().toString().equals("")) {
                   xingMing.setError("姓名不能为空");
                } else if (dianHua.getText().toString().length() != 11) {
                   dianHua.setError("电话号码不对");
                } else if (age < 0 ) {
                   nianLing.setError("年龄错误");
                } else if (Integer.valueOf(month) > 12 || Integer.valueOf(month) < 0 || Integer.valueOf(day) > 31 || Integer.valueOf(day) < 0) {
                    chuShengNianYue.setError("出生日期错误");
                } else {
                        xingming = xingMing.getText().toString();
                        shenfenzheng = shenFenZheng.getText().toString();
                        xingbie = xingBie.getText().toString();
                        nianling = nianLing.getText().toString();
                        dianhua = dianHua.getText().toString();
                        jiatingzhuzhi = jiaTingZhuZhi.getText().toString();
                        wenhuachengdu = wenHuaChengDu.getText().toString();
                        zhiye = zhiYe.getText().toString();
                        binglibianhao = bingLiBianHao.getText().toString();
                        Patient patient = new Patient();
                        patient.setName(xingming);
                        patient.setIdCard(shenfenzheng);
                        patient.setSex(xingbie);
                        patient.setAge(age);
                        if (!nianling.equals("")) {
                            Date date = new Date(Integer.valueOf(year) - 1900, Integer.valueOf(month) - 1, Integer.valueOf(day));
                            Log.e("date", date.toString());
                            patient.setBirthday(date);
                        }
                        patient.setPhoneNumber(dianhua);
                        patient.setAdress(jiatingzhuzhi);
                        patient.setEducationLevel(wenhuachengdu);
                        patient.setProfession(zhiye);

                        JSONObject jsonObject = null;
                        try {
                            jsonObject = new JSONObject(new Gson().toJson(patient));
                            if (patient.getBirthday() != null) {
//                                long millis = patient.getBirthday().getTime();
                                jsonObject.remove("birthday");
//                                jsonObject.put("birthday", String.valueOf(millis) + "l");
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    Log.e("jsonObject", jsonObject.toString());
                        Map<String, String> headers = new HashMap<String, String>();
                        headers.put("Authentication", SharePerferenceUtils.getInformation(SharePerferenceUtils.AUTHENTICATION));
                        confirm.setProgress(50);
                        long millis = patient.getBirthday().getTime();
                        executeRequest(new GsonRequest(Request.Method.POST, Api.PATIENT + "?birthday=" + millis,
                                jsonObject.toString(), responseListener(), errorListener(),
                                Response.class, headers));
                    }
            }
        });
    }

    private com.android.volley.Response.Listener<Response> responseListener() {
        return new com.android.volley.Response.Listener<Response>() {
            @Override
            public void onResponse(Response response) {
                int status = response.getStatus();
                if (status == 0) {
                    float mPatientId = Float.valueOf(response.getBody().toString());
                    int patientId = (int) mPatientId;
                    SharePerferenceUtils.addOther(SharePerferenceUtils.PATIENT_ID, String.valueOf(patientId));
                    confirm.setProgress(100);
                    Intent intent = new Intent(PatientInformationActivity.this, MedicalHistoryInformationActivity.class);
                    intent.putExtra("caseNumber", position);
                    startActivity(intent);
                    finish();

                } else if (status == 6){
                    confirm.setProgress(0);
                    confirm.setIdleText("已存在");
                }
            }
        };
    }


    private boolean isJO(int num)
    {
        int a = num%2;
        if (a == 0)
            return true;
        else
            return false;
    }
}
