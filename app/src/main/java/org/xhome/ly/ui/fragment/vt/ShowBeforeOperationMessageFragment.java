package org.xhome.ly.ui.fragment.vt;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.dd.CircularProgressButton;
import com.google.gson.Gson;
import com.rengwuxian.materialedittext.MaterialEditText;

import org.xhome.ly.R;
import org.xhome.ly.bean.Case1Up;


/**
 * Created by liurongchan on 14/12/15.
 */
public class ShowBeforeOperationMessageFragment extends ShowBaseFragment {

    private static ShowBeforeOperationMessageFragment fragment;

    EditText shuQiangUcg;
    MaterialEditText ecgShuZhiZhuZhiLeiXing;
    MaterialEditText dianZhouPianYi;
    MaterialEditText shuQianQiTaJianChaZhongYaoYangXingMiaoShu;
    EditText shuQianKangXinLvShiChangYaoWu;
    EditText shuQianWuXiaoDeKangXinLvShiChangYaoWu;
    MaterialEditText shuQianHeBingXinLvShiChang;
    CircularProgressButton confirm;


    public static ShowBeforeOperationMessageFragment newInstance(Case1Up case1) {
        if (fragment == null) {
            fragment = new ShowBeforeOperationMessageFragment();
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

        if (case1.getLaBore() != null || case1.getRaBore() != null
                || case1.getLvBore() != null || case1.getRvBore() != null
                || case1.getLvefBore() != null || case1.getUcgRemarks() != null) {

            shuQiangUcg.setText("LA内径:" + case1.getLaBore() + "\n\n"
                    + "RA内径:" + case1.getRaBore() + "\n\n"
                    + "LV内径:" + case1.getLvBore() + "\n\n"
                    + "RV内径:" + case1.getRvBore() + "\n\n"
                    + "LVEF内径:" + case1.getLvefBore() + "\n\n"
                    + "备注:" + case1.getUcgRemarks());
        }
        if (case1.getEcgType() != null) {
            ecgShuZhiZhuZhiLeiXing.setText(case1.getEcgType());
        }
        if (case1.getElectricalOffset() != null) {
            dianZhouPianYi.setText(case1.getElectricalOffset());
        }
        if (case1.getPreopreativeExamination() != null) {
            shuQianQiTaJianChaZhongYaoYangXingMiaoShu.setText(case1.getPreopreativeExamination());
        }
        if (case1.getAntiArrhythmiaDrugs() != null) {
            shuQianKangXinLvShiChangYaoWu.setText(case1.getAntiArrhythmiaDrugs());
        }
        if (case1.getInvaliDantiArrhythmiaDrugs() != null) {
            shuQianWuXiaoDeKangXinLvShiChangYaoWu.setText(case1.getInvaliDantiArrhythmiaDrugs());
        }
        if (case1.getMergerArrhythmia() != null) {
            shuQianHeBingXinLvShiChang.setText(case1.getMergerArrhythmia());
        }


        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextStepListner.OnNextStepClicked(2);
            }
        });

        return rootView;
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

            if (case1.getLaBore() != null || case1.getRaBore() != null
                    || case1.getLvBore() != null || case1.getRvBore() != null
                    || case1.getLvefBore() != null || case1.getUcgRemarks() != null) {

                shuQiangUcg.setText("LA内径:" + case1.getLaBore() + "\n\n"
                        + "RA内径:" + case1.getRaBore() + "\n\n"
                        + "LV内径:" + case1.getLvBore() + "\n\n"
                        + "RV内径:" + case1.getRvBore() + "\n\n"
                        + "LVEF内径:" + case1.getLvefBore() + "\n\n"
                        + "备注:" + case1.getUcgRemarks());
            }
            if (case1.getEcgType() != null) {
                ecgShuZhiZhuZhiLeiXing.setText(case1.getEcgType());
            }
            if (case1.getElectricalOffset() != null) {
                dianZhouPianYi.setText(case1.getElectricalOffset());
            }
            if (case1.getPreopreativeExamination() != null) {
                shuQianQiTaJianChaZhongYaoYangXingMiaoShu.setText(case1.getPreopreativeExamination());
            }
            if (case1.getAntiArrhythmiaDrugs() != null) {
                shuQianKangXinLvShiChangYaoWu.setText(case1.getAntiArrhythmiaDrugs());
            }
            if (case1.getInvaliDantiArrhythmiaDrugs() != null) {
                shuQianWuXiaoDeKangXinLvShiChangYaoWu.setText(case1.getInvaliDantiArrhythmiaDrugs());
            }
            if (case1.getMergerArrhythmia() != null) {
                shuQianHeBingXinLvShiChang.setText(case1.getMergerArrhythmia());
            }
        }

    }

}
