package com.example.androidsde_assignment.feature_data.domain.repository


import com.example.androidsde_assignment.feature_data.domain.model.ExpressionResultEntity

interface ExpressionRepository {

    suspend fun insertAssign(exp : ExpressionResultEntity)

    suspend fun getAllExpression(): List<ExpressionResultEntity>
}