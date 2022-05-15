package algorithms

import kotlinx.coroutines.delay

suspend fun bubbleSort(array: List<Int>, updateUi: (MutableList<Int>) -> Unit){
    var noSwaps: Boolean
    val list = array.toMutableList()
    for (i in list.size downTo 0) {
        noSwaps = true
        for (j in 0 until i - 1) {
            if (list[j] > list[j + 1]) {
                val lower = list[j]
                list[j] = list[j + 1]
                list[j + 1] = lower
                updateUi(list)
                delay(20)
                noSwaps = false
            }
        }
        if (noSwaps) break
    }
}