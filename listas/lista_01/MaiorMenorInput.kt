package logicaDeProgramacao.listas.lista_01

fun main() {
    var valor : Int
    var maior = Integer.MIN_VALUE
    var menor = Integer.MAX_VALUE

    for (i in 1..10) {
        println("Digite o valor $i: ")
        valor = readln().toIntOrNull() ?: 0

        if (valor > maior) maior = valor
        if (valor < menor) menor =  valor
    }

    println("O maior valor informado é $maior.")
    println("O menor valor informado é $menor.")

}