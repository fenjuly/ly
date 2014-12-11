package org.xhome.ly.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

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

/**
 * Created by liurongchan on 14/12/3.
 */
public class RegistActivity extends BaseActivity {

    MaterialEditText userId;
    MaterialEditText certificationNumber;
    MaterialEditText password;
    MaterialEditText repeat_password;
    CircularProgressButton confirm;
    TextView toLogin;


    String id;
    String cert_nu;
    String pwd;
    String r_pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.regist);
        userId = (MaterialEditText) findViewById(R.id.id);
        certificationNumber = (MaterialEditText) findViewById(R.id.certification);
        password = (MaterialEditText) findViewById(R.id.password);
        repeat_password = (MaterialEditText) findViewById(R.id.repeat_password);
        confirm = (CircularProgressButton) findViewById(R.id.confirm);
        toLogin = (TextView) findViewById(R.id.to_login);


        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id = userId.getText().toString();
                cert_nu = certificationNumber.getText().toString();
                pwd = password.getText().toString();
                r_pwd = repeat_password.getText().toString();
                if (id.equals("")) {
                    userId.setError("ID不能为空");
                }  else if (cert_nu.equals("")) {
                    certificationNumber.setError("行医资格证不能为空");
                } else if (pwd.equals("")) {
                    password.setError("密码不能为空");
                } else if (!pwd.equals(r_pwd)) {
                    repeat_password.setError("两次输入密码不一致");
                } else {
                    JSONObject jsonObject = new JSONObject();
                    try {
                        jsonObject.put("userId", id);
                        jsonObject.put("certificationNumber", cert_nu);
                        jsonObject.put("password", pwd);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    confirm.setProgress(50);
                    executeRequest(new GsonRequest(Request.Method.POST, Api.DOCTOR,
                            jsonObject.toString(), responseListener(), errorListener(),
                            Response.class));
                }
            }
        });

        toLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegistActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private com.android.volley.Response.Listener<Response> responseListener() {
        return new com.android.volley.Response.Listener<Response>() {
            @Override
            public void onResponse(Response response) {
                int status = response.getStatus();
                float mDataId = Float.valueOf(response.getBody().toString());
                int dataId = (int) mDataId;
                if (status == 0) {
                    confirm.setProgress(100);
                    SharePerferenceUtils.addOther(SharePerferenceUtils.AUTHENTICATION, id + "%" + pwd);
                    SharePerferenceUtils.addOther(SharePerferenceUtils.DOCTOR_ID, String.valueOf(dataId));
                    Intent intent = new Intent(RegistActivity.this, DoctorInformationCenter.class);
                    startActivity(intent);
                    finish();
                } else {
                    confirm.setProgress(0);
                    if (status == 6) {
                        userId.setError("用户已存在");
                    } else if (status == 1) {
                        password.setError("注册失败");
                    }
                }
            }
        };
    }
}
