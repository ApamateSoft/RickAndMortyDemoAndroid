package com.apamatesoft.rickandmortyandroid.infrastructure.repository.character

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.apamatesoft.repository.remoteSource.CharacterRemoteSource
import com.apamatesoft.rickandmortyandroid.infrastructure.RESPONSE_CHARACTER_JSON
import com.apamatesoft.rickandmortyandroid.infrastructure.api.CharacterApi
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Test
import org.junit.runner.RunWith
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@RunWith(AndroidJUnit4::class)
class CharacterRemoteSourceImpTest {

    private val server = MockWebServer()

    @After
    fun tearDown() {
        server.shutdown()
    }

    @Test
    fun characterRemoteSource_isCorrectlyImplementedIfItIsAbleToMapAllCharacters() = runBlocking {

        server.enqueue(MockResponse().setBody(RESPONSE_CHARACTER_JSON))

        val serverUrl = server.url("/api/character")
        val baseUrl = serverUrl.toString().replace("/api/character", "")

        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val characterApi = retrofit.create(CharacterApi::class.java)
        val characterRemoteSource: CharacterRemoteSource = CharacterRemoteSourceImp(characterApi)

        val result = characterRemoteSource.characterRequest(1)

        assertEquals(20, result.characters.size)
    }

}