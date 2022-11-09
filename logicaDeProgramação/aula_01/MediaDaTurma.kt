fun main() {
    println("Digite a primeira nota: ")
    var nota1 : Double = readln().toDouble()

    println("Digite a segunda nota: ")
    var nota2 : Double = readln().toDouble()

    println("Digite a terceira nota: ")
    var nota3 : Double = readln().toDouble()

    println("Digite a quarta nota: ")
    var nota4 : Double = readln().toDouble()

    println("Digite a quinta nota: ")
    var nota5 : Double = readln().toDouble()

    var total = nota1 + nota2 + nota3 + nota4+ nota5
    var media : Double = total / 5

    println("A média da turma é $media.")
}