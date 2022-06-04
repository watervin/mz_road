package com.example.mz_road


import com.google.gson.annotations.SerializedName

data class DataResultItem(
    @SerializedName("feelings_action")
    val feelingsAction: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("mLocationRequest_result")
    val mLocationRequestResult: String,
    @SerializedName("tendencies")
    val tendencies: String,
    @SerializedName("facial_result")
    val facial_result: String,
    @SerializedName("final_result")
    val final_result: String
)

