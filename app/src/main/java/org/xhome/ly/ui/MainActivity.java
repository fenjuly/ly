package org.xhome.ly.ui;

import android.app.Activity;
import android.os.Bundle;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.rengwuxian.materialedittext.MaterialEditText;

import org.xhome.ly.R;


public class MainActivity extends Activity {


    MaterialEditText userId;
    MaterialEditText certificationNumber;
    MaterialEditText password;
    MaterialEditText repeat_password;


    String id;
    String cert_nu;
    String pwd;
    String r_pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shuzhongxinxi);
        userId = (MaterialEditText) findViewById(R.id.id);
        certificationNumber = (MaterialEditText) findViewById(R.id.certification);
        password = (MaterialEditText) findViewById(R.id.password);
        repeat_password = (MaterialEditText) findViewById(R.id.repeat_password);

    }

}
