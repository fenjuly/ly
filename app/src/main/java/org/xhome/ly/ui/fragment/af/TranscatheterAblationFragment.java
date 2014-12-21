package org.xhome.ly.ui.fragment.af;

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
import android.widget.ListView;

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
public class TranscatheterAblationFragment extends BaseFragment {

    private static TranscatheterAblationFragment fragment;

    private static final String[] methods = {"标测方法一", "标测方法二", "标测方法三"};

    EditText xingQiangNeiZaoYing;
    EditText youFaFangShi;
    MaterialEditText xinDongGuoSuFaZuoShiFouGuiZhe;
    EditText zhouChang;
    EditText biaoCeFangFa;
    EditText biaoCeFangShi;
    EditText xiaoRongShuShi;
    EditText xiaoRongJingXian;
    CircularProgressButton confirm;


    String xinqiangneizaoying;
    String youfafangshi;
    String xindongguosufazuoshifouguize;
    String zhouchang;
    String biaocefangfa;
    String biaocefangshi;
    String shuzhangqidianwei;
    String pdianweibiaoce;
    String xiaorongshushi;
    String xiaorongjingxian;

    String xinqiangneizaoyingtext = "";
    String zuoshitext = "";
    String youshitext = "";
    String feijingmaitext = "";
    String wutext = "";

    String youfafangshitext = "";
    String zifatext = "";
    String xinshifenjidizengcijitext = "";
    String xinshizaobocijitext = "";

    String jianchayongyaotext = "";

    String xiaorongshushitext = "";
    String juzaoxiaorongtext = "";
    String xianxingxiaorongtext = "";
    String suiliedianweixiaorongtext = "";
    String shuzhangqidianweixiaorongtext = "";
    String pdianweixiaorongtext = "";
    String qitashushitext = "";

    String xiaorongjingxiantext = "";
    String zuofangxiabutext = "";
    String zuofangdingbutext = "";
    String youfangxiabutext = "";
    String zuofangdibutext = "";
    String shuruqitatext ="";

    String cartotext = "";
    String ensitetext = "";
    String qitatext = "";
    String biaocefangfatext = "";

    String biaocefangshitext = "";
    String jidongbiaocetext = "";
    String jizhibiaocetext = "";

    public static TranscatheterAblationFragment newInstance(Case2 case2) {
        if (fragment == null) {
            fragment = new TranscatheterAblationFragment();
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
                R.layout.afjingdaoguanxiaorong, container, false);
        init();
        xingQiangNeiZaoYing = (EditText) rootView.findViewById(R.id.xinqiangneizaoying);
        youFaFangShi = (EditText) rootView.findViewById(R.id.youfafangshi);
        xinDongGuoSuFaZuoShiFouGuiZhe = (MaterialEditText) rootView.findViewById(R.id.xindongguosufazuoshifouguize);
        zhouChang = (EditText) rootView.findViewById(R.id.zhouchang);
        biaoCeFangFa = (EditText) rootView.findViewById(R.id.biaocefangfa);
        biaoCeFangShi = (EditText) rootView.findViewById(R.id.biaocefangshi);
        xiaoRongShuShi = (EditText) rootView.findViewById(R.id.xiaorongshushi);
        xiaoRongJingXian = (EditText) rootView.findViewById(R.id.xiaorongjingxian);
        confirm = (CircularProgressButton) rootView.findViewById(R.id.confirm);

        xingQiangNeiZaoYing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zuoshitext = "";
                youshitext = "";
                feijingmaitext = "";
                wutext = "";
                View v = LayoutInflater.from(getActivity()).inflate(R.layout.afxinqiangneizaoying, null);
                final MaterialDialog alert = new MaterialDialog(getActivity())
                        .setTitle("心腔内造影")
                        .setContentView(v);
                alert.show();
                CheckBox zuo = (CheckBox) v.findViewById(R.id.zuoshi);
                CheckBox you = (CheckBox) v.findViewById(R.id.youshi);
                CheckBox feijingmai = (CheckBox) v.findViewById(R.id.feijingmai);
                CheckBox wu = (CheckBox) v.findViewById(R.id.wu);
                CircularProgressButton confirm = (CircularProgressButton) v.findViewById(R.id.confirm);
                zuo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                              zuoshitext = "左室";
                        } else {
                            zuoshitext = "";
                        }
                    }
                });
                you.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            youshitext = "右室";
                        } else {
                            youshitext = "";
                        }
                    }
                });
                feijingmai.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            feijingmaitext = "肺静脉";
                        } else {
                            feijingmaitext = "";
                        }
                    }
                });
                wu.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            wutext = "无";
                        } else {
                            wutext = "";
                        }
                    }
                });
                confirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        xinqiangneizaoyingtext = "";
                        xinqiangneizaoyingtext = zuoshitext + " " + youshitext + " " + feijingmaitext +
                        " " + wutext;
                        xingQiangNeiZaoYing.setText(xinqiangneizaoyingtext);
                        alert.dismiss();
                    }
                });
            }
        });

        youFaFangShi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zifatext = "";
                xinshifenjidizengcijitext = "";
                xinshizaobocijitext = "";
                View v = LayoutInflater.from(getActivity()).inflate(R.layout.youfafangshi, null);
                final MaterialDialog alert = new MaterialDialog(getActivity())
                        .setTitle("诱发方式")
                        .setContentView(v);
                alert.show();
                CheckBox zifa = (CheckBox) v.findViewById(R.id.zifa);
                CheckBox xinshifenjidizengciji = (CheckBox) v.findViewById(R.id.xinshifenjidizeng);
                CheckBox xinshizaobociji = (CheckBox) v.findViewById(R.id.xinshizaobociji);
                final MaterialEditText jianchayongyao = (MaterialEditText) v.findViewById(R.id.jianchayongyao);
                CircularProgressButton confirm = (CircularProgressButton) v.findViewById(R.id.confirm);
                zifa.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            zifatext = "自发";
                        } else {
                            zifatext = "";
                        }
                    }
                });
                xinshifenjidizengciji.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            xinshifenjidizengcijitext = "心室分级递增刺激";
                        } else {
                            xinshifenjidizengcijitext = "";
                        }
                    }
                });
                xinshizaobociji.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            xinshizaobocijitext = "心室早搏刺激";
                        } else {
                            xinshizaobocijitext = "";
                        }
                    }
                });

                confirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        youfafangshitext = "";
                        youfafangshitext = zifatext + " " + xinshifenjidizengcijitext + " " + xinshizaobocijitext;
                        jianchayongyaotext = jianchayongyao.getText().toString();
                        youFaFangShi.setText("诱发方式:" + youfafangshitext + "\n\n"
                        + "检查用药:" + jianchayongyaotext
                        );
                        alert.dismiss();
                    }
                });

            }
        });

        zhouChang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NumberPickerBuilder numberPickerBuilder = new NumberPickerBuilder()
                        .setFragmentManager(getFragmentManager())
                        .setStyleResId(R.style.BetterPickersDialogFragment_Light);
                numberPickerBuilder.show();
                numberPickerBuilder.addNumberPickerDialogHandler(new NumberPickerDialogFragment.NumberPickerDialogHandler() {
                    @Override
                    public void onDialogNumberSet(int reference, int number, double decimal, boolean isNegative, double fullNumber) {
                        zhouChang.setText(fullNumber + "ms");
                    }
                });
            }
        });

        biaoCeFangFa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ensitetext = "";
                cartotext = "";
                qitatext = "";
                View v = LayoutInflater.from(getActivity()).inflate(R.layout.afbiaocefangfa, null);
                final MaterialDialog alert = new MaterialDialog(getActivity())
                        .setTitle("标测方法")
                        .setContentView(v);
                alert.show();

                CheckBox ensite = (CheckBox) v.findViewById(R.id.ensite);
                CheckBox carto = (CheckBox) v.findViewById(R.id.carto);
                final MaterialEditText qita = (MaterialEditText) v.findViewById(R.id.qita);

                CircularProgressButton confirm = (CircularProgressButton) v.findViewById(R.id.confirm);

                carto.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            cartotext = "CARTO";
                        } else {
                            cartotext = "";
                        }
                    }
                });

                ensite.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            ensitetext = "Ensite";
                        } else {
                            ensitetext = "";
                        }
                    }
                });

                confirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        biaocefangfatext = "";
                        qitatext = qita.getText().toString();
                        biaocefangfatext = cartotext + " " + ensitetext + " " +qitatext;
                        biaoCeFangFa.setText("标测方法:" + biaocefangfatext);
                        alert.dismiss();
                    }
                });
            }
        });

        biaoCeFangShi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jidongbiaocetext = "";
                jizhibiaocetext = "";
                View v = LayoutInflater.from(getActivity()).inflate(R.layout.afbiaocefangshi, null);
                final MaterialDialog alert = new MaterialDialog(getActivity())
                        .setTitle("标测方式")
                        .setContentView(v);
                alert.show();
                final CheckBox jidongbiaoce = (CheckBox) v.findViewById(R.id.jidongbiaoce);
                CheckBox jizhibiaoce = (CheckBox) v.findViewById(R.id.jizhibiaoce);
                CircularProgressButton confirm = (CircularProgressButton) v.findViewById(R.id.confirm);
                jidongbiaoce.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            jidongbiaocetext = "激动标测";
                        } else {
                            jidongbiaocetext = "";
                        }
                    }
                });
                jizhibiaoce.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            jizhibiaocetext = "基质标测";
                        } else {
                            jizhibiaocetext = "";
                        }
                    }
                });

                confirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        biaocefangshitext = "";
                        biaocefangshitext = jidongbiaocetext + " " + jizhibiaocetext;
                        biaoCeFangShi.setText(biaocefangshitext);
                        alert.dismiss();
                    }
                });
            }
        });

        xiaoRongShuShi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                juzaoxiaorongtext = "";
                xianxingxiaorongtext = "";
                suiliedianweixiaorongtext = "";
                shuzhangqidianweixiaorongtext = "";
                pdianweixiaorongtext = "";
                View v = LayoutInflater.from(getActivity()).inflate(R.layout.afxiaorongshushi, null);
                final MaterialDialog alert = new MaterialDialog(getActivity())
                        .setTitle("消融术式")
                        .setContentView(v);
                alert.show();

                CheckBox juzaoxiaorong = (CheckBox) v.findViewById(R.id.juzaoxiaorong);
                final CheckBox xianxingxiaorong = (CheckBox) v.findViewById(R.id.xianxingxiaorong);
                CheckBox suiliedianweixiaorong = (CheckBox) v.findViewById(R.id.suiliedianweixiaorong);
                final MaterialEditText qitashushi = (MaterialEditText) v.findViewById(R.id.qitashushi);
                CircularProgressButton confirm = (CircularProgressButton) v.findViewById(R.id.confirm);

                juzaoxiaorong.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                          juzaoxiaorongtext = "局灶消融";
                        } else {
                            juzaoxiaorongtext = "";
                        }
                    }
                });

                xianxingxiaorong.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            xianxingxiaorongtext = "线性消融";
                        } else {
                            xianxingxiaorongtext = "";
                        }
                    }
                });

                suiliedianweixiaorong.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            suiliedianweixiaorongtext = "碎裂电位消融";
                        } else {
                            suiliedianweixiaorongtext = "";
                        }
                    }
                });

                confirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        xiaorongshushitext = "";
                        qitashushitext = qitashushi.getText().toString();
                        xiaorongshushitext = juzaoxiaorongtext + " " + xianxingxiaorongtext + " "
                                + suiliedianweixiaorongtext + " "
                                + qitashushitext;
                        xiaoRongShuShi.setText("消融术式:" + xiaorongshushitext);
                        alert.dismiss();
                    }
                });
             }
        });

        xiaoRongJingXian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zuofangdibutext = "";
                zuofangdingbutext = "";
                youfangxiabutext = "";
                View v = LayoutInflater.from(getActivity()).inflate(R.layout.afxiaorongjingxian, null);
                final MaterialDialog alert = new MaterialDialog(getActivity())
                        .setTitle("消融径线")
                        .setContentView(v);
                alert.show();
                CheckBox zuofangxiabu = (CheckBox) v.findViewById(R.id.zuofangxiabu);
                CheckBox zuofangdingbu = (CheckBox) v.findViewById(R.id.zuofangdingbu);
                CheckBox youfangxiabu = (CheckBox) v.findViewById(R.id.youfangxiabu);
                final MaterialEditText shuruqita = (MaterialEditText) v.findViewById(R.id.shuruqita);
                CircularProgressButton confirm = (CircularProgressButton) v.findViewById(R.id.confirm);

                zuofangxiabu.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            zuofangxiabutext = "左房狭部";
                        } else {
                            zuofangxiabutext = "";
                        }
                    }
                });

                zuofangdingbu.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            zuofangdingbutext = "左房顶部";
                        } else {
                            zuofangdingbutext = "";
                        }
                    }
                });

                youfangxiabu.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            youfangxiabutext = "右房狭部";
                        } else {
                            youfangxiabutext = "";
                        }
                    }
                });

                confirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        xiaorongjingxiantext = "";
                        shuruqitatext = shuruqita.getText().toString();
                        xiaorongjingxiantext = zuofangdibutext + " " + zuofangdingbutext + " "
                                + youfangxiabutext + " "
                                + shuruqitatext;
                        xiaoRongJingXian.setText("消融术式:" + xiaorongjingxiantext);
                        alert.dismiss();
                    }
                });

            }
        });
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextStepListner.OnNextStepClicked(3);
            }
        });
        return rootView;
    }

    @Override
    public void saveCase2() {
        if(case2 != null) {
            xinqiangneizaoying = xingQiangNeiZaoYing.getText().toString();
            youfafangshi = youFaFangShi.getText().toString();
            xindongguosufazuoshifouguize = xinDongGuoSuFaZuoShiFouGuiZhe.getText().toString();
            zhouchang = zhouChang.getText().toString();
            biaocefangfa = biaoCeFangFa.getText().toString();
            xiaorongshushi = xiaoRongShuShi.getText().toString();
            xiaorongjingxian = xiaoRongJingXian.getText().toString();
            biaocefangshi = biaoCeFangShi.getText().toString();
            case2.setImagingInsideHeart(xinqiangneizaoying);
            case2.setInducedWay(youfafangshi);
            case2.setCheckMedication(jianchayongyaotext);
            case2.setTachycardiaRegulation(xindongguosufazuoshifouguize);
            case2.setCcl(zhouchang);
            case2.setInspectionMethod(biaocefangfa);
            case2.setAblationProcedure(xiaorongshushi);
            case2.setAblationLines(xiaorongjingxian);
            case2DataChangedListener.OnCase2DataChanged(case2);
        }
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if (!isInActivity) {
            isInActivity = true;
            xingQiangNeiZaoYing.setText("");
            youFaFangShi.setText("");
            xinDongGuoSuFaZuoShiFouGuiZhe.setText("");
            zhouChang.setText("");
            biaoCeFangFa.setText("");
            xiaoRongShuShi.setText("");
            xiaoRongJingXian.setText("");
        }

    }



}
