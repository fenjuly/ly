package org.xhome.ly.ui.fragment.af;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;

import org.xhome.ly.bean.Case1;
import org.xhome.ly.bean.Case2;
import org.xhome.ly.dao.Case1DataHelper;
import org.xhome.ly.network.RequestManager;
import org.xhome.ly.util.ToastUtils;

/**
 * Created by liurongchan on 14/12/4.
 */
public abstract class BaseFragment extends Fragment {

    protected Case2DataChangedListener case2DataChangedListener;

    protected NextStepListner nextStepListner;
    public boolean isInActivity = true;

    protected Case2 case2;
    protected void parseArgument() {
        Bundle bundle = getArguments();
        case2 = new Gson().fromJson(bundle.getString("case2"), Case2.class);
    }
    protected void init(){
        parseArgument();
        Log.e("case:", getArguments().toString());
    }

    public interface Case2DataChangedListener {
        public void OnCase2DataChanged(Case2 case2);
    }

    public interface NextStepListner {
        public  void OnNextStepClicked(int position);
    }

    public abstract void saveCase2();

    @Override
    public void onSaveInstanceState(Bundle outState) {
        saveCase2();
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
            case2DataChangedListener = (Case2DataChangedListener) activity;
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
