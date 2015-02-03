package org.xhome.ly.ui;

import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

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
import org.xhome.ly.kankan.OnWheelScrollListener;
import org.xhome.ly.kankan.WheelView;
import org.xhome.ly.kankan.adapters.ArrayWheelAdapter;
import org.xhome.ly.network.GsonRequest;
import org.xhome.ly.util.DqxxUtils;
import org.xhome.ly.util.SharePerferenceUtils;
import org.xhome.ly.util.ToastUtils;

import java.sql.Timestamp;
import java.util.ArrayList;
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
    EditText jiaTingZhuZhi;
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


    //address start
    private ImageButton btn_submit, btn_cancel;
    private static final String DBNAME = "dqxx.db";
    private SQLiteDatabase db;
    private ArrayList<ContentValues> provinceArr;// 省
    private ArrayList<ContentValues> cityArr;// 城市
    private ArrayList<ContentValues> areaArr;// 地区

    private Map<String, Integer> provinceMap;// 省
    private Map<String, Integer> cityMap;// 城市
    private Map<String, Integer> areaMap;// 地区

    private String[] provinceArray;
    private String[] cityArray;
    private String[] areaArray;
    private String[] full_areaArray;

    private WheelView provinceWheelView;
    private WheelView cityWheelView;
    private WheelView areaWheelView;

    private ProviceCityAreaAdapter provinceAdapter;
    private ProviceCityAreaAdapter cityAdapter;
    private ProviceCityAreaAdapter areaAdapter;
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
        jiaTingZhuZhi = (EditText) findViewById(R.id.address);
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

        jiaTingZhuZhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View v = LayoutInflater.from(PatientInformationActivity.this).inflate(R.layout.activity_dqxx, null);
                final MaterialDialog alert = new MaterialDialog(PatientInformationActivity.this)
                        .setTitle("家庭住址")
                        .setContentView(v);
                provinceWheelView = (WheelView)v.findViewById(R.id.provice);
                cityWheelView = (WheelView) v.findViewById(R.id.city);
                areaWheelView = (WheelView) v.findViewById(R.id.area);
                btn_cancel = (ImageButton) v.findViewById(R.id.cancel);
                btn_submit = (ImageButton) v.findViewById(R.id.submit);
                alert.show();
                initWheelView();
                btn_submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        switch (view.getId()) {
                            case R.id.submit:
                                String address = full_areaArray[areaWheelView.getCurrentItem()];
//                                ContentValues provinceValues=provinceArr.get(provinceWheelView.getCurrentItem());
//                                ContentValues cityValues=cityArr.get(cityWheelView.getCurrentItem());
//                                ContentValues areaValues=areaArr.get(areaWheelView.getCurrentItem());

//			Toast.makeText(
//					DqxxActivity.this,
//					address+ " key:"+ DqxxUtils.findPrimaryKey(db,address)+""+areaValues.getAsString("area")+""+areaValues.getAsInteger("area_id"),
//					Toast.LENGTH_SHORT).show();
//                                Intent intent = new Intent();
//                                intent.putExtra("province_id", provinceValues.getAsInteger("province_id"));
//                                intent.putExtra("province", provinceValues.getAsString("province"));
//                                intent.putExtra("city_id", cityValues.getAsInteger("city_id"));
//                                intent.putExtra("city", cityValues.getAsString("city"));
//                                intent.putExtra("area_id", areaValues.getAsInteger("area_id"));
//                                intent.putExtra("area", areaValues.getAsString("area"));
//                                intent.putExtra("address", address);
//                                setResult(RESULT_OK, intent);
                                jiaTingZhuZhi.setText(address);
                                alert.dismiss();
                                break;
                            case R.id.cancel:
                                alert.dismiss();
                                break;
                            default:
                                break;
                        }
                    }
                });
                btn_cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        switch (view.getId()) {
                            case R.id.submit:
                                String address = full_areaArray[areaWheelView.getCurrentItem()];
//                                ContentValues provinceValues=provinceArr.get(provinceWheelView.getCurrentItem());
//                                ContentValues cityValues=cityArr.get(cityWheelView.getCurrentItem());
//                                ContentValues areaValues=areaArr.get(areaWheelView.getCurrentItem());

//			Toast.makeText(
//					DqxxActivity.this,
//					address+ " key:"+ DqxxUtils.findPrimaryKey(db,address)+""+areaValues.getAsString("area")+""+areaValues.getAsInteger("area_id"),
//					Toast.LENGTH_SHORT).show();
//                                Intent intent = new Intent();
//                                intent.putExtra("province_id", provinceValues.getAsInteger("province_id"));
//                                intent.putExtra("province", provinceValues.getAsString("province"));
//                                intent.putExtra("city_id", cityValues.getAsInteger("city_id"));
//                                intent.putExtra("city", cityValues.getAsString("city"));
//                                intent.putExtra("area_id", areaValues.getAsInteger("area_id"));
//                                intent.putExtra("area", areaValues.getAsString("area"));
//                                intent.putExtra("address", address);
//                                setResult(RESULT_OK, intent);
                                jiaTingZhuZhi.setText(address);
                                alert.dismiss();
                                break;
                            case R.id.cancel:
                                alert.dismiss();
                                break;
                            default:
                                break;
                        }
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
                       long millis = 0l;
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
                            Calendar calbk = Calendar.getInstance();
                            calbk.set(Integer.valueOf(year), Integer.valueOf(month) - 1, Integer.valueOf(day) - 1, 24, 0, 0);
                            Date date = calbk.getTime();
                            millis = calbk.getTimeInMillis()/1000;
                            Log.e("date", date.toString());
                            Log.e("timestamp", String.valueOf(millis));
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
//                                jsonObject.put("birthday", String.valueOf(millis));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    Log.e("jsonObject", jsonObject.toString());
                        Map<String, String> headers = new HashMap<String, String>();
                        headers.put("Authentication", SharePerferenceUtils.getInformation(SharePerferenceUtils.AUTHENTICATION));
                        confirm.setProgress(50);
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

    //address code start
    public void initWheelView() {


        // 初始化省滚轮列表选择器
        initProviceMap();
        provinceAdapter = new ProviceCityAreaAdapter(this, provinceArray, 0);
        provinceWheelView.setViewAdapter(provinceAdapter);
        provinceWheelView.setCurrentItem(0);
        provinceWheelView.addScrollingListener(privinceScrollListener);

        // 初始化城市滚轮列表选择器
        String provinceName = provinceArray[0];
        int province_id = provinceMap.get(provinceName);
        if (provinceName.endsWith("市")) {
            initCityMap(province_id, false);
        } else {
            initCityMap(province_id, true);
        }
        cityAdapter = new ProviceCityAreaAdapter(this, cityArray, 0);
        cityWheelView.setViewAdapter(cityAdapter);
        cityWheelView.setCurrentItem(0);
        cityWheelView.addScrollingListener(cityScrollListener);

        // 初始化地区滚轮列表选择器
        String cityName = cityArray[0];
        int city_id = cityMap.get(cityName);
        provinceName = cityArray[0];
        if (provinceName.endsWith("市")) {
            city_id = city_id * 100 + 1;
        }
        initAreaMap(city_id);
        areaAdapter = new ProviceCityAreaAdapter(PatientInformationActivity.this, areaArray, 0);
        areaWheelView.setViewAdapter(areaAdapter);
        areaWheelView.setCurrentItem(0);

    }

    OnWheelScrollListener privinceScrollListener = new OnWheelScrollListener() {

        @Override
        public void onScrollingStarted(WheelView wheel) {
        }

        @Override
        public void onScrollingFinished(WheelView wheel) {
            int currentItem = wheel.getCurrentItem();
            String provinceName = provinceArray[currentItem];
            int province_id = provinceMap.get(provinceName);
            if (provinceName.endsWith("市")) {
                initCityMap(province_id, false);
            } else {
                initCityMap(province_id, true);
            }

            cityAdapter = new ProviceCityAreaAdapter(PatientInformationActivity.this,
                    cityArray, 0);
            cityWheelView.setViewAdapter(cityAdapter);
            cityWheelView.setCurrentItem(0);

            String cityName = cityArray[0];
            int city_id = cityMap.get(cityName);
            if (provinceName.endsWith("市")) {
                city_id = city_id * 100 + 1;
            }
            initAreaMap(city_id);
            areaAdapter = new ProviceCityAreaAdapter(PatientInformationActivity.this,
                    areaArray, 0);
            areaWheelView.setViewAdapter(areaAdapter);
            areaWheelView.setCurrentItem(0);
        }
    };

    OnWheelScrollListener cityScrollListener = new OnWheelScrollListener() {

        @Override
        public void onScrollingStarted(WheelView wheel) {
        }

        @Override
        public void onScrollingFinished(WheelView wheel) {
            String provinceName = provinceArray[provinceWheelView
                    .getCurrentItem()];
            int city_id = cityMap.get(cityArray[wheel.getCurrentItem()]);
            if (provinceName.endsWith("市")) {
                city_id = city_id * 100 + 1;
            }
            initAreaMap(city_id);
            areaAdapter = new ProviceCityAreaAdapter(PatientInformationActivity.this, areaArray, 0);
            areaWheelView.setViewAdapter(areaAdapter);
            areaWheelView.setCurrentItem(0);
        }
    };

    public void initProviceMap() {
        DqxxUtils.copyDqdbIfNeeded(this);
        if (db == null) {
            db = this.openOrCreateDatabase(PatientInformationActivity.this.getFilesDir()
                            .getAbsolutePath() + "/" + DBNAME, Context.MODE_PRIVATE,
                    null);
        }
        provinceArr = DqxxUtils.getProvince(db);
        provinceMap = new HashMap<String,Integer>();
        provinceArray = new String[provinceArr.size()];
        for (int i = 0; i < provinceArr.size(); i++) {
            provinceMap.put(provinceArr.get(i).getAsString("province"),provinceArr.get(i).getAsInteger("province_id"));
            provinceArray[i] = provinceArr.get(i).getAsString("province");
        }
    }

    public void initCityMap(int province_id, boolean municipalities) {
        DqxxUtils.copyDqdbIfNeeded(PatientInformationActivity.this);
        if (db == null) {
            db = PatientInformationActivity.this.openOrCreateDatabase(PatientInformationActivity.this.getFilesDir()
                            .getAbsolutePath() + "/" + DBNAME, Context.MODE_PRIVATE,
                    null);
        }
        cityArr = DqxxUtils.getCity(db, province_id, municipalities);
        cityArray = new String[cityArr.size()];
        cityMap = new HashMap<String,Integer>();
        for (int i = 0; i < cityArr.size(); i++) {
            cityMap.put(cityArr.get(i).getAsString("city"),cityArr.get(i).getAsInteger("city_id"));
            cityArray[i] = cityArr.get(i).getAsString("city");
        }
    }

    public void initAreaMap(int province_id) {
        DqxxUtils.copyDqdbIfNeeded(PatientInformationActivity.this);
        if (db == null) {
            db = PatientInformationActivity.this.openOrCreateDatabase(PatientInformationActivity.this.getFilesDir()
                            .getAbsolutePath() + "/" + DBNAME, Context.MODE_PRIVATE,
                    null);
        }
        areaArr = DqxxUtils.getArea(db, province_id);
        areaMap = new HashMap<String,Integer>();
        areaArray = new String[areaArr.size()];
        full_areaArray = new String[areaArr.size()];
        for (int i = 0; i < areaArr.size(); i++) {
            areaMap.put(areaArr.get(i).getAsString("area"),areaArr.get(i).getAsInteger("area_id"));
            areaArray[i] = areaArr.get(i).getAsString("area");
            full_areaArray[i] = areaArr.get(i).getAsString("full_area");
        }
    }

    public class ProviceCityAreaAdapter extends ArrayWheelAdapter<String> {
        private int currentItem;
        private int currentValue;

        public ProviceCityAreaAdapter(Context context, String[] items,
                                      int current) {
            super(context, items);
            this.currentValue = current;
        }

        public void setCurrentValue(int value) {
            this.currentValue = value;
        }

        @Override
        protected void configureTextView(TextView view) {
            super.configureTextView(view);
            view.setTypeface(Typeface.SANS_SERIF);
        }

        @Override
        public View getItem(int index, View convertView, ViewGroup parent) {
            currentItem = index;
            return super.getItem(index, convertView, parent);
        }

    }
}
