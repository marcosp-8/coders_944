fun main(){

    println("Informe o valor do lado do quadrado: ")
    val lado : Int? = readln().toIntOrNull() ?: 1

    val area : Int? = lado?.times(lado)
    val perimetro : Int? = lado?.times(4)

    println("A área do quadrado é $area e seu perímetro é $perimetro.")

}