package data

import app.cash.sqldelight.db.SqlDriver

expect  class DataBaseDriverFactoy {

    fun createDriver(): SqlDriver
}