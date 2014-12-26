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

    CircularProgressButton confirm;


    public static ShowDiagnosticMessageFragment newInstance(Case3Up case3) {
        if (fragment == null) {
            fragment = new ShowDiagnosticMessageFragment();
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
                R.layout.lmzhenduanxinxi, container, false);
        init();
        shouShuRiQi = (EditText) rootView.findViewById(R.id.shoushuriqi);
        shouShuBianHao = (MaterialEditText) rootView.findViewById(R.id.shoushubianhao);
        shuZhe = (MaterialEditText) rootView.findViewById(R.id.shuzhe);
        shiSuLeiXing = (EditText) rootView.findViewById(R.id.shisuleixing);
        shiSuBingCheng = (EditText) rootView.findViewById(R.id.shisubingcheng);
        linChuangXinLvShiChangZhenDuan = (MaterialEditText) rootView.findViewById(R.id.linchuangxinlvshichangzhenduan);
        dianShengLiJianChaZhenDuan = (MaterialEditText) rootView.findViewById(R.id.dianshenglijianchazhenduan);
        shuHouZhenDuan = (MaterialEditText) rootView.findViewById(R.id.shuhouzhenduan);

        confirm = (CircularProgressButton) rootView.findViewById(R.id.confirm);

        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);
        if (case3.getOperationData() != 0) {
            shouShuRiQi.setText(dateFormat.format(new Date(case3.getOperationData())));
        }
        if (case3.getOperationNumber() != null) {
            shouShuBianHao.setText(case3.getOperationNumber());
        }
        if (case3.getOperatorName() != null) {
            shuZhe.setText(case3.getOperatorName());
        }
        if (case3.getAfType() != null && !case3.getAfType().equals("")) {
            shiSuLeiXing.setText("类型:" + case3.getAfType() + "\n\n"
                    + "频度:" + case3.getAfFrequency() + "\n\n"
                    + "每次发作持续时间:" + case3.getAfEveryAttackTime() + "\n\n"
                    + "最近发作持续时间:" + case3.getAfLastAttackTime() + "\n\n"
                    + "曾用转复方法:" + case3.getCardioversionMethod() + "\n\n"
                    + "转律用药:" + case3.getCardioversionMedication());
        }
        if (case3.getAfCourseDisease() != null) {
            shiSuBingCheng.setText(case3.getAfCourseDisease());
        }
        if (case3.getArrhythmiaDiagnose() != null) {
            linChuangXinLvShiChangZhenDuan.setText(case3.getArrhythmiaDiagnose());
        }
        if (case3.getElectrophysiologyDiagnose() != null) {
            dianShengLiJianChaZhenDuan.setText(case3.getElectrophysiologyDiagnose());
        }
        if (case3.getPostoperationDiagnose() != null) {
            shuHouZhenDuan.setText(case3.getPostoperationDiagnose());
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

            DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);
            if (case3.getOperationData() != 0) {
                shouShuRiQi.setText(dateFormat.format(new Date(case3.getOperationData())));
            }
            if (case3.getOperationNumber() != null) {
                shouShuBianHao.setText(case3.getOperationNumber());
            }
            if (case3.getOperatorName() != null) {
                shuZhe.setText(case3.getOperatorName());
            }
            if (case3.getAfType() != null && !case3.getAfType().equals("")) {
                shiSuLeiXing.setText("类型:" + case3.getAfType() + "\n\n"
                        + "频度:" + case3.getAfFrequency() + "\n\n"
                        + "每次发作持续时间:" + case3.getAfEveryAttackTime() + "\n\n"
                        + "最近发作持续时间:" + case3.getAfLastAttackTime() + "\n\n"
                        + "曾用转复方法:" + case3.getCardioversionMethod() + "\n\n"
                        + "转律用药:" + case3.getCardioversionMedication());
            }
            if (case3.getAfCourseDisease() != null) {
                shiSuBingCheng.setText(case3.getAfCourseDisease());
            }
            if (case3.getArrhythmiaDiagnose() != null) {
                linChuangXinLvShiChangZhenDuan.setText(case3.getArrhythmiaDiagnose());
            }
            if (case3.getElectrophysiologyDiagnose() != null) {
                dianShengLiJianChaZhenDuan.setText(case3.getElectrophysiologyDiagnose());
            }
            if (case3.getPostoperationDiagnose() != null) {
                shuHouZhenDuan.setText(case3.getPostoperationDiagnose());
            }

        }

    }

}
