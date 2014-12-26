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
import org.xhome.ly.bean.Case3;

import me.drakeet.materialdialog.MaterialDialog;

/**
 * Created by liurongchan on 14/12/3.
 */
public class UnderOperationMessageFragment extends BaseFragment {

    private static UnderOperationMessageFragment fragment;

    EditText miZouFanShe;
    MaterialEditText shuZhongChuXianMiZouFanSheQuYu;
    EditText shuZhongDianFuLv;
    EditText xiaoRongQianXinLv;
    EditText shuZhongXinLv;
    EditText bingFaZheng;
    CircularProgressButton confirm;

    String mizoufanshe;
    String shuzhongchuxianmizoufanshequyu;
    String shuzhongdianfulv;
    String xiaorongqianxinlv;
    String shuzhongxinlv;
    String bingfazheng;

    String xiaorongqianxinlvtext;
    String xiaorongqian_duxingxinlvtext;
    String xiaorongqian_fangsutext;
    String xiaorongqian_fangchantext;
    String xiaorongqian_fangzaotext;
    String xiaorongqian_beizhutext;

    String shuzhongxinlvtext;
    String shuzhong_duxingxinlvtext;
    String shuzhong_fangsutext;
    String shuzhong_fangchantext;
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


    public static UnderOperationMessageFragment newInstance(Case3 case3) {
        if (fragment == null) {
            fragment = new UnderOperationMessageFragment();
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
                R.layout.lmshuzhongxinxi, container, false);
        init();

        miZouFanShe = (EditText) rootView.findViewById(R.id.mizoufanshe);
        shuZhongChuXianMiZouFanSheQuYu = (MaterialEditText) rootView.findViewById(R.id.shuzhongchuxianmizoufanshequyu);
        shuZhongDianFuLv = (EditText) rootView.findViewById(R.id.shuzhongdianfulv);
        xiaoRongQianXinLv = (EditText) rootView.findViewById(R.id.xiaorongqianxinlv);
        shuZhongXinLv = (EditText) rootView.findViewById(R.id.shuzhongxinlv);
        bingFaZheng = (EditText) rootView.findViewById(R.id.bingfazheng);
        confirm = (CircularProgressButton) rootView.findViewById(R.id.confirm);


        miZouFanShe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                        getActivity(),
                        android.R.layout.simple_list_item_1
                );
                arrayAdapter.add("有");
                arrayAdapter.add("无");
                ListView listView = new ListView(getActivity());
                float scale = getResources().getDisplayMetrics().density;
                int dpAsPixels = (int) (8 * scale + 0.5f);
                listView.setPadding(0, dpAsPixels, 0, dpAsPixels);
                listView.setDividerHeight(0);
                listView.setAdapter(arrayAdapter);
                final MaterialDialog alert = new MaterialDialog(getActivity())
                        .setTitle("迷走反射")
                        .setContentView(listView);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                        switch (position) {
                            case 0:
                                miZouFanShe.setText("有");
                                break;
                            case 1:
                                miZouFanShe.setText("无");
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

        shuZhongDianFuLv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                        getActivity(),
                        android.R.layout.simple_list_item_1
                );
                arrayAdapter.add("有");
                arrayAdapter.add("无");
                ListView listView = new ListView(getActivity());
                float scale = getResources().getDisplayMetrics().density;
                int dpAsPixels = (int) (8 * scale + 0.5f);
                listView.setPadding(0, dpAsPixels, 0, dpAsPixels);
                listView.setDividerHeight(0);
                listView.setAdapter(arrayAdapter);
                final MaterialDialog alert = new MaterialDialog(getActivity())
                        .setTitle("术中电复律")
                        .setContentView(listView);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                        switch (position) {
                            case 0:
                                shuZhongDianFuLv.setText("有");
                                break;
                            case 1:
                                shuZhongDianFuLv.setText("无");
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

        xiaoRongQianXinLv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xiaorongqian_duxingxinlvtext = "";
                xiaorongqian_fangsutext = "";
                xiaorongqian_fangchantext = "";
                xiaorongqian_fangzaotext = "";
                xiaorongqian_beizhutext = "";
                View v = LayoutInflater.from(getActivity()).inflate(R.layout.lmxiaorongqianxinlv, null);
                final MaterialDialog alert = new MaterialDialog(getActivity())
                        .setTitle("消融前心律")
                        .setContentView(v);
                alert.show();
                final EditText duxingxinlv = (EditText) v.findViewById(R.id.duxingxinlv);
                final EditText fangsu = (EditText) v.findViewById(R.id.fangsu);
                final EditText fangchan = (EditText) v.findViewById(R.id.fangchan);
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

                fangchan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        NumberPickerBuilder numberPickerBuilder = new NumberPickerBuilder()
                                .setFragmentManager(getFragmentManager())
                                .setStyleResId(R.style.BetterPickersDialogFragment_Light);
                        numberPickerBuilder.show();
                        numberPickerBuilder.addNumberPickerDialogHandler(new NumberPickerDialogFragment.NumberPickerDialogHandler() {
                            @Override
                            public void onDialogNumberSet(int reference, int number, double decimal, boolean isNegative, double fullNumber) {
                                xiaorongqian_fangchantext = fullNumber + "BPM";
                                fangchan.setText(xiaorongqian_fangchantext);
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
                        xiaorongqianxinlvtext = "窦性心律:" + xiaorongqian_duxingxinlvtext + "\n\n"
                                + "房速:" + xiaorongqian_fangsutext + "\n\n"
                                + "房颤:" + xiaorongqian_fangchantext + "\n\n"
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
                shuzhong_fangchantext = "";
                shuzhong_fangzaotext = "";
                shuzhong_beizhutext = "";
                View v = LayoutInflater.from(getActivity()).inflate(R.layout.lmshuzhongxinlv, null);
                final MaterialDialog alert = new MaterialDialog(getActivity())
                        .setTitle("术中心律")
                        .setContentView(v);
                alert.show();

                final EditText duxingxinlv = (EditText) v.findViewById(R.id.duxingxinlv);
                final EditText fangsu = (EditText) v.findViewById(R.id.fangsu);
                final EditText fangchan = (EditText) v.findViewById(R.id.fangchan);
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

                fangchan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        NumberPickerBuilder numberPickerBuilder = new NumberPickerBuilder()
                                .setFragmentManager(getFragmentManager())
                                .setStyleResId(R.style.BetterPickersDialogFragment_Light);
                        numberPickerBuilder.show();
                        numberPickerBuilder.addNumberPickerDialogHandler(new NumberPickerDialogFragment.NumberPickerDialogHandler() {
                            @Override
                            public void onDialogNumberSet(int reference, int number, double decimal, boolean isNegative, double fullNumber) {
                                shuzhong_fangchantext = fullNumber + "BPM";
                                fangchan.setText(shuzhong_fangchantext);
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
                        shuzhongxinlvtext = "窦性心律:" + shuzhong_duxingxinlvtext + "\n\n"
                                + "房速:" + shuzhong_fangsutext + "\n\n"
                                + "房颤:" + shuzhong_fangchantext + "\n\n"
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
    public void saveCase3() {
        if(case3 != null) {
            mizoufanshe = miZouFanShe.getText().toString();
            shuzhongchuxianmizoufanshequyu = shuZhongChuXianMiZouFanSheQuYu.getText().toString();
            shuzhongdianfulv = shuZhongDianFuLv.getText().toString();
            bingfazheng = bingFaZheng.getText().toString();
            case3.setIntraoperativeCableRate(shuzhongdianfulv);
            case3.setBeforeHeartRate(xiaorongqian_duxingxinlvtext);
            case3.setBeforeRr(xiaorongqian_fangsutext);
            case3.setBeforeRe(xiaorongqian_fangzaotext);
            case3.setBeforeAf(xiaorongqian_fangchantext);
            case3.setBeforeRemarks(xiaorongqian_beizhutext);
            case3.setInHeartRate(shuzhong_duxingxinlvtext);
            case3.setInRr(shuzhong_fangsutext);
            case3.setInRe(shuzhong_fangzaotext);
            case3.setBeforeAf(shuzhong_fangchantext);
            case3.setInRemarks(shuzhong_beizhutext);
            case3.setComplication(bingfazheng);
            case3DataChangedListener.OnCase3DataChanged(case3);
        }
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if (!isInActivity) {
            isInActivity = true;
            miZouFanShe.setText("");
            shuZhongChuXianMiZouFanSheQuYu.setText("");
            shuZhongDianFuLv.setText("");
            xiaoRongQianXinLv.setText("");
            shuZhongXinLv.setText("");
            bingFaZheng.setText("");
        }

    }
}
