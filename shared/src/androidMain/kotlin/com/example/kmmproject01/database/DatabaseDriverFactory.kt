package com.example.kmmproject01.database

import com.example.kmmproject01.utils.AndroidApplication
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

actual fun createSqlDriver(): SqlDriver {
    return AndroidSqliteDriver(CommonDatabase.Schema,AndroidApplication.context,"common.db")
}