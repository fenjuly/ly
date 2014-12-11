package org.xhome.ly.util;

import android.content.Context;
import android.content.SharedPreferences;

import org.xhome.ly.App;

import java.util.Iterator;
import java.util.Map;

/**
 * Created by liurongchan on 14/12/5.
 */
public class SharePerferenceUtils {

    private static final String ACCOUNT_INFORMATION = "accout_information";

    public static final String AUTHENTICATION = "authentication";

    public static final String DOCTOR_ID = "doctor_id";

    public static final String PATIENT_ID = "patient_id";

    private static SharedPreferences mShared;

    private static SharedPreferences getSharedPreference() {
        if (mShared == null) {
            mShared = App.getContext().getSharedPreferences(ACCOUNT_INFORMATION, Context.MODE_PRIVATE);
        }
        return mShared;
    }

    public static void addCookies(Map<String, String> cookies) {
        if (mShared == null) {
            getSharedPreference();
        }
        SharedPreferences.Editor editor = mShared.edit();
        Iterator<String> iterator = cookies.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            editor.putString(key, cookies.get(key));
        }
        editor.apply();
    }

    public static void addOther(String key, String value) {
        if (mShared == null) {
            getSharedPreference();
        }
        SharedPreferences.Editor editor = mShared.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static String getInformation(String key) {
        String information = "";
        if (mShared == null) {
            getSharedPreference();
        }
        information = mShared.getString(key, "");
        return information;
    }
}
