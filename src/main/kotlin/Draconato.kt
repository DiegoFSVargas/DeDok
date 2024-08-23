package org.example

class Draconato : Raca {
    override fun aplicarModificadores(personagem: Personagem) {
        personagem.forca += 2
        personagem.carisma += 1
    }
}