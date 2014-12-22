package org.xhome.ly.api;

/**
 * Created by liurongchan on 14/12/2.
 */
public class Api {
    public static final String HOST = "http://182.92.242.163:8080/yl";

    /**
     * 医生
     */
    //医生登陆
    public static final String AUTHENTICATION = HOST + "/api/doctor/authentication";
    //医生注册/更新
    public static final String DOCTOR = HOST + "/api/doctor";

    //病人
    public static final String PATIENT = HOST + "/api/patient";


    /**
     * 病例
     */
    public static final String CASE_COUNT = HOST + "/api/cases/counts";

    /**
     * 病例1
     */
    //病例1
    public static final String  CASE1 = HOST + "/api/case1";
    //病例1总数
    public static final String CASE1_COUNT = HOST + "/api/case1/counts";
    //病例1查找
    public static final String CASE1_SEARCH = HOST + "/api/case1s";


    /**
     * 病例2
     */
    //病例2
    public static final String  CASE2 = HOST + "/api/case2";
    //病例2总数
    public static final String CASE2_COUNT = HOST + "/api/case2/counts";
    //病例2查找
    public static final String CASE2_SEARCH = HOST + "/api/case2s";

    /**
     * 病史
     */
    public static final String MEDICAL_HISTORY = HOST + "/api/patient/%1$s/medicalhistory";

    //

}
