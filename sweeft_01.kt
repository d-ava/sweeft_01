fun main() {

//test for 1
    println(isPalindrome("Aiveri irevia"))


//test for 2
    println("min split = ${minSplit(9)}")


//test for 3
    val li = listOf<Int>(1, 2, 3, 4, 5)
    println(notContains(li))

//test for 4

    val sequence = "(()())"
    println(isProperly(sequence))

//test for 5
    println(countVariants(121))


//test for 6
    val myDS = MyDataStructure()

    myDS.insert(23)
    myDS.insert(2)
    myDS.insert(200)
    myDS.insert(8)
    myDS.remove(200)
    myDS.remove(29)

    println("printing ${myDS.printList()}")





}


//1
fun isPalindrome(text: String): Boolean {

    return text.lowercase() == text.reversed().lowercase()
}

//2

fun minSplit(amount: Int): Int {
    var tempAmount = amount
    var count = 0
    val listOfCoins = listOf<Int>(50, 20, 10, 5, 1)
    var n = 0
    while (tempAmount > 0) {

        if (tempAmount >= listOfCoins[n]) {
            tempAmount -= listOfCoins[n]
            println(listOfCoins[n])

            count++
        } else {
            n++
        }
    }

    return count
}


//3
fun notContains(list: List<Int>): Int {
    var num = 1

    while (num < list.size + 1) {
        if (num !in list) {
            break
        }
        num++
    }
    return num
}

//4

fun isProperly(sequence: String): Boolean {
    var result = true
    var tempSequence = sequence

    while (true) {
        if ("()" in tempSequence) {
            tempSequence = tempSequence.replace("()", "")

        } else if (tempSequence.isEmpty()) {
            break
        } else {
            result = false
            break
        }
    }
    return result
}

//5
fun countVariants(stairsCount: Int): Int {
    var a = 1
    var b = 1
    var next: Int
    for (i in 1 until stairsCount) {
        next = a + b
        a = b
        b = next
    }
    return b
}

//6

class MyDataStructure {
    private val map = mutableMapOf<Int, Int>()
    private val list = mutableListOf<Int>()

    fun insert(num: Int) {
        if (num in map) {
            println("number $num already in list")
        } else {
            list.add(num)
            map[num] = list.size - 1
            println("number $num added to the list")
            println("new list $list")
        }
    }


    fun remove(num: Int) {


        if (num in map) {
            if (list.size == 1) {

                map.clear()
                list.clear()
            } else {

                val thisIndex: Int = map[num]!!
                val lastIndex: Int = list.size - 1
                if (thisIndex == lastIndex) {

                    list.removeLast()
                } else {

                    list[thisIndex] = list[lastIndex]

                    list.removeLast()

                    map[list[thisIndex]] = thisIndex
                }

                map.remove(num)
                println("number $num removed from the list")
                println("new list $list")
            }
        }else{
            println("number $num not in list")
        }
    }

    fun printList():List<Int>{
        return list
    }

}

