package com.example.mz_road

data class ResultDate(var message: Message? = null){



    data class Message(var result: Result? = null){
        data class Result(var mLocationRequest_result: String? = null)
    }
}