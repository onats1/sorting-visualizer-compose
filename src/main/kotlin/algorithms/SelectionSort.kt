package algorithms

import kotlinx.coroutines.delay

suspend fun selectionSort(arr: List<Int>, updateUi: (MutableList<Int>) -> Unit){
    val mutableList = arr.toMutableList()
    for (i in 0 until mutableList.size) {
        var lowest = i
        for (j in i+1 until mutableList.size) {
            if (mutableList[j] < mutableList[lowest]) {
                lowest = j
            }
        }
        if (i != lowest) {
            //Swap
            val temp = mutableList[i]
            mutableList[i] = mutableList[lowest]
            mutableList[lowest] = temp
            delay(20)
            updateUi(mutableList)
        }
    }
}
