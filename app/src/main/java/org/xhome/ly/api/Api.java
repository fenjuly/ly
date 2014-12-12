package org.xhome.ly.api;

/**
 * Created by liurongchan on 14/12/2.
 */
public class Api {
    public static final String HOST = "http://192.168.0.166:8081/yl";

    //医生登陆
    public static final String AUTHENTICATION = HOST + "/api/doctor/authentication";
    //医生注册/更新
    public static final String DOCTOR = HOST + "/api/doctor";

    //病人
    public static final String PATIENT = HOST + "/api/patient";


    //病例1
    public static final String  CASE1 = HOST + "/api/case1";

}
