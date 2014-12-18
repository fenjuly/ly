package org.xhome.ly.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.android.volley.Request;
import com.dd.CircularProgressButton;
import com.rengwuxian.materialedittext.MaterialEditText;

import org.json.JSONException;
import org.json.JSONObject;
import org.xhome.ly.R;
import org.xhome.ly.api.Api;
import org.xhome.ly.bean.Response;
import org.xhome.ly.network.GsonRequest;
import org.xhome.ly.util.SharePerferenceUtils;

import java.util.HashMap;
import java.util.Map;

import me.drakeet.materialdialog.MaterialDialog;

/**
 * Created by liurongchan on 14/12/3.
 */
public class DoctorInformationCenter extends BaseActivity {

    MaterialEditText id;
    MaterialEditText name;
    MaterialEditText contactWay;

    EditText keShi;
    EditText zhiCheng;
    EditText suoShuYiYuan;

    String n;
    String c;
    String keshi;
    String zhicheng;
    String suoshuyiyuan;

    CircularProgressButton confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doctor_information);
        Intent intent = getIntent();
        String userId = intent.getStringExtra("userId");
        id = (MaterialEditText) findViewById(R.id.id);
        id.setText(userId);
        name = (MaterialEditText) findViewById(R.id.name);
        contactWay = (MaterialEditText) findViewById(R.id.lianxifangshi);
        keShi = (EditText) findViewById(R.id.keshi);
        zhiCheng = (EditText) findViewById(R.id.zhicheng);
        suoShuYiYuan = (EditText) findViewById(R.id.suoshuyiyuan);
        confirm = (CircularProgressButton) findViewById(R.id.confirm);

        keShi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                         DoctorInformationCenter.this,
                        android.R.layout.simple_list_item_1
                );
                arrayAdapter.add("This is item 0");
                arrayAdapter.add("This is item 1");
                ListView listView = new ListView(DoctorInformationCenter.this);
                float scale = getResources().getDisplayMetrics().density;
                int dpAsPixels = (int) (8 * scale + 0.5f);
                listView.setPadding(0, dpAsPixels, 0, dpAsPixels);
                listView.setDividerHeight(0);
                listView.setAdapter(arrayAdapter);
                final MaterialDialog alert = new MaterialDialog(DoctorInformationCenter.this)
                        .setTitle("MaterialDialog")
                        .setContentView(listView);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        keShi.setText("This is item i");
                        alert.dismiss();
                    }
                });
                alert.show();
            }
        });

        zhiCheng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                        DoctorInformationCenter.this,
                        android.R.layout.simple_list_item_1
                );
                arrayAdapter.add("This is item 0");
                arrayAdapter.add("This is item 1");
                ListView listView = new ListView(DoctorInformationCenter.this);
                float scale = getResources().getDisplayMetrics().density;
                int dpAsPixels = (int) (8 * scale + 0.5f);
                listView.setPadding(0, dpAsPixels, 0, dpAsPixels);
                listView.setDividerHeight(0);
                listView.setAdapter(arrayAdapter);
                final MaterialDialog alert = new MaterialDialog(DoctorInformationCenter.this)
                        .setTitle("MaterialDialog")
                        .setContentView(listView);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        zhiCheng.setText("This is item i");
                        alert.dismiss();
                    }
                });
                alert.show();
            }
        });

        suoShuYiYuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                        DoctorInformationCenter.this,
                        android.R.layout.simple_list_item_1
                );
                arrayAdapter.add("This is item 0");
                arrayAdapter.add("This is item 1");
                ListView listView = new ListView(DoctorInformationCenter.this);
                float scale = getResources().getDisplayMetrics().density;
                int dpAsPixels = (int) (8 * scale + 0.5f);
                listView.setPadding(0, dpAsPixels, 0, dpAsPixels);
                listView.setDividerHeight(0);
                listView.setAdapter(arrayAdapter);
                final MaterialDialog alert = new MaterialDialog(DoctorInformationCenter.this)
                        .setTitle("MaterialDialog")
                        .setContentView(listView);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        suoShuYiYuan.setText("This is item i");
                        alert.dismiss();
                    }
                });
                alert.show();
            }
        });

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                n = name.getText().toString();
                c = contactWay.getText().toString();
                keshi = keShi.getText().toString();
                zhicheng = zhiCheng.getText().toString();
                suoshuyiyuan = suoShuYiYuan.getText().toString();

                if (c.equals("") || c.length() != 11) {
                    contactWay.setError("手机号码输入有误");
                } else {
                    JSONObject jsonObject = new JSONObject();
                    try {
                        jsonObject.put("id", SharePerferenceUtils.getInformation(SharePerferenceUtils.DOCTOR_ID));
                        jsonObject.put("name", n);
                        jsonObject.put("major", keshi);
                        jsonObject.put("jobTitle", zhicheng);
                        jsonObject.put("contactNumber", c);
                        jsonObject.put("belongHospital", suoshuyiyuan);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    Map<String, String> headers = new HashMap<String, String>();
                    headers.put("Authentication", SharePerferenceUtils.getInformation(SharePerferenceUtils.AUTHENTICATION));
                    confirm.setProgress(50);
                    executeRequest(new GsonRequest(Request.Method.PATCH, Api.DOCTOR,
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
                    confirm.setProgress(100);
                    Intent intent = new Intent(DoctorInformationCenter.this, DoctorCenterActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    confirm.setProgress(0);
                    if (status == 1) {
                        confirm.setIdleText("失败");
                    } else if (status == 7) {
                        confirm.setIdleText("病人不存在");
                    }
                }
            }
        };
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_doctor_information_center, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.jump:
                Intent intent = new Intent(this, DoctorCenterActivity.class);
                startActivity(intent);
                finish();
            default:
                break;
        }
        return true;
    }
}
