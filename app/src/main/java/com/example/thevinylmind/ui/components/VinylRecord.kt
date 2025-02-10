package com.example.thevinylmind.ui.components
import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer


@Composable
fun VinylRecord(
    modifier: Modifier = Modifier
) {
    val infiniteTransition = rememberInfiniteTransition(label = "vinyl_rotation")
    val rotation by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(6000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "vinyl_rotation"
    )

    Box(
        modifier = modifier
            .graphicsLayer {
                rotationZ = rotation
            }
    ) {
        // LP Record background
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawCircle(
                color = Color.Black,
                radius = size.minDimension / 2
            )
            // Grooves
            for (i in 1..20) {
                drawCircle(
                    color = Color.DarkGray,
                    radius = (size.minDimension / 2) * (1 - i * 0.03f),
                    style = Stroke(width = 1f)
                )
            }
            // Center hole
            drawCircle(
                color = Color.DarkGray,
                radius = size.minDimension * 0.05f
            )
        }
    }
}
