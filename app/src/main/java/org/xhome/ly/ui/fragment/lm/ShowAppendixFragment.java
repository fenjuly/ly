package org.xhome.ly.ui.fragment.lm;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.rengwuxian.materialedittext.MaterialEditText;

import org.xhome.ly.R;
import org.xhome.ly.bean.Case1Up;
import org.xhome.ly.bean.Case3Up;

/**
 * Created by liurongchan on 14/12/15.
 */
public class ShowAppendixFragment extends ShowBaseFragment {

    private static ShowAppendixFragment fragment;

    MaterialEditText beiZhu;

    public static ShowAppendixFragment newInstance(Case3Up case3) {
        if (fragment == null) {
            fragment = new ShowAppendixFragment();
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
                R.layout.fulu, container, false);
        init();
        beiZhu = (MaterialEditText) rootView.findViewById(R.id.beizhu);
        if (case3.getGlobalRemarks() != null) {
            beiZhu.setText(case3.getGlobalRemarks());
        }
        return rootView;
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if (!isInActivity) {
            isInActivity = true;
            beiZhu.setText("");
            if (case3.getGlobalRemarks() != null) {
                beiZhu.setText(case3.getGlobalRemarks());
            }
        }
    }


}
