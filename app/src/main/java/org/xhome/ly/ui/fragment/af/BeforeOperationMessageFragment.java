package org.xhome.ly.ui.fragment.af;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.dd.CircularProgressButton;
import com.doomonafireball.betterpickers.numberpicker.NumberPickerBuilder;
import com.doomonafireball.betterpickers.numberpicker.NumberPickerDialogFragment;
import com.google.gson.Gson;
import com.rengwuxian.materialedittext.MaterialEditText;

import org.xhome.ly.R;
import org.xhome.ly.bean.Case2;

import me.drakeet.materialdialog.MaterialDialog;

/**
 * Created by liurongchan on 14/12/3.
 */
public class BeforeOperationMessageFragment extends BaseFragment {

    private static BeforeOperationMessageFragment fragment;

    private static final String[] la_types = {"未检测", "有血栓", "无血栓"};

    EditText shuQiangUcg;
//    MaterialEditText ecgShuZhiZhuZhiLeiXing;
//    MaterialEditText dianZhouPianYi;
    MaterialEditText shuQianKangXinLvShiChangYaoWu;
    MaterialEditText shuQianWuXiaoDeKangXinLvShiChangYaoWu;
    MaterialEditText shuQianHeBingXinLvShiChang;
    EditText shiFouZuoGuoFangChanXiaoRongZhiLiao;
    MaterialEditText shuQianKangNingYaoWu;
    EditText shuQianLaXueShuanJianCe;
    CircularProgressButton confirm;

    String shuqianucg;
    String ecgshuzhizhuzhileixing;
    String dianzhoupianyi;
    String shuqiankangxinlvshichangyaowu;
    String shuqianwuxiaodekangxinlvshichangyaowu;
    String shuqianhebingxinlvshichang;
    String shifouzuoguofangchanxiaorongzhiliao;
    String shuqiankangningyaowu;
    String shuqianlaxueshuanjiance;



    //ucg
    String laneijingtext = "";
    String raneijingtext = "";
    String lvneijingtext = "";
    String rvneijingtext = "";
    String lvefneijingtext = "";
    String beizhutext = "";



    public static BeforeOperationMessageFragment newInstance(Case2 case2) {
        if (fragment == null) {
            fragment = new BeforeOperationMessageFragment();
        }
        Bundle bundle = fragment.getArguments();
        if (bundle == null) {
            bundle = new Bundle();
            bundle.putString("case2", new Gson().toJson(case2));
            fragment.setArguments(bundle);
        } else {
            bundle.putString("case2", new Gson().toJson(case2));
        }

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(
                R.layout.afshuqianxinxi, container, false);
        init();
        shuQiangUcg = (EditText) rootView.findViewById(R.id.shuqianucg);
//        ecgShuZhiZhuZhiLeiXing = (MaterialEditText) rootView.findViewById(R.id.ecgshuzhizuzhileixing);
//        dianZhouPianYi = (MaterialEditText) rootView.findViewById(R.id.dianzhoupianyi);
        shuQianKangXinLvShiChangYaoWu = (MaterialEditText) rootView.findViewById(R.id.shuqiankangxinlvshichangyaowu);
        shuQianWuXiaoDeKangXinLvShiChangYaoWu = (MaterialEditText) rootView.findViewById(R.id.shuqianwuxiaodekangxinlvshichangyaowu);
        shuQianHeBingXinLvShiChang = (MaterialEditText) rootView.findViewById(R.id.shuqianhebingxinlvshichang);
        shiFouZuoGuoFangChanXiaoRongZhiLiao = (EditText) rootView.findViewById(R.id.shifouzuoguofangchanxiaorongzhiliao);
        shuQianKangNingYaoWu = (MaterialEditText) rootView.findViewById(R.id.shuqiankangningyaowu);
        shuQianLaXueShuanJianCe = (EditText) rootView.findViewById(R.id.shuqianlaxueshuanjiance);
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
                                lvneijingtext = temp;
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

        shiFouZuoGuoFangChanXiaoRongZhiLiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                        getActivity(),
                        android.R.layout.simple_list_item_1
                );
                arrayAdapter.add("是");
                arrayAdapter.add("否");
                ListView listView = new ListView(getActivity());
                float scale = getResources().getDisplayMetrics().density;
                int dpAsPixels = (int) (8 * scale + 0.5f);
                listView.setPadding(0, dpAsPixels, 0, dpAsPixels);
                listView.setDividerHeight(0);
                listView.setAdapter(arrayAdapter);
                final MaterialDialog alert = new MaterialDialog(getActivity())
                        .setTitle("选择类型")
                        .setContentView(listView);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                        switch (position) {
                            case 0:
                                shiFouZuoGuoFangChanXiaoRongZhiLiao.setText("是");
                                break;
                            case 1:
                                shiFouZuoGuoFangChanXiaoRongZhiLiao.setText("否");
                                break;
                            default:
                                break;
                        }
                        alert.dismiss();
                    }
                });
                alert.show();
            }
        });

        shuQianLaXueShuanJianCe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                        getActivity(),
                        android.R.layout.simple_list_item_1
                );
                for(String la_type : la_types) {
                    arrayAdapter.add(la_type);
                }
                ListView listView = new ListView(getActivity());
                float scale = getResources().getDisplayMetrics().density;
                int dpAsPixels = (int) (8 * scale + 0.5f);
                listView.setPadding(0, dpAsPixels, 0, dpAsPixels);
                listView.setDividerHeight(0);
                listView.setAdapter(arrayAdapter);
                final MaterialDialog alert = new MaterialDialog(getActivity())
                        .setTitle("选择类型")
                        .setContentView(listView);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                        shuQianLaXueShuanJianCe.setText(la_types[position]);
                        alert.dismiss();
                    }
                });
                alert.show();
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

    @Override
    public void saveCase2() {
        if(case2 != null) {
            shuqianucg = shuQiangUcg.getText().toString();
//            ecgshuzhizhuzhileixing = ecgShuZhiZhuZhiLeiXing.getText().toString();
//            dianzhoupianyi = dianZhouPianYi.getText().toString();
            shuqiankangxinlvshichangyaowu = shuQianKangXinLvShiChangYaoWu.getText().toString();
            shuqianwuxiaodekangxinlvshichangyaowu = shuQianWuXiaoDeKangXinLvShiChangYaoWu.getText().toString();
            shuqianhebingxinlvshichang = shuQianHeBingXinLvShiChang.getText().toString();
            shifouzuoguofangchanxiaorongzhiliao = shiFouZuoGuoFangChanXiaoRongZhiLiao.getText().toString();
            shuqiankangningyaowu = shuQianKangNingYaoWu.getText().toString();
            shuqianlaxueshuanjiance = shuQianLaXueShuanJianCe.getText().toString();

            case2.setLaBore(laneijingtext);
            case2.setLvBore(lvneijingtext);
            case2.setLvefBore(lvefneijingtext);
            case2.setRaBore(raneijingtext);
            case2.setRvBore(rvneijingtext);
            case2.setUcgRemarks(beizhutext);
            case2.setAfAblationTreatment(shifouzuoguofangchanxiaorongzhiliao);
            case2.setBeforeAnticoagulant(shuqiankangningyaowu);
            case2.setAntiArrhythmiaDrugs(shuqiankangxinlvshichangyaowu);
            case2.setInvaliDantiArrhythmiaDrugs(shuqianwuxiaodekangxinlvshichangyaowu);
            case2.setMergerArrhythmia(shuqianhebingxinlvshichang);
            case2.setLaThrombusDetection(shuqianlaxueshuanjiance);
            case2DataChangedListener.OnCase2DataChanged(case2);
        }
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if (!isInActivity) {
            isInActivity = true;
            shuQiangUcg.setText("");
//            ecgShuZhiZhuZhiLeiXing.setText("");
//            dianZhouPianYi.setText("");
            shuQianKangXinLvShiChangYaoWu.setText("");
            shuQianWuXiaoDeKangXinLvShiChangYaoWu.setText("");
            shuQianHeBingXinLvShiChang.setText("");
            shiFouZuoGuoFangChanXiaoRongZhiLiao.setText("");
            shuQianKangNingYaoWu.setText("");
            shuQianLaXueShuanJianCe.setText("");
        }

    }


}
