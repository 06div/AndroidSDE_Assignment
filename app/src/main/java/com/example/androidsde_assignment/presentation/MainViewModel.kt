package com.example.androidsde_assignment.presentation

import android.telecom.Call
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidsde_assignment.feature_data.data.data_source.AppDatabase
import com.example.androidsde_assignment.feature_data.domain.AssignmentUsecase.ExpressionAPIService
import com.example.androidsde_assignment.feature_data.domain.model.ExpressionResult
import com.example.androidsde_assignment.feature_data.domain.model.ExpressionResultEntity
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainViewModel(private val expressionApiService: ExpressionAPIService,
                    private val database: AppDatabase
) : ViewModel() {
    private val _results = MutableLiveData<List<ExpressionResult>>()
    val results: LiveData<List<ExpressionResult>> get() = _results
    fun evaluateExpression(expression: String) {
        val call = expressionApiService.evaluateExpression(expression)
        call.enqueue(object : retrofit2.Callback<ExpressionResult> {
            override fun onResponse(call: retrofit2.Call<ExpressionResult>, response:
            Response<ExpressionResult>) {
                if (response.isSuccessful) {
                    val result = response.body()
                    result?.let {
                        viewModelScope.launch {
                            database.expressionResultDao().insert(
                                ExpressionResultEntity(expression =
                            expression, result = it.result)
                            )
                            _results.value =
                                database.expressionResultDao().getAllExpressionResults()

                        }
                    }
                }
            }
            override fun onFailure(call: retrofit2.Call<ExpressionResult>, t:
            Throwable) {

                    val resultTextView = "Error: ${t.message}"

            }
        })
    }
}