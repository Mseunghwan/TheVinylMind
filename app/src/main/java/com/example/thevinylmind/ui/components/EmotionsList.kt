package com.example.thevinylmind.ui.components
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.time.LocalDate

@Composable
fun EmotionsList(selectedDate: LocalDate) {
    var showEmotionDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        // Today's message
        Text(
            text = "오늘 LP에 새길 감정을 선택해주세요",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(vertical = 8.dp)
        )

        // Vinyl Record Animation
        VinylRecord(
            modifier = Modifier
                .size(200.dp)
                .align(Alignment.CenterHorizontally)
        )

        // Add Emotion Button
        Button(
            onClick = { showEmotionDialog = true },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary
            )
        ) {
            Text("감정 새기기")
        }
    }

    if (showEmotionDialog) {
        EmotionSelectionDialog(
            onDismiss = { showEmotionDialog = false },
            onEmotionSelected = { emotion ->
                // Handle emotion selection
                showEmotionDialog = false
            }
        )
    }
}
