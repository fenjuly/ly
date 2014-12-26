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
import org.xhome.ly.bean.Case3Up;


/**
 * Created by liurongchan on 14/12/15.
 */
public class ShowUnderOperationMessageFragment extends ShowBaseFragment {

    private static ShowUnderOperationMessageFragment fragment;

    EditText miZouFanShe;
    MaterialEditText shuZhongChuXianMiZouFanSheQuYu;
    EditText shuZhongDianFuLv;
    EditText xiaoRongQianXinLv;
    EditText shuZhongXinLv;
    EditText bingFaZheng;
    CircularProgressButton confirm;


    public static ShowUnderOperationMessageFragment newInstance(Case3Up case3) {
        if (fragment == null) {
            fragment = new ShowUnderOperationMessageFragment();
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

        if (case3.getIntraoperativeCableRate() != null) {
            shuZhongDianFuLv.setText(case3.getIntraoperativeCableRate());
        }

        if (case3.getBeforeHeartRate() != null || case3.getBeforeRr() != null
                || case3.getBeforeRe() != null || case3.getBeforeAf() != null
                || case3.getBeforeRemarks() != null) {
            xiaoRongQianXinLv.setText("窦性心律:" +case3.getBeforeHeartRate() + "\n\n"
                    + "房速:" + case3.getBeforeRr() + "\n\n"
                    + "房早:" + case3.getBeforeRe() + "\n\n"
                    + "房颤:" + case3.getBeforeAf() + "\n\n"
                    + "备注:" + case3.getBeforeRemarks()) ;
        }

        if (case3.getInHeartRate() != null || case3.getInRr() != null
                || case3.getInRe() != null || case3.getInAf() != null
                || case3.getInRemarks() != null) {
            shuZhongXinLv.setText("窦性心律:" + case3.getInHeartRate() + "\n\n"
                    + "房速:" + case3.getInRr() + "\n\n"
                    + "房早:" + case3.getInRe() + "\n\n"
                    + "房颤:" + case3.getInAf() + "\n\n"
                    + "备注:" + case3.getInRemarks()) ;
        }

        if ((case3.getComplication() != null)) {
            bingFaZheng.setText(case3.getComplication());
        }

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextStepListner.OnNextStepClicked(5);
            }
        });
        return rootView;
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

            if (case3.getIntraoperativeCableRate() != null) {
                shuZhongDianFuLv.setText(case3.getIntraoperativeCableRate());
            }

            if (case3.getBeforeHeartRate() != null || case3.getBeforeRr() != null
                    || case3.getBeforeRe() != null || case3.getBeforeAf() != null
                    || case3.getBeforeRemarks() != null) {
                xiaoRongQianXinLv.setText("窦性心律:" +case3.getBeforeHeartRate() + "\n\n"
                        + "房速:" + case3.getBeforeRr() + "\n\n"
                        + "房早:" + case3.getBeforeRe() + "\n\n"
                        + "房颤:" + case3.getBeforeAf() + "\n\n"
                        + "备注:" + case3.getBeforeRemarks()) ;
            }

            if (case3.getInHeartRate() != null || case3.getInRr() != null
                    || case3.getInRe() != null || case3.getInAf() != null
                    || case3.getInRemarks() != null) {
                shuZhongXinLv.setText("窦性心律:" + case3.getInHeartRate() + "\n\n"
                        + "房速:" + case3.getInRr() + "\n\n"
                        + "房早:" + case3.getInRe() + "\n\n"
                        + "房颤:" + case3.getInAf() + "\n\n"
                        + "备注:" + case3.getInRemarks()) ;
            }

            if ((case3.getComplication() != null)) {
                bingFaZheng.setText(case3.getComplication());
            }
        }

    }
}
