package com.apamatesoft.usecase

import com.apamatesoft.repository.CharacterRepository
import com.apamatesoft.domain.entity.Character
import kotlin.properties.Delegates

class CharacterRequestCase(
    private val characterRepo: CharacterRepository
) {

    private var currentPage: Int = 1
    private var pages by Delegates.notNull<Int>()
    private var characters: List<Character> = emptyList()

    fun isLastPage() = currentPage == pages

    suspend fun characterRequest(): List<Character> {
        currentPage = 1
        val characterPage = characterRepo.characterRequest(currentPage)
        pages = characterPage.pages
        characters = characterPage.characters
        characterRepo.saveCharacters(characters)
        return characters
    }

    suspend fun loadMoreCharacters(): List<Character> {
        if (isLastPage()) return characters
        currentPage += 1
        val characterPage = characterRepo.characterRequest(currentPage)
        pages = characterPage.pages
        characters += characterPage.characters
        return characters
    }

}