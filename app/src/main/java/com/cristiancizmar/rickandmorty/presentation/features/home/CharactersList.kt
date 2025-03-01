package com.cristiancizmar.rickandmorty.presentation.features.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.cristiancizmar.rickandmorty.R
import com.cristiancizmar.rickandmorty.domain.Character

private val GRID_ITEM_WIDTH = 130.dp

@Composable
fun CharactersList(
    characters: List<Character>,
    onClickCharacter: (Character) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.home_title),
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(16.dp)
        )
        LazyVerticalGrid(
            modifier = Modifier.fillMaxWidth(),
            columns = GridCells.Adaptive(GRID_ITEM_WIDTH),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            itemsIndexed(
                items = characters,
                key = { _: Int, character: Character -> character.id }
            ) { _, character ->
                CharacterGridItem(
                    character,
                    modifier = Modifier.clickable(onClick = { onClickCharacter(character) })
                )
            }
        }
    }
}