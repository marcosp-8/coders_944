import java.math.BigDecimal

fun main() {
    println("Hello World!")

    println("Digite seu nome: ")
    val nome = readln()

    //val é imutável!

    println("Digite sua idade: ")
    var idade: Int? = readln().toIntOrNull() ?: 0
    //a interrogação após o tipo permite o valor null.
    //para isso, existe o Elvis operator '?:' - uma espécie de operador que, caso nulo, entrega algum valor setado.

    println("Nome: ${nome.uppercase()};\nIdade: $idade;")

    var saldo: BigDecimal = BigDecimal.valueOf(648.88)
    println("Saldo: $saldo.")
}