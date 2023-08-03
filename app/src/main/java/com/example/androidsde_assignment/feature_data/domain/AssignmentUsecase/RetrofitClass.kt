package com.example.androidsde_assignment.feature_data.domain.AssignmentUsecase

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClass {

    val BASE_URL = "http://api.mathjs.org/v4/"

    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val expressionAPIService = retrofit.create(ExpressionAPIService::class.java)

}