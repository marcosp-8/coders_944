package logicaDeProgramacao.listas.lista_01

fun main() { //errado
    println("Digite um número inteiro como limite: ")
    val n = readln().toIntOrNull() ?: 100

    val listaPrimos: MutableList<Int> = mutableListOf()
    var contador = 0
    for(i in 1..n) {
        if (i == 2 || i == 3 || (i % 2 == 1 && i != 1)) {
            listaPrimos.add(contador, i)
            contador++
        }
    }
    println(listaPrimos)
}