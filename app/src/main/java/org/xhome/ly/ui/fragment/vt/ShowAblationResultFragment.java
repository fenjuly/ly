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
public class ShowAblationResultFragment extends ShowBaseFragment {

    private static ShowAblationResultFragment fragment;

    MaterialEditText baDianBuWei;
    EditText nengYuanXiaoRong;
    MaterialEditText qingShuRuXiaoRongNengYuan;
    EditText panDuanXiaoRongYouXiaoZhiBiao;
    EditText xiaoRongZhongDian;
    EditText fangDianShiJian;
    EditText xXianBaoGuangShiJian;
    EditText xiaoRongCiShu;

    CircularProgressButton confirm;

    public static ShowAblationResultFragment newInstance(Case1Up case1) {
        if (fragment == null) {
            fragment = new ShowAblationResultFragment();
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

        if (case1.getTargetPosition() != null) {
            baDianBuWei.setText(case1.getTargetPosition());
        }
        if (case1.getAblationEnergy() != null) {
            nengYuanXiaoRong.setText(case1.getAblationEnergy());
        }
        if (case1.getAblationJudgement() != null) {
            panDuanXiaoRongYouXiaoZhiBiao.setText(case1.getAblationJudgement());
        }
        if (case1.getAblationEndPoint() != null) {
            xiaoRongZhongDian.setText(case1.getAblationEndPoint());
        }
        if (case1.getEffectiveTargetSite() != null || case1.getDischargeTime() != null) {
            fangDianShiJian.setText("有效靶点:" + case1.getEffectiveTargetSite() + "\n\n"
                    + "总放电时间:" + case1.getDischargeTime());
        }
        if (case1.getXrayExposureTime() != null) {
            xXianBaoGuangShiJian.setText(case1.getXrayExposureTime());
        }
        if (case1.getAblationTimes() != null) {
            xiaoRongCiShu.setText(String.valueOf(case1.getAblationTimes()) + "次");
        }

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextStepListner.OnNextStepClicked(4);
            }
        });
        return rootView;
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

            if (case1.getTargetPosition() != null) {
                baDianBuWei.setText(case1.getTargetPosition());
            }
            if (case1.getAblationEnergy() != null) {
                nengYuanXiaoRong.setText(case1.getAblationEnergy());
            }
            if (case1.getAblationJudgement() != null) {
                panDuanXiaoRongYouXiaoZhiBiao.setText(case1.getAblationJudgement());
            }
            if (case1.getAblationEndPoint() != null) {
                xiaoRongZhongDian.setText(case1.getAblationEndPoint());
            }
            if (case1.getEffectiveTargetSite() != null || case1.getDischargeTime() != null) {
                fangDianShiJian.setText("有效靶点:" + case1.getEffectiveTargetSite() + "\n\n"
                        + "总放电时间:" + case1.getDischargeTime());
            }
            if (case1.getXrayExposureTime() != null) {
                xXianBaoGuangShiJian.setText(case1.getXrayExposureTime());
            }
            if (case1.getAblationTimes() != null) {
                xiaoRongCiShu.setText(String.valueOf(case1.getAblationTimes()) + "次");
            }
        }

    }


}
