package org.xhome.ly.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import com.android.volley.Request;

import org.xhome.ly.R;
import org.xhome.ly.api.Api;
import org.xhome.ly.bean.Case;
import org.xhome.ly.bean.Case1Up;
import org.xhome.ly.bean.Case2Up;
import org.xhome.ly.bean.Case3Up;
import org.xhome.ly.bean.Special1Response;
import org.xhome.ly.bean.Special2Response;
import org.xhome.ly.bean.Special3Response;
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
    String request1;
    String request2;
    String request3;

    private List<Case1Up> case1sup = new ArrayList<Case1Up>();
    private List<Case2Up> case2sup = new ArrayList<Case2Up>();
    private List<Case3Up> case3sup = new ArrayList<Case3Up>();

    private List<Case> cases;

    private ProgressDialog progressDialog;

    private SearchResultAdapter searchResultAdapter;

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_case_result);
        setTitle("搜索结果");
        Intent intent = getIntent();
        leixing = intent.getStringExtra("type");
        xingbie = intent.getStringExtra("patientSex");
        riqi = intent.getStringExtra("date");
        listView = (ListView) findViewById(R.id.listview);
        String doctorId = SharePerferenceUtils.getInformation(SharePerferenceUtils.DOCTOR_ID);

        request1 = Api.CASE1_SEARCH + "?doctorId=" + doctorId + "&";
        if (xingbie != null && !xingbie.equals("")) {
            request1 = request1 + "patientSex=" + xingbie + "&";
        }
        if (riqi != null && !riqi.equals("")) {
            request1 = request1 + "date=" +riqi;
        }

        request2 = Api.CASE2_SEARCH + "?doctorId=" + doctorId + "&";
        if (xingbie != null && !xingbie.equals("")) {
            request2 = request2 + "patientSex=" + xingbie + "&";
        }
        if (riqi != null && !riqi.equals("")) {
            request2 = request2 + "date=" +riqi;
        }

        request3 = Api.CASE3_SEARCH + "?doctorId=" + doctorId + "&";
        if (xingbie != null && !xingbie.equals("")) {
            request3 = request3 + "patientSex=" + xingbie + "&";
        }
        if (riqi != null && !riqi.equals("")) {
            request3 = request3 + "date=" +riqi;
        }

        if (leixing.equals("室速")) {
            cases = new ArrayList<Case>();
            searchResultAdapter = new SearchResultAdapter(SearchCaseResultActivity.this, cases);
            listView.setAdapter(searchResultAdapter);
            progressDialog = ProgressDialog.show(SearchCaseResultActivity.this, null, "正在查找");
            Map<String, String> headers = new HashMap<String, String>();
            headers.put("Authentication", SharePerferenceUtils.getInformation(SharePerferenceUtils.AUTHENTICATION));
            executeRequest(new GsonRequest(Request.Method.GET, request1,
                    case1responseListener(), errorListener(),
                    Special1Response.class, headers));
        } else if (leixing.equals("房速")) {
            cases = new ArrayList<Case>();
            searchResultAdapter = new SearchResultAdapter(SearchCaseResultActivity.this, cases);
            listView.setAdapter(searchResultAdapter);
            progressDialog = ProgressDialog.show(SearchCaseResultActivity.this, null, "正在查找");
            Map<String, String> headers = new HashMap<String, String>();
            headers.put("Authentication", SharePerferenceUtils.getInformation(SharePerferenceUtils.AUTHENTICATION));
            executeRequest(new GsonRequest(Request.Method.GET, request2,
                    case2responseListener(), errorListener(),
                    Special2Response.class, headers));
        } else if (leixing.equals("房颤")){
            cases = new ArrayList<Case>();
            searchResultAdapter = new SearchResultAdapter(SearchCaseResultActivity.this, cases);
            listView.setAdapter(searchResultAdapter);
            progressDialog = ProgressDialog.show(SearchCaseResultActivity.this, null, "正在查找");
            Map<String, String> headers = new HashMap<String, String>();
            headers.put("Authentication", SharePerferenceUtils.getInformation(SharePerferenceUtils.AUTHENTICATION));
            executeRequest(new GsonRequest(Request.Method.GET, request3,
                    case3responseListener(), errorListener(),
                    Special3Response.class, headers));
        } else {
            cases = new ArrayList<Case>();
            searchResultAdapter = new SearchResultAdapter(SearchCaseResultActivity.this, cases);
            listView.setAdapter(searchResultAdapter);
            progressDialog = ProgressDialog.show(SearchCaseResultActivity.this, null, "正在查找");
            Map<String, String> headers = new HashMap<String, String>();
            headers.put("Authentication", SharePerferenceUtils.getInformation(SharePerferenceUtils.AUTHENTICATION));
            executeRequest(new GsonRequest(Request.Method.GET, request1,
                    case1responseListener(), errorListener(),
                    Special1Response.class, headers));
            executeRequest(new GsonRequest(Request.Method.GET, request2,
                    case2responseListener(), errorListener(),
                    Special2Response.class, headers));
            executeRequest(new GsonRequest(Request.Method.GET, request3,
                    case3responseListener(), errorListener(),
                    Special3Response.class, headers));
        }


    }

    private com.android.volley.Response.Listener<Special1Response> case1responseListener() {
        return new com.android.volley.Response.Listener<Special1Response>() {
            @Override
            public void onResponse(Special1Response response) {
                progressDialog.dismiss();
                int status = response.getStatus();
                if (status == 0) {
                    case1sup = response.getBody();
                    cases.addAll(case1sup);
                    searchResultAdapter.refresh(cases);
                } else {
                    ToastUtils.showLong("未知错误");
                }
            }
        };
    }

    private com.android.volley.Response.Listener<Special2Response> case2responseListener() {
        return new com.android.volley.Response.Listener<Special2Response>() {
            @Override
            public void onResponse(Special2Response response) {
                progressDialog.dismiss();
                int status = response.getStatus();
                if (status == 0) {
                    case2sup = response.getBody();
                    cases.addAll(case2sup);
                    searchResultAdapter.refresh(cases);
                } else {
                    ToastUtils.showLong("未知错误");
                }
            }
        };
    }

    private com.android.volley.Response.Listener<Special3Response> case3responseListener() {
        return new com.android.volley.Response.Listener<Special3Response>() {
            @Override
            public void onResponse(Special3Response response) {
                progressDialog.dismiss();
                int status = response.getStatus();
                if (status == 0) {
                    case3sup = response.getBody();
                    cases.addAll(case3sup);
                    searchResultAdapter.refresh(cases);
                } else {
                    ToastUtils.showLong("未知错误");
                }
            }
        };
    }
}
