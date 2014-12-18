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
import android.widget.ListView;

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
public class TranscatheterAblationFragment extends BaseFragment {

    private static TranscatheterAblationFragment fragment;

    private static final String[] methods = {"标测方法一", "标测方法二", "标测方法三"};

    EditText xingQiangNeiZaoYing;
    EditText youFaFangShi;
    MaterialEditText xinDongGuoSuFaZuoShiFouGuiZhe;
    EditText zhouChang;
    EditText biaoCeFangFa;
    MaterialEditText shuZhangQiDianWei;
    MaterialEditText pDianWeiBiaoCe;
    EditText xiaoRongShuShi;
    MaterialEditText qingShuRuXiaoRongShuShi;
    EditText xiaoRongJingXian;
    CircularProgressButton confirm;


    String xinqiangneizaoying;
    String youfafangshi;
    String xindongguosufazuoshifouguize;
    String zhouchang;
    String biaocefangfa;
    String shuzhangqidianwei;
    String pdianweibiaoce;
    String xiaorongshushi;
    String qingshuruxiaorongshushi;
    String xiaorongjingxian;

    String xinqiangneizaoyingtext = "";
    String zuoshitext = "";
    String youshitext = "";

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
    String laayierjianbantext = "";
    String zuofangjiangexiantext = "";
    String zuofangdibutext = "";
    String zuoyoufeijingmaixiaoronghuanjiantext = "";
    String shuruqitatext ="";

    public static TranscatheterAblationFragment newInstance(Case1 case1) {
        if (fragment == null) {
            fragment = new TranscatheterAblationFragment();
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
                R.layout.jingdaoguanxiaorong, container, false);
        init();
        xingQiangNeiZaoYing = (EditText) rootView.findViewById(R.id.xinqiangneizaoying);
        youFaFangShi = (EditText) rootView.findViewById(R.id.youfafangshi);
        xinDongGuoSuFaZuoShiFouGuiZhe = (MaterialEditText) rootView.findViewById(R.id.xindongguosufazuoshifouguize);
        zhouChang = (EditText) rootView.findViewById(R.id.zhouchang);
        biaoCeFangFa = (EditText) rootView.findViewById(R.id.biaocefangfa);
        shuZhangQiDianWei = (MaterialEditText) rootView.findViewById(R.id.shuzhangqidianwei);
        pDianWeiBiaoCe = (MaterialEditText) rootView.findViewById(R.id.pdianweibiaoce);
        xiaoRongShuShi = (EditText) rootView.findViewById(R.id.xiaorongshushi);
        qingShuRuXiaoRongShuShi = (MaterialEditText) rootView.findViewById(R.id.qingshuruxiaorongshushi);
        xiaoRongJingXian = (EditText) rootView.findViewById(R.id.xiaorongjingxian);
        confirm = (CircularProgressButton) rootView.findViewById(R.id.confirm);

        xingQiangNeiZaoYing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zuoshitext = "";
                youshitext = "";
                View v = LayoutInflater.from(getActivity()).inflate(R.layout.xinqiangneizaoying, null);
                final MaterialDialog alert = new MaterialDialog(getActivity())
                        .setTitle("心腔内造影")
                        .setContentView(v);
                alert.show();
                CheckBox zuo = (CheckBox) v.findViewById(R.id.zuoshi);
                CheckBox you = (CheckBox) v.findViewById(R.id.youshi);
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
                confirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        xinqiangneizaoyingtext = "";
                        xinqiangneizaoyingtext = zuoshitext + " ";
                        xinqiangneizaoyingtext = xinqiangneizaoyingtext + youshitext;
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
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                        getActivity(),
                        android.R.layout.simple_list_item_1
                );
                for (int i = 0; i < methods.length; i++) {
                    arrayAdapter.add(methods[i]);
                }

                ListView listView = new ListView(getActivity());
                float scale = getResources().getDisplayMetrics().density;
                int dpAsPixels = (int) (8 * scale + 0.5f);
                listView.setPadding(0, dpAsPixels, 0, dpAsPixels);
                listView.setDividerHeight(0);
                listView.setAdapter(arrayAdapter);
                final MaterialDialog alert = new MaterialDialog(getActivity())
                        .setTitle("标测方法")
                        .setContentView(listView);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                        biaoCeFangFa.setText(methods[position]);
                        alert.dismiss();
                    }
                });
                alert.show();
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
                View v = LayoutInflater.from(getActivity()).inflate(R.layout.xiaorongshushi, null);
                final MaterialDialog alert = new MaterialDialog(getActivity())
                        .setTitle("消融术式")
                        .setContentView(v);
                alert.show();

                CheckBox juzaoxiaorong = (CheckBox) v.findViewById(R.id.juzaoxiaorong);
                final CheckBox xianxingxiaorong = (CheckBox) v.findViewById(R.id.xianxingxiaorong);
                CheckBox suiliedianweixiaorong = (CheckBox) v.findViewById(R.id.suiliedianweixiaorong);
                CheckBox shuzhangqidianweixiaorong = (CheckBox) v.findViewById(R.id.shuzhangqidianweixiaorong);
                final CheckBox pdianweixiaorong = (CheckBox) v.findViewById(R.id.pdianweixiaorong);
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

                shuzhangqidianweixiaorong.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            shuzhangqidianweixiaorongtext = "舒张期电位消融";
                        } else {
                            shuzhangqidianweixiaorongtext = "";
                        }
                    }
                });

                pdianweixiaorong.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            pdianweixiaorongtext = "P电位消融";
                        } else {
                            pdianweixiaorongtext = "";
                        }
                    }
                });

                confirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        xiaorongshushitext = "";
                        qitashushitext = qitashushi.getText().toString();
                        xiaorongshushitext = juzaoxiaorongtext + " " + xianxingxiaorongtext + " "
                                + suiliedianweixiaorongtext + " " + shuzhangqidianweixiaorongtext + " "
                                + pdianweixiaorongtext + " " + qitashushitext;
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
                laayierjianbantext = "";
                zuofangjiangexiantext = "";
                zuofangdibutext = "";
                View v = LayoutInflater.from(getActivity()).inflate(R.layout.xiaorongjingxian, null);
                final MaterialDialog alert = new MaterialDialog(getActivity())
                        .setTitle("消融径线")
                        .setContentView(v);
                alert.show();
                CheckBox zuofangxiabu = (CheckBox) v.findViewById(R.id.zuofangxiabu);
                CheckBox zuofangdingbu = (CheckBox) v.findViewById(R.id.zuofangdingbu);
                CheckBox youfangxiabu = (CheckBox) v.findViewById(R.id.youfangxiabu);
                final CheckBox laayierjianban = (CheckBox) v.findViewById(R.id.laayierjianban);
                CheckBox zuofangjiangexian = (CheckBox) v.findViewById(R.id.zuofangjiangexian);
                CheckBox zuofangdibu = (CheckBox) v.findViewById(R.id.zuofangdibu);
                CheckBox zuoyoufeijingmaixiaoronghuanjian = (CheckBox) v.findViewById(R.id.zuoyoufeijingmaixiaoronghuanjian);
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

                laayierjianban.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            laayierjianbantext = "LAA一二尖瓣";
                        } else {
                            laayierjianbantext = "";
                        }
                    }
                });

                zuofangjiangexian.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            zuofangjiangexiantext = "左房间隔线";
                        } else {
                            zuofangjiangexiantext = "";
                        }
                    }
                });

                zuofangdibu.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            zuofangdibutext = "左房底部";
                        } else {
                            zuofangdibutext = "";
                        }
                    }
                });

                zuoyoufeijingmaixiaoronghuanjian.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            zuoyoufeijingmaixiaoronghuanjiantext = "左右肺静脉消融环间";
                        } else {
                            zuoyoufeijingmaixiaoronghuanjiantext = "";
                        }
                    }
                });

                confirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        xiaorongjingxiantext = "";
                        shuruqitatext = shuruqita.getText().toString();
                        xiaorongjingxiantext = zuofangdibutext + " " + zuofangdingbutext + " "
                                + youfangxiabutext + " " + laayierjianbantext + " "
                                + zuofangjiangexiantext + " " + zuofangdibutext + " "
                                + zuoyoufeijingmaixiaoronghuanjiantext + " "
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

    public void saveCase1() {
        if(case1 != null) {
            xinqiangneizaoying = xingQiangNeiZaoYing.getText().toString();
            youfafangshi = youFaFangShi.getText().toString();
            xindongguosufazuoshifouguize = xinDongGuoSuFaZuoShiFouGuiZhe.getText().toString();
            zhouchang = zhouChang.getText().toString();
            biaocefangfa = biaoCeFangFa.getText().toString();
            shuzhangqidianwei = shuZhangQiDianWei.getText().toString();
            pdianweibiaoce = pDianWeiBiaoCe.getText().toString();
            xiaorongshushi = xiaoRongShuShi.getText().toString();
            qingshuruxiaorongshushi = qingShuRuXiaoRongShuShi.getText().toString();
            xiaorongjingxian = xiaoRongJingXian.getText().toString();
            case1.setImagingInsideHeart(xinqiangneizaoying);
            case1.setInducedWay(youfafangshi);
            case1.setCheckMedication(jianchayongyaotext);
            case1.setTachycardiaRegulation(xindongguosufazuoshifouguize);
            case1.setCcl(zhouchang);
            case1.setInspectionMethod(biaocefangfa);
            case1.setDiastolicPotential(shuzhangqidianwei);
            case1.setpPotentialExamination(pdianweibiaoce);
            case1.setAblationProcedure(xiaorongshushi);
            case1.setAblationLines(xiaorongjingxian);
            case1DataChangedListener.OnCase1DataChanged(case1);
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
            shuZhangQiDianWei.setText("");
            pDianWeiBiaoCe.setText("");
            xiaoRongShuShi.setText("");
            qingShuRuXiaoRongShuShi.setText("");
            xiaoRongJingXian.setText("");
        }

    }



}
