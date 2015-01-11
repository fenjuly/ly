package org.xhome.ly.ui.fragment.vt;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
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
    EditText shuQianKangXinLvShiChangYaoWu;
    EditText shuQianWuXiaoDeKangXinLvShiChangYaoWu;
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

    //shuqiankangxinlvshichangyaowu
    String shuqiankangxinlvshichangyaowutext = "";
    String kuinidingtext = "";
    String pulukayinantext = "";
    String bingpiantext = "";
    String liduokayintext = "";
    String meixilvtext = "";
    String bentuoyingtext = "";
    String puluopatongtext = "";
    String fukanitext = "";
    String punailuoertext = "";
    String weilapamitext = "";
    String andiantongtext = "";
    String xiangantext = "";
    String shuruqitatext = "";

    //shuqianwuxiandekangxinlvshichangyaowutext
    String wuxiao_shuqiankangxinlvshichangyaowutext = "";
    String wuxiao_kuinidingtext = "";
    String wuxiao_pulukayinantext = "";
    String wuxiao_bingpiantext = "";
    String wuxiao_liduokayintext = "";
    String wuxiao_meixilvtext = "";
    String wuxiao_bentuoyingtext = "";
    String wuxiao_puluopatongtext = "";
    String wuxiao_fukanitext = "";
    String wuxiao_punailuoertext = "";
    String wuxiao_weilapamitext = "";
    String wuxiao_andiantongtext = "";
    String wuxiao_xiangantext = "";
    String wuxiao_shuruqitatext = "";


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
        View rootView = inflater.inflate(
                R.layout.shuqianxinxi, container, false);
        init();
        shuQiangUcg = (EditText) rootView.findViewById(R.id.shuqianucg);
        ecgShuZhiZhuZhiLeiXing = (MaterialEditText) rootView.findViewById(R.id.ecgshuzhizuzhileixing);
        dianZhouPianYi = (MaterialEditText) rootView.findViewById(R.id.dianzhoupianyi);
        shuQianQiTaJianChaZhongYaoYangXingMiaoShu = (MaterialEditText) rootView.findViewById(R.id.shuqianqitajianchazhongyaoyangxingmiaoshu);
        shuQianKangXinLvShiChangYaoWu = (EditText) rootView.findViewById(R.id.shuqiankangxinlvshichangyaowu);
        shuQianWuXiaoDeKangXinLvShiChangYaoWu = (EditText) rootView.findViewById(R.id.shuqianwuxiaodekangxinlvshichangyaowu);
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

        shuQianKangXinLvShiChangYaoWu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 kuinidingtext = "";
                 pulukayinantext = "";
                 bingpiantext = "";
                 liduokayintext = "";
                 meixilvtext = "";
                 bentuoyingtext = "";
                 puluopatongtext = "";
                 fukanitext = "";
                 punailuoertext = "";
                 weilapamitext = "";
                 andiantongtext = "";
                 xiangantext = "";
                 shuruqitatext = "";
                View v = LayoutInflater.from(getActivity()).inflate(R.layout.shuqiankangxinlvshichangyaowu, null);
                final MaterialDialog alert = new MaterialDialog(getActivity())
                        .setTitle("术前抗心律失常药物")
                        .setContentView(v);
                alert.show();
                CheckBox kuiniding = (CheckBox) v.findViewById(R.id.kuiniding);
                CheckBox pulukayinan = (CheckBox) v.findViewById(R.id.pulukayinan);
                CheckBox bingpian = (CheckBox) v.findViewById(R.id.bingpian);
                CheckBox liduokayin = (CheckBox) v.findViewById(R.id.liduokayin);
                CheckBox meixilv = (CheckBox) v.findViewById(R.id.meixilv);
                CheckBox bentuoying = (CheckBox) v.findViewById(R.id.bentuoying);
                CheckBox puluopatong = (CheckBox) v.findViewById(R.id.puluopatong);
                CheckBox fukani = (CheckBox) v.findViewById(R.id.fukani);
                CheckBox punailuoer = (CheckBox) v.findViewById(R.id.punailuoer);
                CheckBox weilapami = (CheckBox) v.findViewById(R.id.weilapami);
                CheckBox andiantong = (CheckBox) v.findViewById(R.id.andiantong);
                CheckBox xiangan = (CheckBox) v.findViewById(R.id.xiangan);

                final MaterialEditText shuruqita = (MaterialEditText) v.findViewById(R.id.shuruqita);
                CircularProgressButton confirm = (CircularProgressButton) v.findViewById(R.id.confirm);

                kuiniding.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            kuinidingtext = "奎尼丁";
                        } else {
                            kuinidingtext = "";
                        }
                    }
                });

                pulukayinan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            pulukayinantext = "普鲁卡因胺";
                        } else {
                            pulukayinantext = "";
                        }
                    }
                });

                bingpian.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            bingpiantext = "丙吡胺";
                        } else {
                            bingpiantext = "";
                        }
                    }
                });

                liduokayin.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            liduokayintext = "利多卡因";
                        } else {
                            liduokayintext = "";
                        }
                    }
                });

                meixilv.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            meixilvtext = "美西律";
                        } else {
                            meixilvtext = "";
                        }
                    }
                });
                bentuoying.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            bentuoyingtext = "苯妥英";
                        } else {
                            bentuoyingtext = "";
                        }
                    }
                });
                puluopatong.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            puluopatongtext = "普罗帕酮";
                        } else {
                            puluopatongtext = "";
                        }
                    }
                });
                fukani.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            fukanitext = "氟卡尼";
                        } else {
                            fukanitext = "";
                        }
                    }
                });
                punailuoer.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            punailuoertext = "普萘洛尔";
                        } else {
                            punailuoertext = "";
                        }
                    }
                });
                weilapami.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            weilapamitext = "维拉帕米";
                        } else {
                            weilapamitext = "";
                        }
                    }
                });
                andiantong.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            andiantongtext = "胺碘酮";
                        } else {
                            andiantongtext = "";
                        }
                    }
                });
                xiangan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            xiangantext = "腺苷";
                        } else {
                            xiangantext = "";
                        }
                    }
                });


                confirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        shuqiankangxinlvshichangyaowutext = "";
                        shuruqitatext = shuruqita.getText().toString();
                        shuqiankangxinlvshichangyaowutext = kuinidingtext + " " + pulukayinantext + " "
                                + bingpiantext + " " + liduokayintext + " "
                                + meixilvtext + " " + bentuoyingtext + " "
                                + puluopatongtext + " " + fukanitext + " "
                                + punailuoertext + " " + weilapamitext + " "
                                + andiantongtext + " " + xiangantext + " "
                                + shuruqitatext;
                        shuQianKangXinLvShiChangYaoWu.setText("术前抗心律失常药物:" + shuqiankangxinlvshichangyaowutext);
                        alert.dismiss();
                    }
                });

            }
        });

        shuQianWuXiaoDeKangXinLvShiChangYaoWu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wuxiao_kuinidingtext = "";
                wuxiao_pulukayinantext = "";
                wuxiao_bingpiantext = "";
                wuxiao_liduokayintext = "";
                wuxiao_meixilvtext = "";
                wuxiao_bentuoyingtext = "";
                wuxiao_puluopatongtext = "";
                wuxiao_fukanitext = "";
                wuxiao_punailuoertext = "";
                wuxiao_weilapamitext = "";
                wuxiao_andiantongtext = "";
                wuxiao_xiangantext = "";
                wuxiao_shuruqitatext = "";
                View v = LayoutInflater.from(getActivity()).inflate(R.layout.shuqianwuxiaodekangxinlvshichangyaowu, null);
                final MaterialDialog alert = new MaterialDialog(getActivity())
                        .setTitle("术前无效的抗心律失常药物")
                        .setContentView(v);
                alert.show();
                CheckBox wuxiao_kuiniding = (CheckBox) v.findViewById(R.id.kuiniding);
                CheckBox wuxiao_pulukayinan = (CheckBox) v.findViewById(R.id.pulukayinan);
                CheckBox wuxiao_bingpian = (CheckBox) v.findViewById(R.id.bingpian);
                CheckBox wuxiao_liduokayin = (CheckBox) v.findViewById(R.id.liduokayin);
                CheckBox wuxiao_meixilv = (CheckBox) v.findViewById(R.id.meixilv);
                CheckBox wuxiao_bentuoying = (CheckBox) v.findViewById(R.id.bentuoying);
                CheckBox wuxiao_puluopatong = (CheckBox) v.findViewById(R.id.puluopatong);
                CheckBox wuxiao_fukani = (CheckBox) v.findViewById(R.id.fukani);
                CheckBox wuxiao_punailuoer = (CheckBox) v.findViewById(R.id.punailuoer);
                CheckBox wuxiao_weilapami = (CheckBox) v.findViewById(R.id.weilapami);
                CheckBox wuxiao_andiantong = (CheckBox) v.findViewById(R.id.andiantong);
                CheckBox wuxiao_xiangan = (CheckBox) v.findViewById(R.id.xiangan);

                final MaterialEditText wuxiao_shuruqita = (MaterialEditText) v.findViewById(R.id.shuruqita);
                CircularProgressButton confirm = (CircularProgressButton) v.findViewById(R.id.confirm);

                wuxiao_kuiniding.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            wuxiao_kuinidingtext = "奎尼丁";
                        } else {
                            wuxiao_kuinidingtext = "";
                        }
                    }
                });

                wuxiao_pulukayinan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            wuxiao_pulukayinantext = "普鲁卡因胺";
                        } else {
                            wuxiao_pulukayinantext = "";
                        }
                    }
                });

                wuxiao_bingpian.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            wuxiao_bingpiantext = "丙吡胺";
                        } else {
                            wuxiao_bingpiantext = "";
                        }
                    }
                });

                wuxiao_liduokayin.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            wuxiao_liduokayintext = "利多卡因";
                        } else {
                            wuxiao_liduokayintext = "";
                        }
                    }
                });

                wuxiao_meixilv.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            wuxiao_meixilvtext = "美西律";
                        } else {
                            wuxiao_meixilvtext = "";
                        }
                    }
                });
                wuxiao_bentuoying.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            wuxiao_bentuoyingtext = "苯妥英";
                        } else {
                            wuxiao_bentuoyingtext = "";
                        }
                    }
                });
                wuxiao_puluopatong.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            wuxiao_puluopatongtext = "普罗帕酮";
                        } else {
                            wuxiao_puluopatongtext = "";
                        }
                    }
                });
                wuxiao_fukani.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            wuxiao_fukanitext = "氟卡尼";
                        } else {
                            wuxiao_fukanitext = "";
                        }
                    }
                });
                wuxiao_punailuoer.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            wuxiao_punailuoertext = "普萘洛尔";
                        } else {
                            wuxiao_punailuoertext = "";
                        }
                    }
                });
                wuxiao_weilapami.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            wuxiao_weilapamitext = "维拉帕米";
                        } else {
                            wuxiao_weilapamitext = "";
                        }
                    }
                });
                wuxiao_andiantong.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            wuxiao_andiantongtext = "胺碘酮";
                        } else {
                            wuxiao_andiantongtext = "";
                        }
                    }
                });
                wuxiao_xiangan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            wuxiao_xiangantext = "腺苷";
                        } else {
                            wuxiao_xiangantext = "";
                        }
                    }
                });


                confirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        wuxiao_shuqiankangxinlvshichangyaowutext = "";
                        wuxiao_shuruqitatext = wuxiao_shuruqita.getText().toString();
                        wuxiao_shuqiankangxinlvshichangyaowutext = wuxiao_kuinidingtext + " " + wuxiao_pulukayinantext + " "
                                + wuxiao_bingpiantext + " " + wuxiao_liduokayintext + " "
                                + wuxiao_meixilvtext + " " + wuxiao_bentuoyingtext + " "
                                + wuxiao_puluopatongtext + " " + wuxiao_fukanitext + " "
                                + wuxiao_punailuoertext + " " + wuxiao_weilapamitext + " "
                                + wuxiao_andiantongtext + " " + wuxiao_xiangantext + " "
                                + wuxiao_shuruqitatext;
                        shuQianWuXiaoDeKangXinLvShiChangYaoWu.setText("术前无效的抗心律失常药物:" + wuxiao_shuqiankangxinlvshichangyaowutext);
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

    public void saveCase1() {
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


}
