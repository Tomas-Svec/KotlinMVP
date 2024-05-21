package data

import model.Expense
import model.ExpenseCategory

object ExpenseManager {

    private var currentId = 1L

    val fakeExpenseList = mutableListOf(
        Expense(
           id = currentId++,
            amount = 70.0,
            category = ExpenseCategory.Hogar,
            description = "Weekly boy"
        ),
        Expense(
            id = currentId++,
            amount = 12.0,
            category = ExpenseCategory.SNACKS,
            description = "Doritos"
        ),
        Expense(
            id = currentId++,
            amount = 80.0,
            category = ExpenseCategory.CAR,
            description = "A1"
        ),
        Expense(
            id = currentId++,
            amount = 456.0,
            category = ExpenseCategory.PARTY,
            description = "Party weeeee"
        ),
        Expense(
            id = currentId++,
            amount = 120.0,
            category = ExpenseCategory.HOUSE,
            description = "Cleaning"
        ),
        Expense(
            id = currentId++,
            amount = 25.0,
            category = ExpenseCategory.OTHER,
            description = "Servicios"
        ),
    )

    fun addNewExpense(expense: Expense){
        fakeExpenseList.add(expense.copy(id = currentId++))
    }

    fun deleteExpense(expense: Expense){
        val index = fakeExpenseList.indexOfFirst {
            it.id == expense.id
        }
        fakeExpenseList.removeAt(index)
    }

    fun editExpensee(expense: Expense){
        val index = fakeExpenseList.indexOfFirst {
            it.id == expense.id
        }
        if (index != -1){
            fakeExpenseList[index] = fakeExpenseList[index].copy(
                amount = expense.amount,
                category = expense.category,
                description = expense.description
            )
        }
    }

    fun getCateegories(): List<ExpenseCategory>{
        return listOf(
            ExpenseCategory.Hogar,
            ExpenseCategory.PARTY,
            ExpenseCategory.SNACKS,
            ExpenseCategory.COFFE,
            ExpenseCategory.CAR,
            ExpenseCategory.HOUSE,
            ExpenseCategory.OTHER,
        )
    }
}

