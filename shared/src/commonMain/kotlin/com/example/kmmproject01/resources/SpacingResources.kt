package com.example.kmmproject01.resources

import kotlin.native.concurrent.ThreadLocal

@ThreadLocal
object SpacingResources {
    private val small by lazy { Small() }
    private val medium by lazy { Medium() }
    private val large by lazy { Large() }

    internal fun getSpacing(): Spacing {
        return when (getWindowSize()) {
            WindowSize.Small -> small
            WindowSize.Medium -> medium
            WindowSize.Large -> large
        }
    }
}

abstract class Spacing(
    val noSpace: SpacingResource,
    val extraTiny: SpacingResource,
    val tiny: SpacingResource,
    val extraSmall: SpacingResource,
    val small: SpacingResource,
    val normal: SpacingResource,
    val medium: SpacingResource,
    val big: SpacingResource,
    val extraBig: SpacingResource,
    val large: SpacingResource,
    val extraLarge: SpacingResource,
    val huge: SpacingResource,
    val extraHuge: SpacingResource,
)

private class Small : Spacing(
    noSpace = SpacingResource(0),
    extraTiny = SpacingResource(2),
    tiny = SpacingResource(4),
    extraSmall = SpacingResource(8),
    small = SpacingResource(12),
    normal = SpacingResource(16),
    medium = SpacingResource(20),
    big = SpacingResource(24),
    extraBig = SpacingResource(28),
    large = SpacingResource(32),
    extraLarge = SpacingResource(36),
    huge = SpacingResource(40),
    extraHuge = SpacingResource(44),
)

private class Medium : Spacing(
    noSpace = SpacingResource(0),
    extraTiny = SpacingResource(4),
    tiny = SpacingResource(8),
    extraSmall = SpacingResource(12),
    small = SpacingResource(16),
    normal = SpacingResource(20),
    medium = SpacingResource(24),
    big = SpacingResource(28),
    extraBig = SpacingResource(32),
    large = SpacingResource(36),
    extraLarge = SpacingResource(40),
    huge = SpacingResource(44),
    extraHuge = SpacingResource(48),
)

private class Large : Spacing(
    noSpace = SpacingResource(0),
    extraTiny = SpacingResource(8),
    tiny = SpacingResource(12),
    extraSmall = SpacingResource(16),
    small = SpacingResource(20),
    normal = SpacingResource(24),
    medium = SpacingResource(28),
    big = SpacingResource(32),
    extraBig = SpacingResource(36),
    large = SpacingResource(40),
    extraLarge = SpacingResource(44),
    huge = SpacingResource(48),
    extraHuge = SpacingResource(52),
)