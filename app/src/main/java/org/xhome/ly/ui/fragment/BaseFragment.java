package org.xhome.ly.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.google.gson.Gson;

import org.xhome.ly.bean.Case1;
import org.xhome.ly.dao.Case1DataHelper;

/**
 * Created by liurongchan on 14/12/4.
 */
public class BaseFragment extends Fragment {

    protected Case1DataHelper case1DataHelper;
    protected Case1DataChangedListener case1DataChangedListener;

    protected NextStepListner nextStepListner;
    public boolean isInActivity = true;

    protected Case1 case1;
    protected void parseArgument() {
        Bundle bundle = getArguments();
        case1 = new Gson().fromJson(bundle.getString("case1"), Case1.class);
        Log.e("case:", bundle.toString());
    }
    protected void init(){
        parseArgument();
    }

    public interface Case1DataChangedListener {
        public void OnCase1DataChanged(Case1 case1);
    }

    public interface NextStepListner {
        public  void OnNextStepClicked(int position);
    }
}
