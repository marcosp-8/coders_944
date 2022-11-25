package logicaDeProgramacao.avaliacao

fun main() {
    do {
        var finalizarCompra = "S"
        ePadoca()

        if (itensComanda.isEmpty()) {
            println("Deseja mesmo finalizar a compra? (S/N)")
            finalizarCompra = readln().uppercase()
        } else {
            println(cabecalhoComanda)
            itensComanda.forEach { item -> println(item) }

            println("Valor total R$$total \nDeseja aplicar um cupom?(S/N)")
            val querDesconto = readln()
            if (querDesconto == "S") desconto(total)

            else println("Valor total R$$total")
        }
    } while (finalizarCompra != "S")
}

fun ePadoca() {
    println("Bem Vindo à padaria E-Padoca!")
    do {
        println(categorias)

        val categoria = readln().toInt()

        when (categoria) {
            PAES -> selecionaProduto(menuPaes, paes)
            SALGADOS -> selecionaProduto(menuSalgados, salgados)
            DOCES -> selecionaProduto(menuDoces, doces)
            FINALIZAR -> Unit
            else -> println("Insira uma opção válida!\n")
        }
    } while (categoria != FINALIZAR)
}

fun selecionaProduto( menuSelecionado: String, produtos: List<Pair<String, Double>> ) {
    do {
        println(menuSelecionado)
        val produtoSelecionado = readln().toInt()

        for ((i, produto) in produtos.withIndex()) {
            if (i.inc() == produtoSelecionado) {
                selecionaQuantidadeDoProduto(produto)
                break
            }
        }
    } while (produtoSelecionado != 0)
}

fun selecionaQuantidadeDoProduto(produto: Pair<String, Double>) {
    println("Digite a quantidade:")
    val quantidade = readln().toInt()
    val totalItem = quantidade * produto.second
    val item =
        itemComanda(produto = produto.first, quantidade = quantidade, valorUnitario = produto.second, total = totalItem)
    itensComanda.add(item)
    total += totalItem
}

fun itemComanda(
    produto: String,
    quantidade: Int,
    valorUnitario: Double,
    total: Double,
): String = "${itensComanda.size.inc()}$LINHA$produto$LINHA$quantidade$LINHA$valorUnitario${LINHA}R$$total"

fun desconto(valorTotal : Double) {
    var cupom : String
    var valorComDesconto = 0.00

    do {
        println("Digite o seu cupom: ")
        cupom = readln().uppercase()

        when(cupom) {
            "5PADOCA" -> valorComDesconto = valorTotal - (valorTotal * 0.05)
            "10PADOCA" -> valorComDesconto = valorTotal - (valorTotal * 0.10)
            "5OFF" -> valorComDesconto = valorTotal - 5.00
            else -> println("Cupom inválido. Tente novamente.")
        }
    } while (cupom != "5PADOCA" &&
             cupom != "10PADOCA" &&
             cupom != "5OFF"
    )

    println("O valor total com o desconto do cupom é R$$valorComDesconto")
}

private const val PAES = 1
private const val SALGADOS = 2
private const val DOCES = 3
private const val FINALIZAR = 0

val categorias = """
    Digite a opção desejada no Menu:
    1..................Pães
    2..............Salgados
    3.................Doces
    0......Finalizar compra
""".trimIndent()

/*---Seção de pães---*/

const val produtoPaoFrances = "Pão Francês"
const val produtoPaoDeLeite = "Pão de Leite"
const val produtoPaoDeMilho = "Pão de Milho"

const val valorPaoFrances = 0.60
const val valorPaoDeLeite = 0.40
const val valorPaoDeMilho = 0.50

val menuPaes = """
        1 - $produtoPaoFrances...........R$$valorPaoFrances
        2 - $produtoPaoDeLeite..........R$$valorPaoDeLeite
        3 - $produtoPaoDeMilho..........R$$valorPaoDeMilho
        0 - Voltar
    """.trimIndent()

val paes: List<Pair<String, Double>> = listOf(
    Pair(produtoPaoFrances, valorPaoFrances), // index 0
    Pair(produtoPaoDeLeite, valorPaoDeLeite), // index 1
    Pair(produtoPaoDeMilho, valorPaoDeMilho), // index 2
)

/*---Seção de Salgados---*/

const val produtoCoxinha = "Coxinha"
const val produtoEsfiha = "Esfiha"
const val produtoPaoDeQueijo = "Pão de Queijo"

const val valorCoxinha = 5.00
const val valorEsfiha = 6.00
const val valorPaoDeQueijo = 3.00

val menuSalgados = """
        1 - $produtoCoxinha...........R$$valorCoxinha
        2 - $produtoEsfiha..........R$$valorEsfiha
        3 - $produtoPaoDeQueijo..........R$$valorPaoDeQueijo
        0 - Voltar
    """.trimIndent()

val salgados : List<Pair<String, Double>> = listOf(
    Pair(produtoCoxinha, valorCoxinha),
    Pair(produtoEsfiha, valorEsfiha),
    Pair(produtoPaoDeQueijo, valorPaoDeQueijo)
)

/*---Seção de Doces---*/

const val produtoCarolina = "Carolina"
const val produtoPudim = "Pudim"
const val produtoBrigadeiro = "Brigadeiro"

const val valorCarolina = 1.50
const val valorPudim = 4.00
const val valorBrigadeiro = 2.00

val menuDoces = """
        1 - $produtoCarolina...........R$$valorCarolina
        2 - $produtoPudim..........R$$valorPudim
        3 - $produtoBrigadeiro..........R$$valorBrigadeiro
        0 - Voltar
    """.trimIndent()

val doces: List<Pair<String, Double>> = listOf(
    Pair(produtoCarolina, valorCarolina),
    Pair(produtoPudim, valorPudim),
    Pair(produtoBrigadeiro, valorBrigadeiro)
)

private const val LINHA = ".........."

const val cabecalhoComanda : String =  "$LINHA$LINHA Comanda E-Padoca $LINHA$LINHA"

val itensComanda: MutableList<String> = mutableListOf()
var total: Double = 0.0
