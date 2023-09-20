package com.apamatesoft.rickandmortyandroid.infrastructure.api

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.apamatesoft.rickandmortyandroid.infrastructure.RESPONSE_CHARACTER_JSON
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@RunWith(AndroidJUnit4::class)
class CharacterApiTest {

    private val server = MockWebServer()

    @After
    fun tearDown() {
        server.shutdown()
    }

    @Test
    fun characterRequest_isSuccessIfReturnAllCharacters() = runBlocking {

        server.enqueue(MockResponse().setBody(RESPONSE_CHARACTER_JSON))

        val serverUrl = server.url("/api/character")
        val baseUrl = serverUrl.toString().replace("/api/character", "")

        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val characterApi = retrofit.create(CharacterApi::class.java)

        val result = characterApi.characterRequest(1)

        assertEquals(20, result.results.size)

    }

}