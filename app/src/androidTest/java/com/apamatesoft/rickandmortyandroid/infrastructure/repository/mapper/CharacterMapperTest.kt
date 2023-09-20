package com.apamatesoft.rickandmortyandroid.infrastructure.repository.mapper

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.apamatesoft.domain.entity.Character
import com.apamatesoft.rickandmortyandroid.infrastructure.api.dto.CharacterDto
import com.apamatesoft.rickandmortyandroid.infrastructure.api.dto.CharacterPageDto
import com.apamatesoft.rickandmortyandroid.infrastructure.api.dto.InfoDto
import com.apamatesoft.rickandmortyandroid.infrastructure.localStorage.model.CharacterModel
import junit.framework.TestCase
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class CharacterMapperTest {

    @Test
    fun characterPageDtoToCharacterPage() {
        val dto = CharacterPageDto(
            info = InfoDto(pages = 42),
            results = listOf(
                CharacterDto(
                    id = 0,
                    name = "0 - name",
                    image = "https://picsum.photos/id/0/40"
                ),
                CharacterDto(
                    id = 1,
                    name = "1 - name",
                    image = "https://picsum.photos/id/1/40"
                )
            )
        )

        val entity = dto.toEntity()

        TestCase.assertEquals(dto.results.size, entity.characters.size)

    }

    @Test
    fun characterDtoToCharacter() {
        val dto = CharacterDto(
            id = 0,
            name = "0 - name",
            image = "https://picsum.photos/id/0/40"
        )
        val entity = dto.toEntity()
        TestCase.assertEquals(dto.id, entity.id)
        TestCase.assertEquals(dto.name, entity.name)
        TestCase.assertEquals(dto.image, entity.imageUrl)
    }

    @Test
    fun characterEntityToCharacter() {
        val entity = CharacterModel(
            id = 0,
            name = "0 - name",
            imageUrl = "https://picsum.photos/id/0/40"
        )
        val character = entity.toEntity()
        TestCase.assertEquals(entity.id, character.id)
        TestCase.assertEquals(entity.name, character.name)
        TestCase.assertEquals(entity.imageUrl, character.imageUrl)
    }

    @Test
    fun characterToCharacterEntity() {
        val character = Character(
            id = 0,
            name = "0 - name",
            imageUrl = "https://picsum.photos/id/0/40"
        )
        val model = character.toModel()
        TestCase.assertEquals(character.id, model.id)
        TestCase.assertEquals(character.name, model.name)
        TestCase.assertEquals(character.imageUrl, model.imageUrl)
    }

}