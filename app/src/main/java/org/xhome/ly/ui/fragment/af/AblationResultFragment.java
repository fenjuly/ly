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
public class AblationResultFragment extends BaseFragment {

    private static AblationResultFragment fragment;

    MaterialEditText baDianBuWei;
    EditText nengYuanXiaoRong;
    MaterialEditText qingShuRuXiaoRongNengYuan;
    EditText xiaoRongZhongDian;
    EditText fangDianShiJian;
    EditText xXianBaoGuangShiJian;
    EditText xiaoRongCiShu;

    CircularProgressButton confirm;

    String badianbuwei;
    String nengyuanxiaorong;
    String qingshuruxiaorongnengyuan;
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
    String xiaorongxianshuangxiangchuandaozuzhitext;
    String suiliedianweiwanquanxiaoshitext;
    String diancijifangsufangpubunengyoufatext;
    String lsqdiancijifangsufangpubunengyoufatext;
    String shuruqitatext;

    String fangdianshijiantext;
    String youxiaobadiantext;
    String zongfangdianshijiantext;
    public static AblationResultFragment newInstance(Case2 case2) {
        if (fragment == null) {
            fragment = new AblationResultFragment();
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
                R.layout.afxiaorongjieguo, container, false);
        init();
        baDianBuWei = (MaterialEditText) rootView.findViewById(R.id.badianbuwei);
        nengYuanXiaoRong = (EditText) rootView.findViewById(R.id.nengyuanxiaorong);
        qingShuRuXiaoRongNengYuan = (MaterialEditText) rootView.findViewById(R.id.qingshuruxiaorongnengyuan);
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
                xiaorongxianshuangxiangchuandaozuzhitext = "";
                suiliedianweiwanquanxiaoshitext = "";
                diancijifangsufangpubunengyoufatext = "";
                lsqdiancijifangsufangpubunengyoufatext = "";
                shuruqitatext = "";
                View v = LayoutInflater.from(getActivity()).inflate(R.layout.afxiaorongzhongdian, null);
                final MaterialDialog alert = new MaterialDialog(getActivity())
                        .setTitle("消融终点")
                        .setContentView(v);
                alert.show();
                CheckBox wanchengxiaorongjingxian = (CheckBox) v.findViewById(R.id.wanchengxiaorongjingxian);
                CheckBox xiaorongxianshuangxiangchuandaozuzhi = (CheckBox) v.findViewById(R.id.xiaorongxianshuangxiangchuandaozuzhi);
                CheckBox suiliedianweiwanquanxiaoshi = (CheckBox) v.findViewById(R.id.suiliedianweiwanquanxiaoshi);
                CheckBox diancijifangsufangpubunengyoufa = (CheckBox) v.findViewById(R.id.diancijifangsufangpubunengbeiyoufa);
                CheckBox lsqdiancijifangsufangpubunengyoufa = (CheckBox) v.findViewById(R.id.lsqdiancijifangsufangpubunengbeiyoufa);
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

                xiaorongxianshuangxiangchuandaozuzhi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            xiaorongxianshuangxiangchuandaozuzhitext = "消融线双向传导阻滞";
                        } else {
                            xiaorongxianshuangxiangchuandaozuzhitext = "";
                        }
                    }
                });

                suiliedianweiwanquanxiaoshi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            suiliedianweiwanquanxiaoshitext = "碎裂电位完全消失";
                        } else {
                            suiliedianweiwanquanxiaoshitext = "";
                        }
                    }
                });

                diancijifangsufangpubunengyoufa.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            diancijifangsufangpubunengyoufatext = "电刺激房速/房扑不能诱发";
                        } else {
                            diancijifangsufangpubunengyoufatext = "";
                        }
                    }
                });

                lsqdiancijifangsufangpubunengyoufa.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            lsqdiancijifangsufangpubunengyoufatext = "LSQ电刺激房速/房扑不能诱发";
                        } else {
                            lsqdiancijifangsufangpubunengyoufatext = "";
                        }
                    }
                });

                confirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        xiaorongzhongdiantext = "";
                        shuruqitatext = shuruqita.getText().toString();
                        xiaorongzhongdiantext = wanchengxiaorongjingxiantext + " " + xiaorongxianshuangxiangchuandaozuzhitext + " "
                                + suiliedianweiwanquanxiaoshitext + " " + diancijifangsufangpubunengyoufatext + " "
                                + lsqdiancijifangsufangpubunengyoufatext + " " + shuruqitatext;
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
    public void saveCase2() {
        if(case2 != null) {
            badianbuwei = baDianBuWei.getText().toString();
            nengyuanxiaorong = nengYuanXiaoRong.getText().toString();
            qingshuruxiaorongnengyuan = qingShuRuXiaoRongNengYuan.getText().toString();
            xiaorongzhongdian = xiaoRongZhongDian.getText().toString();
            fangdianshijian = fangDianShiJian.getText().toString();
            xxianbaoguanshijia = xXianBaoGuangShiJian.getText().toString();
            case2.setTargetPosition(badianbuwei);
            case2.setAblationEnergy(nengyuanxiaorong);
            case2.setAblationEndPoint(xiaorongzhongdian);
            case2.setEffectiveTargetSite(youxiaobadiantext);
            case2.setDischargeTime(zongfangdianshijiantext);
            case2.setXrayExposureTime(xxianbaoguanshijia);
            if(xiaorongcishu != null && !xiaorongcishu.equals("")) {
                case2.setAblationTimes(Integer.valueOf(xiaorongcishu));
            }
            case2DataChangedListener.OnCase2DataChanged(case2);
        }
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if (!isInActivity) {
            isInActivity = true;
            baDianBuWei.setText("");
            nengYuanXiaoRong.setText("");
            qingShuRuXiaoRongNengYuan.setText("");
            xiaoRongZhongDian.setText("");
            fangDianShiJian.setText("");
            xXianBaoGuangShiJian.setText("");
        }

    }

}
