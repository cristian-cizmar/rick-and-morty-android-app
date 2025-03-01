package com.cristiancizmar.rickandmorty.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://rickandmortyapi.com/api/"

class CharactersRepository {

    private val api: CharactersService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CharactersService::class.java)
    }

    suspend fun getCharacters() = api.getCharacters()
}