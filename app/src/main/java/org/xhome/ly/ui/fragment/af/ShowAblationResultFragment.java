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
import org.xhome.ly.bean.Case2Up;


/**
 * Created by liurongchan on 14/12/15.
 */
public class ShowAblationResultFragment extends ShowBaseFragment {

    private static ShowAblationResultFragment fragment;

    MaterialEditText baDianBuWei;
    EditText nengYuanXiaoRong;
    EditText xiaoRongZhongDian;
    EditText fangDianShiJian;
    EditText xXianBaoGuangShiJian;
    EditText xiaoRongCiShu;

    CircularProgressButton confirm;

    public static ShowAblationResultFragment newInstance(Case2Up case2) {
        if (fragment == null) {
            fragment = new ShowAblationResultFragment();
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
        xiaoRongZhongDian = (EditText) rootView.findViewById(R.id.xiaorongzhongdian);
        fangDianShiJian = (EditText) rootView.findViewById(R.id.fangdianshijian);
        xXianBaoGuangShiJian = (EditText) rootView.findViewById(R.id.xxianbaoguanshijia);
        xiaoRongCiShu = (EditText) rootView.findViewById(R.id.xiaorongcishu);
        confirm = (CircularProgressButton) rootView.findViewById(R.id.confirm);

        if (case2.getTargetPosition() != null) {
            baDianBuWei.setText(case2.getTargetPosition());
        }
        if (case2.getAblationEnergy() != null) {
            nengYuanXiaoRong.setText(case2.getAblationEnergy());
        }
        if (case2.getAblationEndPoint() != null) {
            xiaoRongZhongDian.setText(case2.getAblationEndPoint());
        }
        if (case2.getEffectiveTargetSite() != null || case2.getDischargeTime() != null) {
            fangDianShiJian.setText("有效靶点:" + case2.getEffectiveTargetSite() + "\n\n"
                    + "总放电时间:" + case2.getDischargeTime());
        }
        if (case2.getXrayExposureTime() != null) {
            xXianBaoGuangShiJian.setText(case2.getXrayExposureTime());
        }
        if (case2.getAblationTimes() != null) {
            xiaoRongCiShu.setText(String.valueOf(case2.getAblationTimes()) + "次");
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
            xiaoRongZhongDian.setText("");
            fangDianShiJian.setText("");
            xXianBaoGuangShiJian.setText("");
            xiaoRongCiShu.setText("");

            if (case2.getTargetPosition() != null) {
                baDianBuWei.setText(case2.getTargetPosition());
            }
            if (case2.getAblationEnergy() != null) {
                nengYuanXiaoRong.setText(case2.getAblationEnergy());
            }
            if (case2.getAblationEndPoint() != null) {
                xiaoRongZhongDian.setText(case2.getAblationEndPoint());
            }
            if (case2.getEffectiveTargetSite() != null || case2.getDischargeTime() != null) {
                fangDianShiJian.setText("有效靶点:" + case2.getEffectiveTargetSite() + "\n\n"
                        + "总放电时间:" + case2.getDischargeTime());
            }
            if (case2.getXrayExposureTime() != null) {
                xXianBaoGuangShiJian.setText(case2.getXrayExposureTime());
            }
            if (case2.getAblationTimes() != null) {
                xiaoRongCiShu.setText(String.valueOf(case2.getAblationTimes()) + "次");
            }
        }

    }


}
