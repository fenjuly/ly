package org.xhome.ly.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.xhome.ly.R;

/**
 * Created by liurongchan on 14/12/3.
 */
public class AppendixFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(
                R.layout.shuqianxinxi, container, false);
        return rootView;
    }
}
