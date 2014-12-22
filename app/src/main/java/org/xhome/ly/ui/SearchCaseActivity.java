package org.xhome.ly.ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.dd.CircularProgressButton;
import com.fourmob.datetimepicker.date.DatePickerDialog;

import org.xhome.ly.R;

import java.util.Calendar;
import java.util.Date;

import me.drakeet.materialdialog.MaterialDialog;

/**
 * Created by liurongchan on 14/12/14.
 */
public class SearchCaseActivity extends BaseActivity {

    public static final String DATEPICKER_TAG = "datepicker";

    private static final String[] types = {"室速", "房颤", "房速", "全部"};

    EditText leiXing;
    EditText xingBie;
    EditText riQi;
    CircularProgressButton confirm;


    String leixing = "";
    String xingbie = "";
    String riqi = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sousuobingli);
        setTitle("搜索病例");
        setTitleColor(Color.WHITE);
        leiXing = (EditText) findViewById(R.id.leixing);
        xingBie = (EditText) findViewById(R.id.xingbie);
        riQi = (EditText) findViewById(R.id.riqi);
        confirm = (CircularProgressButton) findViewById(R.id.confirm);

        leiXing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                        SearchCaseActivity.this,
                        android.R.layout.simple_list_item_1
                );
               for (String type : types) {
                   arrayAdapter.add(type);
               }
                ListView listView = new ListView(SearchCaseActivity.this);
                float scale = getResources().getDisplayMetrics().density;
                int dpAsPixels = (int) (8 * scale + 0.5f);
                listView.setPadding(0, dpAsPixels, 0, dpAsPixels);
                listView.setDividerHeight(0);
                listView.setAdapter(arrayAdapter);
                final MaterialDialog alert = new MaterialDialog(SearchCaseActivity.this)
                        .setTitle("选择类型")
                        .setContentView(listView);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                                leixing = types[position];
                                leiXing.setText(types[position]);
                        alert.dismiss();
                    }
                });
                alert.show();
            }
        });

        xingBie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                        SearchCaseActivity.this,
                        android.R.layout.simple_list_item_1
                );
                arrayAdapter.add("男");
                arrayAdapter.add("女");
                arrayAdapter.add("全部");
                ListView listView = new ListView(SearchCaseActivity.this);
                float scale = getResources().getDisplayMetrics().density;
                int dpAsPixels = (int) (8 * scale + 0.5f);
                listView.setPadding(0, dpAsPixels, 0, dpAsPixels);
                listView.setDividerHeight(0);
                listView.setAdapter(arrayAdapter);
                final MaterialDialog alert = new MaterialDialog(SearchCaseActivity.this)
                        .setTitle("选择性别")
                        .setContentView(listView);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                        switch (position) {
                            case 0:
                                xingBie.setText("男");
                                xingbie = "男";
                                break;
                            case 1:
                                xingBie.setText("女");
                                xingbie = "女";
                                break;
                            default:
                                xingbie = "";
                                break;
                        }
                        alert.dismiss();
                    }
                });
                alert.show();
            }
        });

        riQi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar calendar = Calendar.getInstance();
                final DatePickerDialog datePickerDialog = DatePickerDialog
                        .newInstance(new ShouShuRiQiDatePickrDialogListener(), calendar.
                                get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), false);
                datePickerDialog.setYearRange(1985, 2028);
                datePickerDialog.show(getSupportFragmentManager(), DATEPICKER_TAG);
            }
        });

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SearchCaseActivity.this, SearchCaseResultActivity.class);
                intent.putExtra("date", riqi);
                intent.putExtra("patientSex", xingbie);
                intent.putExtra("type", leixing);
                startActivity(intent);
            }
        });
    }

    private class ShouShuRiQiDatePickrDialogListener implements DatePickerDialog.OnDateSetListener {

        @Override
        public void onDateSet(DatePickerDialog datePickerDialog, int year, int month, int day) {
            month++;
            riqi = year + "/" + month + "/" + day;
            riQi.setText(year+ "年" + month  + "月" + day + "日");
        }
    }
}
