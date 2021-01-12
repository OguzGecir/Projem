package com.h5190076_oguzcan_gecir_final.util;

import com.google.gson.Gson;
import com.h5190076_oguzcan_gecir_final.model.UyeModel;

public class ObjectUtil {
    public static String uyeToJsonString(UyeModel uyeModel){
        Gson gson = new Gson();
        return gson.toJson(uyeModel);
    }

    public static UyeModel jsonStringUye(String jsonString){
        Gson gson = new Gson();
        return gson.fromJson(jsonString,UyeModel.class);
    }
}
