package algorithms.bigonotation

fun printFirst1(items: List<String>){
    println(items[0]) // Big O(1)
}

fun printFirst2(items: List<String>){
    println(items[0]) // Big O(1)

    for (item in items){ // Big O(n) n = quantity of items
        println(item) // Big O(1)
    }

    for (i in items.size -1 downTo 0){ // Big O(n) n = quantity of items
        println(items[i])  // Big O(1)
    }
}

fun printFirst3(items: List<String>){
    println(items[0]) // Big O(1)

    for (item in items){ // Big O(n) n = quantity of items
        println(item) // Big O(1)
    }
}

//fun main(){
//    printFirst2(listOf("Reginaldo","Ribeiro","Filho")
//}

fun findElement(matrix: Array<IntArray>, target: Int): Boolean {
    val rows = matrix.size
    val column = matrix[0].size

    for (i in 0 until rows) {
        for(j in 0 until rows){
            if(matrix[i][j] == target){
                return true
            }
        }
    }

    return false
}

fun main () {
    val matrix = arrayOf(
        intArrayOf (1, 2, 3, 4),
        intArrayOf(5, 6, 7, 8),
        intArrayOf(9, 10, 11, 12)
    )
    val target = 7
    val result = findElement (matrix, target)
    println("The element $target was found in the matrix? $result")
}