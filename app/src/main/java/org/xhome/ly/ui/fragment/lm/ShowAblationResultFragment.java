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
public class ShowAblationResultFragment extends ShowBaseFragment {

    private static ShowAblationResultFragment fragment;

    MaterialEditText baDianBuWei;
    EditText nengYuanXiaoRong;
    MaterialEditText biaoCeFangFa;
    EditText xiaoRongZhongDian;
    EditText fangDianShiJian;
    EditText xXianBaoGuangShiJian;
    EditText xiaoRongCiShu;

    CircularProgressButton confirm;

    public static ShowAblationResultFragment newInstance(Case3Up case3) {
        if (fragment == null) {
            fragment = new ShowAblationResultFragment();
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
        xiaoRongZhongDian = (EditText) rootView.findViewById(R.id.xiaorongzhongdian);
        fangDianShiJian = (EditText) rootView.findViewById(R.id.fangdianshijian);
        xXianBaoGuangShiJian = (EditText) rootView.findViewById(R.id.xxianbaoguanshijia);
        xiaoRongCiShu = (EditText) rootView.findViewById(R.id.xiaorongcishu);
        biaoCeFangFa = (MaterialEditText) rootView.findViewById(R.id.biaocefangfa);
        confirm = (CircularProgressButton) rootView.findViewById(R.id.confirm);

        if (case3.getTargetPosition() != null) {
            baDianBuWei.setText(case3.getTargetPosition());
        }
        if (case3.getAblationEnergy() != null) {
            nengYuanXiaoRong.setText(case3.getAblationEnergy());
        }

        if (case3.getAblationEndPoint() != null) {
            xiaoRongZhongDian.setText(case3.getAblationEndPoint());
        }

        if (case3.getInspectionMethod() != null) {
            biaoCeFangFa.setText(case3.getInspectionMethod());
        }

        if (case3.getDischargeTime() != null) {
            fangDianShiJian.setText(case3.getDischargeTime());
        }
        if (case3.getXrayExposureTime() != null) {
            xXianBaoGuangShiJian.setText(case3.getXrayExposureTime());
        }
        if (case3.getAblationTimes() != null) {
            xiaoRongCiShu.setText(String.valueOf(case3.getAblationTimes()) + "次");
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
            biaoCeFangFa.setText("");
            xiaoRongZhongDian.setText("");
            fangDianShiJian.setText("");
            xXianBaoGuangShiJian.setText("");
            xiaoRongCiShu.setText("");

            if (case3.getTargetPosition() != null) {
                baDianBuWei.setText(case3.getTargetPosition());
            }
            if (case3.getAblationEnergy() != null) {
                nengYuanXiaoRong.setText(case3.getAblationEnergy());
            }

            if (case3.getAblationEndPoint() != null) {
                xiaoRongZhongDian.setText(case3.getAblationEndPoint());
            }

            if (case3.getInspectionMethod() != null) {
                biaoCeFangFa.setText(case3.getInspectionMethod());
            }

            if (case3.getDischargeTime() != null) {
                fangDianShiJian.setText(case3.getDischargeTime());
            }
            if (case3.getXrayExposureTime() != null) {
                xXianBaoGuangShiJian.setText(case3.getXrayExposureTime());
            }
            if (case3.getAblationTimes() != null) {
                xiaoRongCiShu.setText(String.valueOf(case3.getAblationTimes()) + "次");
            }
        }

    }


}
