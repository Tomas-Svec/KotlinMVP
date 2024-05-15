import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Apps
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import data.ExpenseManager
import data.ExpenseRepoImpl
import data.TitleTopBarTypes


import kotlinmultiplatform.composeapp.generated.resources.Res
import kotlinmultiplatform.composeapp.generated.resources.compose_multiplatform
import moe.tlaster.precompose.PreComposeApp
import moe.tlaster.precompose.flow.collectAsStateWithLifecycle
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.path
import moe.tlaster.precompose.navigation.rememberNavigator
import moe.tlaster.precompose.viewmodel.viewModel
import navigation.Navigation
import presentacion.ExpensesUiState
import presentacion.ExpensesViewModel
import ui.ExpensesScreen

@Composable
fun App() {
    PreComposeApp {

        val colors = getColorsTheme()

        AppTheme {
            val navigator = rememberNavigator()
            val titleTopBar = getTitleTopAppBar(navigator)
            val isEditOrAddExpenses = titleTopBar != TitleTopBarTypes.DASHBOARD.value
            Scaffold(
                modifier = Modifier.fillMaxSize(),//Toma toda la pantalla
                topBar = {
                    TopAppBar(elevation = 0.dp,
                        title = {
                            Text(
                                text = titleTopBar,
                                fontSize = 25.sp,
                                color = colors.textColor
                            )
                        },
                        navigationIcon = {
                            if (isEditOrAddExpenses) {
                                IconButton(
                                    onClick = {
                                        navigator.popBackStack()
                                    }
                                ) {
                                    Icon(
                                        modifier = Modifier.padding(start = 16.dp),
                                        imageVector = Icons.Default.ArrowBack,
                                        tint = colors.textColor,
                                        contentDescription = "Back Arrow Iconk"
                                    )
                                }
                            } else {
                                Icon(
                                    modifier = Modifier.padding(start = 16.dp),
                                    imageVector = Icons.Default.Apps,
                                    tint = colors.textColor,
                                    contentDescription = "Dashboard Icon"
                                )
                            }

                        }, backgroundColor = colors.backgroundColor
                    )
                },
                    floatingActionButton = {
                        if(!isEditOrAddExpenses){
                            FloatingActionButton(
                                modifier = Modifier.padding(8.dp),
                                onClick = {
                                    navigator.navigate("/addExpenses")
                                },
                                shape = RoundedCornerShape(50),
                                backgroundColor = colors.addIconColor,
                                contentColor = colors.backgroundColor
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Add,
                                    tint = Color.White,
                                    contentDescription = "Floating icon"
                                )
                            }
                        }
                    }
                ) {
                Navigation(navigator)
            }
        }
    }
}

@Composable
fun getTitleTopAppBar(navigator: Navigator): String {
    var titleTopBar = TitleTopBarTypes.DASHBOARD

    val isOnAddExpenses =
        navigator.currentEntry.collectAsState(null).value?.route?.route.equals("/addExpenses/{id}?")
    if (isOnAddExpenses) {
        titleTopBar = TitleTopBarTypes.ADD
    }

    val isOnEditExpense = navigator.currentEntry.collectAsState(null).value?.path<Long>("id")
    isOnEditExpense?.let {
        titleTopBar = TitleTopBarTypes.EDIT
    }

    return titleTopBar.value
}