package com.example.kmmproject01.database

import com.example.kmmproject01.utils.AndroidMainApp
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

actual fun createSqlDriver(): SqlDriver {
    return AndroidSqliteDriver(CommonDatabase.Schema,AndroidMainApp.applicationContext,"common.db")
}