package pl.bzawadka.kotlinplayground

typealias Predicate<T> = (T) -> Boolean

fun main(args: Array<String>) {
    instantiateFunctionTypes()
    functionTypeWithReceiverType()
    functionUsingTypeAlias()
}

fun instantiateFunctionTypes() {
    println("*** FUNCTION TYPES ***")

    // The compiler can infer return type of the function
    val increment_lambdaSyntax = { i: Int -> i + 1 }
    println("next increment from 1 is      " + increment_lambdaSyntax(1))

    val increment_FunctionTypeSyntax: (Int) -> Int = { i -> i + 1 }
    println("next increment from 1 is      " + increment_FunctionTypeSyntax(1))

    val sum_lambdaSyntax = { x: Int, y: Int -> x + y }
    println("surely 2 + 3 equals        " + sum_lambdaSyntax(2, 3))

    val sum_FunctionTypeSyntax: (Int, Int) -> Int = {x, y -> x + y}
    println("surely 2 + 3 equals        " + sum_FunctionTypeSyntax(2, 3))

    //                                function type
    val differentReturnTypeFunction: (String) -> Int = { it.toIntOrNull() ?: 0 }
    println("do I look like a number?   " + differentReturnTypeFunction("42"))
}

fun functionTypeWithReceiverType() {
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

fun functionUsingTypeAlias() {
    val isPositive: Predicate<Int> = {it > 0}
    println("is 7 a positive number? " + isPositive(7))
}



















