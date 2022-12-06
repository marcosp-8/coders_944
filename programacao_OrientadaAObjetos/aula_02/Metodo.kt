package programacaoOrientada_aObjetos.aula_02

import programacaoOrientada_aObjetos.aula_01.Funcionário

class Empresa(
    val nome: String,
    val cnpj: String,
    val segmento: String,
    val listaDeFuncionarios: MutableList<Funcionário> = mutableListOf()
) {
    /*Quando uma função é definida dentro do escopo de uma classe, torna-se
    * um método.*/

    fun inserirFuncionario(funcionário: Funcionário) {

    }
}