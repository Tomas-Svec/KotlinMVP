import data.DataBaseDriverFactoy
import di.appModule
import org.expenseApp.db.AppDatabase
import org.koin.core.context.startKoin


//fun MainViewController() = ComposeUIViewController { App(CrossConfigDevice()) }

fun initKoin() {
    startKoin{
        modules(appModule(AppDatabase.invoke(DataBaseDriverFactoy().createDriver())))
    }.koin
}