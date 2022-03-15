fun main() {

    var i = 20

//    i = null - can't do this

    var i1: Int? = 7
    i1 = null //this works

    var newNum = !!i1 //unwrapping nullable

    var Foods = mapOf("Palak Paneer" to 1, "pulav" to 2)
    print(Foods["Prawns"]) //nullable

    var someStr: String? ="Kams"
    someStr = null



}