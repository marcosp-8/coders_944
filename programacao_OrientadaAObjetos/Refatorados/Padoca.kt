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

            println("Valor total R$%.2f \nDeseja aplicar um cupom?(S/N)".format(total))
            val querDesconto = readln().uppercase()
            if (querDesconto == "S") desconto(total)
            else println("Valor total R$%.2f".format(total))
        }
    } while (finalizarCompra != "S")
}

fun ePadoca() {
    println("Bem Vindo à padaria E-Padoca!")
    do {
        println(categorias)

        var categoria: Int
        try {
            readln().toInt().also { categoria = it }
        } catch (e: NumberFormatException) {
            categoria = 0
        }

        when (categoria) {
            PAES -> selecionaProduto(menuPaes, paes)
            SALGADOS -> selecionaProduto(menuSalgados, salgados)
            DOCES -> selecionaProduto(menuDoces, doces)
            FINALIZAR -> Unit
            else -> println("Insira uma opção válida!\n")
        }
    } while (categoria != FINALIZAR)
}

fun selecionaProduto(menuSelecionado: String, produtos: List<Produto>) {
    do {
        println(menuSelecionado)
        var produtoSelecionado: Int
        try {
            readln().toInt().also { produtoSelecionado = it }
        } catch (e: NumberFormatException) {
            produtoSelecionado = 0
        }

        for ((i, produto) in produtos.withIndex()) {
            if (i.inc() == produtoSelecionado) {
                selecionaQuantidadeDoProduto(produto)
                break
            }
        }
    } while (produtoSelecionado != 0)
}

fun selecionaQuantidadeDoProduto(produto: Produto) {
    println("Digite a quantidade:")
    var quantidade: Int
    try {
        readln().toInt().also { quantidade = it }
    } catch (e: NumberFormatException) {
        println("Será considerado 0.")
        quantidade = 0
    }
    val totalItem = quantidade * produto.preco
    val item =
        itemComanda(produto = produto.nome, quantidade = quantidade, valorUnitario = produto.preco, total = totalItem)
    itensComanda.add(item)
    total += totalItem
}

fun itemComanda(
    produto: String,
    quantidade: Int,
    valorUnitario: Double,
    total: Double,
): String =
    "${itensComanda.size.inc()}$LINHA$produto$LINHA$quantidade${LINHA}R$%.2f${LINHA}R$%.2f".format(valorUnitario, total)

fun desconto(valorTotal: Double) {
    var cupom: String
    var valorComDesconto = 0.00

    do {
        println("Digite o seu cupom: ")
        cupom = readln().uppercase()

        when (cupom) {
            "5PADOCA" -> valorComDesconto = valorTotal - (valorTotal * 0.05)
            "10PADOCA" -> valorComDesconto = valorTotal - (valorTotal * 0.10)
            "5OFF" -> valorComDesconto = valorTotal - 5.00
            else -> println("Cupom inválido. Tente novamente.")
        }
    } while (cupom != "5PADOCA" &&
        cupom != "10PADOCA" &&
        cupom != "5OFF"
    )

    println("O valor total com o desconto do cupom é R$%.2f".format(valorComDesconto))
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

class Produto(
    var nome: String,
    var preco: Double
) {
    fun formatarParaBR(preco: Double): String {
        return "%.2f".format(preco)
    }
}

/*---Seção de pães---*/

val paoFrances = Produto(nome = "Pão Francês", preco = 0.60)
val paoDeLeite = Produto(nome = "Pão de Leite", preco = 0.40)
val paoDeMilho = Produto(nome = "Pão de Milho", preco = 0.50)

val menuPaes: String
    get() = """
        1 - ${paoFrances.nome}...........R$${paoFrances.formatarParaBR(paoFrances.preco)}
        2 - ${paoDeLeite.nome}..........R$${paoDeLeite.formatarParaBR(paoDeLeite.preco)}
        3 - ${paoDeMilho.nome}..........R$${paoDeMilho.formatarParaBR(paoDeMilho.preco)}
        0 - Voltar
    """.trimIndent()

val paes: List<Produto>
    get() = listOf(
        paoFrances,
        paoDeLeite,
        paoDeMilho
    )

/*---Seção de Salgados---*/

val coxinha = Produto(nome = "Coxinha", preco = 5.00)
val esfiha = Produto(nome = "Esfiha", preco = 6.00)
val paoDeQueijo = Produto(nome = "Pão de Queijo", preco = 3.00)

val menuSalgados: String
    get() = """
        1 - ${coxinha.nome}...........R$${coxinha.formatarParaBR(coxinha.preco)}
        2 - ${esfiha.nome}..........R$${esfiha.formatarParaBR(esfiha.preco)}
        3 - ${paoDeQueijo.nome}..........R$${paoDeQueijo.formatarParaBR(paoDeQueijo.preco)}
        0 - Voltar
    """.trimIndent()

val salgados: List<Produto>
    get() = listOf(
        coxinha,
        esfiha,
        paoDeQueijo
    )

/*---Seção de Doces---*/

val carolina = Produto(nome = "Carolina", preco = 1.50)
val pudim = Produto(nome = "Pudim", preco = 4.00)
val brigadeiro = Produto(nome = "Brigadeiro", preco = 2.00)

val menuDoces: String
    get() = """
            1 - ${carolina.nome}...........R$${carolina.formatarParaBR(carolina.preco)}
            2 - ${pudim.nome}..........R$${pudim.formatarParaBR(pudim.preco)}
            3 - ${brigadeiro.nome}..........R$${brigadeiro.formatarParaBR(brigadeiro.preco)}
            0 - Voltar
        """.trimIndent()

val doces: List<Produto>
    get() = listOf(
        carolina,
        pudim,
        brigadeiro
    )

private const val LINHA = ".........."

const val cabecalhoComanda: String = "$LINHA$LINHA Comanda E-Padoca $LINHA$LINHA"

val itensComanda: MutableList<String> = mutableListOf()
var total: Double = 0.0