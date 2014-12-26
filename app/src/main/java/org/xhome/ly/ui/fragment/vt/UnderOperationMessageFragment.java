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

import org.xhome.ly.R;
import org.xhome.ly.bean.Case1;

import me.drakeet.materialdialog.MaterialDialog;

/**
 * Created by liurongchan on 14/12/3.
 */
public class UnderOperationMessageFragment extends BaseFragment {

    private static UnderOperationMessageFragment fragment;

    MaterialEditText shuZhongDianFuLv;
    EditText xiaoRongQianXinLv;
    EditText shuZhongXinLv;
    EditText bingFaZheng;
    CircularProgressButton confirm;

    String shuzhongdianfulv;
    String xiaorongqianxinlv;
    String shuzhongxinlv;
    String bingfazheng;

    String xiaorongqianxinlvtext;
    String xiaorongqian_duxingxinlvtext;
    String xiaorongqian_shisutext;
    String xiaorongqian_shizaotext;
    String xiaorongqian_beizhutext;

    String shuzhongxinlvtext;
    String shuzhong_duxingxinlvtext;
    String shuzhong_shisutext;
    String shuzhong_shizaotext;
    String shuzhong_beizhutext;

    String bingfazhengtext;
    String xinbaotiansetext;
    String feijingmaixiazhaitext;
    String xueshuanshuansetext;
    String shidaoxinfangweitext;
    String geshenjingsunshangtext;
    String kongqishuansetext;
    String zuzhongtext;
    String shidaozhouweimizoushenjingsunshangtext;
    String jixingguanmaibisetext;
    String pixiaxuechongtext;
    String jiaxingdongmailiutext;
    String dongjingmaiweitext;
    String fumohouchuxuetext;
    String banmosunshangtext;
    String siwangtext;
    String qitatext;


    public static UnderOperationMessageFragment newInstance(Case1 case1) {
        if (fragment == null) {
            fragment = new UnderOperationMessageFragment();
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
                R.layout.shuzhongxinxi, container, false);
        init();
        shuZhongDianFuLv = (MaterialEditText) rootView.findViewById(R.id.shuzhongdianfulv);
        xiaoRongQianXinLv = (EditText) rootView.findViewById(R.id.xiaorongqianxinlv);
        shuZhongXinLv = (EditText) rootView.findViewById(R.id.shuzhongxinlv);
        bingFaZheng = (EditText) rootView.findViewById(R.id.bingfazheng);
        confirm = (CircularProgressButton) rootView.findViewById(R.id.confirm);

        xiaoRongQianXinLv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xiaorongqian_duxingxinlvtext = "";
                xiaorongqian_shisutext = "";
                xiaorongqian_shizaotext = "";
                xiaorongqian_beizhutext = "";
                View v = LayoutInflater.from(getActivity()).inflate(R.layout.xiaorongqianxinlv, null);
                final MaterialDialog alert = new MaterialDialog(getActivity())
                        .setTitle("消融前心律")
                        .setContentView(v);
                alert.show();
                final EditText duxingxinlv = (EditText) v.findViewById(R.id.xiaorongqianxinlv);
                final EditText shisu = (EditText) v.findViewById(R.id.shisu);
                final EditText shizao = (EditText) v.findViewById(R.id.shizao);
                final MaterialEditText beizhu = (MaterialEditText) v.findViewById(R.id.beizhu);
                CircularProgressButton confirm = (CircularProgressButton) v.findViewById(R.id.confirm);

                duxingxinlv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        NumberPickerBuilder numberPickerBuilder = new NumberPickerBuilder()
                                .setFragmentManager(getFragmentManager())
                                .setStyleResId(R.style.BetterPickersDialogFragment_Light);
                        numberPickerBuilder.show();
                        numberPickerBuilder.addNumberPickerDialogHandler(new NumberPickerDialogFragment.NumberPickerDialogHandler() {
                            @Override
                            public void onDialogNumberSet(int reference, int number, double decimal, boolean isNegative, double fullNumber) {
                                xiaorongqian_duxingxinlvtext = fullNumber + "BPM";
                                duxingxinlv.setText(xiaorongqian_duxingxinlvtext);
                            }
                        });
                    }
                });

                shisu.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        NumberPickerBuilder numberPickerBuilder = new NumberPickerBuilder()
                                .setFragmentManager(getFragmentManager())
                                .setStyleResId(R.style.BetterPickersDialogFragment_Light);
                        numberPickerBuilder.show();
                        numberPickerBuilder.addNumberPickerDialogHandler(new NumberPickerDialogFragment.NumberPickerDialogHandler() {
                            @Override
                            public void onDialogNumberSet(int reference, int number, double decimal, boolean isNegative, double fullNumber) {
                                xiaorongqian_shisutext = fullNumber + "BPM";
                                shisu.setText(xiaorongqian_shisutext);
                            }
                        });
                    }
                });

                shizao.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        NumberPickerBuilder numberPickerBuilder = new NumberPickerBuilder()
                                .setFragmentManager(getFragmentManager())
                                .setStyleResId(R.style.BetterPickersDialogFragment_Light);
                        numberPickerBuilder.show();
                        numberPickerBuilder.addNumberPickerDialogHandler(new NumberPickerDialogFragment.NumberPickerDialogHandler() {
                            @Override
                            public void onDialogNumberSet(int reference, int number, double decimal, boolean isNegative, double fullNumber) {
                                xiaorongqian_shizaotext = fullNumber + "BPM";
                                shizao.setText(xiaorongqian_shizaotext);
                            }
                        });
                    }
                });

                confirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        xiaorongqianxinlvtext = "";
                        xiaorongqian_beizhutext = beizhu.getText().toString();
                        xiaorongqianxinlvtext = "窦性心律:" + xiaorongqian_duxingxinlvtext + "\n\n"
                                + "室速:" + xiaorongqian_shisutext + "\n\n"
                                + "室早:" + xiaorongqian_shizaotext;
                        xiaoRongQianXinLv.setText(xiaorongqianxinlvtext + "\n\n"
                                        + "备注:" + xiaorongqian_beizhutext
                        );
                        alert.dismiss();
                    }
                });

            }
        });

        shuZhongXinLv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shuzhong_duxingxinlvtext = "";
                shuzhong_shisutext = "";
                shuzhong_shizaotext = "";
                shuzhong_beizhutext = "";
                View v = LayoutInflater.from(getActivity()).inflate(R.layout.shuzhongxinlv, null);
                final MaterialDialog alert = new MaterialDialog(getActivity())
                        .setTitle("术中心律")
                        .setContentView(v);
                alert.show();

                final EditText duxingxinlv = (EditText) v.findViewById(R.id.xiaorongqianxinlv);
                final EditText shisu = (EditText) v.findViewById(R.id.shisu);
                final EditText shizao = (EditText) v.findViewById(R.id.shizao);
                final MaterialEditText beizhu = (MaterialEditText) v.findViewById(R.id.beizhu);
                CircularProgressButton confirm = (CircularProgressButton) v.findViewById(R.id.confirm);

                duxingxinlv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        NumberPickerBuilder numberPickerBuilder = new NumberPickerBuilder()
                                .setFragmentManager(getFragmentManager())
                                .setStyleResId(R.style.BetterPickersDialogFragment_Light);
                        numberPickerBuilder.show();
                        numberPickerBuilder.addNumberPickerDialogHandler(new NumberPickerDialogFragment.NumberPickerDialogHandler() {
                            @Override
                            public void onDialogNumberSet(int reference, int number, double decimal, boolean isNegative, double fullNumber) {
                                shuzhong_duxingxinlvtext = fullNumber + "BPM";
                                duxingxinlv.setText(shuzhong_duxingxinlvtext);
                            }
                        });
                    }
                });

                shisu.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        NumberPickerBuilder numberPickerBuilder = new NumberPickerBuilder()
                                .setFragmentManager(getFragmentManager())
                                .setStyleResId(R.style.BetterPickersDialogFragment_Light);
                        numberPickerBuilder.show();
                        numberPickerBuilder.addNumberPickerDialogHandler(new NumberPickerDialogFragment.NumberPickerDialogHandler() {
                            @Override
                            public void onDialogNumberSet(int reference, int number, double decimal, boolean isNegative, double fullNumber) {
                                shuzhong_shisutext = fullNumber + "BPM";
                                shisu.setText(shuzhong_shisutext);
                            }
                        });
                    }
                });

                shizao.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        NumberPickerBuilder numberPickerBuilder = new NumberPickerBuilder()
                                .setFragmentManager(getFragmentManager())
                                .setStyleResId(R.style.BetterPickersDialogFragment_Light);
                        numberPickerBuilder.show();
                        numberPickerBuilder.addNumberPickerDialogHandler(new NumberPickerDialogFragment.NumberPickerDialogHandler() {
                            @Override
                            public void onDialogNumberSet(int reference, int number, double decimal, boolean isNegative, double fullNumber) {
                                shuzhong_shizaotext = fullNumber + "BPM";
                                shizao.setText(shuzhong_shizaotext);
                            }
                        });
                    }
                });

                confirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        shuzhongxinlvtext = "";
                        shuzhong_beizhutext = beizhu.getText().toString();
                        shuzhongxinlvtext = "窦性心律:" + shuzhong_duxingxinlvtext + "\n\n"
                                + "室速:" + shuzhong_shisutext + "\n\n"
                                + "室早:" + shuzhong_shizaotext;
                        shuZhongXinLv.setText(shuzhongxinlvtext + "\n\n"
                                        + "备注:" + shuzhong_beizhutext
                        );
                        alert.dismiss();
                    }
                });
            }
        });

        bingFaZheng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xinbaotiansetext = "";
                feijingmaixiazhaitext = "";
                xueshuanshuansetext = "";
                shidaoxinfangweitext = "";
                geshenjingsunshangtext = "";
                kongqishuansetext = "";
                zuzhongtext = "";
                shidaozhouweimizoushenjingsunshangtext = "";
                jixingguanmaibisetext = "";
                pixiaxuechongtext = "";
                jiaxingdongmailiutext = "";
                dongjingmaiweitext = "";
                fumohouchuxuetext = "";
                banmosunshangtext = "";
                siwangtext = "";
                View v = LayoutInflater.from(getActivity()).inflate(R.layout.bingfazheng, null);
                final MaterialDialog alert = new MaterialDialog(getActivity())
                        .setTitle("并发症")
                        .setContentView(v);
                alert.show();

                CheckBox xinbaotianse = (CheckBox) v.findViewById(R.id.xinbaotianse);
                CheckBox feijingmaixiazhai = (CheckBox) v.findViewById(R.id.feijingmaixiazhai);
                final CheckBox xueshuanshuanse = (CheckBox) v.findViewById(R.id.xueshuanshuanse);
                CheckBox shidaoxinfangwei = (CheckBox) v.findViewById(R.id.shidaoxinfangwei);
                CheckBox geshenjingsunshang = (CheckBox) v.findViewById(R.id.geshenjingsunshang);
                CheckBox kongqishuanse = (CheckBox) v.findViewById(R.id.kongqishuanse);
                CheckBox zuzhong = (CheckBox) v.findViewById(R.id.zuzhong);
                CheckBox shidaozhouweimizoushenjingsunshang = (CheckBox) v.findViewById(R.id.shidaozhouweimizoushenjingsunshang);
                CheckBox jixingguanmaibise = (CheckBox) v.findViewById(R.id.jixingguanmaibise);
                CheckBox pixiaxuezhong = (CheckBox) v.findViewById(R.id.pixiaxuezhong);
                CheckBox jiaxingdongmailiu = (CheckBox) v.findViewById(R.id.jiaxingdongmailiu);
                CheckBox dongjingmaiwei = (CheckBox) v.findViewById(R.id.dongjingmaiwei);
                CheckBox fumohouchuxue = (CheckBox) v.findViewById(R.id.fumohouchuxue);
                CheckBox banmosunshang = (CheckBox) v.findViewById(R.id.banmosunshang);
                CheckBox siwang = (CheckBox) v.findViewById(R.id.siwang);
                final MaterialEditText qita = (MaterialEditText) v.findViewById(R.id.qita);
                CircularProgressButton confirm = (CircularProgressButton) v.findViewById(R.id.confirm);

                xinbaotianse.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            xinbaotiansetext = "心包填塞";
                        } else {
                            xinbaotiansetext = "";
                        }
                    }
                });

                feijingmaixiazhai.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            feijingmaixiazhaitext = "肺静脉狭窄";
                        } else {
                            feijingmaixiazhaitext = "";
                        }
                    }
                });

                xueshuanshuanse.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            xueshuanshuansetext = "血栓栓塞";
                        } else {
                            xueshuanshuansetext = "";
                        }
                    }
                });

                shidaoxinfangwei.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            shidaoxinfangweitext = "食道心房瘘";
                        } else {
                            shidaoxinfangweitext = "";
                        }
                    }
                });

                geshenjingsunshang.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            geshenjingsunshangtext = "膈神经损伤";
                        } else {
                            geshenjingsunshangtext = "";
                        }
                    }
                });

                kongqishuanse.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            kongqishuansetext = "空气栓塞";
                        } else {
                            kongqishuansetext = "";
                        }
                    }
                });

                zuzhong.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            zuzhongtext = "卒中";
                        } else {
                            zuzhongtext = "";
                        }
                    }
                });

                shidaozhouweimizoushenjingsunshang.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            shidaozhouweimizoushenjingsunshangtext = "食道周围迷走神经损伤";
                        } else {
                            shidaozhouweimizoushenjingsunshangtext = "";
                        }
                    }
                });

                jixingguanmaibise.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            jixingguanmaibisetext = "急性冠脉闭塞";
                        } else {
                            jixingguanmaibisetext = "";
                        }
                    }
                });

                pixiaxuezhong.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            pixiaxuechongtext = "皮下血肿";
                        } else {
                            pixiaxuechongtext = "";
                        }
                    }
                });

                jiaxingdongmailiu.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            jiaxingdongmailiutext = "假性动脉瘤";
                        } else {
                            jiaxingdongmailiutext = "";
                        }
                    }
                });

                dongjingmaiwei.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            dongjingmaiweitext = "动静脉瘘";
                        } else {
                            dongjingmaiweitext = "";
                        }
                    }
                });

                fumohouchuxue.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            fumohouchuxuetext = "腹膜后出血";
                        } else {
                            fumohouchuxuetext = "";
                        }
                    }
                });

                banmosunshang.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            banmosunshangtext = "瓣膜损伤";
                        } else {
                            banmosunshangtext = "";
                        }
                    }
                });

                siwang.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            siwangtext = "死亡";
                        } else {
                            siwangtext = "";
                        }
                    }
                });

                confirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        bingfazhengtext = "";
                        qitatext = qita.getText().toString();
                        bingfazhengtext = xinbaotiansetext + " " + feijingmaixiazhaitext + " "
                                + xueshuanshuansetext + " " + shidaoxinfangweitext + " "
                                + geshenjingsunshangtext + " " + kongqishuansetext + " "
                                + zuzhongtext + " " + shidaozhouweimizoushenjingsunshangtext + " "
                                + jixingguanmaibisetext + " " + pixiaxuechongtext + " "
                                + jiaxingdongmailiutext + " " + dongjingmaiweitext + " "
                                + fumohouchuxuetext + " " + banmosunshangtext + " "
                                + siwangtext + " " + qitatext ;
                        bingFaZheng.setText("并发症:" + bingfazhengtext);
                        alert.dismiss();
                    }
                });

            }
        });

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextStepListner.OnNextStepClicked(5);
            }
        });
        return rootView;
    }

    @Override
    public void saveCase1() {
        if(case1 != null) {
            shuzhongdianfulv = shuZhongDianFuLv.getText().toString();
            bingfazheng = bingFaZheng.getText().toString();
            case1.setIntraoperativeCableRate(shuzhongdianfulv);
            case1.setBeforeHeartRate(xiaorongqian_duxingxinlvtext);
            case1.setBeforeVt(xiaorongqian_shisutext);
            case1.setBeforeRont(xiaorongqian_shizaotext);
            case1.setBeforeRemarks(xiaorongqian_beizhutext);
            case1.setInHeartRate(shuzhong_duxingxinlvtext);
            case1.setInVt(shuzhong_shisutext);
            case1.setInRont(shuzhong_shizaotext);
            case1.setInRemarks(shuzhong_beizhutext);
            case1.setComplication(bingfazheng);
            case1DataChangedListener.OnCase1DataChanged(case1);
        }
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if (!isInActivity) {
            isInActivity = true;
            shuZhongDianFuLv.setText("");
            xiaoRongQianXinLv.setText("");
            shuZhongXinLv.setText("");
            bingFaZheng.setText("");
        }

    }
}
