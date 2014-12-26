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
public class ShowTranscatheterAblationFragment extends ShowBaseFragment {

    private static ShowTranscatheterAblationFragment fragment;

    EditText xingQiangNeiZaoYing;
    EditText youFaFangShi;
    MaterialEditText xinDongGuoSuFaZuoShiFouGuiZhe;
    EditText zhouChang;
    EditText biaoCeFangFa;
    EditText biaoCeFangShi;
    EditText xiaoRongShuShi;
    EditText xiaoRongJingXian;
    CircularProgressButton confirm;


    public static ShowTranscatheterAblationFragment newInstance(Case2Up case2) {
        if (fragment == null) {
            fragment = new ShowTranscatheterAblationFragment();
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
                R.layout.afjingdaoguanxiaorong, container, false);
        init();
        xingQiangNeiZaoYing = (EditText) rootView.findViewById(R.id.xinqiangneizaoying);
        youFaFangShi = (EditText) rootView.findViewById(R.id.youfafangshi);
        xinDongGuoSuFaZuoShiFouGuiZhe = (MaterialEditText) rootView.findViewById(R.id.xindongguosufazuoshifouguize);
        zhouChang = (EditText) rootView.findViewById(R.id.zhouchang);
        biaoCeFangFa = (EditText) rootView.findViewById(R.id.biaocefangfa);
        biaoCeFangShi = (EditText) rootView.findViewById(R.id.biaocefangshi);
        xiaoRongShuShi = (EditText) rootView.findViewById(R.id.xiaorongshushi);
        xiaoRongJingXian = (EditText) rootView.findViewById(R.id.xiaorongjingxian);
        confirm = (CircularProgressButton) rootView.findViewById(R.id.confirm);

        if (case2.getImagingInsideHeart() != null) {
            xingQiangNeiZaoYing.setText(case2.getImagingInsideHeart());
        }
        if (case2.getInducedWay() != null) {
            youFaFangShi.setText(case2.getInducedWay() + "\n\n");
        }
        if (case2.getTachycardiaRegulation() != null) {
            xinDongGuoSuFaZuoShiFouGuiZhe.setText(case2.getTachycardiaRegulation());
        }
        if (case2.getCcl() != null) {
            zhouChang.setText(case2.getCcl());
        }
        if (case2.getInspectionMethod() != null) {
            biaoCeFangFa.setText(case2.getInspectionMethod());
        }
        if (case2.getAblationProcedure() != null) {
            xiaoRongShuShi.setText(case2.getAblationProcedure());
        }
        if (case2.getAblationLines() != null) {
            xiaoRongJingXian.setText(case2.getAblationLines());
        }
        if (case2.getMappingMode() != null) {
            biaoCeFangShi.setText(case2.getMappingMode());
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
            xingQiangNeiZaoYing.setText("");
            youFaFangShi.setText("");
            xinDongGuoSuFaZuoShiFouGuiZhe.setText("");
            zhouChang.setText("");
            biaoCeFangFa.setText("");
            biaoCeFangShi.setText("");
            xiaoRongShuShi.setText("");
            xiaoRongJingXian.setText("");

            if (case2.getImagingInsideHeart() != null) {
                xingQiangNeiZaoYing.setText(case2.getImagingInsideHeart());
            }
            if (case2.getInducedWay() != null) {
                youFaFangShi.setText(case2.getInducedWay() + "\n\n");
            }
            if (case2.getTachycardiaRegulation() != null) {
                xinDongGuoSuFaZuoShiFouGuiZhe.setText(case2.getTachycardiaRegulation());
            }
            if (case2.getCcl() != null) {
                zhouChang.setText(case2.getCcl());
            }
            if (case2.getInspectionMethod() != null) {
                biaoCeFangFa.setText(case2.getInspectionMethod());
            }
            if (case2.getAblationProcedure() != null) {
                xiaoRongShuShi.setText(case2.getAblationProcedure());
            }
            if (case2.getAblationLines() != null) {
                xiaoRongJingXian.setText(case2.getAblationLines());
            }
            if (case2.getMappingMode() != null) {
                biaoCeFangShi.setText(case2.getMappingMode());
            }
        }

    }

}
