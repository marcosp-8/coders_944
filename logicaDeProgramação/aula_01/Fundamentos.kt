import java.math.BigDecimal

fun main() {
    println("Hello World!")

    println("Digite seu nome: ")
    val nome = readln()

    //val é imutável! ou seja, não é possível alterar o valor que foi atribuído a ela
    //var pode receber diversos valores de diversos tipos diferentes durante o runtime

    println("Digite sua idade: ")
    var idade: Int? = readln().toIntOrNull() ?: 0
    //a interrogação após o tipo permite o valor null.
    //para isso, existe o Elvis operator '?:' - uma espécie de operador que, caso nulo, entrega algum valor setado.

    println("Nome: ${nome.uppercase()};\nIdade: $idade;")

    var saldo: BigDecimal = BigDecimal.valueOf(648.88)
    println("Saldo: $saldo.")
}
