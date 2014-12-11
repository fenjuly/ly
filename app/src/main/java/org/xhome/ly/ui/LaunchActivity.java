package org.xhome.ly.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import org.xhome.ly.R;
import org.xhome.ly.util.SharePerferenceUtils;

/**
 * Created by liurongchan on 14/12/2.
 */
public class LaunchActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lunch_activity);
        if (SharePerferenceUtils.getInformation(SharePerferenceUtils.AUTHENTICATION).equals("")) {
            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    Intent intent = new Intent(LaunchActivity.this,
                            RegistActivity.class);
                    startActivity(intent);
                    finish();
                }
            }, 2000);
        } else {
            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    Intent intent = new Intent(LaunchActivity.this,
                            DoctorCenterActivity.class);
                    startActivity(intent);
                    finish();
                }
            }, 2000);
        }
    }
}
