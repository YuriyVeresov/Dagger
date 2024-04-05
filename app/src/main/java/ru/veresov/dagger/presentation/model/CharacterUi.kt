package ru.veresov.dagger.presentation.model


class CharacterUi(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: LocationUi,
    val name: String,
    val origin: OriginUi,
    val species: String,
    val status: String,
    val type: String,
    val url: String
) {
    override fun toString(): String {
        return "CharacterUi(created='$created', episode=$episode, gender='$gender', id=$id, image='$image', location=$location, name='$name', origin=$origin, species='$species', status='$status', type='$type', url='$url')"
    }

}