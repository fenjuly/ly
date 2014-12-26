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
public class ShowUnderOperationMessageFragment extends ShowBaseFragment {

    private static ShowUnderOperationMessageFragment fragment;

    MaterialEditText shuZhongDianFuLv;
    EditText xiaoRongQianXinLv;
    EditText shuZhongXinLv;
    EditText bingFaZheng;
    CircularProgressButton confirm;


    public static ShowUnderOperationMessageFragment newInstance(Case2Up case2) {
        if (fragment == null) {
            fragment = new ShowUnderOperationMessageFragment();
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
                R.layout.afshuzhongxinxi, container, false);
        init();
        shuZhongDianFuLv = (MaterialEditText) rootView.findViewById(R.id.shuzhongdianfulv);
        xiaoRongQianXinLv = (EditText) rootView.findViewById(R.id.xiaorongqianxinlv);
        shuZhongXinLv = (EditText) rootView.findViewById(R.id.shuzhongxinlv);
        bingFaZheng = (EditText) rootView.findViewById(R.id.bingfazheng);
        confirm = (CircularProgressButton) rootView.findViewById(R.id.confirm);

        if (case2.getIntraoperativeCableRate() != null) {
            shuZhongDianFuLv.setText(case2.getIntraoperativeCableRate());
        }

        if (case2.getBeforeHeartRate() != null || case2.getBeforeRr() != null
                || case2.getBeforeRe() != null || case2.getBeforeRemarks() != null) {
            xiaoRongQianXinLv.setText(case2.getBeforeHeartRate() + "\n\n"
                    + "房速:" + case2.getBeforeRr() + "\n\n"
                    + "房早:" + case2.getBeforeRe() + "\n\n"
                    + "备注:" + case2.getBeforeRemarks()) ;
        }

        if (case2.getInHeartRate() != null || case2.getInRr() != null
                || case2.getInRr() != null || case2.getInRemarks() != null) {
            shuZhongXinLv.setText(case2.getInHeartRate() + "\n\n"
                    + "房速:" + case2.getInRr() + "\n\n"
                    + "房早:" + case2.getInRe() + "\n\n"
                    + "备注:" + case2.getInRemarks()) ;
        }

        if ((case2.getComplication() != null)) {
            bingFaZheng.setText(case2.getComplication());
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
            shuZhongDianFuLv.setText("");
            xiaoRongQianXinLv.setText("");
            shuZhongXinLv.setText("");
            bingFaZheng.setText("");

            if (case2.getIntraoperativeCableRate() != null) {
                shuZhongDianFuLv.setText(case2.getIntraoperativeCableRate());
            }

            if (case2.getBeforeHeartRate() != null || case2.getBeforeRr() != null
                    || case2.getBeforeRe() != null || case2.getBeforeRemarks() != null) {
                xiaoRongQianXinLv.setText(case2.getBeforeHeartRate() + "\n\n"
                        + "房速:" + case2.getBeforeRr() + "\n\n"
                        + "房早:" + case2.getBeforeRe() + "\n\n"
                        + "备注:" + case2.getBeforeRemarks()) ;
            }

            if (case2.getInHeartRate() != null || case2.getInRr() != null
                    || case2.getInRr() != null || case2.getInRemarks() != null) {
                shuZhongXinLv.setText(case2.getInHeartRate() + "\n\n"
                        + "房速:" + case2.getInRr() + "\n\n"
                        + "房早:" + case2.getInRe() + "\n\n"
                        + "备注:" + case2.getInRemarks()) ;
            }

            if ((case2.getComplication() != null)) {
                bingFaZheng.setText(case2.getComplication());
            }
        }

    }
}
