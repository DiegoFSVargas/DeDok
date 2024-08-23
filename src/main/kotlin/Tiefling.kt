package org.example

class Tiefling : Raca {
    override fun aplicarModificadores(personagem: Personagem) {
        personagem.inteligencia += 1
        personagem.carisma += 2
    }
}
