/** Essa função pega o último elemento como pivô e coloca ele no lugar certo.
* E coloca todos os elementos que são menores do que o pivô para a esquerda
* e todos os elementos que são maiores do que o pivô para a direita*/
fun partition(arr: Array<Int>, low: Int, high: Int): Int {
    val pivo = arr[high]

    // Index do menor elemento.
    // A variável "i" sempre guardará a posição do elemento que ainda deve ser trocado de lugar.
    var i = low - 1

    for (j in low until high) {
        if (arr[j] <= pivo) {
            i++

            val temp = arr[i]
            arr[i] = arr[j]
            arr[j] = temp
        }
    }

    val temp = arr[i + 1]
    arr[i + 1] = arr[high]
    arr[high] = temp
    return i + 1
}

fun quickSort(arr: Array<Int>, low: Int, high: Int) {
    var low = low
    var high = high
    val stack = IntArray(high - low + 1)

    var top = -1

    //Coloca os valores "ini" e "fim" na pilha. E muda o valor do topo da pilha
    stack[++top] = low
    stack[++top] = high

    // Desempilha da pilha enquanto ela não estiver vazia
    while (top >= 0) {
        high = stack[top--]
        low = stack[top--]

        val p = partition(arr, low, high)

        // Se houver elementos no lado esquerdo do pivô. Coloque o lado esquerdo na pilha
        if (p - 1 > low) {
            stack[++top] = low
            stack[++top] = p - 1
        }
        // Se houver elementos no lado direito do pivô. Coloque o lado direito na pilha
        if (p + 1 < high) {
            stack[++top] = p + 1
            stack[++top] = high
        }
    }
}
