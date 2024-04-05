package ru.veresov.dagger.presentation.mapper

import ru.veresov.dagger.domain.model.CharacterDmn
import ru.veresov.dagger.domain.model.LoadCharacterResult
import ru.veresov.dagger.domain.model.LocationDmn
import ru.veresov.dagger.domain.model.OriginDmn
import ru.veresov.dagger.presentation.model.CharacterUi
import ru.veresov.dagger.presentation.model.LocationUi
import ru.veresov.dagger.presentation.model.OriginUi
import ru.veresov.dagger.presentation.state.MainScreenState
import javax.inject.Inject

class CharacterUiMapper @Inject constructor() : LoadCharacterResult.CharacterMapper<MainScreenState> {
    override fun mapSuccess(character: CharacterDmn): MainScreenState {
        return MainScreenState.Success(
            CharacterUi(
                created = character.created,
                episode = character.episode,
                gender = character.gender,
                id = character.id,
                image = character.image,
                location = LocationUiMapper().map(character.location),
                name = character.name,
                origin = OriginUiMapper().map(character.origin),
                species = character.species,
                status = character.status,
                type = character.type,
                url = character.url
            )
        )
    }

    override fun mapError(errorMessage: String, errorCode: Int): MainScreenState {
        return MainScreenState.Error(errorMessage, errorCode)
    }

}

interface Mapper<I, O> {
    fun map(input: I): O
}

class LocationUiMapper : Mapper<LocationDmn, LocationUi> {
    override fun map(input: LocationDmn): LocationUi {
        return LocationUi(input.name, input.url)
    }
}

class OriginUiMapper : Mapper<OriginDmn, OriginUi> {
    override fun map(input: OriginDmn): OriginUi {
        return OriginUi(input.name, input.url)
    }
}