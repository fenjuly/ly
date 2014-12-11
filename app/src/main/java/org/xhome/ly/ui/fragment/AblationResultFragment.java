package org.xhome.ly.ui.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
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
public class AblationResultFragment extends BaseFragment {

    private static AblationResultFragment fragment;

    MaterialEditText baDianBuWei;
    EditText nengYuanXiaoRong;
    MaterialEditText qingShuRuXiaoRongNengYuan;
    EditText panDuanXiaoRongYouXiaoZhiBiao;
    EditText xiaoRongZhongDian;
    EditText fangDianShiJian;
    EditText xXianBaoGuangShiJian;
    EditText xiaoRongCiShu;

    CircularProgressButton confirm;

    String badianbuwei;
    String nengyuanxiaorong;
    String qingshuruxiaorongnengyuan;
    String panduanxiaorongyouxiaozhibiao;
    String xiaorongzhongdian;
    String fangdianshijian;
    String xxianbaoguanshijia;
    String xiaorongcishu;


    String nengyuanxiaorongtext = "";
    String shepinxiaorongtext = "";
    String lengdongtext = "";
    String qitatext = "";

    String panduanxiaorongyouxiaozhibiaotext;
    String xindongguosuzhongzhitext;
    String xindongguosupinlvjiakuaitext;
    String xindongguosupinlvbianmantext;

    String xiaorongzhongdiantext;
    String pdianweijiangdihuoxiaoshitext;
    String shuzhangqidianweixiaoshitext;
    String suiliedianweiwanquanxiaoshitext;
    String lsqdiancijishisubunengbeiyoufatext;
    String diancijishisubunengyoufatext;
    String shuruqitatext;

    String fangdianshijiantext;
    String youxiaobadiantext;
    String zongfangdianshijiantext;
    public static AblationResultFragment newInstance(Case1 case1) {
        if (fragment == null) {
            fragment = new AblationResultFragment();
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
                R.layout.xiaorongjieguo, container, false);
        init();
        baDianBuWei = (MaterialEditText) rootView.findViewById(R.id.badianbuwei);
        nengYuanXiaoRong = (EditText) rootView.findViewById(R.id.nengyuanxiaorong);
        qingShuRuXiaoRongNengYuan = (MaterialEditText) rootView.findViewById(R.id.qingshuruxiaorongnengyuan);
        panDuanXiaoRongYouXiaoZhiBiao = (EditText) rootView.findViewById(R.id.panduanxiaorongyouxiaozhibiao);
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

        panDuanXiaoRongYouXiaoZhiBiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xindongguosuzhongzhitext = "";
                xindongguosupinlvjiakuaitext = "";
                xindongguosupinlvbianmantext = "";
                View v = LayoutInflater.from(getActivity()).inflate(R.layout.panduanxiaorongyouxiaozhibiao, null);
                final MaterialDialog alert = new MaterialDialog(getActivity())
                        .setTitle("判断消融有效指标")
                        .setContentView(v);
                alert.show();
                final CheckBox xindongguosuzhongzhi = (CheckBox) v.findViewById(R.id.xindongguosuzhongzhi);
                CheckBox xindongguosupinlvjiakuai = (CheckBox) v.findViewById(R.id.xindongguosupinlvjiakuai);
                CheckBox xindongguosupinlvbianman = (CheckBox) v.findViewById(R.id.xindongguosupinlvbianman);
                CircularProgressButton confirm = (CircularProgressButton) v.findViewById(R.id.confirm);

                xindongguosuzhongzhi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            xindongguosuzhongzhitext = "心动过速终止";
                        } else {
                            xindongguosuzhongzhitext = "";
                        }
                    }
                });

                xindongguosupinlvjiakuai.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            xindongguosupinlvjiakuaitext = "心动过速频率加快";
                        } else {
                            xindongguosupinlvjiakuaitext = "";
                        }
                    }
                });

                xindongguosupinlvbianman.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            xindongguosupinlvbianmantext = "心动过速频率变慢";
                        } else {
                            xindongguosupinlvbianmantext = "";
                        }
                    }
                });

                confirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        panduanxiaorongyouxiaozhibiaotext = "";
                        panduanxiaorongyouxiaozhibiaotext = xindongguosuzhongzhitext + " "
                                + xindongguosupinlvjiakuaitext + " "
                                + xindongguosupinlvbianmantext;
                        panDuanXiaoRongYouXiaoZhiBiao.setText("判断消融有效指标:" + panduanxiaorongyouxiaozhibiaotext);
                        alert.dismiss();
                    }
                });
            }
        });

        xiaoRongZhongDian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pdianweijiangdihuoxiaoshitext = "";
                shuzhangqidianweixiaoshitext = "";
                suiliedianweiwanquanxiaoshitext = "";
                lsqdiancijishisubunengbeiyoufatext = "";
                diancijishisubunengyoufatext = "";
                shuruqitatext = "";
                View v = LayoutInflater.from(getActivity()).inflate(R.layout.xiaorongzhongdian, null);
                final MaterialDialog alert = new MaterialDialog(getActivity())
                        .setTitle("消融终点")
                        .setContentView(v);
                alert.show();
                CheckBox pdianweijiangdihuoxiaoshi = (CheckBox) v.findViewById(R.id.pdianweijiangdihuoxiaoshi);
                CheckBox shuzhangqidianweixiaoshi = (CheckBox) v.findViewById(R.id.shuzhangqidianweixiaoshi);
                CheckBox suiliedianweiwanquanxiaoshi = (CheckBox) v.findViewById(R.id.suiliedianweiwanquanxiaoshi);
                CheckBox lsqdiancijishisubunengbeiyoufa = (CheckBox) v.findViewById(R.id.lsqdiancijishisubunengbeiyoufa);
                CheckBox diancijishisubunengyoufa = (CheckBox) v.findViewById(R.id.diancijishisubunengyoufa);
                final MaterialEditText shuruqita = (MaterialEditText) v.findViewById(R.id.shuruqita);
                CircularProgressButton confirm = (CircularProgressButton) v.findViewById(R.id.confirm);

                pdianweijiangdihuoxiaoshi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            pdianweijiangdihuoxiaoshitext = "P电位降低或消失";
                        } else {
                            pdianweijiangdihuoxiaoshitext = "";
                        }
                    }
                });

                shuzhangqidianweixiaoshi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            shuzhangqidianweixiaoshitext = "舒张期电位消失";
                        } else {
                            shuzhangqidianweixiaoshitext = "";
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

                lsqdiancijishisubunengbeiyoufa.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            lsqdiancijishisubunengbeiyoufatext = "LSQ电刺激室速不能被诱发";
                        } else {
                            lsqdiancijishisubunengbeiyoufatext = "";
                        }
                    }
                });

                diancijishisubunengyoufa.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            diancijishisubunengyoufatext = "电刺激室速不能诱发";
                        } else {
                            diancijishisubunengyoufatext = "";
                        }
                    }
                });

                confirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        xiaorongzhongdiantext = "";
                        shuruqitatext = shuruqita.getText().toString();
                        xiaorongzhongdiantext = pdianweijiangdihuoxiaoshitext + " " + shuzhangqidianweixiaoshitext + " "
                                + suiliedianweiwanquanxiaoshitext + " " + lsqdiancijishisubunengbeiyoufatext + " "
                                + diancijishisubunengyoufatext + " " + shuruqitatext;
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

    private void saveCase1() {
        if(case1 != null) {
            badianbuwei = baDianBuWei.getText().toString();
            nengyuanxiaorong = nengYuanXiaoRong.getText().toString();
            qingshuruxiaorongnengyuan = qingShuRuXiaoRongNengYuan.getText().toString();
            panduanxiaorongyouxiaozhibiao = panDuanXiaoRongYouXiaoZhiBiao.getText().toString();
            xiaorongzhongdian = xiaoRongZhongDian.getText().toString();
            fangdianshijian = fangDianShiJian.getText().toString();
            xxianbaoguanshijia = xXianBaoGuangShiJian.getText().toString();
//            xiaorongcishu = xiaoRongCiShu.getText().toString();
            case1.setTargetPosition(badianbuwei);
            case1.setAblationEnergy(nengyuanxiaorong);
            case1.setAblationJudgement(panduanxiaorongyouxiaozhibiao);
            case1.setAblationEndPoint(xiaorongzhongdian);
            case1.setEffectiveTargetSite(youxiaobadiantext);
            case1.setDischargeTime(zongfangdianshijiantext);
            case1.setXrayExposureTime(xxianbaoguanshijia);
            if(xiaorongcishu != null && !xiaorongcishu.equals("")) {
                case1.setAblationTimes(Integer.valueOf(xiaorongcishu));
            }
            case1DataChangedListener.OnCase1DataChanged(case1);
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
            panDuanXiaoRongYouXiaoZhiBiao.setText("");
            xiaoRongZhongDian.setText("");
            fangDianShiJian.setText("");
            xXianBaoGuangShiJian.setText("");
            xiaoRongCiShu.setText("");
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
