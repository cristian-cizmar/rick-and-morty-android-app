package com.cristiancizmar.rickandmorty.presentation.features.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.cristiancizmar.rickandmorty.R
import com.cristiancizmar.rickandmorty.domain.Character

@Composable
fun CharacterGridItem(
    character: Character,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        shape = MaterialTheme.shapes.medium
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = rememberAsyncImagePainter(character.image),
                contentDescription = stringResource(R.string.character_image),
                modifier = Modifier
                    .size(80.dp)
                    .padding(end = 8.dp)
                    .clip(MaterialTheme.shapes.small),
                contentScale = ContentScale.Crop
            )
            Text(
                text = character.name,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }
    }
}

@Preview
@Composable
fun CharacterGridItemPreview() {
    CharacterGridItem(
        Character.getMockCharacter1(),
        Modifier.padding(8.dp)
    )
}