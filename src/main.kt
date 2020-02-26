import java.lang.NumberFormatException

fun main(args: Array<String>) {
//    val array = intArrayOf(-20, 20, 53, 2, 1, 123, 90, 0)
//    val n = 8
    try {
        val array = readLine()!!.split(' ').map { it.toInt() }.toTypedArray()

        val n = array.size

        quickSort(array, 0, n - 1)

        for (i in 0 until n) {
            print(array[i].toString() + " ")
        }

    } catch (e : NumberFormatException) {
        println("Somente números inteiros")
    }

}