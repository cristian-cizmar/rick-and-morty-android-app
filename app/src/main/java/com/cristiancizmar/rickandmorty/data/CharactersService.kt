package com.cristiancizmar.rickandmorty.data

import com.cristiancizmar.rickandmorty.domain.CharactersResponse
import retrofit2.http.GET

interface CharactersService {

    @GET("character")
    suspend fun getCharacters(): CharactersResponse
}