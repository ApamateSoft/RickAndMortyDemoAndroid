package com.apamatesoft.rickandmortyandroid.ui.screen.home

import androidx.annotation.VisibleForTesting
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apamatesoft.domain.entity.Character
import com.apamatesoft.usecase.CharacterRequestCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.reflect.Modifier.PRIVATE
import javax.inject.Inject

@HiltViewModel
class HomeModel @Inject constructor(
    private val characterRequestCase: CharacterRequestCase
): ViewModel() {

    data class State(
        val loading: Boolean = false,
        val hasNetworkError: Boolean = false,
        val characters: List<Character> = emptyList()
    )

    var state by mutableStateOf(State())
        @VisibleForTesting
        internal set

    fun onCreate() {
        loadCharactersFromCache()
        characterRequest()
    }

    @VisibleForTesting
    internal fun loadCharactersFromCache() = viewModelScope.launch {
        withContext(IO) {
            characterRequestCase.loadCharacters()
        }.also {
            if (it.isNotEmpty()) state = state.copy(characters = it)
        }
    }

    fun characterRequest() {
        if (state.loading) return
        state = state.copy(loading = true, hasNetworkError = false)
        viewModelScope.launch {
            state = try {
                val characters = withContext(IO) {
                    characterRequestCase.characterRequest()
                }
                state.copy(
                    characters = characters,
                    loading = false
                )
            } catch (e: Exception) {
                state.copy(loading = false, hasNetworkError = true)
            }
        }
    }

    fun loadMoreCharacters() {
        if (state.loading) return
        state = state.copy(loading = true, hasNetworkError = false)
        viewModelScope.launch {
            state = try {
                val characters = withContext(IO) {
                    characterRequestCase.loadMoreCharacters()
                }
                state.copy(
                    characters = characters,
                    loading = false
                )
            } catch (e: Exception) {
                state.copy(loading = false, hasNetworkError = true)
            }
        }
    }

}