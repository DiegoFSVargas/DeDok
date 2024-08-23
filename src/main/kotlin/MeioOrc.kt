package org.example

class MeioOrc : Raca {
    override fun aplicarModificadores(personagem: Personagem) {
        personagem.forca += 2
        personagem.constituicao += 1
    }
}