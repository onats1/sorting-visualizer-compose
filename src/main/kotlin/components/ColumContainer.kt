import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ColumnContainer(
    modifier: Modifier = Modifier.fillMaxSize(),
    maxWidth: Int,
    array: List<Int>
) {
    val numberOfSpacings = array.size - 1
    val spacingWidth = 3
    val totalSpacingWidth = numberOfSpacings * spacingWidth
    val columnWidth = (maxWidth - totalSpacingWidth) / array.size
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.Bottom
    ) {
        array.forEach { number ->
            ListColumn(columnWidth.dp, number.dp)
            Spacer(modifier = Modifier.width(3.dp))
        }
    }
}

@[Composable Preview]
fun PreviewColumnContainer() {

}