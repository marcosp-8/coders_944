package logicaDeProgramacao.listas.lista_01

fun main() {
    val lista: MutableList<Int> = mutableListOf()
    for (i in 0..14) {
        println("Digite o valor ${i + 1}: ")
        lista.add(i, readln().toIntOrNull() ?: 0)
    }
    println("\nOs valores inseridos em ordem inversa são: \n${lista.asReversed()}")
}