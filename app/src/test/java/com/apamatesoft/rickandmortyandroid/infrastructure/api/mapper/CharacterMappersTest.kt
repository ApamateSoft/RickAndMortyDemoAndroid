package com.apamatesoft.rickandmortyandroid.infrastructure.api.mapper

import com.apamatesoft.rickandmortyandroid.infrastructure.api.dto.CharacterDto
import com.apamatesoft.rickandmortyandroid.infrastructure.api.dto.CharacterPageDto
import com.apamatesoft.rickandmortyandroid.infrastructure.api.dto.InfoDto
import junit.framework.TestCase.assertEquals
import org.junit.Test

class CharacterMappersTest {

    @Test
    fun `CharacterPageDto to CharacterPage`() {
        val dto = CharacterPageDto(
            info = InfoDto(pages = 42),
            results = listOf(
                CharacterDto(
                    id = 0,
                    name = "0 - name",
                    image = "https://picsum.photos/id/0/40"
                ),
                CharacterDto(
                    id =1,
                    name = "1 - name",
                    image = "https://picsum.photos/id/1/40"
                )
            )
        )

        val entity = dto.toCharacterPage()

        assertEquals(dto.results.size, entity.characters.size)

    }

    @Test
    fun `CharacterDto to Character`() {
        val dto = CharacterDto(
            id = 0,
            name = "0 - name",
            image = "https://picsum.photos/id/0/40"
        )
        val entity = dto.toCharacter()
        assertEquals(dto.id, entity.id)
        assertEquals(dto.name, entity.name)
        assertEquals(dto.image, entity.imageUrl)
    }

}