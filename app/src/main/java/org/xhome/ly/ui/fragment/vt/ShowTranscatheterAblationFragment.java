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
public class ShowTranscatheterAblationFragment extends ShowBaseFragment {

    private static ShowTranscatheterAblationFragment fragment;

    private static final String[] methods = {"标测方法一", "标测方法二", "标测方法三"};

    EditText xingQiangNeiZaoYing;
    EditText youFaFangShi;
    EditText xinDongGuoSuFaZuoShiFouGuiZhe;
    EditText zhouChang;
    EditText biaoCeFangFa;
    MaterialEditText shuZhangQiDianWei;
    MaterialEditText pDianWeiBiaoCe;
    EditText xiaoRongShuShi;
    MaterialEditText qingShuRuXiaoRongShuShi;
    EditText xiaoRongJingXian;
    CircularProgressButton confirm;


    public static ShowTranscatheterAblationFragment newInstance(Case1Up case1) {
        if (fragment == null) {
            fragment = new ShowTranscatheterAblationFragment();
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
                R.layout.jingdaoguanxiaorong, container, false);
        init();
        xingQiangNeiZaoYing = (EditText) rootView.findViewById(R.id.xinqiangneizaoying);
        youFaFangShi = (EditText) rootView.findViewById(R.id.youfafangshi);
        xinDongGuoSuFaZuoShiFouGuiZhe = (EditText) rootView.findViewById(R.id.xindongguosufazuoshifouguize);
        zhouChang = (EditText) rootView.findViewById(R.id.zhouchang);
        biaoCeFangFa = (EditText) rootView.findViewById(R.id.biaocefangfa);
        shuZhangQiDianWei = (MaterialEditText) rootView.findViewById(R.id.shuzhangqidianwei);
        pDianWeiBiaoCe = (MaterialEditText) rootView.findViewById(R.id.pdianweibiaoce);
        xiaoRongShuShi = (EditText) rootView.findViewById(R.id.xiaorongshushi);
        qingShuRuXiaoRongShuShi = (MaterialEditText) rootView.findViewById(R.id.qingshuruxiaorongshushi);
        xiaoRongJingXian = (EditText) rootView.findViewById(R.id.xiaorongjingxian);
        confirm = (CircularProgressButton) rootView.findViewById(R.id.confirm);

        if (case1.getImagingInsideHeart() != null) {
            xingQiangNeiZaoYing.setText(case1.getImagingInsideHeart());
        }
        if (case1.getInducedWay() != null) {
            youFaFangShi.setText(case1.getInducedWay() + "\n\n");
        }
        if (case1.getTachycardiaRegulation() != null) {
            xinDongGuoSuFaZuoShiFouGuiZhe.setText(case1.getTachycardiaRegulation());
        }
        if (case1.getCcl() != null) {
            zhouChang.setText(case1.getCcl());
        }
        if (case1.getInspectionMethod() != null) {
            biaoCeFangFa.setText(case1.getInspectionMethod());
        }
        if (case1.getDiastolicPotential() != null) {
            shuZhangQiDianWei.setText(case1.getDiastolicPotential());
        }
        if (case1.getpPotentialExamination() != null) {
            pDianWeiBiaoCe.setText(case1.getpPotentialExamination());
        }
        if (case1.getAblationProcedure() != null) {
            xiaoRongShuShi.setText(case1.getAblationProcedure());
        }
        if (case1.getAblationLines() != null) {
            xiaoRongJingXian.setText(case1.getAblationLines());
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
            shuZhangQiDianWei.setText("");
            pDianWeiBiaoCe.setText("");
            xiaoRongShuShi.setText("");
            qingShuRuXiaoRongShuShi.setText("");
            xiaoRongJingXian.setText("");

            if (case1.getImagingInsideHeart() != null) {
                xingQiangNeiZaoYing.setText(case1.getImagingInsideHeart());
            }
            if (case1.getInducedWay() != null) {
                youFaFangShi.setText(case1.getInducedWay() + "\n\n");
            }
            if (case1.getTachycardiaRegulation() != null) {
                xinDongGuoSuFaZuoShiFouGuiZhe.setText(case1.getTachycardiaRegulation());
            }
            if (case1.getCcl() != null) {
                zhouChang.setText(case1.getCcl());
            }
            if (case1.getInspectionMethod() != null) {
                biaoCeFangFa.setText(case1.getInspectionMethod());
            }
            if (case1.getDiastolicPotential() != null) {
                shuZhangQiDianWei.setText(case1.getDiastolicPotential());
            }
            if (case1.getpPotentialExamination() != null) {
                pDianWeiBiaoCe.setText(case1.getpPotentialExamination());
            }
            if (case1.getAblationProcedure() != null) {
                xiaoRongShuShi.setText(case1.getAblationProcedure());
            }
            if (case1.getAblationLines() != null) {
                xiaoRongJingXian.setText(case1.getAblationLines());
            }
        }

    }

}
