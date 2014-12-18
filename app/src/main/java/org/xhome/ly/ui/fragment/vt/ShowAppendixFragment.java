package org.xhome.ly.ui.fragment.vt;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.rengwuxian.materialedittext.MaterialEditText;

import org.xhome.ly.R;
import org.xhome.ly.bean.Case1Up;

/**
 * Created by liurongchan on 14/12/15.
 */
public class ShowAppendixFragment extends ShowBaseFragment {

    private static ShowAppendixFragment fragment;

    MaterialEditText beiZhu;

    public static ShowAppendixFragment newInstance(Case1Up case1) {
        if (fragment == null) {
            fragment = new ShowAppendixFragment();
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
                R.layout.fulu, container, false);
        init();
        beiZhu = (MaterialEditText) rootView.findViewById(R.id.beizhu);
        if (case1.getGlobalRemarks() != null) {
            beiZhu.setText(case1.getGlobalRemarks());
        }
        return rootView;
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if (!isInActivity) {
            isInActivity = true;

        }
    }


}
