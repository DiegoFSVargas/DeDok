package org.example

class Halfling : Raca {
    override fun aplicarModificadores(personagem: Personagem) {
        personagem.destreza += 2
        personagem.constituicao += 1
        personagem.carisma += 1
    }
}
