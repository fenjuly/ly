package org.xhome.ly.ui.fragment.lm;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.google.gson.Gson;

import org.xhome.ly.bean.Case1Up;
import org.xhome.ly.bean.Case3Up;
import org.xhome.ly.network.RequestManager;

/**
 * Created by liurongchan on 14/12/15.
 */
public class ShowBaseFragment extends Fragment{

    protected NextStepListner nextStepListner;
    public boolean isInActivity = true;

    protected Case3Up case3;
    protected void parseArgument() {
        Bundle bundle = getArguments();
        case3 = new Gson().fromJson(bundle.getString("case3"), Case3Up.class);
    }
    protected void init(){
        parseArgument();
        Log.e("case:", getArguments().toString());
    }


    public interface NextStepListner {
        public  void OnNextStepClicked(int position);
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.e("onSaveInstanceState", "invoked");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        RequestManager.cancelAll(getActivity());
        Log.e("onDestroy", "invoked");
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            nextStepListner = (NextStepListner) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement NextStepListner");
        }
    }


}
