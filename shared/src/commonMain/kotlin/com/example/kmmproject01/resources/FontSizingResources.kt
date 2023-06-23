package com.example.kmmproject01.resources

import kotlin.native.concurrent.ThreadLocal

@ThreadLocal
object FontSizingResources {
    private val small by lazy { FontSizing.Small() }
    private val medium by lazy { FontSizing.Medium() }
    private val large by lazy { FontSizing.Large() }

    internal fun getFontSizing(): FontSizing {
        return when (getWindowSize()) {
            WindowSize.Small -> small
            WindowSize.Medium -> medium
            WindowSize.Large -> large
        }
    }
}

abstract class FontSizing(
    val tiny: FontSizingResource,
    val small: FontSizingResource,
    val normal: FontSizingResource,
    val medium: FontSizingResource,
    val big: FontSizingResource,
    val large: FontSizingResource,
    val huge: FontSizingResource,
){
    class Small : FontSizing(
        tiny = FontSizingResource(8, 14),
        small = FontSizingResource(12, 16),
        normal = FontSizingResource(14, 18),
        medium = FontSizingResource(16, 20),
        big = FontSizingResource(18, 22),
        large = FontSizingResource(20, 24),
        huge = FontSizingResource(22, 26),
    )

    class Medium : FontSizing(
        tiny = FontSizingResource(10, 16),
        small = FontSizingResource(14, 18),
        normal = FontSizingResource(16, 20),
        medium = FontSizingResource(18, 22),
        big = FontSizingResource(20, 24),
        large = FontSizingResource(22, 26),
        huge = FontSizingResource(24, 28),
    )

    class Large : FontSizing(
        tiny = FontSizingResource(12, 16),
        small = FontSizingResource(16, 20),
        normal = FontSizingResource(18, 22),
        medium = FontSizingResource(20, 24),
        big = FontSizingResource(22, 26),
        large = FontSizingResource(24, 28),
        huge = FontSizingResource(26, 30),
    )
}