package com.cristiancizmar.rickandmorty.presentation.features.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.cristiancizmar.rickandmorty.R
import com.cristiancizmar.rickandmorty.domain.Character

@Composable
fun DetailsScreen(
    character: Character,
    modifier: Modifier = Modifier
) {
    Scaffold(modifier = modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(horizontal = 16.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = character.name,
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(16.dp),
                color = MaterialTheme.colorScheme.primary
            )
            Image(
                painter = rememberAsyncImagePainter(character.image),
                contentDescription = stringResource(R.string.character_image),
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .clip(MaterialTheme.shapes.large),
                contentScale = ContentScale.Crop
            )
            CardCharacterDetails(character)
        }
    }
}

@Preview
@Composable
fun DetailsScreenPreview() {
    DetailsScreen(Character.getMockCharacter1())
}