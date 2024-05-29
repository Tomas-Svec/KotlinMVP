package data

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import org.expenseApp.db.AppDatabase

actual class DataBaseDriverFactoy {
    actual fun createDriver(): SqlDriver {
       return NativeSqliteDriver(
           schema = AppDatabase.Schema,
           name = "AppDatabase.db"
       )
    }

}