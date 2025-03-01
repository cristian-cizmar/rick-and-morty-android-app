package com.cristiancizmar.rickandmorty.presentation.navigation

import android.net.Uri
import android.os.Bundle
import androidx.navigation.NavType
import com.cristiancizmar.rickandmorty.domain.Character
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

// Helps us navigate with custom parameters

object CustomNavType {

    val CharacterType = object : NavType<Character>(
        isNullableAllowed = false
    ) {
        override fun get(bundle: Bundle, key: String): Character? {
            return Json.decodeFromString(bundle.getString(key) ?: return null)
        }

        override fun parseValue(value: String): Character {
            return Json.decodeFromString(Uri.decode(value))
        }

        override fun serializeAsValue(value: Character): String {
            return Uri.encode(Json.encodeToString(value))
        }

        override fun put(bundle: Bundle, key: String, value: Character) {
            bundle.putString(key, Json.encodeToString(value))
        }
    }
}