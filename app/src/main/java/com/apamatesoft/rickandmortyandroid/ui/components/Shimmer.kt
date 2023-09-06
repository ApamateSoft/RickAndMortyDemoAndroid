package com.apamatesoft.rickandmortyandroid.ui.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.apamatesoft.rickandmortyandroid.ui.theme.RickAndMortyAndroidTheme

@Composable
fun Shimmer(
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .height(50.dp)
) {

    val colors = listOf(
        Color(0xFFEAEAEA),
        Color(0xFFF6F6F6),
        Color(0xFFEAEAEA)
    )


    val transition = rememberInfiniteTransition(label = "")

    val shimmerWidthPercentage = 0.3f

    BoxWithConstraints {
        val spaceMaxWidth = with(LocalDensity.current) { maxWidth.toPx() }
        val spaceMaxHeight = with(LocalDensity.current) { maxHeight.toPx() }

        val translateAnim = transition.animateFloat(
            initialValue = 0f,
            targetValue = spaceMaxWidth * (1 + shimmerWidthPercentage),
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = 1000,
                    easing = FastOutSlowInEasing
                ),
                repeatMode = RepeatMode.Restart
            ),
            label = ""
        )

        val brush = Brush.linearGradient(
            colors,
            start = Offset(translateAnim.value - (spaceMaxWidth * shimmerWidthPercentage),spaceMaxHeight),
            end = Offset(translateAnim.value,spaceMaxHeight)
        )


        Spacer(
            modifier = modifier.background(brush = brush)
        )

    }

}

@Preview(showBackground = true)
@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES
)
@Composable
private fun PreviewShimmer() {
    RickAndMortyAndroidTheme {
        Surface {
            Shimmer()
        }
    }
}
