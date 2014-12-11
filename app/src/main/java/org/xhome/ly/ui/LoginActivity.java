package org.xhome.ly.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.android.volley.Request;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.dd.CircularProgressButton;

import org.json.JSONException;
import org.json.JSONObject;
import org.xhome.ly.R;
import org.xhome.ly.api.Api;
import org.xhome.ly.bean.Response;
import org.xhome.ly.network.GsonRequest;
import org.xhome.ly.util.SharePerferenceUtils;


/**
 * Created by liurongchan on 14/12/2.
 */
public class LoginActivity extends BaseActivity {

    MaterialEditText userId;
    MaterialEditText password;
    CircularProgressButton confirm;


    String id;
    String pwd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        userId = (MaterialEditText)findViewById(R.id.id);
        password = (MaterialEditText)findViewById(R.id.password);
        confirm = (CircularProgressButton)findViewById(R.id.confirm);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id = userId.getText().toString();
                pwd = password.getText().toString();
                if (id.equals("")) {
                    userId.setError("ID不能为空");
                } else if (pwd.equals("")) {
                    password.setError("密码不能为空");
                } else {
                    confirm.setProgress(50);
                    JSONObject jsonObject = new JSONObject();
                    try {
                        jsonObject.put("userId", id);
                        jsonObject.put("password", pwd);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                  executeRequest(new GsonRequest(Request.Method.POST, Api.AUTHENTICATION,
                          jsonObject.toString(), responseListener(), errorListener(), Response.class
                          ));
                }
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
                    Intent intent = new Intent(LoginActivity.this, DoctorCenterActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    confirm.setProgress(0);
                    confirm.setIdleText("认证失败");
                   if (status == 7) {
                       userId.setError("用户不存在");
                   } else if (status == 9) {
                       password.setError("密码不正确");
                   }
                }
            }
        };
    }

}
