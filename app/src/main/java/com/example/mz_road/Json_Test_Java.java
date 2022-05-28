package com.example.mz_road;

import com.google.gson.annotations.SerializedName;

import aws.sdk.kotlin.services.dynamodb.model.ComparisonOperator;

public class Json_Test_Java {

    @SerializedName("test")
    public String feelings_action;
    public String tendencies;


    public Json_Test_Java(String feelings_action,String tendencies) {

        this.feelings_action = feelings_action;
        this.tendencies = tendencies;
    }



    public String get_feelings_action() {
        return feelings_action;
    }
    public String get_tendencies() {
        return tendencies;
    }

    public void setTest(String feelings_action,String tendencies) {

        this.feelings_action = feelings_action;
        this.tendencies = tendencies;

    }


}
