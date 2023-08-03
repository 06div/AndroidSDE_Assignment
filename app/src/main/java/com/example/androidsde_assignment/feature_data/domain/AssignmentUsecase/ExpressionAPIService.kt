package com.example.androidsde_assignment.feature_data.domain.AssignmentUsecase

import com.example.androidsde_assignment.feature_data.domain.model.ExpressionResult
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST


interface ExpressionAPIService {
    @POST("evaluate")
    fun evaluateExpression(@Body expression: String): Call<ExpressionResult>


}