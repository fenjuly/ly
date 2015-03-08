package org.xhome.ly.ui.fragment.vt;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;

import com.dd.CircularProgressButton;
import com.doomonafireball.betterpickers.hmspicker.HmsPickerBuilder;
import com.doomonafireball.betterpickers.hmspicker.HmsPickerDialogFragment;
import com.doomonafireball.betterpickers.numberpicker.NumberPickerBuilder;
import com.doomonafireball.betterpickers.numberpicker.NumberPickerDialogFragment;
import com.fourmob.datetimepicker.date.DatePickerDialog;
import com.google.gson.Gson;
import com.rengwuxian.materialedittext.MaterialEditText;

import org.xhome.ly.App;
import org.xhome.ly.R;
import org.xhome.ly.bean.Case1;
import org.xhome.ly.dao.Case1DataHelper;
import org.xhome.ly.util.ToastUtils;

import java.util.Calendar;
import java.util.Date;

import me.drakeet.materialdialog.MaterialDialog;

/**
 * Created by liurongchan on 14/12/3.
 */
public class DiagnosticMessageFragment extends BaseFragment  {

    public static final String DATEPICKER_TAG = "datepicker";



    private static DiagnosticMessageFragment fragment;

    private static final String[] types = {"阵发性", "持续性", "慢性连续性"};

    private static final String[] zhenduan_types = {"特发性室性室早/室速", "器质性室速", "⼼心外膜室速", "分⽀支折返性室速"};

    EditText shouShuRiQi;
    MaterialEditText shouShuBianHao;
    MaterialEditText shuZhe;
    EditText shiSuLeiXing;
    EditText shiSuBingCheng;
    EditText linChuangXinLvShiChangZhenDuan;

    EditText buWei;

    CircularProgressButton confirm;

    String shoushuriqi;
    String shoushubianhao;
    String shuzhe;
    String shisuleixing;
    String shisubingcheng;
    String linchuangxinlvshichangzhenduan;
    String dianshenlijianchazhenduan;
    String shuhouzhenduan;
    String jizhi;
    String buwei;

    String shisubingchengtext = "";
    String niantext = "";
    String yuetext = "";

    //室速类型
    String spinnertext = "";
    String pindutext = "";
    String meicifazuochixushijiantext = "";
    String zuijinfazuochixushijiantext = "";
    String zaobofuhetext = "";
    String cengyongzhuanfufangfatext = "";
    String zhuanlvyongyaotext = "";

    String buweitext = "";
    String youshitext = "";
    String zuoshitext = "";
    String liuchudaotext = "";
    String xinjianbutext = "";
    String jiangetext = "";
    String qianbitext = "";
    String houbitext = "";
    String qitatext = "";

    public static DiagnosticMessageFragment newInstance(Case1 case1) {
        if (fragment == null) {
            fragment = new DiagnosticMessageFragment();
        }
        Bundle bundle = fragment.getArguments();
        if (bundle == null) {
            bundle = new Bundle();
            bundle.putString("case1", new Gson().toJson(case1));
            fragment.setArguments(bundle);
        } else {
            bundle.putString("case1", new Gson().toJson(case1));
        }

        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(
                R.layout.zhenduanxinxi, container, false);

        init();
        shouShuRiQi = (EditText) rootView.findViewById(R.id.shoushuriqi);
        shouShuBianHao = (MaterialEditText) rootView.findViewById(R.id.shoushubianhao);
        shuZhe = (MaterialEditText) rootView.findViewById(R.id.shuzhe);
        shiSuLeiXing = (EditText) rootView.findViewById(R.id.shisuleixing);
        shiSuBingCheng = (EditText) rootView.findViewById(R.id.shisubingcheng);
        linChuangXinLvShiChangZhenDuan = (EditText) rootView.findViewById(R.id.linchuangxinlvshichangzhenduan);

        buWei = (EditText) rootView.findViewById(R.id.buwei);
        confirm = (CircularProgressButton) rootView.findViewById(R.id.confirm);

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DATE);

        month++;
        Date date = new Date(year - 1900, month - 1, day);
        case1.setOperationData(date);
        shouShuRiQi.setText(year+ "年" + month + "月" + day + "日");

        shouShuRiQi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar calendar = Calendar.getInstance();
                final DatePickerDialog datePickerDialog = DatePickerDialog
                        .newInstance(new ShouShuRiQiDatePickrDialogListener(), calendar.
                                get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), false);
                datePickerDialog.setYearRange(1985, 2028);
                datePickerDialog.show(getActivity().getSupportFragmentManager(), DATEPICKER_TAG);
            }
        });

        linChuangXinLvShiChangZhenDuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                        getActivity(),
                        android.R.layout.simple_list_item_1
                );
                for (int i = 0; i < zhenduan_types.length; i++) {
                    arrayAdapter.add(zhenduan_types[i]);
                }
                ListView listView = new ListView(getActivity());
                float scale = getResources().getDisplayMetrics().density;
                int dpAsPixels = (int) (8 * scale + 0.5f);
                listView.setPadding(0, dpAsPixels, 0, dpAsPixels);
                listView.setDividerHeight(0);
                listView.setAdapter(arrayAdapter);
                final MaterialDialog alert = new MaterialDialog(getActivity())
                        .setTitle("临床心率失常诊断")
                        .setContentView(listView);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                        linChuangXinLvShiChangZhenDuan.setText(zhenduan_types[position]);
                        alert.dismiss();
                    }
                });
                alert.show();
            }
        });

        buWei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 youshitext = "";
                 zuoshitext = "";
                 liuchudaotext = "";
                 xinjianbutext = "";
                 jiangetext = "";
                 qianbitext = "";
                 houbitext = "";
                 qitatext = "";

                View v = LayoutInflater.from(getActivity()).inflate(R.layout.buwei, null);
                final MaterialDialog alert = new MaterialDialog(getActivity())
                        .setTitle("部位")
                        .setContentView(v);
                alert.show();
                final CheckBox youshi = (CheckBox) v.findViewById(R.id.youshi);
                CheckBox zuoshi = (CheckBox) v.findViewById(R.id.zuoshi);
                CheckBox liuchudao = (CheckBox) v.findViewById(R.id.liuchudao);
                CheckBox xinjianbu = (CheckBox) v.findViewById(R.id.xinjianbu);
                CheckBox jiange = (CheckBox) v.findViewById(R.id.jiange);
                CheckBox qianbi = (CheckBox) v.findViewById(R.id.qianbi);
                CheckBox houbi = (CheckBox) v.findViewById(R.id.houbi);

                final MaterialEditText qita = (MaterialEditText) v.findViewById(R.id.qita);
                CircularProgressButton confirm = (CircularProgressButton) v.findViewById(R.id.confirm);

                youshi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            youshitext = "右室";
                        } else {
                            youshitext = "";
                        }
                    }
                });

                zuoshi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            zuoshitext = "左室";
                        } else {
                            zuoshitext = "";
                        }
                    }
                });

                liuchudao.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            liuchudaotext = "流出道";
                        } else {
                            liuchudaotext = "";
                        }
                    }
                });

                xinjianbu.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            xinjianbutext = "心尖部";
                        } else {
                            xinjianbutext = "";
                        }
                    }
                });

                jiange.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            jiangetext = "间隔";
                        } else {
                            jiangetext = "";
                        }
                    }
                });

                qianbi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            qianbitext = "前壁";
                        } else {
                            qianbitext = "";
                        }
                    }
                });

                houbi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            houbitext = "后壁";
                        } else {
                            houbitext = "";
                        }
                    }
                });

                confirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        buweitext = "";
                        qitatext = qita.getText().toString();
                        buweitext = youshitext + " " + zuoshitext + " "
                                + liuchudaotext + " " + xinjianbutext + " "
                                + jiangetext + " " + qianbitext + " " + houbitext + " " + qitatext;
                        buWei.setText("部位:" + buweitext);
                        alert.dismiss();
                    }
                });

            }
        });


        shiSuLeiXing.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                final View v = LayoutInflater.from(getActivity()).inflate(R.layout.shisuleixing, null);
                final MaterialDialog alert = new MaterialDialog(getActivity())
                        .setTitle("室速类型")
                        .setContentView(v);
                alert.show();
                final Spinner spinner = (Spinner) v.findViewById(R.id.leixing);
                final EditText zaobofuhe = (EditText) v.findViewById(R.id.zaobofuhe);
                final EditText pindu = (EditText) v.findViewById(R.id.pindu);
                final EditText meicifazuochixushijian = (EditText) v.findViewById(R.id.meicifazuochixushijian);
                final EditText zuijinfazuochixushijian = (EditText) v.findViewById(R.id.zuijinfazuochixushijian);
                final LinearLayout pindu_aera = (LinearLayout) v.findViewById(R.id.pindu_aera);
                final LinearLayout zaobofuhe_aera = (LinearLayout) v.findViewById(R.id.zaobofuhe_aera);
                final LinearLayout meicifazuochixushijian_aera = (LinearLayout) v.findViewById(R.id.meicifazuochixushijian_aera);
                final LinearLayout zuijinfazuochixushijian_aera = (LinearLayout) v.findViewById(R.id.zuijinfazuochixushijian_aera);
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                        getActivity(),
                        android.R.layout.simple_list_item_1
                );
                for (int i = 0; i < types.length; i++) {
                    arrayAdapter.add(types[i]);
                }
                spinner.setAdapter(arrayAdapter);
                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                        spinnertext = types[position];
                        if (position == 1) {
                            zaobofuhe_aera.setVisibility(View.VISIBLE);
                            pindu_aera.setVisibility(View.GONE);
                            meicifazuochixushijian_aera.setVisibility(View.GONE);
                            zuijinfazuochixushijian_aera.setVisibility(View.GONE);
                        } else {
                            zaobofuhe_aera.setVisibility(View.GONE);
                            pindu_aera.setVisibility(View.VISIBLE);
                            meicifazuochixushijian_aera.setVisibility(View.VISIBLE);
                            zuijinfazuochixushijian_aera.setVisibility(View.VISIBLE);
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {
                        spinnertext = types[0];
                    }
                });


                zaobofuhe.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        NumberPickerBuilder numberPickerBuilder = new NumberPickerBuilder()
                                .setFragmentManager(getFragmentManager())
                                .setStyleResId(R.style.BetterPickersDialogFragment_Light);
                        numberPickerBuilder.show();
                        numberPickerBuilder.addNumberPickerDialogHandler(new NumberPickerDialogFragment.NumberPickerDialogHandler() {
                            @Override
                            public void onDialogNumberSet(int reference, int number, double decimal, boolean isNegative, double fullNumber) {
                                zaobofuhetext = String.valueOf(number);
                                zaobofuhe.setText(zaobofuhetext);

                            }
                        });
                    }
                });


                pindu.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        HmsPickerBuilder hmsPickerBuilder = new HmsPickerBuilder()
                                .setFragmentManager(getFragmentManager())
                                .setStyleResId(R.style.BetterPickersDialogFragment_Light);
                        hmsPickerBuilder.show();
                        hmsPickerBuilder.addHmsPickerDialogHandler(new HmsPickerDialogFragment.HmsPickerDialogHandler() {
                            @Override
                            public void onDialogHmsSet(int reference, int hours, int minutes, int seconds) {
                                String temp = hours + "小时" + minutes + "分钟" + seconds + "秒";
                                pindu.setText(temp);
                                pindutext = temp;
                            }
                        });
                    }
                });


                meicifazuochixushijian.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        HmsPickerBuilder hmsPickerBuilder = new HmsPickerBuilder()
                                .setFragmentManager(getFragmentManager())
                                .setStyleResId(R.style.BetterPickersDialogFragment_Light);
                        hmsPickerBuilder.show();
                        hmsPickerBuilder.addHmsPickerDialogHandler(new HmsPickerDialogFragment.HmsPickerDialogHandler() {
                            @Override
                            public void onDialogHmsSet(int reference, int hours, int minutes, int seconds) {
                                String temp = hours + "小时" + minutes + "分钟" + seconds + "秒";
                                meicifazuochixushijian.setText(temp);
                                meicifazuochixushijiantext = temp;
                            }
                        });
                    }
                });


                zuijinfazuochixushijian.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        HmsPickerBuilder hmsPickerBuilder = new HmsPickerBuilder()
                                .setFragmentManager(getFragmentManager())
                                .setStyleResId(R.style.BetterPickersDialogFragment_Light);
                        hmsPickerBuilder.show();
                        hmsPickerBuilder.addHmsPickerDialogHandler(new HmsPickerDialogFragment.HmsPickerDialogHandler() {
                            @Override
                            public void onDialogHmsSet(int reference, int hours, int minutes, int seconds) {
                                String temp = hours + "小时" + minutes + "分钟" + seconds + "秒";
                                zuijinfazuochixushijian.setText(temp);
                                zuijinfazuochixushijiantext = temp;
                            }
                        });
                    }
                });
//                final MaterialEditText cengyongzhuanfufangfa = (MaterialEditText) v.findViewById(R.id.cengyongzhuanfufangfa);
//                final MaterialEditText zhuanlvyongyao = (MaterialEditText) v.findViewById(R.id.zhuanlvyongyao);


                CircularProgressButton sure = (CircularProgressButton) v.findViewById(R.id.confirm);
                sure.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
//                        cengyongzhuanfufangfatext = cengyongzhuanfufangfa.getText().toString();
//                        zhuanlvyongyaotext = zhuanlvyongyao.getText().toString();

                        if (spinnertext.equals("持续性")) {
                            shiSuLeiXing.setText("类型:" + spinnertext + "\n\n"
                                           + "早搏负荷:" + zaobofuhetext
//                        + "曾用转复方法:" + cengyongzhuanfufangfatext + "\n\n"
//                        + "转律用药:" + zhuanlvyongyaotext
                            );
                        } else {
                            shiSuLeiXing.setText("类型:" + spinnertext + "\n\n"
                                            + "频度:" + pindutext + "\n\n"
                                            + "每次发作持续时间:" + meicifazuochixushijiantext + "\n\n"
                                            + "最近发作持续时间:" + zuijinfazuochixushijiantext + "\n\n"
//                        + "曾用转复方法:" + cengyongzhuanfufangfatext + "\n\n"
//                        + "转律用药:" + zhuanlvyongyaotext
                            );
                        }
                        alert.dismiss();
                    }
                });

            }
        });

        shiSuBingCheng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                niantext = "";
                yuetext = "";
                final View v = LayoutInflater.from(getActivity()).inflate(R.layout.shisubingcheng, null);
                final MaterialDialog alert = new MaterialDialog(getActivity())
                        .setTitle("室速病程")
                        .setContentView(v);
                alert.show();
                final EditText nian = (EditText) v.findViewById(R.id.nian);
                final EditText yue = (EditText) v.findViewById(R.id.yue);

                CircularProgressButton confirm = (CircularProgressButton) v.findViewById(R.id.confirm);

                nian.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        NumberPickerBuilder numberPickerBuilder = new NumberPickerBuilder()
                                .setFragmentManager(getFragmentManager())
                                .setStyleResId(R.style.BetterPickersDialogFragment_Light);
                        numberPickerBuilder.show();
                        numberPickerBuilder.addNumberPickerDialogHandler(new NumberPickerDialogFragment.NumberPickerDialogHandler() {
                            @Override
                            public void onDialogNumberSet(int reference, int number, double decimal, boolean isNegative, double fullNumber) {
                                if (number > 50 || number < 1){
                                    ToastUtils.showLong("年份长度为1－50年");
                                } else {
                                    niantext = String.valueOf(number);
                                    nian.setText(niantext + "年");
                                }
                            }
                        });
                    }
                });

                yue.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        NumberPickerBuilder numberPickerBuilder = new NumberPickerBuilder()
                                .setFragmentManager(getFragmentManager())
                                .setStyleResId(R.style.BetterPickersDialogFragment_Light);
                        numberPickerBuilder.show();
                        numberPickerBuilder.addNumberPickerDialogHandler(new NumberPickerDialogFragment.NumberPickerDialogHandler() {
                            @Override
                            public void onDialogNumberSet(int reference, int number, double decimal, boolean isNegative, double fullNumber) {
                                if (number > 12 || number < 1){
                                    ToastUtils.showLong("月份长度为1－12月");
                                } else {
                                    yuetext = String.valueOf(number);
                                    yue.setText(yuetext + "月");
                                }
                            }
                        });
                    }
                });

                confirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        shisubingchengtext = niantext + "年" + " " + yuetext + "月";
                        shiSuBingCheng.setText(shisubingchengtext);
                        alert.dismiss();
                    }
                });
            }
        });

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextStepListner.OnNextStepClicked(1);
            }
        });
        return rootView;
    }

    public void saveCase1() {
        if (case1 != null) {
            shoushuriqi = shouShuRiQi.getText().toString();
            shoushubianhao = shouShuBianHao.getText().toString();
            shuzhe = shuZhe.getText().toString();
            shisuleixing = shiSuLeiXing.getText().toString();
            shisubingcheng = shiSuBingCheng.getText().toString();
            linchuangxinlvshichangzhenduan = linChuangXinLvShiChangZhenDuan.getText().toString();

            buwei = buWei.getText().toString();
            case1.setOperationNumber(shoushubianhao);
            case1.setOperatorName(shuzhe);
            case1.setVtType(spinnertext);
            case1.setVtFrequency(pindutext);
            case1.setVtEveryAttackTime(meicifazuochixushijiantext);
            case1.setVtLastAttackTime(zuijinfazuochixushijiantext);
            case1.setPrematureBeatLoad(zaobofuhetext);
            case1.setCardioversionMethod(cengyongzhuanfufangfatext);
            case1.setCardioversionMedication(zhuanlvyongyaotext);
            case1.setVtCourseDisease(shisubingcheng);
            case1.setArrhythmiaDiagnose(linchuangxinlvshichangzhenduan);
            case1.setElectrophysiologyDiagnose(dianshenlijianchazhenduan);
            case1.setPostoperationDiagnose(shuhouzhenduan);
            case1.setMechanism(jizhi);
            case1.setPart(buwei);
            case1DataChangedListener.OnCase1DataChanged(case1);
        }
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if (!isInActivity) {
            isInActivity = true;
            shouShuRiQi.setText("");
            shouShuBianHao.setText("");
            shuZhe.setText("");
            shiSuLeiXing.setText("");
            shiSuBingCheng.setText("");
            linChuangXinLvShiChangZhenDuan.setText("");

            buWei.setText("");
        }

    }

    private class ShouShuRiQiDatePickrDialogListener implements DatePickerDialog.OnDateSetListener {

        @Override
        public void onDateSet(DatePickerDialog datePickerDialog, int year, int month, int day) {
            month ++;
            Date date = new Date(year - 1900, month - 1, day);
            case1.setOperationData(date);
            shouShuRiQi.setText(year+ "年" + month + "月" + day + "日");
        }
    }

    private class ShiSuBingChengDatePickrDialogListener implements DatePickerDialog.OnDateSetListener {

        @Override
        public void onDateSet(DatePickerDialog datePickerDialog, int year, int month, int day) {
            month ++;
            shiSuBingCheng.setText(year+ "年" + month + "月" + day + "日");
        }
    }


}
