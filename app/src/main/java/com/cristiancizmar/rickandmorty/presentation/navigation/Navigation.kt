package com.cristiancizmar.rickandmorty.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.cristiancizmar.rickandmorty.domain.Character
import com.cristiancizmar.rickandmorty.presentation.features.details.DetailsScreen
import com.cristiancizmar.rickandmorty.presentation.features.home.HomeScreen
import kotlinx.serialization.Serializable
import kotlin.reflect.typeOf

@Serializable
data object HomeRoute

@Serializable
data class DetailsRoute(
    val character: Character
)

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = HomeRoute
    ) {
        composable<HomeRoute> {
            HomeScreen(
                onClickCharacter = { character ->
                    navController.navigate(DetailsRoute(character))
                })
        }
        composable<DetailsRoute>(
            typeMap = mapOf(typeOf<Character>() to CustomNavType.CharacterType)
        ) {
            val arguments = it.toRoute<DetailsRoute>()
            DetailsScreen(arguments.character)
        }
    }

}