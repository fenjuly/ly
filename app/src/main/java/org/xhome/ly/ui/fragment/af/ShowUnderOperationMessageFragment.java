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


    public static ShowUnderOperationMessageFragment newInstance(Case1Up case1) {
        if (fragment == null) {
            fragment = new ShowUnderOperationMessageFragment();
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
                R.layout.shuzhongxinxi, container, false);
        init();
        shuZhongDianFuLv = (MaterialEditText) rootView.findViewById(R.id.shuzhongdianfulv);
        xiaoRongQianXinLv = (EditText) rootView.findViewById(R.id.xiaorongqianxinlv);
        shuZhongXinLv = (EditText) rootView.findViewById(R.id.shuzhongxinlv);
        bingFaZheng = (EditText) rootView.findViewById(R.id.bingfazheng);
        confirm = (CircularProgressButton) rootView.findViewById(R.id.confirm);

        if (case1.getIntraoperativeCableRate() != null) {
            shuZhongDianFuLv.setText(case1.getIntraoperativeCableRate());
        }

        if (case1.getBeforeHeartRate() != null || case1.getBeforeVt() != null
                || case1.getBeforeRont() != null || case1.getBeforeRemarks() != null) {
            xiaoRongQianXinLv.setText(case1.getBeforeHeartRate() + "\n\n"
                    + "室速:" + case1.getBeforeVt() + "\n\n"
                    + "室早:" + case1.getBeforeRont() + "\n\n"
                    + "备注:" + case1.getBeforeRemarks()) ;
        }

        if (case1.getInHeartRate() != null || case1.getInVt() != null
                || case1.getInRont() != null || case1.getInRemarks() != null) {
            shuZhongXinLv.setText(case1.getInHeartRate() + "\n\n"
                    + "室速:" + case1.getInVt() + "\n\n"
                    + "室早:" + case1.getInRont() + "\n\n"
                    + "备注:" + case1.getInRemarks()) ;
        }

        if ((case1.getComplication() != null)) {
            bingFaZheng.setText(case1.getComplication());
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
        }

    }
}
