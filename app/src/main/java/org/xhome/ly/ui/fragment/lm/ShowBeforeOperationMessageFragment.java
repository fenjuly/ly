package org.xhome.ly.ui.fragment.lm;

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
import org.xhome.ly.bean.Case3Up;


/**
 * Created by liurongchan on 14/12/15.
 */
public class ShowBeforeOperationMessageFragment extends ShowBaseFragment {

    private static ShowBeforeOperationMessageFragment fragment;

    EditText shuQiangUcg;
    MaterialEditText shuQianKangXinLvShiChangYaoWu;
    MaterialEditText shuQianWuXiaoDeKangXinLvShiChangYaoWu;
    MaterialEditText shuQianHeBingXinLvShiChang;
    EditText shuQianLaXueShuanJianCe;
    MaterialEditText jianCeFangFa;
    CircularProgressButton confirm;


    public static ShowBeforeOperationMessageFragment newInstance(Case3Up case3) {
        if (fragment == null) {
            fragment = new ShowBeforeOperationMessageFragment();
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
                R.layout.lmshuqianxinxi, container, false);
        init();
        shuQiangUcg = (EditText) rootView.findViewById(R.id.shuqianucg);
        shuQianKangXinLvShiChangYaoWu = (MaterialEditText) rootView.findViewById(R.id.shuqiankangxinlvshichangyaowu);
        shuQianWuXiaoDeKangXinLvShiChangYaoWu = (MaterialEditText) rootView.findViewById(R.id.shuqianwuxiaodekangxinlvshichangyaowu);
        shuQianHeBingXinLvShiChang = (MaterialEditText) rootView.findViewById(R.id.shuqianhebingxinlvshichang);
        shuQianLaXueShuanJianCe = (EditText) rootView.findViewById(R.id.shuqianlaxueshuanjiance);
        jianCeFangFa = (MaterialEditText) rootView.findViewById(R.id.jiancefangfa);
        confirm = (CircularProgressButton) rootView.findViewById(R.id.confirm);

        if (case3.getLaBore() != null || case3.getRaBore() != null
                || case3.getLvBore() != null || case3.getRvBore() != null
                || case3.getLvefBore() != null || case3.getUcgRemarks() != null) {

            shuQiangUcg.setText("LA内径:" + case3.getLaBore() + "\n\n"
                    + "RA内径:" + case3.getRaBore() + "\n\n"
                    + "LV内径:" + case3.getLvBore() + "\n\n"
                    + "RV内径:" + case3.getRvBore() + "\n\n"
                    + "LVEF内径:" + case3.getLvefBore() + "\n\n"
                    + "备注:" + case3.getUcgRemarks());
        }
        if (case3.getLaThrombusDetection() != null) {
            shuQianLaXueShuanJianCe.setText(case3.getLaThrombusDetection());
        }
        if (case3.getTestMethod() != null) {
            jianCeFangFa.setText(case3.getTestMethod());
        }

        if (case3.getAntiArrhythmiaDrugs() != null) {
            shuQianKangXinLvShiChangYaoWu.setText(case3.getAntiArrhythmiaDrugs());
        }
        if (case3.getInvaliDantiArrhythmiaDrugs() != null) {
            shuQianWuXiaoDeKangXinLvShiChangYaoWu.setText(case3.getInvaliDantiArrhythmiaDrugs());
        }
        if (case3.getMergerArrhythmia() != null) {
            shuQianHeBingXinLvShiChang.setText(case3.getMergerArrhythmia());
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
            shuQianKangXinLvShiChangYaoWu.setText("");
            shuQianWuXiaoDeKangXinLvShiChangYaoWu.setText("");
            shuQianHeBingXinLvShiChang.setText("");
            shuQianLaXueShuanJianCe.setText("");
            jianCeFangFa.setText("");

            if (case3.getLaBore() != null || case3.getRaBore() != null
                    || case3.getLvBore() != null || case3.getRvBore() != null
                    || case3.getLvefBore() != null || case3.getUcgRemarks() != null) {

                shuQiangUcg.setText("LA内径:" + case3.getLaBore() + "\n\n"
                        + "RA内径:" + case3.getRaBore() + "\n\n"
                        + "LV内径:" + case3.getLvBore() + "\n\n"
                        + "RV内径:" + case3.getRvBore() + "\n\n"
                        + "LVEF内径:" + case3.getLvefBore() + "\n\n"
                        + "备注:" + case3.getUcgRemarks());
            }
            if (case3.getLaThrombusDetection() != null) {
                shuQianLaXueShuanJianCe.setText(case3.getLaThrombusDetection());
            }
            if (case3.getTestMethod() != null) {
                jianCeFangFa.setText(case3.getTestMethod());
            }

            if (case3.getAntiArrhythmiaDrugs() != null) {
                shuQianKangXinLvShiChangYaoWu.setText(case3.getAntiArrhythmiaDrugs());
            }
            if (case3.getInvaliDantiArrhythmiaDrugs() != null) {
                shuQianWuXiaoDeKangXinLvShiChangYaoWu.setText(case3.getInvaliDantiArrhythmiaDrugs());
            }
            if (case3.getMergerArrhythmia() != null) {
                shuQianHeBingXinLvShiChang.setText(case3.getMergerArrhythmia());
            }
        }

    }

}
