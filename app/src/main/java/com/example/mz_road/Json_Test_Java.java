package com.example.mz_road;

import android.util.Log;

import com.google.gson.annotations.SerializedName;

import aws.sdk.kotlin.services.dynamodb.model.ComparisonOperator;

public class Json_Test_Java {

    public String feelings_action;
    public String tendencies;
    public String facial_result;
    public String final_result;



    public Json_Test_Java(String feelings_action,String tendencies,String facial_result, String final_result) {
        this.feelings_action = feelings_action;
        this.tendencies = tendencies;
        this.facial_result = facial_result;
        this.final_result =final_result;
;

    }



    public String get_feelings_action() {
        return feelings_action;
    }
    public String get_tendencies() {
        return tendencies;
    }
    public String get_facial_result() {
        return facial_result;
    }
    public String get_final_result() {
        return final_result;
    }


    public void setTest(String feelings_action,String tendencies,String facial_result, String final_result) {

        this.feelings_action = feelings_action;
        this.tendencies = tendencies;
        this.facial_result = facial_result;
        this.final_result = final_result;
    }


}
