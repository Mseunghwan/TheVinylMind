package com.example.thevinylmind.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.thevinylmind.ui.components.CalendarHeader
import com.example.thevinylmind.ui.components.EmotionsList
import com.example.thevinylmind.ui.components.VinylCalendar
import java.time.LocalDate

@Composable
fun MainScreen(
    modifier: Modifier = Modifier
) {
    var selectedDate by remember { mutableStateOf(LocalDate.now()) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        CalendarHeader(selectedDate)
        VinylCalendar(
            selectedDate = selectedDate,
            onDateSelect = { selectedDate = it }
        )
        EmotionsList(selectedDate)
    }
}