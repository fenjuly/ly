package org.xhome.ly.ui.fragment.lm;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;

import org.xhome.ly.bean.Case1;
import org.xhome.ly.bean.Case3;
import org.xhome.ly.network.RequestManager;
import org.xhome.ly.util.ToastUtils;

/**
 * Created by liurongchan on 14/12/4.
 */
public abstract class BaseFragment extends Fragment {

    protected Case3DataChangedListener case3DataChangedListener;

    protected NextStepListner nextStepListner;
    public boolean isInActivity = true;

    protected Case3 case3;
    protected void parseArgument() {
        Bundle bundle = getArguments();
        case3 = new Gson().fromJson(bundle.getString("case3"), Case3.class);
    }
    protected void init(){
        parseArgument();
        Log.e("case:", getArguments().toString());
    }

    public interface Case3DataChangedListener {
        public void OnCase3DataChanged(Case3 case3);
    }

    public interface NextStepListner {
        public  void OnNextStepClicked(int position);
    }

    public abstract void saveCase3();

    @Override
    public void onSaveInstanceState(Bundle outState) {
        saveCase3();
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
            case3DataChangedListener = (Case3DataChangedListener) activity;
            nextStepListner = (NextStepListner) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement Case1DataChangedListener");
        }
    }

    protected void executeRequest(Request request) {
        RequestManager.addRequest(request, this);
    }

    protected Response.ErrorListener errorListener() {
        return new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                ToastUtils.showLong(error.getMessage());
            }
        };
    }
}
