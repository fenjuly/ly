package org.xhome.ly.ui.fragment.lm;

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
import org.xhome.ly.bean.Case3;

import me.drakeet.materialdialog.MaterialDialog;

/**
 * Created by liurongchan on 14/12/3.
 */
public class AblationResultFragment extends BaseFragment {

    private static AblationResultFragment fragment;

    MaterialEditText baDianBuWei;
    EditText nengYuanXiaoRong;
    MaterialEditText biaoCeFangFa;
    EditText xiaoRongZhongDian;
    EditText fangDianShiJian;
    EditText xXianBaoGuangShiJian;
    EditText xiaoRongCiShu;

    CircularProgressButton confirm;

    String badianbuwei;
    String nengyuanxiaorong;
    String biaocefangfa;
    String xiaorongzhongdian;
    String fangdianshijian;
    String xxianbaoguanshijia;
    String xiaorongcishu;


    String nengyuanxiaorongtext = "";
    String shepinxiaorongtext = "";
    String lengdongtext = "";
    String qitatext = "";


    String xiaorongzhongdiantext;
    String wanchengxiaorongjingxiantext;
    String feijingmaidianweixiaoshitext;
    String feijingmaizuoxinfangshuangxiangchuandaozuzhitext;
    String diancijifangchanbunengyoufatext;
    String isodiancijifangchanbunengyoufatext;
    String dianyabiaocetext;
    String cafeswanquanxiaoshitext;
    String gaopincijimizoushenjingfanshexiaoshitext;
    String shuruqitatext;

    String fangdianshijiantext;
    String youxiaobadiantext;
    String zongfangdianshijiantext;
    public static AblationResultFragment newInstance(Case3 case3) {
        if (fragment == null) {
            fragment = new AblationResultFragment();
        }
        Bundle bundle = fragment.getArguments();
        if (bundle == null) {
            bundle = new Bundle();
            bundle.putString("case3", new Gson().toJson(case3));
            fragment.setArguments(bundle);
        } else {
            bundle.putString("case3", new Gson().toJson(case3));
        }

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(
                R.layout.lmxiaorongjieguo, container, false);
        init();
        baDianBuWei = (MaterialEditText) rootView.findViewById(R.id.badianbuwei);
        nengYuanXiaoRong = (EditText) rootView.findViewById(R.id.nengyuanxiaorong);
        biaoCeFangFa = (MaterialEditText) rootView.findViewById(R.id.biaocefangfa);
        xiaoRongZhongDian = (EditText) rootView.findViewById(R.id.xiaorongzhongdian);
        fangDianShiJian = (EditText) rootView.findViewById(R.id.fangdianshijian);
        xXianBaoGuangShiJian = (EditText) rootView.findViewById(R.id.xxianbaoguanshijia);
        xiaoRongCiShu = (EditText) rootView.findViewById(R.id.xiaorongcishu);
        confirm = (CircularProgressButton) rootView.findViewById(R.id.confirm);

        nengYuanXiaoRong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shepinxiaorongtext = "";
                lengdongtext = "";
                qitatext = "";
                View v = LayoutInflater.from(getActivity()).inflate(R.layout.nengyuanxiaorong, null);
                final MaterialDialog alert = new MaterialDialog(getActivity())
                        .setTitle("能源消融")
                        .setContentView(v);
                alert.show();
                CheckBox shepinxiaorong = (CheckBox) v.findViewById(R.id.shepinxiaorong);
                CheckBox lengdong = (CheckBox) v.findViewById(R.id.lengdong);
                final MaterialEditText qita = (MaterialEditText) v.findViewById(R.id.qita);
                CircularProgressButton confirm = (CircularProgressButton) v.findViewById(R.id.confirm);

                shepinxiaorong.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            shepinxiaorongtext = "射频消融";
                        } else {
                            shepinxiaorongtext = "";
                        }
                    }
                });

                lengdong.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            lengdongtext = "冷冻";
                        } else {
                            lengdongtext = "";
                        }
                    }
                });

                confirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        nengyuanxiaorongtext = "";
                        qitatext = qita.getText().toString();
                        nengyuanxiaorongtext = shepinxiaorongtext + " " + lengdongtext + " " + qitatext;
                        nengYuanXiaoRong.setText("消融能源:" + nengyuanxiaorongtext
                        );
                        alert.dismiss();
                    }
                });

             }
        });



        xiaoRongZhongDian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 wanchengxiaorongjingxiantext = "";
                 feijingmaidianweixiaoshitext = "";
                 feijingmaizuoxinfangshuangxiangchuandaozuzhitext = "";
                 diancijifangchanbunengyoufatext = "";
                 isodiancijifangchanbunengyoufatext = "";
                 dianyabiaocetext = "";
                 cafeswanquanxiaoshitext = "";
                 gaopincijimizoushenjingfanshexiaoshitext = "";
                shuruqitatext = "";
                View v = LayoutInflater.from(getActivity()).inflate(R.layout.lmxiaorongzhongdian, null);
                final MaterialDialog alert = new MaterialDialog(getActivity())
                        .setTitle("消融终点")
                        .setContentView(v);
                alert.show();
                CheckBox wanchengxiaorongjingxian = (CheckBox) v.findViewById(R.id.wanchengxiaorongjingxian);
                CheckBox feijingmaidianweixiaoshi = (CheckBox) v.findViewById(R.id.feijingmaidianweixiaoshi);
                CheckBox feijingmaizuoxinfangshuangxiangchuandaozuzhi = (CheckBox) v.findViewById(R.id.feijingmaizuoxinfangshuangxiangchuandaozuzhi);
                CheckBox diancijifangchanbunengyoufa = (CheckBox) v.findViewById(R.id.diancijifangchanbunengyoufa);
                CheckBox isodiancijifangchanbunengyoufa = (CheckBox) v.findViewById(R.id.isodiancijifangchanbunengyoufa);
                CheckBox dianyabiaoce = (CheckBox) v.findViewById(R.id.dianyabiaoce);
                CheckBox cafeswanquanxiaoshi = (CheckBox) v.findViewById(R.id.cafeswanquanxiaoshi);
                CheckBox gaopincijimizoushenjingfanshexiaoshi = (CheckBox) v.findViewById(R.id.gaopincijimizoushenjingfanshexiaoshi);
                final MaterialEditText shuruqita = (MaterialEditText) v.findViewById(R.id.shuruqita);
                CircularProgressButton confirm = (CircularProgressButton) v.findViewById(R.id.confirm);

                wanchengxiaorongjingxian.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            wanchengxiaorongjingxiantext = "完成消融径线";
                        } else {
                            wanchengxiaorongjingxiantext = "";
                        }
                    }
                });

                feijingmaidianweixiaoshi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            feijingmaidianweixiaoshitext = "肺静脉电位消失";
                        } else {
                            feijingmaidianweixiaoshitext = "";
                        }
                    }
                });

                feijingmaizuoxinfangshuangxiangchuandaozuzhi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            feijingmaizuoxinfangshuangxiangchuandaozuzhitext = "肺静脉—左心房双向传导阻滞";
                        } else {
                            feijingmaizuoxinfangshuangxiangchuandaozuzhitext = "";
                        }
                    }
                });

                diancijifangchanbunengyoufa.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            diancijifangchanbunengyoufatext = "电刺激房颤不能诱发";
                        } else {
                            diancijifangchanbunengyoufatext = "";
                        }
                    }
                });

                isodiancijifangchanbunengyoufa.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            isodiancijifangchanbunengyoufatext = "ISO+电刺激房颤不能诱";
                        } else {
                            isodiancijifangchanbunengyoufatext = "";
                        }
                    }
                });

                dianyabiaoce.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            dianyabiaocetext = "电压标测，消融线以内的电压＜0.1mv:激动标测，消融径线任何部位两侧的局部激动时间";
                        } else {
                            dianyabiaocetext = "";
                        }
                    }
                });

                cafeswanquanxiaoshi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            cafeswanquanxiaoshitext = "CAFEs完全消失";
                        } else {
                            cafeswanquanxiaoshitext = "";
                        }
                    }
                });

                gaopincijimizoushenjingfanshexiaoshi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            gaopincijimizoushenjingfanshexiaoshitext = "高频刺激迷走神经反射消失";
                        } else {
                            gaopincijimizoushenjingfanshexiaoshitext = "";
                        }
                    }
                });

                confirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        xiaorongzhongdiantext = "";
                        shuruqitatext = shuruqita.getText().toString();
                        xiaorongzhongdiantext = wanchengxiaorongjingxiantext + " " + feijingmaidianweixiaoshitext + " "
                                + feijingmaizuoxinfangshuangxiangchuandaozuzhitext + " " + diancijifangchanbunengyoufatext + " "
                                + isodiancijifangchanbunengyoufatext + " " + dianyabiaocetext + " "
                                + cafeswanquanxiaoshitext + " " + gaopincijimizoushenjingfanshexiaoshitext + " " + shuruqitatext;
                        xiaoRongZhongDian.setText("消融终点:" + xiaorongzhongdiantext);
                        alert.dismiss();
                    }
                });

            }
        });

        fangDianShiJian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                youxiaobadiantext = "";
                zongfangdianshijiantext = "";
                View v = LayoutInflater.from(getActivity()).inflate(R.layout.fangdianshijian, null);
                final MaterialDialog alert = new MaterialDialog(getActivity())
                        .setTitle("放电时间")
                        .setContentView(v);
                final MaterialEditText youxiaobadian = (MaterialEditText) v.findViewById(R.id.youxiaobadian);
                final EditText zongfangdianshijian = (EditText) v.findViewById(R.id.zongfangdianshijian);
                CircularProgressButton confirm = (CircularProgressButton) v.findViewById(R.id.confirm);

                zongfangdianshijian.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        NumberPickerBuilder numberPickerBuilder = new NumberPickerBuilder()
                                .setFragmentManager(getFragmentManager())
                                .setStyleResId(R.style.BetterPickersDialogFragment_Light);
                        numberPickerBuilder.show();
                        numberPickerBuilder.addNumberPickerDialogHandler(new NumberPickerDialogFragment.NumberPickerDialogHandler() {
                            @Override
                            public void onDialogNumberSet(int reference, int number, double decimal, boolean isNegative, double fullNumber) {
                                zongfangdianshijiantext = number + "min";
                                zongfangdianshijian.setText(zongfangdianshijiantext);
                            }
                        });
                    }
                });

                confirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        fangdianshijiantext = "";
                        youxiaobadiantext = youxiaobadian.getText().toString();
                        fangDianShiJian.setText("有效靶点:" + youxiaobadiantext + "\n\n"
                           + "总放电时间:" + zongfangdianshijiantext
                        );
                        alert.dismiss();
                    }
                });

                alert.show();
            }
        });

        xXianBaoGuangShiJian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NumberPickerBuilder numberPickerBuilder = new NumberPickerBuilder()
                        .setFragmentManager(getFragmentManager())
                        .setStyleResId(R.style.BetterPickersDialogFragment_Light);
                numberPickerBuilder.show();
                numberPickerBuilder.addNumberPickerDialogHandler(new NumberPickerDialogFragment.NumberPickerDialogHandler() {
                    @Override
                    public void onDialogNumberSet(int reference, int number, double decimal, boolean isNegative, double fullNumber) {
                        xXianBaoGuangShiJian.setText(number + "min");
                    }
                });
            }
        });

        xiaoRongCiShu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NumberPickerBuilder numberPickerBuilder = new NumberPickerBuilder()
                        .setFragmentManager(getFragmentManager())
                        .setStyleResId(R.style.BetterPickersDialogFragment_Light);
                numberPickerBuilder.show();
                numberPickerBuilder.addNumberPickerDialogHandler(new NumberPickerDialogFragment.NumberPickerDialogHandler() {
                    @Override
                    public void onDialogNumberSet(int reference, int number, double decimal, boolean isNegative, double fullNumber) {
                        xiaoRongCiShu.setText(number + "次");
                        xiaorongcishu  = number + "";
                    }
                });
            }
        });

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextStepListner.OnNextStepClicked(4);
            }
        });
        return rootView;
    }

    @Override
    public void saveCase3() {
        if(case3 != null) {
            badianbuwei = baDianBuWei.getText().toString();
            nengyuanxiaorong = nengYuanXiaoRong.getText().toString();
            biaocefangfa = biaoCeFangFa.getText().toString();
            xiaorongzhongdian = xiaoRongZhongDian.getText().toString();
            fangdianshijian = fangDianShiJian.getText().toString();
            xxianbaoguanshijia = xXianBaoGuangShiJian.getText().toString();
//            xiaorongcishu = xiaoRongCiShu.getText().toString();
            case3.setTargetPosition(badianbuwei);
            case3.setAblationEnergy(nengyuanxiaorong);
            case3.setAblationEndPoint(xiaorongzhongdian);
            case3.setDischargeTime(zongfangdianshijiantext);
            case3.setXrayExposureTime(xxianbaoguanshijia);
            if(xiaorongcishu != null && !xiaorongcishu.equals("")) {
                case3.setAblationTimes(Integer.valueOf(xiaorongcishu));
            }
            case3DataChangedListener.OnCase3DataChanged(case3);
        }
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if (!isInActivity) {
            isInActivity = true;
            baDianBuWei.setText("");
            nengYuanXiaoRong.setText("");
            biaoCeFangFa.setText("");
            xiaoRongZhongDian.setText("");
            fangDianShiJian.setText("");
            xXianBaoGuangShiJian.setText("");
            xiaoRongCiShu.setText("");
        }

    }

}
