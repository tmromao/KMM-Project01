package com.example.kmmproject01.database

import com.example.kmmproject01.models.Story
import com.example.kmmproject01.models.StoryMedia
import com.squareup.sqldelight.db.SqlDriver

class Database(driver: SqlDriver, clearDatabase: Boolean = false) {
    private val database = CommonDatabase(driver)
    private val dbQuery = database.appDatabaseQueries

    init {
        if (clearDatabase) clearDb()
    }

    private fun clearDb() {
        dbQuery.transaction {
            dbQuery.removeAllStory()
        }
    }

    fun getAllStory(): List<Story> {
        return dbQuery.selectAllStories(::mapStories).executeAsList()
    }

    fun insertStories(stories: List<Story>){
        if (stories.isNotEmpty()){
            dbQuery.transaction {
                stories.forEach { dbQuery.insertStory(id = it.id, body = it.name) }
            }
        }
    }

    // Aprender a mapear, caso o banco de dados tenha nomes diferentes
    private fun mapStories(
        id: String,
        body: String
    ): Story {
        return Story(
            id = id,
            name = body,
            storyMedia = StoryMedia(
                name = "test",
                imgUrl = "uri",
                mimeType = "image/png"
            ),
            slides = emptyList()
        )
    }
}