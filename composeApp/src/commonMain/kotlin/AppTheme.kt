import androidx.compose.foundation.shape.AbsoluteCutCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun AppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = MaterialTheme.colors.copy(primary = Color.Black),
        shapes = MaterialTheme.shapes.copy(
            small = AbsoluteCutCornerShape(0.dp),
            medium = AbsoluteCutCornerShape(0.dp),
            large = AbsoluteCutCornerShape(0.dp)
        )
    ) {
        content()
    }
}

@Composable
fun getColorsTheme(): DarkModeColors {
    val isDarkMode = false

    val Purple = Color.Black
    val Black = Color.Black
    val ColorExpenseItem = if(isDarkMode) Color(0xFF090808) else Color(0xff312519)//0xFFF1F1F1)
    val BackgroundColor = if (isDarkMode) Color(0xFF1Ec1C) else Color(0xfffdf6e4)
    val TextColor = if (isDarkMode) Color.Black else Color.White
    val AddIconColor = if (isDarkMode) Purple else Color.Black
    val colorArrowRound = if (isDarkMode) Purple else Color.Gray.copy(alpha = .2f)
    val colorEditText = if (isDarkMode) Color.White else Color.Black

    return DarkModeColors(
        purple = Purple,
        colorExpenseItem = ColorExpenseItem,
        backgroundColor = BackgroundColor,
        textColor = TextColor,
        addIconColor = AddIconColor,
        colorArrowRound = colorArrowRound,
        colorEditText = colorEditText
    )
}

data class DarkModeColors(
    val purple: Color,
    val colorExpenseItem: Color,
    val backgroundColor: Color,
    val textColor: Color,
    val addIconColor: Color,
    val colorArrowRound: Color,
    val colorEditText: Color
)