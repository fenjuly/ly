package org.xhome.ly.ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;

import org.xhome.ly.R;
import org.xhome.ly.api.Api;
import org.xhome.ly.bean.Response;
import org.xhome.ly.network.GsonRequest;
import org.xhome.ly.util.SharePerferenceUtils;
import org.xhome.ly.util.ToastUtils;

import java.util.HashMap;
import java.util.Map;

import me.drakeet.materialdialog.MaterialDialog;

/**
 * Created by liurongchan on 14/12/3.
 */
public class DoctorCenterActivity extends BaseActivity {

    View xinZeng;
    View chaZhao;
    View bingLiArea;
    TextView number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);
        setTitle("电生理上报系统");
        setTitleColor(Color.WHITE);
        bingLiArea = findViewById(R.id.bingli_area);
        xinZeng = findViewById(R.id.xinzeng);
        number = (TextView) findViewById(R.id.number);
        chaZhao = findViewById(R.id.chazhao);
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Authentication", SharePerferenceUtils.getInformation(SharePerferenceUtils.AUTHENTICATION));
        executeRequest(new GsonRequest(Request.Method.GET, Api.CASE_COUNT + "?doctorId=" + SharePerferenceUtils.getInformation(SharePerferenceUtils.DOCTOR_ID),
                responseListener(), errorListener(),
                Response.class, headers));

        bingLiArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DoctorCenterActivity.this, SearchCaseActivity.class);
                startActivity(intent);
            }
        });

        chaZhao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DoctorCenterActivity.this, SearchResultActivity.class);
                startActivity(intent);
            }
        });

        xinZeng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                        DoctorCenterActivity.this,
                        android.R.layout.simple_list_item_1
                );
                arrayAdapter.add("室速病");
                arrayAdapter.add("房颤病");
                arrayAdapter.add("房速病");
                ListView listView = new ListView(DoctorCenterActivity.this);
                float scale = getResources().getDisplayMetrics().density;
                int dpAsPixels = (int) (8 * scale + 0.5f);
                listView.setPadding(0, dpAsPixels, 0, dpAsPixels);
                listView.setDividerHeight(0);
                listView.setAdapter(arrayAdapter);
                final MaterialDialog alert = new MaterialDialog(DoctorCenterActivity.this)
                        .setTitle("选择类型")
                        .setContentView(listView);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                         Intent intent = new Intent(DoctorCenterActivity.this, PatientInformationActivity.class);
                         intent.putExtra("caseNumber", position);
                         alert.dismiss();
                         startActivity(intent);
                    }
                });
                alert.show();
            }
        });


    }

    private com.android.volley.Response.Listener<Response> responseListener() {
        return new com.android.volley.Response.Listener<Response>() {
            @Override
            public void onResponse(Response response) {
                int status = response.getStatus();
                if (status == 0) {
                    float mCounts = Float.valueOf(response.getBody().toString());
                    int counts = (int) mCounts;
                    SharePerferenceUtils.addOther("counts", String.valueOf(counts));
                    number.setText("共计" + counts + "个病例");
                } else {
                    ToastUtils.showLong("未知错误");
                }
            }
        };
    }

}
