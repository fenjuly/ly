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

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by liurongchan on 14/12/15.
 */
public class ShowDiagnosticMessageFragment extends ShowBaseFragment {


    private static ShowDiagnosticMessageFragment fragment;

    private static final String[] types = {"阵发性", "持续性", "慢性连续性"};

    EditText shouShuRiQi;
    MaterialEditText shouShuBianHao;
    MaterialEditText shuZhe;
    EditText shiSuLeiXing;
    EditText shiSuBingCheng;
    MaterialEditText linChuangXinLvShiChangZhenDuan;
    MaterialEditText dianShengLiJianChaZhenDuan;
    MaterialEditText shuHouZhenDuan;
    MaterialEditText jiZhi;
    MaterialEditText buWei;

    CircularProgressButton confirm;


    public static ShowDiagnosticMessageFragment newInstance(Case1Up case1) {
        if (fragment == null) {
            fragment = new ShowDiagnosticMessageFragment();
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
                R.layout.zhenduanxinxi, container, false);
        init();
        shouShuRiQi = (EditText) rootView.findViewById(R.id.shoushuriqi);
        shouShuBianHao = (MaterialEditText) rootView.findViewById(R.id.shoushubianhao);
        shuZhe = (MaterialEditText) rootView.findViewById(R.id.shuzhe);
        shiSuLeiXing = (EditText) rootView.findViewById(R.id.shisuleixing);
        shiSuBingCheng = (EditText) rootView.findViewById(R.id.shisubingcheng);
        linChuangXinLvShiChangZhenDuan = (MaterialEditText) rootView.findViewById(R.id.linchuangxinlvshichangzhenduan);
        dianShengLiJianChaZhenDuan = (MaterialEditText) rootView.findViewById(R.id.dianshenglijianchazhenduan);
        shuHouZhenDuan = (MaterialEditText) rootView.findViewById(R.id.shuhouzhenduan);
        jiZhi = (MaterialEditText) rootView.findViewById(R.id.jizhi);
        buWei = (MaterialEditText) rootView.findViewById(R.id.buwei);
        confirm = (CircularProgressButton) rootView.findViewById(R.id.confirm);

        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);
        if (case1.getOperationData() != 0) {
            shouShuRiQi.setText(dateFormat.format(new Date(case1.getOperationData())));
        }
        if (case1.getOperationNumber() != null) {
            shouShuBianHao.setText(case1.getOperationNumber());
        }
        if (case1.getOperatorName() != null) {
            shuZhe.setText(case1.getOperatorName());
        }
        if (case1.getVtType() != null && !case1.getVtType().equals("")) {
            shiSuLeiXing.setText("类型:" + case1.getVtType() + "\n\n"
                    + "频度:" + case1.getVtFrequency() + "\n\n"
                    + "每次发作持续时间:" + case1.getVtEveryAttackTime() + "\n\n"
                    + "最近发作持续时间:" + case1.getVtLastAttackTime() + "\n\n"
                    + "曾用转复方法:" + case1.getCardioversionMethod() + "\n\n"
                    + "转律用药:" + case1.getCardioversionMedication());
        }
        if (case1.getVtCourseDisease() != null) {
            shiSuBingCheng.setText(case1.getVtCourseDisease());
        }
        if (case1.getArrhythmiaDiagnose() != null) {
            linChuangXinLvShiChangZhenDuan.setText(case1.getArrhythmiaDiagnose());
        }
        if (case1.getElectrophysiologyDiagnose() != null) {
            dianShengLiJianChaZhenDuan.setText(case1.getElectrophysiologyDiagnose());
        }
        if (case1.getPostoperationDiagnose() != null) {
            shuHouZhenDuan.setText(case1.getPostoperationDiagnose());
        }
        if (case1.getMechanism() != null) {
            jiZhi.setText(case1.getMechanism());
        }
        if (case1.getPart() != null) {
            buWei.setText(case1.getPart());
        }

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextStepListner.OnNextStepClicked(1);
            }
        });
        return rootView;
    }


    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if (!isInActivity) {
            isInActivity = true;
            shouShuRiQi.setText("");
            shouShuBianHao.setText("");
            shuZhe.setText("");
            shiSuLeiXing.setText("");
            shiSuBingCheng.setText("");
            linChuangXinLvShiChangZhenDuan.setText("");
            dianShengLiJianChaZhenDuan.setText("");
            shuHouZhenDuan.setText("");
            jiZhi.setText("");
            buWei.setText("");

            DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);
            if (case1.getOperationData() != 0) {
                shouShuRiQi.setText(dateFormat.format(new Date(case1.getOperationData())));
            }
            if (case1.getOperationNumber() != null) {
                shouShuBianHao.setText(case1.getOperationNumber());
            }
            if (case1.getOperatorName() != null) {
                shuZhe.setText(case1.getOperatorName());
            }
            if (case1.getVtType() != null && !case1.getVtType().equals("")) {
                shiSuLeiXing.setText("类型:" + case1.getVtType() + "\n\n"
                        + "频度:" + case1.getVtFrequency() + "\n\n"
                        + "每次发作持续时间:" + case1.getVtEveryAttackTime() + "\n\n"
                        + "最近发作持续时间:" + case1.getVtLastAttackTime() + "\n\n"
                        + "曾用转复方法:" + case1.getCardioversionMethod() + "\n\n"
                        + "转律用药:" + case1.getCardioversionMedication());
            }
            if (case1.getVtCourseDisease() != null) {
                shiSuBingCheng.setText(case1.getVtCourseDisease());
            }
            if (case1.getArrhythmiaDiagnose() != null) {
                linChuangXinLvShiChangZhenDuan.setText(case1.getArrhythmiaDiagnose());
            }
            if (case1.getElectrophysiologyDiagnose() != null) {
                dianShengLiJianChaZhenDuan.setText(case1.getElectrophysiologyDiagnose());
            }
            if (case1.getPostoperationDiagnose() != null) {
                shuHouZhenDuan.setText(case1.getPostoperationDiagnose());
            }
            if (case1.getMechanism() != null) {
                jiZhi.setText(case1.getMechanism());
            }
            if (case1.getPart() != null) {
                buWei.setText(case1.getPart());
            }
        }

    }

}
