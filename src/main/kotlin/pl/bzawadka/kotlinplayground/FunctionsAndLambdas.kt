package pl.bzawadka.kotlinplayground

fun main(args: Array<String>) {
    instantiateFunctionTypes()
    functionWithReceiverType()
}

fun instantiateFunctionTypes() {
    println("*** FUNCTION TYPES ***")

    // The compiler can infer the function type
    // val oneArgumentFunction: (Int) -> Int = { i: Int -> i + 1 }
    val oneArgumentFunction = { i: Int -> i + 1 }
    println("next number from 1 is      " + oneArgumentFunction(1))

    val twoArgumentsFunction = { a: Int, b: Int -> a + b }
    println("surely 2 + 3 equals        " + twoArgumentsFunction(2, 3))

    val differentReturnTypeFunction: (String) -> Int = { it.toIntOrNull() ?: 0 }
    println("do I look like a number?   " + differentReturnTypeFunction("42"))
}

fun functionWithReceiverType() {
    // A.(B) -> C represents functions that can be called on a
    // receiver object of A
    // with a parameter of B
    // and return a value of C

    //           receiver.(param) -> return value
    val repeatFun: String.(Int) -> String = { times -> this.repeat(times) }
    val twoParameters: (String, Int) -> String = repeatFun
    val longDefinitionOfAbove: (String, Int) -> String = { input: String, times: Int -> input.repeat(times)}

    fun runTransformation(f: (String, Int) -> String): String {
        return f("hello", 3)
    }

    val result = runTransformation(repeatFun)

    println("run me 3 times             $result")
}

