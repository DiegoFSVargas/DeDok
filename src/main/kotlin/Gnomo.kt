package org.example

class Gnomo : Raca {
    override fun aplicarModificadores(personagem: Personagem) {
        personagem.constituicao += 1
        personagem.destreza += 1
        personagem.inteligencia += 2
    }
}
