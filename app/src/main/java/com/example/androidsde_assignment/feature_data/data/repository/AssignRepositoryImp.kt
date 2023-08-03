package com.example.androidsde_assignment.feature_data.data.repository


import com.example.androidsde_assignment.feature_data.data.data_source.ExpressionResultDao
import com.example.androidsde_assignment.feature_data.domain.model.ExpressionResult

import com.example.androidsde_assignment.feature_data.domain.model.ExpressionResultEntity
import com.example.androidsde_assignment.feature_data.domain.repository.ExpressionRepository


class AssignRepositoryImp(private val dao: ExpressionResultDao): ExpressionRepository {

  override suspend fun insertAssign(exp : ExpressionResultEntity) {
        return dao.insert(exp)
    }

    override suspend fun getAllExpression(): List<ExpressionResultEntity> {
        return dao.getAllExpressionResults()
    }
}