package logicaDeProgramacao.listas.lista_01

fun percentual(candidato: Int, totalidade: Int) : Int {
    return (candidato * 100) / totalidade
}

fun main() {
    println("Informe o número total de eleitores: ")
    val total: Int = readln().toIntOrNull() ?: 10
    var voto: String

    var a = 0
    var b = 0
    var c = 0

    for (i in 1..total) {
        println("Voto do eleitor $i: ")
        voto = readln().lowercase()

        while (voto != "a" && voto != "b" && voto != "c") {
            println("Informe um candidato válido: ")
            voto = readln().lowercase()
        }

        when(voto) {
            "a" -> a++
            "b" -> b++
            "c" -> c++
        }
    }

    println("Candidato A: $a votos (${percentual(a, total)}%)")
    println("Candidato B: $b votos (${percentual(b, total)}%)")
    println("Candidato C: $c votos (${percentual(c, total)}%)")

}