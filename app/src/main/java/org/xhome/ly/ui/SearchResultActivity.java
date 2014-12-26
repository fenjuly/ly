package org.xhome.ly.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
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
 * Created by liurongchan on 14/12/14.
 */
public class SearchResultActivity extends BaseActivity {

    EditText souSuo;
    ImageView confirm;
    ListView listView;

    String searchKeyWord;

    private SearchResultAdapter searchResultAdapter;


    private List<Case1Up> case1sup = new ArrayList<Case1Up>();
    private List<Case2Up> case2sup = new ArrayList<Case2Up>();
    private List<Case3Up> case3sup = new ArrayList<Case3Up>();

    private List<Case> cases;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searchresult);
        souSuo = (EditText) findViewById(R.id.search);
        confirm = (ImageView) findViewById(R.id.confirm);
        listView = (ListView) findViewById(R.id.listview);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String doctorId = SharePerferenceUtils.getInformation(SharePerferenceUtils.DOCTOR_ID);
                searchKeyWord = souSuo.getText().toString();
                if (searchKeyWord.length() == 11 && isNumeric(searchKeyWord)) {
                    cases = new ArrayList<Case>();
                    searchResultAdapter = new SearchResultAdapter(SearchResultActivity.this, cases);
                    listView.setAdapter(searchResultAdapter);
                    progressDialog = ProgressDialog.show(SearchResultActivity.this, null, "按手机号查找");
                    Map<String, String> headers = new HashMap<String, String>();
                    headers.put("Authentication", SharePerferenceUtils.getInformation(SharePerferenceUtils.AUTHENTICATION));
                    Log.e("api", Api.CASE1_SEARCH + "?doctorId=" + doctorId + "&patientPhomeNumber=" + searchKeyWord);
                    executeRequest(new GsonRequest(Request.Method.GET, Api.CASE1_SEARCH + "?doctorId=" + doctorId + "&patientPhomeNumber=" + searchKeyWord,
                            case1responseListener(), errorListener(),
                            Special1Response.class, headers));
                    executeRequest(new GsonRequest(Request.Method.GET, Api.CASE2_SEARCH + "?doctorId=" + doctorId + "&patientPhomeNumber=" + searchKeyWord,
                            case2responseListener(), errorListener(),
                            Special2Response.class, headers));
                    executeRequest(new GsonRequest(Request.Method.GET, Api.CASE3_SEARCH + "?doctorId=" + doctorId + "&patientPhomeNumber=" + searchKeyWord,
                            case3responseListener(), errorListener(),
                            Special3Response.class, headers));

                } else if (searchKeyWord.length() == 18 && isNumeric(searchKeyWord)) {
                    cases = new ArrayList<Case>();
                    searchResultAdapter = new SearchResultAdapter(SearchResultActivity.this, cases);
                    listView.setAdapter(searchResultAdapter);
                    progressDialog = ProgressDialog.show(SearchResultActivity.this, null, "按身份证号查找");
                    Map<String, String> headers = new HashMap<String, String>();
                    headers.put("Authentication", SharePerferenceUtils.getInformation(SharePerferenceUtils.AUTHENTICATION));
                    executeRequest(new GsonRequest(Request.Method.GET, Api.CASE1_SEARCH + "?doctorId=" + doctorId + "&patientIdCard=" + searchKeyWord,
                            case1responseListener(), errorListener(),
                            Special1Response.class, headers));
                    executeRequest(new GsonRequest(Request.Method.GET, Api.CASE2_SEARCH + "?doctorId=" + doctorId + "&patientIdCard=" + searchKeyWord,
                            case2responseListener(), errorListener(),
                            Special2Response.class, headers));
                    executeRequest(new GsonRequest(Request.Method.GET, Api.CASE3_SEARCH + "?doctorId=" + doctorId + "&patientIdCard=" + searchKeyWord,
                            case3responseListener(), errorListener(),
                            Special3Response.class, headers));
                } else if (!searchKeyWord.equals("")) {
                    cases = new ArrayList<Case>();
                    searchResultAdapter = new SearchResultAdapter(SearchResultActivity.this, cases);
                    listView.setAdapter(searchResultAdapter);
                    progressDialog = ProgressDialog.show(SearchResultActivity.this, null, "按姓名查找");
                    Map<String, String> headers = new HashMap<String, String>();
                    headers.put("Authentication", SharePerferenceUtils.getInformation(SharePerferenceUtils.AUTHENTICATION));
                    executeRequest(new GsonRequest(Request.Method.GET, Api.CASE1_SEARCH + "?doctorId=" + doctorId + "&patientName=" + searchKeyWord,
                            case1responseListener(), errorListener(),
                            Special1Response.class, headers));
                    executeRequest(new GsonRequest(Request.Method.GET, Api.CASE2_SEARCH + "?doctorId=" + doctorId + "&patientName=" + searchKeyWord,
                            case2responseListener(), errorListener(),
                            Special2Response.class, headers));
                    executeRequest(new GsonRequest(Request.Method.GET, Api.CASE3_SEARCH + "?doctorId=" + doctorId + "&patientName=" + searchKeyWord,
                            case3responseListener(), errorListener(),
                            Special3Response.class, headers));
                }

            }
        });
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


    private boolean isNumeric(String str){
        for (int i = str.length();--i>=0;){
            if (!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        return true;
    }

}
