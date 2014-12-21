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
    EditText fangSuLeiXing;
    EditText fangSuBingCheng;
    MaterialEditText linChuangXinLvShiChangZhenDuan;
    MaterialEditText dianShengLiJianChaZhenDuan;
    MaterialEditText shuHouZhenDuan;
    MaterialEditText jiZhi;
    MaterialEditText buWei;

    CircularProgressButton confirm;


    public static ShowDiagnosticMessageFragment newInstance(Case2Up case2) {
        if (fragment == null) {
            fragment = new ShowDiagnosticMessageFragment();
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
                R.layout.afzhenduanxinxi, container, false);
        init();
        shouShuRiQi = (EditText) rootView.findViewById(R.id.shoushuriqi);
        shouShuBianHao = (MaterialEditText) rootView.findViewById(R.id.shoushubianhao);
        shuZhe = (MaterialEditText) rootView.findViewById(R.id.shuzhe);
        fangSuLeiXing = (EditText) rootView.findViewById(R.id.fangsuleixing);
        fangSuBingCheng = (EditText) rootView.findViewById(R.id.fangsubingcheng);
        linChuangXinLvShiChangZhenDuan = (MaterialEditText) rootView.findViewById(R.id.linchuangxinlvshichangzhenduan);
        dianShengLiJianChaZhenDuan = (MaterialEditText) rootView.findViewById(R.id.dianshenglijianchazhenduan);
        shuHouZhenDuan = (MaterialEditText) rootView.findViewById(R.id.shuhouzhenduan);
        jiZhi = (MaterialEditText) rootView.findViewById(R.id.jizhi);
        buWei = (MaterialEditText) rootView.findViewById(R.id.buwei);
        confirm = (CircularProgressButton) rootView.findViewById(R.id.confirm);

        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);
        if (case2.getOperationData() != 0) {
            shouShuRiQi.setText(dateFormat.format(new Date(case2.getOperationData())));
        }
        if (case2.getOperationNumber() != null) {
            shouShuBianHao.setText(case2.getOperationNumber());
        }
        if (case2.getOperatorName() != null) {
            shuZhe.setText(case2.getOperatorName());
        }
        if (case2.getRrType() != null && !case2.getRrType().equals("")) {
            fangSuLeiXing.setText("类型:" + case2.getRrType() + "\n\n"
                    + "频度:" + case2.getRrFrequency() + "\n\n"
                    + "每次发作持续时间:" + case2.getRrEveryAttackTime() + "\n\n"
                    + "最近发作持续时间:" + case2.getRrLastAttackTime() + "\n\n"
                    + "曾用转复方法:" + case2.getCardioversionMethod() + "\n\n"
                    + "转律用药:" + case2.getCardioversionMedication());
        }
        if (case2.getRrCourseDisease() != null) {
            fangSuBingCheng.setText(case2.getRrCourseDisease());
        }
        if (case2.getArrhythmiaDiagnose() != null) {
            linChuangXinLvShiChangZhenDuan.setText(case2.getArrhythmiaDiagnose());
        }
        if (case2.getElectrophysiologyDiagnose() != null) {
            dianShengLiJianChaZhenDuan.setText(case2.getElectrophysiologyDiagnose());
        }
        if (case2.getPostoperationDiagnose() != null) {
            shuHouZhenDuan.setText(case2.getPostoperationDiagnose());
        }
        if (case2.getMechanism() != null) {
            jiZhi.setText(case2.getMechanism());
        }
        if (case2.getPart() != null) {
            buWei.setText(case2.getPart());
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
            fangSuLeiXing.setText("");
            fangSuBingCheng.setText("");
            linChuangXinLvShiChangZhenDuan.setText("");
            dianShengLiJianChaZhenDuan.setText("");
            shuHouZhenDuan.setText("");
            jiZhi.setText("");
            buWei.setText("");
        }

    }

}
