package presentacion

import domain.ExpenseRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import model.Expense
import model.ExpenseCategory
import moe.tlaster.precompose.viewmodel.ViewModel
import moe.tlaster.precompose.viewmodel.viewModelScope

data class ExpensesUiState(
    val expenses: List<Expense> = emptyList(),
    val total: Double = 0.0
)

class ExpensesViewModel(private val repo: ExpenseRepository) : ViewModel() {
    //Implementamos el ViewModel porque no solicita nada, el viewmodel se tiene que adaptar a cambios

    private val _iuState = MutableStateFlow(ExpensesUiState())
    val uiState = _iuState.asStateFlow()
    private val allExpense = repo.getAllExpenses()

    init {
        getAllExpenses()
    }

    private fun getAllExpenses(){
        viewModelScope.launch {
            _iuState.update { state ->
                state.copy(expenses = allExpense, total = allExpense.sumOf { it.amount })
            }
        }
    }

    fun addExpense(expense: Expense){
        viewModelScope.launch {
            repo.addExpense(expense)
            _iuState.update {state ->
                state.copy(expenses = allExpense, total = allExpense.sumOf { it.amount })
            }
        }
    }

    fun editExpense(expense: Expense){
        viewModelScope.launch {
            repo.editExpense(expense)
            updateState()
        }
    }

    fun deleteExpense(expense: Expense){
        viewModelScope.launch {
            repo.deleteExpense(expense)
            updateState()
        }
    }
    private fun updateState() {
        _iuState.update {state ->
            state.copy(expenses = allExpense, total = allExpense.sumOf { it.amount })
        }
    }

    fun getExpenseWithID(id: Long): Expense {
        return allExpense.first{it.id == id}
    }

    fun getCategories(): List<ExpenseCategory>{
        return repo.getCategories()
    }
}