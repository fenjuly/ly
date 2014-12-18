package org.xhome.ly.ui.fragment.af;

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
import org.xhome.ly.bean.Case2;

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
    String xiaorongqian_fangsutext;
    String xiaorongqian_fangzaotext;
    String xiaorongqian_beizhutext;

    String shuzhongxinlvtext;
    String shuzhong_duxingxinlvtext;
    String shuzhong_fangsutext;
    String shuzhong_fangzaotext;
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


    public static UnderOperationMessageFragment newInstance(Case2 case2) {
        if (fragment == null) {
            fragment = new UnderOperationMessageFragment();
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
                xiaorongqian_fangsutext = "";
                xiaorongqian_fangzaotext = "";
                xiaorongqian_beizhutext = "";
                View v = LayoutInflater.from(getActivity()).inflate(R.layout.afxiaorongqianxinlv, null);
                final MaterialDialog alert = new MaterialDialog(getActivity())
                        .setTitle("消融前心律")
                        .setContentView(v);
                alert.show();
                final EditText duxingxinlv = (EditText) v.findViewById(R.id.duxingxinlv);
                final EditText fangsu = (EditText) v.findViewById(R.id.fangsu);
                final EditText fangzao = (EditText) v.findViewById(R.id.fangzao);
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

                fangsu.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        NumberPickerBuilder numberPickerBuilder = new NumberPickerBuilder()
                                .setFragmentManager(getFragmentManager())
                                .setStyleResId(R.style.BetterPickersDialogFragment_Light);
                        numberPickerBuilder.show();
                        numberPickerBuilder.addNumberPickerDialogHandler(new NumberPickerDialogFragment.NumberPickerDialogHandler() {
                            @Override
                            public void onDialogNumberSet(int reference, int number, double decimal, boolean isNegative, double fullNumber) {
                                xiaorongqian_fangsutext = fullNumber + "BPM";
                                fangsu.setText(xiaorongqian_fangsutext);
                            }
                        });
                    }
                });

                fangzao.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        NumberPickerBuilder numberPickerBuilder = new NumberPickerBuilder()
                                .setFragmentManager(getFragmentManager())
                                .setStyleResId(R.style.BetterPickersDialogFragment_Light);
                        numberPickerBuilder.show();
                        numberPickerBuilder.addNumberPickerDialogHandler(new NumberPickerDialogFragment.NumberPickerDialogHandler() {
                            @Override
                            public void onDialogNumberSet(int reference, int number, double decimal, boolean isNegative, double fullNumber) {
                                xiaorongqian_fangzaotext = fullNumber + "BPM";
                                fangzao.setText(xiaorongqian_fangzaotext);
                            }
                        });
                    }
                });

                confirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        xiaorongqianxinlvtext = "";
                        xiaorongqian_beizhutext = beizhu.getText().toString();
                        xiaorongqianxinlvtext = "消融前心律:" + xiaorongqian_duxingxinlvtext + "\n\n"
                                + "房速:" + xiaorongqian_fangsutext + "\n\n"
                                + "房早:" + xiaorongqian_fangzaotext;
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
                shuzhong_fangsutext = "";
                shuzhong_fangzaotext = "";
                shuzhong_beizhutext = "";
                View v = LayoutInflater.from(getActivity()).inflate(R.layout.afshuzhongxinlv, null);
                final MaterialDialog alert = new MaterialDialog(getActivity())
                        .setTitle("术中心律")
                        .setContentView(v);
                alert.show();

                final EditText duxingxinlv = (EditText) v.findViewById(R.id.duxingxinlv);
                final EditText fangsu = (EditText) v.findViewById(R.id.fangsu);
                final EditText fangzao = (EditText) v.findViewById(R.id.fangzao);
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

                fangsu.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        NumberPickerBuilder numberPickerBuilder = new NumberPickerBuilder()
                                .setFragmentManager(getFragmentManager())
                                .setStyleResId(R.style.BetterPickersDialogFragment_Light);
                        numberPickerBuilder.show();
                        numberPickerBuilder.addNumberPickerDialogHandler(new NumberPickerDialogFragment.NumberPickerDialogHandler() {
                            @Override
                            public void onDialogNumberSet(int reference, int number, double decimal, boolean isNegative, double fullNumber) {
                                shuzhong_fangsutext = fullNumber + "BPM";
                                fangsu.setText(shuzhong_fangsutext);
                            }
                        });
                    }
                });

                fangzao.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        NumberPickerBuilder numberPickerBuilder = new NumberPickerBuilder()
                                .setFragmentManager(getFragmentManager())
                                .setStyleResId(R.style.BetterPickersDialogFragment_Light);
                        numberPickerBuilder.show();
                        numberPickerBuilder.addNumberPickerDialogHandler(new NumberPickerDialogFragment.NumberPickerDialogHandler() {
                            @Override
                            public void onDialogNumberSet(int reference, int number, double decimal, boolean isNegative, double fullNumber) {
                                shuzhong_fangzaotext = fullNumber + "BPM";
                                fangzao.setText(shuzhong_fangzaotext);
                            }
                        });
                    }
                });

                confirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        shuzhongxinlvtext = "";
                        shuzhong_beizhutext = beizhu.getText().toString();
                        shuzhongxinlvtext = "术中心律:" + shuzhong_duxingxinlvtext + "\n\n"
                                + "房速:" + shuzhong_fangsutext + "\n\n"
                                + "房早:" + shuzhong_fangzaotext;
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
    public void saveCase2() {
        if(case2 != null) {
            shuzhongdianfulv = shuZhongDianFuLv.getText().toString();
            bingfazheng = bingFaZheng.getText().toString();
            case2.setBeforeHeartRate(xiaorongqianxinlvtext);
            case2.setBeforeVt(xiaorongqian_fangsutext);
            case2.setBeforeRont(xiaorongqian_fangzaotext);
            case2.setBeforeRemarks(xiaorongqian_beizhutext);
            case2.setInHeartRate(shuzhongxinlvtext);
            case2.setInVt(shuzhong_fangsutext);
            case2.setInRont(shuzhong_fangzaotext);
            case2.setInRemarks(shuzhong_beizhutext);
            case2.setComplication(bingfazheng);
            case2DataChangedListener.OnCase2DataChanged(case2);
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
