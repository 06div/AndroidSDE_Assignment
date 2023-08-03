package com.example.androidsde_assignment.feature_data.data.data_source

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

import com.example.androidsde_assignment.feature_data.domain.model.ExpressionResultEntity

@Dao
interface ExpressionResultDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(expressionResultEntity: ExpressionResultEntity)

    @Query("SELECT * FROM expression_results")
    suspend fun getAllExpressionResults(): List<ExpressionResultEntity>
}