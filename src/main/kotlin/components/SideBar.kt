package components

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SideBar(
    reset: () -> Unit,
    startSort: (SortingAlgorithms) -> Unit
) {
    var selectedAlgorithm by remember { mutableStateOf(SortingAlgorithms.BUBBLE_SORT) }

    Column(
        modifier = Modifier.width(150.dp).fillMaxHeight().background(color = Color.Gray),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            modifier = Modifier.width(120.dp).height(60.dp).padding(top = 20.dp),
            onClick = reset,
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red)
        ) {
            Text("Reset")
        }

        Button(
            modifier = Modifier
                .width(120.dp)
                .height(60.dp)
                .padding(top = 20.dp),
            onClick = {
                selectedAlgorithm = SortingAlgorithms.BUBBLE_SORT
                reset()
            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = if (selectedAlgorithm == SortingAlgorithms.BUBBLE_SORT) Color.Yellow else Color.Transparent
            )
        ) {
            Text("Bubble")
        }

        Button(
            modifier = Modifier
                .width(120.dp)
                .height(60.dp)
                .padding(top = 5.dp),
            onClick = {
                selectedAlgorithm = SortingAlgorithms.SELECTION_SORT
                reset()
            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = if (selectedAlgorithm == SortingAlgorithms.SELECTION_SORT) Color.Yellow else Color.Transparent
            ),
        ) {
            Text("Selection")
        }

        Button(
            modifier = Modifier
                .width(120.dp)
                .height(60.dp)
                .padding(top = 5.dp),
            onClick = {
                selectedAlgorithm = SortingAlgorithms.INSERTION_SORT
                reset()
            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = if (selectedAlgorithm == SortingAlgorithms.INSERTION_SORT) Color.Yellow else Color.Transparent
            ),
        ) {
            Text("Insertion")
        }

        Button(
            modifier = Modifier
                .width(120.dp)
                .height(60.dp)
                .padding(top = 5.dp),
            onClick = {
                selectedAlgorithm = SortingAlgorithms.MERGE_SORT
                reset()
            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = if (selectedAlgorithm == SortingAlgorithms.MERGE_SORT) Color.Yellow else Color.Transparent
            )
        ) {
            Text("Merge")
        }

        Button(
            modifier = Modifier
                .width(120.dp)
                .height(60.dp)
                .padding(top = 5.dp),
            onClick = {
                selectedAlgorithm = SortingAlgorithms.QUICK_SORT
                reset()
            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = if (selectedAlgorithm == SortingAlgorithms.QUICK_SORT) Color.Yellow else Color.Transparent
            )
        ) {
            Text("Quick")
        }
        Spacer(modifier = Modifier.height(40.dp))

        Button(
            modifier = Modifier.width(120.dp).height(60.dp),
            onClick = { startSort(selectedAlgorithm) },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Green
            )
        ) {
            Text("Sort")
        }
    }
}

@[Preview Composable]
fun PreviewSideBar() {
    SideBar(
        reset = {},
        startSort = {}
    )
}

enum class SortingAlgorithms {
    BUBBLE_SORT, SELECTION_SORT, INSERTION_SORT, MERGE_SORT, QUICK_SORT
}