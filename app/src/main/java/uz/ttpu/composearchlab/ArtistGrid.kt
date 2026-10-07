package uz.ttpu.composearchlab

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ArtistGrid(
    artists: List<Artist>,
    likedIds: Set<Int>,
    onLikeClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = modifier.fillMaxWidth()
    ) {

        items(
            items = artists,
            key = {
                it.id
            }
        ) { artist ->

            ArtistCard(
                artist = artist,
                liked = artist.id in likedIds,
                onLikeClick = {
                    onLikeClick(artist.id)
                }
            )
        }
    }
}