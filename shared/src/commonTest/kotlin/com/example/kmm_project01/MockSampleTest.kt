package com.example.kmmproject01

import kotlin.test.Test
import kotlin.test.assertEquals

// 1. Add test lib dependency
// 2. Add mockk plugin
// 3. Add mockk annotation processor
// 4. Add mockk impl dependency
/*

class MockSampleTest {

    class Clock{
        fun getCurrentTime():String = "12:00"
    }

    @Test
    fun `sample mock test`(){
        val clock = mockk<Clock>()
        every { clock.getCurrentTime() } returns "13:15"

        val time = clock.getCurrentTime()

        verify { clock.getCurrentTime() }
        assertEquals("13:15", time)

    }
}*/
