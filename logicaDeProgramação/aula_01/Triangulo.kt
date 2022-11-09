fun main() {
    println("Digite o valor da base do triângulo: ")
    val base = readln().toIntOrNull() ?: 0
    println("Digite o valor da altura do triângulo: ")
    val altura = readln().toIntOrNull() ?: 0

    val area = (base.times(altura)).div(2)
    println ("A área do triângulo é $area.")
}