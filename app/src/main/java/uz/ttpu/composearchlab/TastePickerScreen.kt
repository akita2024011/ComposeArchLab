package uz.ttpu.composearchlab

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun TastePickerRoute(
    viewModel: TastePickerViewModel = viewModel()
) {

    val state =
        viewModel.state.collectAsStateWithLifecycle()

    TastePickerScreen(
        state = state.value,
        onGenreClick = viewModel::onGenreClick,
        onLikeClick = viewModel::onArtistLikeToggled
    )
}

@Composable
fun TastePickerScreen(
    state: TastePickerState,
    onGenreClick: (String) -> Unit,
    onLikeClick: (Int) -> Unit
) {

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        Text(
            text = "Choose your favorite artists",
            modifier = Modifier.padding(16.dp)
        )

        GenreChips(
            genres = state.genres,
            selectedGenre = state.selectedGenre,
            onGenreClick = onGenreClick
        )

        ArtistGrid(
            artists = state.visibleArtists,
            likedIds = state.likedIds,
            onLikeClick = onLikeClick,
            modifier = Modifier.weight(1f)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement =
                Arrangement.spacedBy(8.dp)
        ) {

            Text(
                text = "Liked: ${state.likedCount}"
            )

            if (!state.canContinue) {

                CircularProgressIndicator(
                    progress = {
                        (
                                state.likedCount
                                    .toFloat() /
                                        REQUIRED_LIKES
                                ).coerceIn(0f, 1f)
                    }
                )
            }

            Button(
                onClick = {},
                enabled = state.canContinue,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Continue")
            }
        }
    }
}