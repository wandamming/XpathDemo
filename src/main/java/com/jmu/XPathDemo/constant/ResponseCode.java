package com.jmu.XPathDemo.constant;

import java.util.HashMap;
import java.util.Map;

public class ResponseCode {

    public static final int FAILED_CODE = 199;
    public static final int SUCCESS_CODE = 200;


    public static final Map<Integer, String> sCodeMsgMap = new HashMap();

    static {
        sCodeMsgMap.put(FAILED_CODE, " Fail ... ");
        sCodeMsgMap.put(SUCCESS_CODE, " Success... ");



    }

    public static String getMsg(int code) {
        if (sCodeMsgMap.containsKey(code)) {
            return sCodeMsgMap.get(code);
        } else {
            return " Unknown ";
        }
    }


}
