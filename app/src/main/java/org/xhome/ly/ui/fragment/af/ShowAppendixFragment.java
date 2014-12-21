package org.xhome.ly.ui.fragment.af;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.rengwuxian.materialedittext.MaterialEditText;

import org.xhome.ly.R;
import org.xhome.ly.bean.Case2Up;

/**
 * Created by liurongchan on 14/12/15.
 */
public class ShowAppendixFragment extends ShowBaseFragment {

    private static ShowAppendixFragment fragment;

    MaterialEditText beiZhu;

    public static ShowAppendixFragment newInstance(Case2Up case2) {
        if (fragment == null) {
            fragment = new ShowAppendixFragment();
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
                R.layout.fulu, container, false);
        init();
        beiZhu = (MaterialEditText) rootView.findViewById(R.id.beizhu);
        if (case2.getGlobalRemarks() != null) {
            beiZhu.setText(case2.getGlobalRemarks());
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
