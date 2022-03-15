fun main() {
    class VideoGame(val name: String, val releaseYear: Int)  {


    }

    var doomTheGame = VideoGame("Doom",2000)

    class someClass{
        var name:String
        var age: Int

        init {
            name = "John Doe"
            age = 0
        }
    }

    class anotherClass {
        var name: String
        var age: Int

        constructor(name:String, age:Int){
            this.name = name
            this.age = age
        }
        //Overloading
        constructor(){
            this.name="John Doe"
            this.age = 0
        }

        fun personInfo():String{
            return "age: $age ; Name: $name"
        }
    }

    var something = anotherClass()
    println(something.personInfo())

    var something2 = anotherClass("Rhea", 22)
    println(something2.personInfo())
}