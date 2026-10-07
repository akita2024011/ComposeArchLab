package uz.ttpu.composearchlab

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun GenreChips(
    genres: List<String>,
    selectedGenre: String?,
    onGenreClick: (String) -> Unit
) {

    LazyRow(
        horizontalArrangement =
            Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(8.dp)
    ) {

        items(genres) { genre ->

            FilterChip(
                selected = selectedGenre == genre,
                onClick = {
                    onGenreClick(genre)
                },
                label = {
                    Text(genre)
                }
            )
        }
    }
}