package com.example.kmmproject01.viewmodels

import com.example.kmmproject01.BaseSharedViewModel
import com.example.kmmproject01.models.Story
import com.example.kmmproject01.models.StoryMedia
import com.example.kmmproject01.providers.DataSourceProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SampleViewModel : BaseSharedViewModel() {

    // TODO: Business logic and state management goes here...

    private val _stories = MutableStateFlow<List<Story>>(emptyList())
    val stories : StateFlow<List<Story>>
        get() {
            return _stories
        }

    private val _error = MutableStateFlow<Boolean>(false)
    val error : StateFlow<Boolean>
        get() {
            return _error
        }

    private val dataSourceProvider = DataSourceProvider()

    fun loadStories() {
        scope.launch {
            kotlin.runCatching{
                val db = dataSourceProvider.getLocalCommonDatabase()
                db.clearDatabase()
                db.insertStories(mockStories())
                db.getAllStory()
            }.onSuccess { stories ->
                _stories.emit(stories)
            }.onFailure {
                _error.emit(true)
            }
        }
    }

    fun clearStories(){
        scope.launch {
            kotlin.runCatching{
                val db = dataSourceProvider.getLocalCommonDatabase()
                db.clearDatabase()
                db.getAllStory()
            }.onSuccess { stories ->
                _stories.emit(stories)
            }.onFailure {
                _error.emit(true)
            }
        }
    }

    // Mock stories
    //
    private fun mockStories():List<Story>{
        return listOf(
            createStory("1", "Story 1"),
            createStory("2", "Story 2"),
            createStory("3", "Story 3"),
        )
    }

    // Create a story
    private fun createStory(id: String, name: String): Story {
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