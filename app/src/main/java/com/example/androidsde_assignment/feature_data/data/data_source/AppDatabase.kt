package com.example.androidsde_assignment.feature_data.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.androidsde_assignment.feature_data.domain.model.ExpressionResultEntity


@Database(entities = [ExpressionResultEntity::class], version = 1,
    exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun expressionResultDao(): ExpressionResultDao
}