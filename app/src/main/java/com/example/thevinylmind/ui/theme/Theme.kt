package com.example.vinylmind.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.thevinylmind.ui.theme.Typography

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF6F44FF),
    secondary = Color(0xFF4E4E4E),
    background = Color(0xFF121212),
    surface = Color(0xFF1E1E1E),
    onBackground = Color.White,
    onSurface = Color.White
)

@Composable
fun VinylMindTheme(content: @Composable () -> Unit) {
    androidx.compose.material3.MaterialTheme(
        colorScheme = DarkColorScheme,
        typography = Typography,
        content = content
    )
}