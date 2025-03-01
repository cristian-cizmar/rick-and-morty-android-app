package com.cristiancizmar.rickandmorty.presentation.features.details

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cristiancizmar.rickandmorty.R
import com.cristiancizmar.rickandmorty.domain.Character
import com.cristiancizmar.rickandmorty.presentation.common.TextWithLabel

@Composable
fun CardCharacterDetails(
    character: Character,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
        shape = MaterialTheme.shapes.large
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .wrapContentSize(Alignment.Center)
                ) {
                    TextWithLabel(character.species, stringResource(R.string.species))
                }
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .wrapContentSize(Alignment.Center)
                ) {
                    TextWithLabel(character.gender, stringResource(R.string.gender))
                }
            }
            Row(modifier = Modifier.fillMaxWidth()) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .wrapContentSize(Alignment.Center)
                ) {
                    TextWithLabel(character.status, stringResource(R.string.status))
                }
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .wrapContentSize(Alignment.Center)
                ) {
                    TextWithLabel(
                        character.type.ifBlank { stringResource(R.string.type_default) },
                        stringResource(R.string.type)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun CardCharacterDetailsPreview() {
    CardCharacterDetails(Character.getMockCharacter1())
}