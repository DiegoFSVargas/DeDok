package org.example

import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val pontosDisponiveis = 27
    val personagem = Personagem()

    println("\n#######  BEM-VINDO AO D&D!!! #######")
    println("Vamos começar a criar seu personagem para embarcarmos nesta mágica aventura?")

    println("\nPrimeiro, comece escolhendo a raça do seu personagem! Escolha com sabedoria...")
    println("1. Anão")
    println("2. Humano")
    println("3. Draconato")
    println("4. Meio-orc")
    println("5. Elfo")
    println("6. Halfling")
    println("7. Gnomo")
    println("8. Tiefling")
    println("9. Drow")

    val escolha = scanner.nextInt()

    val raca: Raca = when (escolha) {
        1 -> Anao()
        2 -> Humano()
        3 -> Draconato()
        4 -> MeioOrc()
        5 -> Elfo()
        6 -> Halfling()
        7 -> Gnomo()
        8 -> Tiefling()
        9 -> Drow()
        else -> {
            println("Está raça não existe!.")
            return
        }
    }

    val tabelaCusto = mapOf(
        8 to 0,
        9 to 1,
        10 to 2,
        11 to 3,
        12 to 4,
        13 to 5,
        14 to 7,
        15 to 9
    )

    var pontosRestantes = pontosDisponiveis

    println("Agora você tem $pontosDisponiveis pontos para distribuir entre as habilidades.")
    println("Tabela de custos de pontos de habilidade:")
    tabelaCusto.forEach { (valor, custo) -> println("Valor: $valor --- Custo: $custo pontos") }

    fun aumentarHabilidade(nomeHabilidade: String, valorInicial: Int): Int {
        var valorHabilidade = valorInicial
        while (true) {
            println("Você tem $pontosRestantes pontos restantes ainda.")
            println("Escolha um valor para $nomeHabilidade (mínimo 8 e o máximo 15):")
            val novoValor = scanner.nextInt()

            val custo = tabelaCusto[novoValor] ?: continue
            val custoIncremento = custo - tabelaCusto[valorHabilidade]!!

            if (novoValor in 8..15 && custoIncremento <= pontosRestantes) {
                pontosRestantes -= custoIncremento
                valorHabilidade = novoValor
                break
            } else {
                println("Valor inválido ou pontos insuficientes. Tente novamente.")
            }
        }
        return valorHabilidade
    }

    personagem.forca = aumentarHabilidade("Força", personagem.forca)
    personagem.destreza = aumentarHabilidade("Destreza", personagem.destreza)
    personagem.constituicao = aumentarHabilidade("Constituição", personagem.constituicao)
    personagem.inteligencia = aumentarHabilidade("Inteligência", personagem.inteligencia)
    personagem.sabedoria = aumentarHabilidade("Sabedoria", personagem.sabedoria)
    personagem.carisma = aumentarHabilidade("Carisma", personagem.carisma)

    if (pontosRestantes > 0) {
        println("Você ainda tem $pontosRestantes de pontos que não utilizou.")
    } else {
        println("Você utilizou todos os seus pontos!!!")
    }

    raca.aplicarModificadores(personagem)

    println("Escolha um nome para o seu personagem:")
    scanner.nextLine()
    personagem.nome = scanner.nextLine()

    println("Esses são os pontos finais das habilidades do ${personagem.nome}, com a aplicação de pontos extras raciais já aplicados.")
    println("Parabéns, você fez ótimas escolhas!!!")
    println("Força: ${personagem.forca}")
    println("Destreza: ${personagem.destreza}")
    println("Constituição: ${personagem.constituicao}")
    println("Inteligência: ${personagem.inteligencia}")
    println("Sabedoria: ${personagem.sabedoria}")
    println("Carisma: ${personagem.carisma}")
}
