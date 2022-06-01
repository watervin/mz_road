package com.example.mz_road;

import android.util.Log;

import com.google.gson.annotations.SerializedName;

import aws.sdk.kotlin.services.dynamodb.model.ComparisonOperator;

public class Json_Test_Java {

    public String feelings_action;
    public String tendencies;
    public String mLocationRequest_result;





    public Json_Test_Java(String feelings_action,String tendencies,String mLocationRequest_result) {

        this.feelings_action = feelings_action;
        this.tendencies = tendencies;
        this.mLocationRequest_result = mLocationRequest_result;


    }



    public String get_feelings_action() {
        return feelings_action;
    }
    public String get_tendencies() {
        return tendencies;
    }
    public String get_mLocationRequest_result() {
        return mLocationRequest_result;
    }


    public void setTest(String feelings_action,String tendencies,String mLocationRequest_result) {

        this.feelings_action = feelings_action;
        this.tendencies = tendencies;
        this.mLocationRequest_result = mLocationRequest_result;
    }


}
