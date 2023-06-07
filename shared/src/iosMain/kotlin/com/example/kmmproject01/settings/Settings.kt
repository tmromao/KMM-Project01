package com.example.kmmproject01.settings

import com.russhwolf.settings.NSUserDefaultsSettings
import com.russhwolf.settings.Settings
import platform.Foundation.NSUserDefaults

val delegate: NSUserDefaults = NSUserDefaults.standardUserDefaults()
// Francisco explica que o ? nao resulta no iOS!??
actual fun getSettings(): Settings? = NSUserDefaultsSettings(delegate)

