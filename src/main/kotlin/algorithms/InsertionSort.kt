package algorithms

import kotlinx.coroutines.delay

suspend fun insertionSort(arr: List<Int>, updateUi: (MutableList<Int>) -> Unit) {
    val mutableList = arr.toMutableList()
    for (count in 1 until mutableList.size) {
        val item = mutableList[count]
        var i = count
        while (i > 0 && item < mutableList[i - 1]) {
            mutableList[i] = mutableList[i - 1]
            i -= 1
            updateUi(mutableList)
            delay(20)
        }
        mutableList[i] = item
        updateUi(mutableList)
        delay(20)
    }
}