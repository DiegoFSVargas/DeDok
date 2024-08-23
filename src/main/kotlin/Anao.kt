package org.example

class Anao : Raca {
    override fun aplicarModificadores(personagem: Personagem) {
        personagem.forca += 2
        personagem.constituicao += 2
        personagem.sabedoria += 2
    }
}