package org.xhome.ly.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import com.android.volley.Request;

import org.xhome.ly.R;
import org.xhome.ly.api.Api;
import org.xhome.ly.bean.Case1Up;
import org.xhome.ly.bean.SpecialResponse;
import org.xhome.ly.network.GsonRequest;
import org.xhome.ly.ui.adapter.SearchResultAdapter;
import org.xhome.ly.util.SharePerferenceUtils;
import org.xhome.ly.util.ToastUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liurongchan on 14/12/15.
 */
public class SearchCaseResultActivity extends BaseActivity {

    String leixing;
    String xingbie;
    String riqi;
    String request;

    private List<Case1Up> case1sup = new ArrayList<Case1Up>();

    private ProgressDialog progressDialog;

    private SearchResultAdapter searchResultAdapter;

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_case_result);
        Intent intent = getIntent();
        leixing = intent.getStringExtra("type");
        xingbie = intent.getStringExtra("patientSex");
        riqi = intent.getStringExtra("date");
        listView = (ListView) findViewById(R.id.listview);
        String doctorId = SharePerferenceUtils.getInformation(SharePerferenceUtils.DOCTOR_ID);
        request = Api.CASE1_SEARCH + "?doctorId=" + doctorId + "&";
        if (xingbie != null && !xingbie.equals("")) {
            request = request + "patientSex=" + xingbie + "&";
        }
        if (riqi != null && !riqi.equals("")) {
            request = request + "date=" +riqi;
        }
        progressDialog = ProgressDialog.show(SearchCaseResultActivity.this, null, "正在查找");
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Authentication", SharePerferenceUtils.getInformation(SharePerferenceUtils.AUTHENTICATION));
        executeRequest(new GsonRequest(Request.Method.GET, request,
                responseListener(), errorListener(),
                SpecialResponse.class, headers));

    }

    private com.android.volley.Response.Listener<SpecialResponse> responseListener() {
        return new com.android.volley.Response.Listener<SpecialResponse>() {
            @Override
            public void onResponse(SpecialResponse response) {
                progressDialog.dismiss();
                int status = response.getStatus();
                if (status == 0) {
                    case1sup = response.getBody();
                    searchResultAdapter = new SearchResultAdapter(SearchCaseResultActivity.this, case1sup);
                    listView.setAdapter(searchResultAdapter);
                } else {
                    ToastUtils.showLong("未知错误");
                }
            }
        };
    }
}
