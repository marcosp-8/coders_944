package logicaDeProgramacao.avaliacao

fun main() {
    println("=====Bem vindo ao i-Stock=====\n")

    iStock()

    println("Obrigado por utilizar nosso programa!")
}

fun iStock() {
    contentValidator(pecas)

    do {
        println(opcoes)
        var selecao = 0
        try {
            readln().toInt().also { selecao = it }
        } catch (e: NumberFormatException) {
            println("\nValor inválido. Digite uma das opções disponíves.")
        }

        when (selecao) {
            addItem -> addItemToStock(pecas)
            editItem -> editItem(pecas)
            showStock -> showStockAvailable(pecas)
            showAll -> showFullStock(pecas)
        }
    } while (selecao != close)
}

fun contentValidator(lista: MutableList<Item>) {
    if (lista.isEmpty()) {
        println("Ainda não há itens cadastrados no sistema :/ \nAdicione novo item.\n")
        addItemToStock(lista)
    } else return
}

fun addItemToStock(lista: MutableList<Item>) {
    do {
        print("Digite o nome da peça: ")
        val nome = readln()
        print("Digite sua quantidade: ")
        var quantidade: Int
        try {
            readln().toInt().also { quantidade = it }
        } catch (e: java.lang.NumberFormatException) {
            println("Valor informado inválido. Será tratado como 0.")
            quantidade = 0
        }
        while (quantidade < 0 || quantidade > 999) {
            println("Quantidade inválida! Insira novo valor: ")
            quantidade = readln().toInt()
        }

        lista.add(lista.size, Item(nome, quantidade))

        println("\nDeseja adicionar outro item? (S/N)")
        val newItem = readln().uppercase()

    } while (newItem != "N")
}

fun editItem(lista: MutableList<Item>) {
    do {
        println("Digite o ID do item que deseja editar: ")
        val id = readln().toInt()

        println(
            """ 
                O que deseja editar?
                
                1 - NOME
                2 - QUANTIDADE
            """.trimIndent()
        )

        when (readln().toInt()) {
            1 -> {
                print(
                    """
                         Nome atual: ${lista[id - 1].name}
                         Insira o novo nome: """.trimIndent()
                )

                lista[id - 1] = Item(name =readln(), lista[id - 1].quant)
            }

            2 -> {
                print(
                    """ 
                        Quantidade atual: ${lista[id - 1].quant}
                        Insira a nova quantidade: """.trimIndent()
                )
                lista[id - 1] = Item(lista[id - 1].name, quant = (readln().toInt()))
            }
        }
        println("Deseja editar outro item? (S/N)")
        val newEdit = readln().uppercase()

    } while (newEdit != "N")
}

fun showStockAvailable(lista: MutableList<Item>) {
    for (i in 0..lista.size.dec()) {
        if (lista[i].quant >= 1) println("#%03d ".format(i + 1) + "| ${lista[i].name} | ${lista[i].quant} peças")
    }
}

fun showFullStock(lista: MutableList<Item>) {
    for (i in 0..lista.size.dec()) {
        println("#%03d ".format(i + 1) + "| ${lista[i].name} | ${lista[i].quant} peças")
    }
}

class Item(val name: String, val quant: Int)

val pecas: MutableList<Item> = mutableListOf()

val opcoes = """
    
    O que deseja?
    
    1 - ADICIONAR ITEM
    2 - EDITAR ITEM
    3 - EXIBIR ITENS EM ESTOQUE
    4 - EXIBIR TODOS OS ITENS
    5 - FECHAR SISTEMA
    
""".trimIndent()

const val addItem = 1
const val editItem = 2
const val showStock = 3
const val showAll = 4
const val close = 5
