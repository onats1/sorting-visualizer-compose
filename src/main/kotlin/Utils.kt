
fun generateRandomList(): List<Int> {
    val list = mutableListOf<Int>()
    for (i in 0 until 20) {
        val number = (5..500).random()
        list.add(number)
    }
    return list
}