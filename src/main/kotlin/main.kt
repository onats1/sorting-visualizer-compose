import androidx.compose.material.MaterialTheme
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Compose for Desktop",
        state = rememberWindowState(
            size = DpSize(800.dp, 600.dp)
        ),
    ) {
        MaterialTheme {
            ColumnContainer(
                maxWidth = 800,
                array = generateRandomList()
            )
        }
    }
}