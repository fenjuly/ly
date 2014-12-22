package org.xhome.ly.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
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
 * Created by liurongchan on 14/12/14.
 */
public class SearchResultActivity extends BaseActivity {

    EditText souSuo;
    ImageView confirm;
    ListView listView;

    String searchKeyWord;

    private SearchResultAdapter searchResultAdapter;


    private List<Case1Up> case1sup = new ArrayList<Case1Up>();

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
                    progressDialog = ProgressDialog.show(SearchResultActivity.this, null, "按手机号查找");
                    Map<String, String> headers = new HashMap<String, String>();
                    headers.put("Authentication", SharePerferenceUtils.getInformation(SharePerferenceUtils.AUTHENTICATION));
                    executeRequest(new GsonRequest(Request.Method.GET, Api.CASE1_SEARCH + "?doctorId=" + doctorId + "&patientPhomeNumber=" + searchKeyWord,
                            responseListener(), errorListener(),
                            SpecialResponse.class, headers));

                } else if (searchKeyWord.length() == 18 && isNumeric(searchKeyWord)) {
                    progressDialog = ProgressDialog.show(SearchResultActivity.this, null, "按身份证号查找");
                    Map<String, String> headers = new HashMap<String, String>();
                    headers.put("Authentication", SharePerferenceUtils.getInformation(SharePerferenceUtils.AUTHENTICATION));
                    executeRequest(new GsonRequest(Request.Method.GET, Api.CASE1_SEARCH + "?doctorId=" + doctorId + "patientIdCard=" + searchKeyWord,
                            responseListener(), errorListener(),
                            SpecialResponse.class, headers));
                } else if (!searchKeyWord.equals("")) {
                    progressDialog = ProgressDialog.show(SearchResultActivity.this, null, "按姓名查找");
                    Map<String, String> headers = new HashMap<String, String>();
                    headers.put("Authentication", SharePerferenceUtils.getInformation(SharePerferenceUtils.AUTHENTICATION));
                    executeRequest(new GsonRequest(Request.Method.GET, Api.CASE1_SEARCH + "?doctorId="+ doctorId +"patientName=" + searchKeyWord,
                            responseListener(), errorListener(),
                            SpecialResponse.class, headers));
                }

            }
        });
    }


    private com.android.volley.Response.Listener<SpecialResponse> responseListener() {
        return new com.android.volley.Response.Listener<SpecialResponse>() {
            @Override
            public void onResponse(SpecialResponse response) {
                progressDialog.dismiss();
                int status = response.getStatus();
                if (status == 0) {
                    case1sup = response.getBody();
                    searchResultAdapter = new SearchResultAdapter(SearchResultActivity.this, case1sup);
                    listView.setAdapter(searchResultAdapter);
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
