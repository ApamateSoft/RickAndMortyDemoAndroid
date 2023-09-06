package com.apamatesoft.rickandmortyandroid.ui.screen.home.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.apamatesoft.rickandmortyandroid.ui.components.Shimmer
import com.apamatesoft.rickandmortyandroid.ui.theme.RickAndMortyAndroidTheme

@Composable
fun CharacterListSkeleton(
    size: Int = 5
) {

    LazyColumn {
        items((0 until size).toList()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("CharacterItemSkeleton")
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.padding(8.dp)
                ) {

                    Shimmer(
                        Modifier
                            .clip(CircleShape)
                            .size(40.dp)
                    )

                    Shimmer(
                        Modifier
                            .height(20.dp)
                            .fillMaxWidth(0.5f)
                            .clip(RoundedCornerShape(8.dp))
                    )

                }
            }
            Divider()
        }
    }

}

@Preview(showBackground = true)
@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES
)
@Composable
private fun PreviewCharacterListSkeleton() {
    RickAndMortyAndroidTheme {
        Surface {
            CharacterListSkeleton()
        }
    }
}

