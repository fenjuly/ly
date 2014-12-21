package org.xhome.ly.ui.fragment.af;

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
import org.xhome.ly.bean.Case2Up;


/**
 * Created by liurongchan on 14/12/15.
 */
public class ShowBeforeOperationMessageFragment extends ShowBaseFragment {

    private static ShowBeforeOperationMessageFragment fragment;

    EditText shuQiangUcg;
    MaterialEditText ecgShuZhiZhuZhiLeiXing;
    MaterialEditText dianZhouPianYi;
    MaterialEditText shuQianKangXinLvShiChangYaoWu;
    MaterialEditText shuQianWuXiaoDeKangXinLvShiChangYaoWu;
    MaterialEditText shuQianHeBingXinLvShiChang;
    EditText shiFouZuoGuoFangChanXiaoRongZhiLiao;
    MaterialEditText shuQianKangNingYaoWu;
    EditText shuQianLaXueShuanJianCe;
    CircularProgressButton confirm;


    public static ShowBeforeOperationMessageFragment newInstance(Case2Up case2) {
        if (fragment == null) {
            fragment = new ShowBeforeOperationMessageFragment();
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
                R.layout.afshuqianxinxi, container, false);
        init();
        shuQiangUcg = (EditText) rootView.findViewById(R.id.shuqianucg);
        ecgShuZhiZhuZhiLeiXing = (MaterialEditText) rootView.findViewById(R.id.ecgshuzhizuzhileixing);
        dianZhouPianYi = (MaterialEditText) rootView.findViewById(R.id.dianzhoupianyi);
        shuQianKangXinLvShiChangYaoWu = (MaterialEditText) rootView.findViewById(R.id.shuqiankangxinlvshichangyaowu);
        shuQianWuXiaoDeKangXinLvShiChangYaoWu = (MaterialEditText) rootView.findViewById(R.id.shuqianwuxiaodekangxinlvshichangyaowu);
        shuQianHeBingXinLvShiChang = (MaterialEditText) rootView.findViewById(R.id.shuqianhebingxinlvshichang);
        shiFouZuoGuoFangChanXiaoRongZhiLiao = (EditText) rootView.findViewById(R.id.shifouzuoguofangchanxiaorongzhiliao);
        shuQianKangNingYaoWu = (MaterialEditText) rootView.findViewById(R.id.shuqiankangningyaowu);
        shuQianLaXueShuanJianCe = (EditText) rootView.findViewById(R.id.shuqianlaxueshuanjiance);
        confirm = (CircularProgressButton) rootView.findViewById(R.id.confirm);

        shuQiangUcg.setText("LA内径:" + case2.getLaBore() + "\n\n"
                + "RA内径:" + case2.getRaBore() + "\n\n"
                + "LV内径:" + case2.getLvBore() + "\n\n"
                + "RV内径:" + case2.getRvBore() + "\n\n"
                + "LVEF内径:" + case2.getLvefBore() + "\n\n"
                + "备注:" + case2.getUcgRemarks());

        if (case2.getAntiArrhythmiaDrugs() != null) {
            shuQianKangXinLvShiChangYaoWu.setText(case2.getAntiArrhythmiaDrugs());
        }
        if (case2.getInvaliDantiArrhythmiaDrugs() != null) {
            shuQianWuXiaoDeKangXinLvShiChangYaoWu.setText(case2.getInvaliDantiArrhythmiaDrugs());
        }
        if (case2.getMergerArrhythmia() != null) {
            shuQianHeBingXinLvShiChang.setText(case2.getMergerArrhythmia());
        }
        if (case2.getRrAblationTreatment() != null) {
            shiFouZuoGuoFangChanXiaoRongZhiLiao.setText(case2.getRrAblationTreatment());
        }
        if (case2.getBeforeAnticoagulant() != null) {
            shuQianKangNingYaoWu.setText(case2.getBeforeAnticoagulant());
        }
        if (case2.getLaThrombusDetection() != null) {
            shuQianLaXueShuanJianCe.setText(case2.getLaThrombusDetection());
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
            shuQianKangXinLvShiChangYaoWu.setText("");
            shuQianWuXiaoDeKangXinLvShiChangYaoWu.setText("");
            shuQianHeBingXinLvShiChang.setText("");
        }

    }

}
