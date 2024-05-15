package previews

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import data.ExpenseManager
import presentacion.ExpensesUiState
import ui.AllExpensesHeader
import ui.ExpenseAmount
import ui.ExpensesItem
import ui.ExpensesScreen
import ui.ExpensesTotalHeader

@Preview(showBackground = true)
@Composable
fun ExpensesTotalHeaderPreview() {
    Box(modifier = Modifier.padding(16.dp)) {
        ExpensesTotalHeader(total = 1028.8)
    }
}

@Preview(showBackground = true)
@Composable
fun AllExpensesPreview() {
    AllExpensesHeader()
}

@Preview(showBackground = true)
@Composable
fun ExpensesItemPreview() {
    Box(modifier = Modifier.padding(16.dp)) {
        ExpensesItem(expense = ExpenseManager.fakeExpenseList[0], onExpenseClick = {})
    }
}

@Preview(showBackground = true)
@Composable
private fun ExpenseScreenPreview() {
    ExpensesScreen(
        uiState = ExpensesUiState(
            expenses = ExpenseManager.fakeExpenseList,
            total = 10.50
        ), onExpenseClick = {})
}


@Preview(showBackground = true)
@Composable
fun ExpenseAmountPreview() {
   // ExpenseAmount(priceContent = 12.0, onPriceChange = {}, keyboardController = LocalSoftwareKeyboardController)
}