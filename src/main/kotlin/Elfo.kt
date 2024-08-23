package org.example

class Elfo : Raca {
    override fun aplicarModificadores(personagem: Personagem) {
        personagem.destreza += 2
        personagem.inteligencia += 1
        personagem.sabedoria += 1
        personagem.carisma += 2
    }
}