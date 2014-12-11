package org.xhome.ly.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.xhome.ly.R;

import me.drakeet.materialdialog.MaterialDialog;

/**
 * Created by liurongchan on 14/12/3.
 */
public class DoctorCenterActivity extends BaseActivity {

    View xinZeng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);
        xinZeng = findViewById(R.id.xinzeng);

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
                        switch (position) {
                            case 0:
                                Intent intent = new Intent(DoctorCenterActivity.this, Case1InformationActivity.class);
                                alert.dismiss();
                                startActivity(intent);
                        }
                        alert.dismiss();
                    }
                });
                alert.show();
            }
        });
    }
}
