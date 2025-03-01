package com.cristiancizmar.rickandmorty.domain

import kotlinx.serialization.Serializable

@Serializable
data class CharactersResponse(
    val results: List<Character>
)