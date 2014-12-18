package org.xhome.ly.ui.fragment.vt;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.dd.CircularProgressButton;
import com.doomonafireball.betterpickers.hmspicker.HmsPickerBuilder;
import com.doomonafireball.betterpickers.hmspicker.HmsPickerDialogFragment;
import com.fourmob.datetimepicker.date.DatePickerDialog;
import com.google.gson.Gson;
import com.rengwuxian.materialedittext.MaterialEditText;

import org.xhome.ly.App;
import org.xhome.ly.R;
import org.xhome.ly.bean.Case1;
import org.xhome.ly.dao.Case1DataHelper;

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

    EditText shouShuRiQi;
    MaterialEditText shouShuBianHao;
    MaterialEditText shuZhe;
    EditText shiSuLeiXing;
    EditText shiSuBingCheng;
    MaterialEditText linChuangXinLvShiChangZhenDuan;
    MaterialEditText dianShengLiJianChaZhenDuan;
    MaterialEditText shuHouZhenDuan;
    MaterialEditText jiZhi;
    MaterialEditText buWei;

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

    //室速类型
    String spinnertext = "";
    String pindutext = "";
    String meicifazuochixushijiantext = "";
    String zuijinfazuochixushijiantext = "";
    String cengyongzhuanfufangfatext = "";
    String zhuanlvyongyaotext = "";

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
        case1DataHelper = new Case1DataHelper(App.getContext());
        View rootView = inflater.inflate(
                R.layout.zhenduanxinxi, container, false);

        init();
        shouShuRiQi = (EditText) rootView.findViewById(R.id.shoushuriqi);
        shouShuBianHao = (MaterialEditText) rootView.findViewById(R.id.shoushubianhao);
        shuZhe = (MaterialEditText) rootView.findViewById(R.id.shuzhe);
        shiSuLeiXing = (EditText) rootView.findViewById(R.id.shisuleixing);
        shiSuBingCheng = (EditText) rootView.findViewById(R.id.shisubingcheng);
        linChuangXinLvShiChangZhenDuan = (MaterialEditText) rootView.findViewById(R.id.linchuangxinlvshichangzhenduan);
        dianShengLiJianChaZhenDuan = (MaterialEditText) rootView.findViewById(R.id.dianshenglijianchazhenduan);
        shuHouZhenDuan = (MaterialEditText) rootView.findViewById(R.id.shuhouzhenduan);
        jiZhi = (MaterialEditText) rootView.findViewById(R.id.jizhi);
        buWei = (MaterialEditText) rootView.findViewById(R.id.buwei);
        confirm = (CircularProgressButton) rootView.findViewById(R.id.confirm);

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

        shiSuLeiXing.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                View v = LayoutInflater.from(getActivity()).inflate(R.layout.shisuleixing, null);
                final MaterialDialog alert = new MaterialDialog(getActivity())
                        .setTitle("室速类型")
                        .setContentView(v);
                alert.show();
                final Spinner spinner = (Spinner) v.findViewById(R.id.leixing);
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
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {
                        spinnertext = types[0];
                    }
                });

                final EditText pindu = (EditText) v.findViewById(R.id.pindu);
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

                final EditText meicifazuochixushijian = (EditText) v.findViewById(R.id.meicifazuochixushijian);
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

                final EditText zuijinfazuochixushijian = (EditText) v.findViewById(R.id.zuijinfazuochixushijian);
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
                final MaterialEditText cengyongzhuanfufangfa = (MaterialEditText) v.findViewById(R.id.cengyongzhuanfufangfa);
                final MaterialEditText zhuanlvyongyao = (MaterialEditText) v.findViewById(R.id.zhuanlvyongyao);


                CircularProgressButton sure = (CircularProgressButton) v.findViewById(R.id.confirm);
                sure.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        cengyongzhuanfufangfatext = cengyongzhuanfufangfa.getText().toString();
                        zhuanlvyongyaotext = zhuanlvyongyao.getText().toString();
                        shiSuLeiXing.setText("类型:" + spinnertext + "\n\n"
                        + "频度:" + pindutext + "\n\n"
                        + "每次发作持续时间:" + meicifazuochixushijiantext + "\n\n"
                        + "最近发作持续时间:" + zuijinfazuochixushijiantext + "\n\n"
                        + "曾用转复方法:" + cengyongzhuanfufangfatext + "\n\n"
                        + "转律用药:" + zhuanlvyongyaotext
                        );
                        alert.dismiss();
                    }
                });

            }
        });

        shiSuBingCheng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar calendar = Calendar.getInstance();
                final DatePickerDialog datePickerDialog = DatePickerDialog
                        .newInstance(new ShiSuBingChengDatePickrDialogListener(), calendar.
                                get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), false);
                datePickerDialog.setYearRange(1985, 2028);
                datePickerDialog.show(getActivity().getSupportFragmentManager(), DATEPICKER_TAG);
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
            dianshenlijianchazhenduan = dianShengLiJianChaZhenDuan.getText().toString();
            shuhouzhenduan = shuHouZhenDuan.getText().toString();
            jizhi = jiZhi.getText().toString();
            buwei = buWei.getText().toString();
            case1.setOperationNumber(shoushubianhao);
            case1.setOperatorName(shuzhe);
            case1.setVtType(spinnertext);
            case1.setVtFrequency(pindutext);
            case1.setVtEveryAttackTime(meicifazuochixushijiantext);
            case1.setVtLastAttackTime(zuijinfazuochixushijiantext);
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
            dianShengLiJianChaZhenDuan.setText("");
            shuHouZhenDuan.setText("");
            jiZhi.setText("");
            buWei.setText("");
        }

    }

    private class ShouShuRiQiDatePickrDialogListener implements DatePickerDialog.OnDateSetListener {

        @Override
        public void onDateSet(DatePickerDialog datePickerDialog, int year, int month, int day) {
            month ++;
            Date date = new Date(year - 1900, month, day);
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
