fun main() {

    fun hello(){
        println("Hello Kams!")
    }

    hello()

    fun anotherFunc():String{
        return "Hahaha"
    }

    println(anotherFunc())

    fun someFunc(name: String):String{
        return "$name is the ultimate lord"
    }
    println(someFunc("Poojit"))

    fun someFunc2(name:String ="John Doe"):String{
        return "Hello $name"
    }

    println(someFunc2())
    println(someFunc2("Chokli"))

    fun addNumbers (num1: Int , num2: Int):Int{
        return num1 + num2
    }
    fun addNumberShort (num1: Int, num2: Int) = num1+num2 //shorthand like in JS
    println(addNumbers(2,3))
    println(addNumberShort(59,10))

    fun greeter(dogAge: Int, dogName: String ) = "Hello $dogName. You are $dogAge years old"
    println(greeter(2, "Lemmi"))
}