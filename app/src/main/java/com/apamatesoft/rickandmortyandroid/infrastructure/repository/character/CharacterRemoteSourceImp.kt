package com.apamatesoft.rickandmortyandroid.infrastructure.repository.character

import com.apamatesoft.domain.entity.Character
import com.apamatesoft.domain.entity.CharacterPage
import com.apamatesoft.repository.remoteSource.CharacterRemoteSource
import com.apamatesoft.rickandmortyandroid.infrastructure.api.CharacterApi
import kotlinx.coroutines.delay
import javax.inject.Inject

class CharacterRemoteSourceImp @Inject constructor(
    private val characterApi: CharacterApi
): CharacterRemoteSource {

    override suspend fun characterRequest(page: Int): CharacterPage {

        val dto = characterApi.characterRequest(page)

        return CharacterPage(
            pages = dto.info.pages,
            characters = dto.results.map {
                Character(
                    id = it.id,
                    name = it.name,
                    imageUrl = it.image
                )
            }
        )

//        delay(2_000L)
//        return CharacterPage(
//            pages = 3,
//            characters = (0..29).map {
//                val id = it+((page-1)*30)
//                Character(
//                    id = id,
//                    name = "$id - Name",
//                    imageUrl = "https://picsum.photos/id/$id/40"
//                )
//            }
//        )

    }

}