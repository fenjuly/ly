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
public class ShowTranscatheterAblationFragment extends ShowBaseFragment {

    private static ShowTranscatheterAblationFragment fragment;

    private static final String[] methods = {"标测方法一", "标测方法二", "标测方法三"};

    EditText xiaoRongShuShi;
    EditText xiaoRongJingXian;
    EditText baFeiJingMai;
    EditText shenJingJieCongXiaoRong;
    CircularProgressButton confirm;


    public static ShowTranscatheterAblationFragment newInstance(Case3Up case3) {
        if (fragment == null) {
            fragment = new ShowTranscatheterAblationFragment();
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
                R.layout.lmjingdaoguanxiaorong, container, false);
        init();
        xiaoRongShuShi = (EditText) rootView.findViewById(R.id.xiaorongshushi);
        xiaoRongJingXian = (EditText) rootView.findViewById(R.id.xiaorongjingxian);
        baFeiJingMai = (EditText) rootView.findViewById(R.id.bafeijingmai);
        shenJingJieCongXiaoRong = (EditText) rootView.findViewById(R.id.shenjingjiecongxiaorong);
        confirm = (CircularProgressButton) rootView.findViewById(R.id.confirm);

        if (case3.getLungVein() != null) {
            baFeiJingMai.setText(case3.getLungVein());
        }
        if (case3.getGpAblation() != null) {
            shenJingJieCongXiaoRong.setText(case3.getGpAblation() + "\n\n");
        }

        if (case3.getAblationProcedure() != null) {
            xiaoRongShuShi.setText(case3.getAblationProcedure());
        }
        if (case3.getAblationLines() != null) {
            xiaoRongJingXian.setText(case3.getAblationLines());
        }

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextStepListner.OnNextStepClicked(3);
            }
        });
        return rootView;
    }


    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if (!isInActivity) {
            isInActivity = true;
            xiaoRongShuShi.setText("");
            xiaoRongJingXian.setText("");
            baFeiJingMai.setText("");
            shenJingJieCongXiaoRong.setText("");

            if (case3.getLungVein() != null) {
                baFeiJingMai.setText(case3.getLungVein());
            }
            if (case3.getGpAblation() != null) {
                shenJingJieCongXiaoRong.setText(case3.getGpAblation() + "\n\n");
            }

            if (case3.getAblationProcedure() != null) {
                xiaoRongShuShi.setText(case3.getAblationProcedure());
            }
            if (case3.getAblationLines() != null) {
                xiaoRongJingXian.setText(case3.getAblationLines());
            }
        }

    }

}
