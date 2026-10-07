package uz.ttpu.composearchlab

data class Artist(
    val id: Int,
    val name: String,
    val genre: String
)

const val REQUIRED_LIKES = 3

val seedArtists = listOf(

    Artist(1, "Nilufar Skye", "Pop"),
    Artist(2, "Amir Neon", "Pop"),
    Artist(3, "Zarina Bloom", "Pop"),

    Artist(4, "Iron Caravan", "Rock"),
    Artist(5, "Qora Tun", "Rock"),
    Artist(6, "Steel Orchard", "Rock"),

    Artist(7, "Midnight Samarkand", "Jazz"),
    Artist(8, "Blue Registan", "Jazz"),
    Artist(9, "Saida Quartet", "Jazz"),

    Artist(10, "Silk Road Duo", "Folk"),
    Artist(11, "Navruz Ensemble", "Folk"),
    Artist(12, "Chor Minor", "Folk")
)