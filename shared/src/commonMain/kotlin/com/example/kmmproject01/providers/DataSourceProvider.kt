package com.example.kmmproject01.providers

import com.example.kmmproject01.database.Database
import com.example.kmmproject01.database.createSqlDriver

class DataSourceProvider {

    private val database = Database(createSqlDriver())

    fun getLocalCommonDatabase() = database
}