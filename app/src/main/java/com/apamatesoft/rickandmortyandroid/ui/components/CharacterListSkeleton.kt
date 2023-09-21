package com.apamatesoft.rickandmortyandroid.ui.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ListItem
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.apamatesoft.rickandmortyandroid.ui.theme.RickAndMortyAndroidTheme

@Composable
fun CharacterListSkeleton(
    size: Int = 6
) {

    LazyColumn(Modifier.testTag("CharacterListSkeleton")) {
        items((0 until size).toList()) {
            ListItem(
                modifier = Modifier.testTag("CharacterItemSkeleton"),
                leadingContent = {
                    Shimmer(
                        Modifier
                            .clip(CircleShape)
                            .size(40.dp)
                    )
                },
                headlineContent = {
                    Shimmer(
                        Modifier
                            .height(20.dp)
                            .fillMaxWidth(0.5f)
                            .clip(RoundedCornerShape(8.dp))
                    )
                }
            )
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

