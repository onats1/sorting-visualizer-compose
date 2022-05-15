package algorithms

import kotlinx.coroutines.delay

suspend fun mergeSort(list: List<Int>, updateUi: (MutableList<Int>) -> Unit) {
    val array = list.toMutableList()
    if (array.size <= 1) return
    val auxArray = array.toMutableList()
    mergeSortHelper(array, 0, array.size - 1, auxArray, updateUi)
    updateUi(array)
}

suspend fun mergeSortHelper(mainArray: MutableList<Int>, startIdx: Int, endIdx: Int, auxArray: MutableList<Int>, updateUi: (MutableList<Int>) -> Unit) {
    if (startIdx == endIdx) return
    val middleIdx = (startIdx + endIdx) / 2
    mergeSortHelper(auxArray, startIdx, middleIdx, mainArray, updateUi)
    mergeSortHelper(auxArray, middleIdx + 1, endIdx, mainArray, updateUi)
    merge(mainArray, startIdx, middleIdx, endIdx, auxArray, updateUi)
    delay(10)
    updateUi(auxArray)
}

suspend fun merge(mainArray: MutableList<Int>, startIdx: Int, middleIdx: Int, endIdx: Int, auxArray: List<Int>, updateUi: (MutableList<Int>) -> Unit) {
    var k = startIdx
    var i = startIdx
    var j = middleIdx + 1
    while (i <= middleIdx && j <= endIdx) {
        if (auxArray[i] <= auxArray[j]) {
            mainArray[k++] = auxArray[i++]
            delay(10)
            updateUi(auxArray.toMutableList())
        } else {
            mainArray[k++] = auxArray[j++]
            delay(10)
            updateUi(auxArray.toMutableList())
        }
    }
    while (i <= middleIdx) {
        mainArray[k++] = auxArray[i++]
        delay(10)
        updateUi(auxArray.toMutableList())
    }
    while (j <= endIdx) {
        mainArray[k++] = auxArray[j++]
        updateUi(auxArray.toMutableList())
    }
}