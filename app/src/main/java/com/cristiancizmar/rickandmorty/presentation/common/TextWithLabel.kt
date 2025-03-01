package com.cristiancizmar.rickandmorty.presentation.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cristiancizmar.rickandmorty.R

@Composable
fun TextWithLabel(
    text: String,
    label: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.labelMedium.copy(
                fontWeight = FontWeight.Bold
            ),
            color = MaterialTheme.colorScheme.onPrimaryContainer
        )
        Text(
            modifier = Modifier.padding(top = 4.dp),
            text = text,
            lineHeight = MaterialTheme.typography.bodyLarge.fontSize.times(1.2f),
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onPrimaryContainer,
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
fun TextWithLabelPreview() {
    Surface(
        color = MaterialTheme.colorScheme.background
    ) {
        TextWithLabel(
            stringResource(R.string.app_name),
            stringResource(R.string.type)
        )
    }
}