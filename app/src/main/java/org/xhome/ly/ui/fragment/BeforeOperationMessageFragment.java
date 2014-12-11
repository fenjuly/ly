package org.xhome.ly.ui.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.dd.CircularProgressButton;
import com.doomonafireball.betterpickers.numberpicker.NumberPickerBuilder;
import com.doomonafireball.betterpickers.numberpicker.NumberPickerDialogFragment;
import com.google.gson.Gson;
import com.rengwuxian.materialedittext.MaterialEditText;

import org.xhome.ly.App;
import org.xhome.ly.R;
import org.xhome.ly.bean.Case1;
import org.xhome.ly.dao.Case1DataHelper;
import me.drakeet.materialdialog.MaterialDialog;

/**
 * Created by liurongchan on 14/12/3.
 */
public class BeforeOperationMessageFragment extends BaseFragment {

    private static BeforeOperationMessageFragment fragment;

    EditText shuQiangUcg;
    MaterialEditText ecgShuZhiZhuZhiLeiXing;
    MaterialEditText dianZhouPianYi;
    MaterialEditText shuQianQiTaJianChaZhongYaoYangXingMiaoShu;
    MaterialEditText shuQianKangXinLvShiChangYaoWu;
    MaterialEditText shuQianWuXiaoDeKangXinLvShiChangYaoWu;
    MaterialEditText shuQianHeBingXinLvShiChang;
    CircularProgressButton confirm;

    String shuqianucg;
    String ecgshuzhizhuzhileixing;
    String dianzhoupianyi;
    String shuqianqitajianchazhongyaoyangxingmiaoshu;
    String shuqiankangxinlvshichangyaowu;
    String shuqianwuxiaodekangxinlvshichangyaowu;
    String shuqianhebingxinlvshichang;



    //ucg
    String laneijingtext = "";
    String raneijingtext = "";
    String lvneijingtext = "";
    String rvneijingtext = "";
    String lvefneijingtext = "";
    String beizhutext = "";



    public static BeforeOperationMessageFragment newInstance(Case1 case1) {
        if (fragment == null) {
            fragment = new BeforeOperationMessageFragment();
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
                R.layout.shuqianxinxi, container, false);
        init();
        shuQiangUcg = (EditText) rootView.findViewById(R.id.shuqianucg);
        ecgShuZhiZhuZhiLeiXing = (MaterialEditText) rootView.findViewById(R.id.ecgshuzhizuzhileixing);
        dianZhouPianYi = (MaterialEditText) rootView.findViewById(R.id.dianzhoupianyi);
        shuQianQiTaJianChaZhongYaoYangXingMiaoShu = (MaterialEditText) rootView.findViewById(R.id.shuqianqitajianchazhongyaoyangxingmiaoshu);
        shuQianKangXinLvShiChangYaoWu = (MaterialEditText) rootView.findViewById(R.id.shuqiankangxinlvshichangyaowu);
        shuQianWuXiaoDeKangXinLvShiChangYaoWu = (MaterialEditText) rootView.findViewById(R.id.shuqianwuxiaodekangxinlvshichangyaowu);
        shuQianHeBingXinLvShiChang = (MaterialEditText) rootView.findViewById(R.id.shuqianhebingxinlvshichang);
        confirm = (CircularProgressButton) rootView.findViewById(R.id.confirm);


        shuQiangUcg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View v = LayoutInflater.from(getActivity()).inflate(R.layout.shuqianucg, null);
                final MaterialDialog alert = new MaterialDialog(getActivity())
                        .setTitle("术前UCG")
                        .setContentView(v);
                alert.show();

                final EditText laneijing = (EditText) v.findViewById(R.id.laneijing);
                final EditText raneijing = (EditText) v.findViewById(R.id.raneijing);
                final EditText lvneijing = (EditText) v.findViewById(R.id.lvneijing);
                final EditText rvneijing = (EditText) v.findViewById(R.id.rvneijing);
                final EditText lvefneijing = (EditText) v.findViewById(R.id.lvefneijing);
                final MaterialEditText beizhu = (MaterialEditText) v.findViewById(R.id.beizhu);
                CircularProgressButton confirm = (CircularProgressButton) v.findViewById(R.id.confirm);


                laneijing.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        NumberPickerBuilder numberPickerBuilder = new NumberPickerBuilder()
                                .setFragmentManager(getFragmentManager())
                                .setStyleResId(R.style.BetterPickersDialogFragment_Light);
                        numberPickerBuilder.show();
                        numberPickerBuilder.addNumberPickerDialogHandler(new NumberPickerDialogFragment.NumberPickerDialogHandler() {
                            @Override
                            public void onDialogNumberSet(int reference, int number, double decimal, boolean isNegative, double fullNumber) {
                                String temp = fullNumber + "mm";
                                laneijing.setText(temp);
                                laneijingtext = temp;
                            }
                        });
                    }
                });

                raneijing.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        NumberPickerBuilder numberPickerBuilder = new NumberPickerBuilder()
                                .setFragmentManager(getFragmentManager())
                                .setStyleResId(R.style.BetterPickersDialogFragment_Light);
                        numberPickerBuilder.show();
                        numberPickerBuilder.addNumberPickerDialogHandler(new NumberPickerDialogFragment.NumberPickerDialogHandler() {
                            @Override
                            public void onDialogNumberSet(int reference, int number, double decimal, boolean isNegative, double fullNumber) {
                                String temp = fullNumber + "mm";
                                raneijing.setText(temp);
                                raneijingtext = temp;
                            }
                        });
                    }
                });

                lvneijing.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        NumberPickerBuilder numberPickerBuilder = new NumberPickerBuilder()
                                .setFragmentManager(getFragmentManager())
                                .setStyleResId(R.style.BetterPickersDialogFragment_Light);
                        numberPickerBuilder.show();
                        numberPickerBuilder.addNumberPickerDialogHandler(new NumberPickerDialogFragment.NumberPickerDialogHandler() {
                            @Override
                            public void onDialogNumberSet(int reference, int number, double decimal, boolean isNegative, double fullNumber) {
                                String temp = fullNumber + "mm";
                                lvneijing.setText(number + "mm");
                                lvefneijingtext = temp;
                            }
                        });
                    }
                });

                rvneijing.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        NumberPickerBuilder numberPickerBuilder = new NumberPickerBuilder()
                                .setFragmentManager(getFragmentManager())
                                .setStyleResId(R.style.BetterPickersDialogFragment_Light);
                        numberPickerBuilder.show();
                        numberPickerBuilder.addNumberPickerDialogHandler(new NumberPickerDialogFragment.NumberPickerDialogHandler() {
                            @Override
                            public void onDialogNumberSet(int reference, int number, double decimal, boolean isNegative, double fullNumber) {
                                String temp = fullNumber + "mm";
                                rvneijing.setText(temp);
                                rvneijingtext = temp;
                            }
                        });
                    }
                });

                lvefneijing.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        NumberPickerBuilder numberPickerBuilder = new NumberPickerBuilder()
                                .setFragmentManager(getFragmentManager())
                                .setStyleResId(R.style.BetterPickersDialogFragment_Light);
                        numberPickerBuilder.show();
                        numberPickerBuilder.addNumberPickerDialogHandler(new NumberPickerDialogFragment.NumberPickerDialogHandler() {
                            @Override
                            public void onDialogNumberSet(int reference, int number, double decimal, boolean isNegative, double fullNumber) {
                                String temp = fullNumber + "%";
                                lvefneijing.setText(temp);
                                lvefneijingtext = temp;
                            }
                        });
                    }
                });


                confirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String temp = beizhu.getText().toString();
                        beizhutext = temp;
                        shuQiangUcg.setText("LA内径:" + laneijingtext + "\n\n"
                        + "RA内径:" + raneijingtext + "\n\n"
                        + "LV内径:" + lvneijingtext + "\n\n"
                        + "RV内径:" + rvneijingtext + "\n\n"
                        + "LVEF内径:" + lvefneijingtext + "\n\n"
                        + "备注:" + beizhutext
                        );
                        alert.dismiss();
                    }

                });
            }
        });

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextStepListner.OnNextStepClicked(2);
            }
        });

        return rootView;
    }

    private void saveCase1() {
        if(case1 != null) {
            shuqianucg = shuQiangUcg.getText().toString();
            ecgshuzhizhuzhileixing = ecgShuZhiZhuZhiLeiXing.getText().toString();
            dianzhoupianyi = dianZhouPianYi.getText().toString();
            shuqianqitajianchazhongyaoyangxingmiaoshu = shuQianQiTaJianChaZhongYaoYangXingMiaoShu.getText().toString();
            shuqiankangxinlvshichangyaowu = shuQianKangXinLvShiChangYaoWu.getText().toString();
            shuqianwuxiaodekangxinlvshichangyaowu = shuQianWuXiaoDeKangXinLvShiChangYaoWu.getText().toString();
            shuqianhebingxinlvshichang = shuQianHeBingXinLvShiChang.getText().toString();
            case1.setLaBore(laneijingtext);
            case1.setLvBore(lvneijingtext);
            case1.setLvefBore(lvefneijingtext);
            case1.setRaBore(raneijingtext);
            case1.setRvBore(rvneijingtext);
            case1.setUcgRemarks(beizhutext);
            case1.setEcgType(ecgshuzhizhuzhileixing);
            case1.setElectricalOffset(dianzhoupianyi);
            case1.setPreopreativeExamination(shuqianqitajianchazhongyaoyangxingmiaoshu);
            case1.setAntiArrhythmiaDrugs(shuqiankangxinlvshichangyaowu);
            case1.setInvaliDantiArrhythmiaDrugs(shuqianwuxiaodekangxinlvshichangyaowu);
            case1.setMergerArrhythmia(shuqianhebingxinlvshichang);
            case1DataChangedListener.OnCase1DataChanged(case1);
        }
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if (!isInActivity) {
            isInActivity = true;
            shuQiangUcg.setText("");
            ecgShuZhiZhuZhiLeiXing.setText("");
            dianZhouPianYi.setText("");
            shuQianQiTaJianChaZhongYaoYangXingMiaoShu.setText("");
            shuQianKangXinLvShiChangYaoWu.setText("");
            shuQianWuXiaoDeKangXinLvShiChangYaoWu.setText("");
            shuQianHeBingXinLvShiChang.setText("");
        }

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        saveCase1();
        super.onSaveInstanceState(outState);
        Log.e("onSaveInstanceState", "invoked");
    }

    @Override
    public void onDestroy() {
        saveCase1();
        super.onDestroy();
        Log.e("onDestroy", "invoked");
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            case1DataChangedListener = (Case1DataChangedListener) activity;
            nextStepListner = (NextStepListner) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement Case1DataChangedListener");
        }
    }

}
