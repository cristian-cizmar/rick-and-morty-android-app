package com.cristiancizmar.rickandmorty.presentation.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cristiancizmar.rickandmorty.R

@Composable
fun ErrorTextWithButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.general_error),
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(16.dp)
        )
        Button(
            onClick = onClick,
            modifier = Modifier.padding(16.dp)
        ) {
            Text(stringResource(R.string.try_again))
        }
    }
}

@Preview
@Composable
fun ErrorTextWithButtonPreview() {
    Surface(
        color = MaterialTheme.colorScheme.background
    ) {
        ErrorTextWithButton({})
    }
}