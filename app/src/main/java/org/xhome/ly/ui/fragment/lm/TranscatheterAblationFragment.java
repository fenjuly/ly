package org.xhome.ly.ui.fragment.lm;

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

    EditText xiaoRongShuShi;
    EditText xiaoRongJingXian;
    EditText baFeiJingMai;
    EditText shenJingJieCongXiaoRong;
    CircularProgressButton confirm;


    String xinqiangneizaoying;
    String youfafangshi;
    String xindongguosufazuoshifouguize;
    String zhouchang;
    String biaocefangfa;
    String shuzhangqidianwei;
    String pdianweibiaoce;
    String xiaorongshushi;
    String xiaorongjingxian;
    String bafeijingmai;
    String shenjingjiecongxiaorong;


    String xiaorongjingxiantext = "";
    String zuofangxiabutext = "";
    String zuofangdingbutext = "";
    String youfangxiabutext = "";
    String laayierjianbantext = "";
    String zuofangjiangexiantext = "";
    String zuofangdibutext = "";
    String zuoyoufeijingmaixiaoronghuanjiantext = "";
    String shuruqitatext ="";


    String xiaorongshushitext = "";
    String juzaoxiaorongtext = "";
    String jieduanxingfeijingmaixiaorongtext = "";
    String huanfeijingmaixiaorongtext = "";
    String huanfeijingmaibiyaofuzhuxiantext = "";
    String suiliedianweixiaorongtext = "";
    String shenjingjiecongxiaorongtext = "";
    String qitashushitext = "";


    String bafeijingmaitext = "";
    String rsptext = "";
    String ripvtext = "";
    String rpvstext = "";
    String lspvtext = "";
    String lipvtext = "";
    String lpvstext = "";
    String svctext = "";
    String ivctext = "";
    String csotext = "";
    String pvgonggantext = "";
    String qitatext = "";



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
                R.layout.lmjingdaoguanxiaorong, container, false);
        init();
        xiaoRongShuShi = (EditText) rootView.findViewById(R.id.xiaorongshushi);
        xiaoRongJingXian = (EditText) rootView.findViewById(R.id.xiaorongjingxian);
        baFeiJingMai = (EditText) rootView.findViewById(R.id.bafeijingmai);
        shenJingJieCongXiaoRong = (EditText) rootView.findViewById(R.id.shenjingjiecongxiaorong);
        confirm = (CircularProgressButton) rootView.findViewById(R.id.confirm);




        xiaoRongShuShi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                juzaoxiaorongtext = "";
                jieduanxingfeijingmaixiaorongtext = "";
                huanfeijingmaixiaorongtext = "";
                huanfeijingmaibiyaofuzhuxiantext = "";
                suiliedianweixiaorongtext = "";
                shenjingjiecongxiaorongtext = "";
                qitashushitext = "";
                View v = LayoutInflater.from(getActivity()).inflate(R.layout.lmxiaorongshushi, null);
                final MaterialDialog alert = new MaterialDialog(getActivity())
                        .setTitle("消融术式")
                        .setContentView(v);
                alert.show();

                CheckBox juzaoxiaorong = (CheckBox) v.findViewById(R.id.juzaoxiaorong);
                final CheckBox jieduanxingfeijingmaixiaorong = (CheckBox) v.findViewById(R.id.jieduanxingfeijingmaixiaorong);
                CheckBox huanfeijingmaixiaorong = (CheckBox) v.findViewById(R.id.huanfeijingmaixiaorong);
                CheckBox huanfeijingmaibiyaofuzhuxian = (CheckBox) v.findViewById(R.id.huanfeijingmaibiyaofuzhuxian);
                final CheckBox suiliedianweixiaorong = (CheckBox) v.findViewById(R.id.suiliedianweixiaorong);
                final CheckBox shenjingjiecongxiaorong = (CheckBox) v.findViewById(R.id.shenjingjiecongxiaorong);
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

                jieduanxingfeijingmaixiaorong.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            jieduanxingfeijingmaixiaorongtext = "节段性肺静脉消融";
                        } else {
                            jieduanxingfeijingmaixiaorongtext = "";
                        }
                    }
                });

                huanfeijingmaixiaorong.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            huanfeijingmaixiaorongtext = "环肺静脉消融";
                        } else {
                            huanfeijingmaixiaorongtext = "";
                        }
                    }
                });

                huanfeijingmaibiyaofuzhuxian.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            huanfeijingmaibiyaofuzhuxiantext = "环肺静脉+必要辅助线";
                        } else {
                            huanfeijingmaibiyaofuzhuxiantext = "";
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

                shenjingjiecongxiaorong.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            shenjingjiecongxiaorongtext = "神经节丛消融";
                        } else {
                            shenjingjiecongxiaorongtext = "";
                        }
                    }
                });


                confirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        xiaorongshushitext = "";
                        qitashushitext = qitashushi.getText().toString();
                        xiaorongshushitext = juzaoxiaorongtext + " " + jieduanxingfeijingmaixiaorongtext + " "
                                + huanfeijingmaixiaorongtext + " " + huanfeijingmaibiyaofuzhuxiantext + " "
                                + suiliedianweixiaorongtext + " " + shenjingjiecongxiaorongtext + " " + qitashushitext;
                        xiaoRongShuShi.setText("消融术式:" + xiaorongshushitext);
                        alert.dismiss();
                    }
                });
             }
        });


        baFeiJingMai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 rsptext = "";
                 ripvtext = "";
                 rpvstext = "";
                 lspvtext = "";
                 lipvtext = "";
                 lpvstext = "";
                 svctext = "";
                 ivctext = "";
                 csotext = "";
                 pvgonggantext = "";
                 qitatext = "";
                View v = LayoutInflater.from(getActivity()).inflate(R.layout.lmbafeijingmai, null);
                final MaterialDialog alert = new MaterialDialog(getActivity())
                        .setTitle("靶肺静脉")
                        .setContentView(v);
                alert.show();

                CheckBox rsp = (CheckBox) v.findViewById(R.id.rsp);
                final CheckBox ripv = (CheckBox) v.findViewById(R.id.ripv);
                CheckBox rpvs = (CheckBox) v.findViewById(R.id.rpvs);
                CheckBox lspv = (CheckBox) v.findViewById(R.id.lspv);
                final CheckBox lipv = (CheckBox) v.findViewById(R.id.lipv);
                final CheckBox lpvs = (CheckBox) v.findViewById(R.id.lpvs);
                final CheckBox svc = (CheckBox) v.findViewById(R.id.svc);
                final CheckBox ivc = (CheckBox) v.findViewById(R.id.ivc);
                final CheckBox cso = (CheckBox) v.findViewById(R.id.cso);
                final CheckBox pvgonggan = (CheckBox) v.findViewById(R.id.pvgonggan);
                final MaterialEditText qita = (MaterialEditText) v.findViewById(R.id.qita);
                CircularProgressButton confirm = (CircularProgressButton) v.findViewById(R.id.confirm);

                rsp.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            rsptext = "RSP";
                        } else {
                            rsptext = "";
                        }
                    }
                });

                ripv.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            ripvtext = "RIPV";
                        } else {
                            ripvtext = "";
                        }
                    }
                });

                rpvs.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            rpvstext = "RPVs";
                        } else {
                            rpvstext = "";
                        }
                    }
                });

                lspv.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            lspvtext = "LSPV";
                        } else {
                            lspvtext = "";
                        }
                    }
                });

                lipv.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            lipvtext = "LIPV";
                        } else {
                            lipvtext = "";
                        }
                    }
                });

                lpvs.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            lpvstext = "LPVS";
                        } else {
                            lpvstext = "";
                        }
                    }
                });

                svc.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            svctext = "SVC";
                        } else {
                            svctext = "";
                        }
                    }
                });

                ivc.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            ivctext = "IVC";
                        } else {
                            ivctext = "";
                        }
                    }
                });

                cso.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            csotext = "CSO";
                        } else {
                            csotext = "";
                        }
                    }
                });

                pvgonggan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            pvgonggantext = "PV公干";
                        } else {
                            pvgonggantext = "";
                        }
                    }
                });


                confirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        bafeijingmaitext = "";
                        qitatext = qita.getText().toString();
                        bafeijingmaitext = rsptext + " " + ripvtext + " "
                                + rpvstext + " " + lspvtext + " "
                                + lipvtext + " " + lpvstext + " " + svctext + " "
                                + ivctext + " " + csotext + " "
                                + pvgonggantext + " " + qitashushitext;
                        baFeiJingMai.setText("靶肺静脉:" + bafeijingmaitext);
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

    public void saveCase3() {
        if(case3 != null) {
            xiaorongjingxian = xiaoRongJingXian.getText().toString();
            xiaorongshushi = xiaoRongShuShi.getText().toString();
            bafeijingmai = baFeiJingMai.getText().toString();
            shenjingjiecongxiaorong = shenJingJieCongXiaoRong.getText().toString();

            case3.setAblationLines(xiaorongjingxian);
            case3.setAblationProcedure(xiaorongshushi);
            case3.setLungVein(bafeijingmai);
            case3.setGpAblation(shenjingjiecongxiaorong);
            case3DataChangedListener.OnCase3DataChanged(case3);
        }
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if (!isInActivity) {
            isInActivity = true;
            baFeiJingMai.setText("");
            shenJingJieCongXiaoRong.setText("");
            xiaoRongShuShi.setText("");
            xiaoRongJingXian.setText("");
        }

    }



}
