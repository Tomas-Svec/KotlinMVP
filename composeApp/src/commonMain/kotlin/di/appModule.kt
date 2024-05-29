package di

import data.ExpenseManager
import data.ExpenseRepoImpl
import domain.ExpenseRepository
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import org.expenseApp.db.AppDatabase
import org.koin.core.module.dsl.createdAtStart
import org.koin.core.module.dsl.withOptions
import org.koin.dsl.module
import presentacion.ExpensesViewModel

fun appModule(appDatabase: AppDatabase) = module {
    single<HttpClient> { HttpClient() {install(ContentNegotiation) {json ()} } }
    single<ExpenseRepository> {ExpenseRepoImpl(appDatabase, get())}
    factory {ExpensesViewModel(get())}
}