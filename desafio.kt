// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String, val matricula: String) {
    override fun toString(): String {
        return "Usuario: $nome | matricula: $matricula"
    }
}

data class ConteudoEducacional(var nome: String, val duracao: Int = 60) {
    override fun toString(): String {
        return "Conteudo: $nome | duracao: $duracao"
    }
}

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val nivel: Nivel)  {
    val inscritos = mutableListOf<Usuario>()

    fun matricular(vararg usuario: Usuario) {
        inscritos.addAll(usuario)
    }

    override fun toString(): String {
        return """
        Formacao: $nome
        Conteudos: $conteudos
        Nivel: $nivel
        Alunos Matriculados: $inscritos
            """.trimIndent()
    }
}

fun geradorMat() : String {
    return (100..1000).random().toString()
}

fun main() {
    val rodrigo = Usuario("Rodrigo", geradorMat())
    val jessica = Usuario("Jessica", geradorMat())
    val rosana = Usuario("Rosana", geradorMat())
    val isabella = Usuario("Isabella", geradorMat())


    val conteudoAndroid = ConteudoEducacional("Kotlin Syntax, Android Studio", 120)
    val conteudoUI = ConteudoEducacional("Figma, Photoshop ", 60)
    val conteudoTechLeader = ConteudoEducacional("Gestao de Pessoas, Arquitetura de Projetos", 120)
    val conteudoJunior = ConteudoEducacional("Logica de programacao, Algoritmo, POO", 60)


    val formacaoAndroid = Formacao("Android Developer", listOf(conteudoJunior, conteudoAndroid), Nivel.INTERMEDIARIO)
    val formacaoUX = Formacao("UX Developer", listOf(conteudoUI), Nivel.BASICO)
    val formacaoTechLeader = Formacao("Tech Leader", listOf(conteudoTechLeader), Nivel.DIFICIL)
    val formacaoDevJunior = Formacao("Junior Developer", listOf(conteudoJunior), Nivel.BASICO)


    formacaoAndroid.matricular(rodrigo)
    formacaoDevJunior.matricular(rodrigo, isabella)
    formacaoTechLeader.matricular(rosana)
    formacaoUX.matricular(jessica)


    println("\n=======================================\n")
    println(formacaoAndroid)
    println("\n=======================================\n")
    println(formacaoDevJunior)
    println("\n=======================================\n")
    println(formacaoUX)
    println("\n=======================================\n")
    println(formacaoTechLeader)





}
