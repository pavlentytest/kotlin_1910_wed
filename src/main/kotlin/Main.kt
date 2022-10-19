fun main(args: Array<String>) {

    val zz = { println("Hello") }
    zz()

    val zz2: () -> Unit = {println(777)}

    { println("111")}()

    val m1 = { message: String -> println(message)}
    m1("555")

    val m2 = {x: Int, y: Int -> println(x+y)}
    m2(5,6)
    m2(10,11)

    val sum = {x:Int, y:Int -> val result = x+y; println("$x + $y = $result")}
    val sum2 = {x:Int, y:Int ->
        val result = x+y
        println("$x + $y = $result")
    }
    // передаю Лямбда
    doOperation(3,4,{a: Int, b: Int -> a-b})

    doOperation(3,4) { a, b -> a - b }
    // передаю аноним функцию
    doOperation(3,4,fun(x: Int, y:Int) = x*x*y)
    


    val ivan = Person("N23423", "Ivan")
    val petr = Person(48483,"Petr")
    ivan.typeOfId()
    petr.typeOfId()
    ivan.checkId("Nsdf4")
    petr.checkId(48483)

    var day1: DayOfWeek<String, String> = DayOfWeek("monday","1")
    var day2: DayOfWeek<String, Int> = DayOfWeek("monday",2)

    // анонимная функция без параметров
    val test = fun() = println("123")
    test()

    val test2 = fun(x: Int, y: Int): Int = x * y
    val result2 = test2(5,6)

    val test3 = fun(x: Int, y: Int) = println("$x $y")
    test3(10,20)
    // анонимная функция как аргумент
    example(8,9,fun(x1: Int, x2: Int) = println("$x1 $x2"))
    example2(8,9,fun(x1: Int, x2: Int) = Math.pow(x1.toDouble(),x2.toDouble()))

    // возвращение анонимной функции как результата
    var rr = bigFunc(1)
    println(rr(1,2))




}



fun doOperation(x: Int, y: Int, op: (Int, Int) -> Int) {
    val result = op(x,y)
    println(result)
}




fun bigFunc(key: Int): (Int, Int) -> Int {
    when(key) {
        1 -> return fun(x: Int, y: Int): Int = 2 * x - 2 * y
        2 -> return fun(x: Int, y: Int): Int = 100 - 2*(x-y)
        else -> return fun(x: Int, y: Int): Int = 1000*x*y
    }
}
fun example(x: Int, y: Int, test: (Int, Int) -> Unit) {
    test(555,666)
}

fun example2(x: Int, y: Int, test: (Int, Int) -> Double) {
    test(5,6)
}






class DayOfWeek<K,V>(val source: K, val target: V)
class Person<T>(val id: T, val name: String) {
    fun typeOfId() {
        when(id) {
            is Int -> println("id is an Integer")
            is String -> println("id is a String")
        }
    }
    fun checkId(_id: T) {
        if(id == _id) {
            println("valid")
        } else {
            println("invalid")
        }
    }
}