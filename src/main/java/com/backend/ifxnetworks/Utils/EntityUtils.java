package com.backend.ifxnetworks.Utils;

import java.sql.Timestamp;

public class EntityUtils {

    public static Timestamp getCurrentDate(){
        return new java.sql.Timestamp(System.currentTimeMillis());
    }
}
