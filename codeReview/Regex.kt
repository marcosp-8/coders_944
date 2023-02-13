package tecnicasDeProgramacao.codeReview

fun validarNome (nome : String) {
    val pattern = Regex("[bc]at(wo)?man", RegexOption.IGNORE_CASE)
    println(pattern.matches(nome))
}

fun validaCPF (cpf : String) {
    val patternFormat = Regex("[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}\\-[0-9]{2}")

    println("CPF valid : ${cpf.matches(patternFormat)}")
}

fun validaCNPJ (cnpj : String) {
    val patternFormat = Regex("[0-9]{2}\\.[0-9]{3}\\.[0-9]{3}\\/[0-9]{4}\\-[0-9]{2}")

    println("CNPJ valid : ${cnpj.matches(patternFormat)}")
}

fun validaCash (dinero : String) {
    val patternFormat = Regex("[RU]S?[$][0-9][,.][0-9]{2}")

    println("Coin valid : ${patternFormat.matches(dinero)}")
}

fun validaEmail (email : String) {
    val patternFormat = Regex("[a-zA-Z0-9._+$*/#%&]+@[a-z]+\\.com(.br)?")

    println("Email valid : ${email.matches(patternFormat)}")
}

fun validaTelefone (numero : String) {
    val patternFormat = Regex("[(][0-9]{2}[)]\\s9[0-9]{4}\\-[0-9]{4}")

    println("Number valid : ${numero.matches(patternFormat)}")
}

fun validaCPFeCNPJ (doc : String) {
    val patternFormat = Regex("[0-9]{2,3}\\.[0-9]{3}\\.[0-9]{3}[/-][0-9]{2,4}(-[0-9]{2})?")

    println("CNPJ valid : ${doc.matches(patternFormat)}")
}

fun validaSenha (senha : String) {
    val patternFormat = Regex("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~\$^+=<>]).{8,20}\$")

    println("Password valid: ${senha.matches(patternFormat)}")
}

fun main() {
    validaSenha("")
}