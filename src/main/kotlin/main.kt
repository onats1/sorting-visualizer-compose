import algorithms.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import components.SideBar
import components.SortingAlgorithms
import kotlinx.coroutines.launch

const val SCREEN_WIDTH = 1200
const val SCREEN_HEIGHT = 600

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Sorting Visualizer",
        state = rememberWindowState(
            size = DpSize(SCREEN_WIDTH.dp, SCREEN_HEIGHT.dp)
        ),
    ) {
        val list = mutableStateOf(listOf<Int>()).apply { this.value = generateRandomList() }
        val coroutineScope = rememberCoroutineScope()

        MaterialTheme {
            Row(
                modifier = Modifier.fillMaxSize()
            ) {
                SideBar(
                    reset = {
                        list.value = generateRandomList()
                    },
                    startSort = { selectedAlgo ->
                        when (selectedAlgo) {
                            SortingAlgorithms.SELECTION_SORT -> {
                                coroutineScope.launch {
                                    selectionSort(list.value) {
                                        list.value = listOf()
                                        list.value = it
                                    }
                                }
                            }
                            SortingAlgorithms.INSERTION_SORT -> {
                                coroutineScope.launch {
                                    insertionSort(list.value) {
                                        list.value = listOf()
                                        list.value = it
                                    }
                                }
                            }
                            SortingAlgorithms.MERGE_SORT -> {
                                coroutineScope.launch {
                                    mergeSort(list.value) {
                                        list.value = listOf()
                                        list.value = it
                                    }
                                }
                            }
                            SortingAlgorithms.BUBBLE_SORT -> {
                                coroutineScope.launch {
                                    bubbleSort(list.value) {
                                        list.value = listOf()
                                        list.value = it
                                    }
                                }
                            }
                        }
                    }
                )
                Spacer(modifier = Modifier.width(10.dp))
                ColumnContainer(
                    maxWidth = SCREEN_WIDTH - 160,
                    array = list.value
                )
            }
        }
    }
}