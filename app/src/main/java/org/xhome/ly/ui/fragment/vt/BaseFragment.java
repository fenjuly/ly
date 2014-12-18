package org.xhome.ly.ui.fragment.vt;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;

import org.xhome.ly.bean.Case1;
import org.xhome.ly.dao.Case1DataHelper;
import org.xhome.ly.network.RequestManager;
import org.xhome.ly.util.ToastUtils;

/**
 * Created by liurongchan on 14/12/4.
 */
public abstract class BaseFragment extends Fragment {

    protected Case1DataHelper case1DataHelper;
    protected Case1DataChangedListener case1DataChangedListener;

    protected NextStepListner nextStepListner;
    public boolean isInActivity = true;

    protected Case1 case1;
    protected void parseArgument() {
        Bundle bundle = getArguments();
        case1 = new Gson().fromJson(bundle.getString("case1"), Case1.class);
    }
    protected void init(){
        parseArgument();
        Log.e("case:", getArguments().toString());
    }

    public interface Case1DataChangedListener {
        public void OnCase1DataChanged(Case1 case1);
    }

    public interface NextStepListner {
        public  void OnNextStepClicked(int position);
    }

    public abstract void saveCase1();

    @Override
    public void onSaveInstanceState(Bundle outState) {
        saveCase1();
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
            case1DataChangedListener = (Case1DataChangedListener) activity;
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
