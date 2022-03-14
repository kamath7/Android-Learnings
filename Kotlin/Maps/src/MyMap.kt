fun main() {
    var myDogs = mapOf("Lemi" to 2, "Kharadi" to 1, "Cobra" to 14)

    print(myDogs["Lemi"])

    //map is immutable
    var foods = mutableMapOf("Lazy" to 5)

    var mangaloreWords = mapOf("GTFO" to "Get The F*** out" , "WTF" to "What the Frick")

    println(mangaloreWords["GTFO"])
}