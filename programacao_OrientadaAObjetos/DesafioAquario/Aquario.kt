package programacaoOrientada_aObjetos.aula_03.Desafio

import kotlin.random.Random

fun main() {
    intro()
}

fun intro() {

    println("====_Bem vindo ao seu Aquário!_====")
    do {
        println(introOptions)

        var userChoice: Int
        try {
            readln().toInt().also { userChoice = it }
        } catch (e: NumberFormatException) {
            userChoice = 5
        }

        when(userChoice) {
            1 -> addPeixe()
            2 -> showListOfPeixes()
            3 -> feedPeixes()
            4 -> cleanAquario()
            5 -> println("Insira uma opção válida!")
        }
    } while(userChoice != CLOSE_SYSTEM)

}

fun addPeixe() {

    if (healthyAquario) {
        println("Adicione um peixe ao seu aquário!")

        print("Nome: ")
        val name = readln()
        print("Cor: ")
        val color = readln()

        print(sizeOptions)
        var sizeInput: Int
        try {
            readln().toInt().also { sizeInput = it }
        } catch (e: NumberFormatException) {
            sizeInput = 0
        }

        var sizeOutput = ""
        when (sizeInput) {
            1 -> sizeOutput = "Pequeno"
            2 -> sizeOutput = "Médio"
            3 -> sizeOutput = "Grande"
            0 -> sizeOutput = "?"
        }

        listOfPeixes.add(
            Peixe(
                nameOfPeixe = name,
                colorOfPeixe = color,
                sizeOfPeixe = sizeOutput
            )
        )

        if (listOfPeixes.size % healthyDivider == 0) healthyAquario = false

    } else println("Limpe seu aquário antes de adicionar mais peixes.")
}

fun showListOfPeixes() {
    for (i in listOfPeixes) println(i.toString())
}

fun feedPeixes() {
    if (listOfPeixes.isEmpty()) println("Não há peixes a serem alimentados!")
    else {
        var lucky = Random.nextInt(1, 31)
        when(lucky) {
            in 1..10 -> println("Falha ao alimentar peixes :/")
            in 11..20 -> println("${Random.nextInt(1, listOfPeixes.size)} peixes foram alimentados!")
            in 21..30 -> println("Todos os peixes foram alimentados!!")
            31 -> println("ESSA NÃO!!  Os peixes decidiram fugir do seu aquário!!!!")
        }
    }
}

fun  cleanAquario() {
    if (healthyAquario) println("Seu aquário já está limpo!")
    else {
        healthyAquario = true
        println("Seu aquário acabou de ser limpo!")
    }
}

data class Peixe(
    val nameOfPeixe: String,
    val colorOfPeixe: String,
    val sizeOfPeixe: String
)

val listOfPeixes = mutableListOf<Peixe>()

var healthyAquario: Boolean = true

var healthyDivider: Int = 3

val introOptions: String = """
    Digite a opção desejada: 
    
    1 - Adicionar Peixe
    2 - Listar Peixes
    3 - Alimentar Peixes
    4 - Limpar Aquário
    0 - Fechar Sistema
    
""".trimIndent()

const val CLOSE_SYSTEM = 0

val sizeOptions: String = """
    Escolha uma opção correspondente ao tamanho do peixe:
    
    1 - Pequeno
    2 - Médio
    3 - Grande
    
""".trimIndent()