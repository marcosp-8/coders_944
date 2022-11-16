package logicaDeProgramacao.listas.lista_01

fun main() {
    println("Digite um número inteiro: ")
    val n: Int = readln().toIntOrNull() ?: 1

    println("Tabuada do $n: \n")
    for (i in 1..10) println("$n x $i = " + (n * i))
}