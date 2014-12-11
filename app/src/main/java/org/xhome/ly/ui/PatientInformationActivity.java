package org.xhome.ly.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.dd.CircularProgressButton;
import com.rengwuxian.materialedittext.MaterialEditText;

import org.xhome.ly.R;

/**
 * Created by liurongchan on 14/12/6.
 */
public class PatientInformationActivity extends BaseActivity {

    MaterialEditText xingMing;
    MaterialEditText shenFenZheng;
    MaterialEditText xingBie;
    MaterialEditText chuShengNianYue;
    MaterialEditText dianHua;
    MaterialEditText jiaTingZhuZhi;
    EditText         wenHuaChengDu;
    MaterialEditText zhiYe;
    MaterialEditText bingLiBianHao;
    CircularProgressButton confirm;

    String xingming;
    String shenfenzheng;
    String xingbie;
    String chushengnianyue;
    String dianhua;
    String jiatingzhuzhi;
    String wenhuachengdu;
    String zhiye;
    String binglibianhao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patient_information);
        xingMing = (MaterialEditText) findViewById(R.id.name);
        shenFenZheng = (MaterialEditText) findViewById(R.id.id_card);
        xingBie = (MaterialEditText) findViewById(R.id.sex);
        chuShengNianYue = (MaterialEditText) findViewById(R.id.birthday);
        dianHua = (MaterialEditText) findViewById(R.id.phone_number);
        jiaTingZhuZhi = (MaterialEditText) findViewById(R.id.address);
        wenHuaChengDu = (EditText) findViewById(R.id.culture_degree);
        zhiYe = (MaterialEditText) findViewById(R.id.profession);
        bingLiBianHao = (MaterialEditText) findViewById(R.id.case_number);
        confirm = (CircularProgressButton) findViewById(R.id.confirm);

        shenFenZheng.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                shenfenzheng = shenFenZheng.getText().toString();
                if (!b && shenfenzheng.length() == 18) {
                    if (isJO(Integer.valueOf(shenfenzheng.substring(16, 17)))) {
                        xingBie.setText("女性");
                    } else {
                        xingBie.setText("男性");
                    }
                    String year = shenfenzheng.substring(6, 10);
                    String month = shenfenzheng.substring(10, 12);
                    String day = shenfenzheng.substring(12, 14);
                    chuShengNianYue.setText(year + "年" + month + "月" + day + "日");
                }
            }
        });
    }

    private boolean isJO(int num)
    {
        int a = num%2;
        if (a == 0)
            return true;
        else
            return false;
    }
}
