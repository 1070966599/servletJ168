package com.lovo.servlet.mybaits.util;

import java.util.UUID;

public class GetUUID {

    public static String createUUID(){

        return UUID.randomUUID().toString().replaceAll("-","");
    }

}
