package org.example

class Drow : Raca {
    override fun aplicarModificadores(personagem: Personagem) {
        personagem.carisma += 1
    }
}
