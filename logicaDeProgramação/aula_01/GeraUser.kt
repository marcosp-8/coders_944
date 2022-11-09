package logicaDeProgramação

fun main() {

    println("Digite seu nome: ")
    val nome = readln()
    println("Digite seu sobrenome: ")
    val sobrenome = readln()
    println("Digite o ano em que nasceu: ")
    val ano = readln()

    val nickNome = nome.lowercase().substring(0,2)
    val nickSobrenome = sobrenome.reversed().lowercase()
    val nickAno = ano.takeLast(2)

    val nick = nickNome.plus(nickSobrenome.plus(nickAno))
    println("Nick gerado: $nick")

}