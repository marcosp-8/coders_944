package programacaoOrientada_aObjetos.aula_01

//
//class Pessoa {
//
//    fun conversar(pessoa: Pessoa?) {
//
//    }
//
//}

class Funcionário(//construtor primário
    val nome: String,
    val id: Int,
    val cpf: String,
    val sobrenome: String,
    val cargo: String,
    val salario: Double
) {
    constructor(nome: String, sobrenome: String, cpf: String): this(nome, 0, cpf, sobrenome, "", 0.0)
}

fun main() {

}