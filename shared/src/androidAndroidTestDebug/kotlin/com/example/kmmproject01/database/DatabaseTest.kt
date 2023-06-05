package com.example.kmmproject01.database

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.kmmproject01.models.Story
import com.example.kmmproject01.models.StoryMedia
import com.example.kmmproject01.utils.AndroidMainApp
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import kotlin.test.assertEquals

@RunWith(AndroidJUnit4::class)
class DatabaseTest {

    private lateinit var database: Database

    @Before
    fun prepareTest() {
        AndroidMainApp.applicationContext = InstrumentationRegistry.getInstrumentation().targetContext
        database = Database(createSqlDriver())
        database.clearDatabase()
    }

    @After
    fun cleanupTest() {
        database.clearDatabase()
    }

    @Test
    fun clearDatabase() {
        assertEquals(0, database.getAllStory().size)
    }

    @Test
    fun getAllStories() {
        val stories = listOf(
            createStory("1", "Teste 1"),
            createStory("2", "Teste 2"),
        )
        database.insertStories(stories)
        val source = database.getAllStory()
        assertEquals(2, source.size)
    }

    @Test
    fun insertStories() {
        val stories = listOf(
            createStory("1", "Teste 1"),
            createStory("2", "Teste 2"),
            createStory("3", "Teste 3"),
            createStory("4", "Teste 4"),
        )
        database.insertStories(stories)
        val source = database.getAllStory()
        assertEquals(4, source.size)
    }

    private fun createStory(
        id: String,
        name: String,
    ): Story {
        return Story(
            id = id,
            name = name,
            storyMedia = StoryMedia(
                name = "test",
                imgUrl = "uri",
                mimeType = "image/png"
            ),
            slides = emptyList()
        )
    }

}