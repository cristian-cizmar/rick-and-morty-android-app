package com.cristiancizmar.rickandmorty.presentation.features.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.cristiancizmar.rickandmorty.domain.Character
import com.cristiancizmar.rickandmorty.presentation.common.ErrorTextWithButton
import com.cristiancizmar.rickandmorty.util.State
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HomeScreen(
    onClickCharacter: (Character) -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state = viewModel.state

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.Center
        ) {
            when (state) {
                is State.Success -> {
                    CharactersList(state.data, onClickCharacter)
                }

                State.Loading -> {
                    CircularProgressIndicator()
                }

                is State.Error -> {
                    ErrorTextWithButton(
                        onClick = { viewModel.onAction(HomeViewModel.HomeEvent.LoadCharacters) }
                    )
                }
            }
        }
    }
}