package com.cristiancizmar.rickandmorty.domain

import kotlinx.serialization.Serializable

@Serializable
data class Character(
    val id: Int,
    val name: String,
    val image: String,
    val status: String,
    val species: String,
    val gender: String,
    val type: String
) {

    companion object {

        fun getMockCharacter1() = Character(1, "Rick", "", "Alive", "Human", "Male", "")

        fun getMockCharacter2() = Character(2, "Morty", "", "Alive", "Human", "Male", "")
    }
}