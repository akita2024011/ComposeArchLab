package uz.ttpu.composearchlab

data class TastePickerState(
    val artists: List<Artist>,
    val selectedGenre: String? = null,
    val likedIds: Set<Int> = emptySet()
) {

    val genres: List<String>
        get() = artists
            .map { it.genre }
            .distinct()

    val visibleArtists: List<Artist>
        get() =
            if (selectedGenre == null) {
                artists
            } else {
                artists.filter {
                    it.genre == selectedGenre
                }
            }

    val likedCount: Int
        get() = likedIds.size

    val canContinue: Boolean
        get() = likedCount >= REQUIRED_LIKES
}