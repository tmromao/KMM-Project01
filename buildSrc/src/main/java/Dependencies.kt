/** PLAYSTORE VERSIONS */
object Playstore {
    const val applicationId = "com.example.app" // Can't be changed
    const val compileSdk = 33
    const val minSdk = 23
    const val targetSdk = 31
    const val versionCode = 1 // Increment on every release
    const val versionName = "1.0.0" // Increment on every release. Suggested approach https://semver.org/
}

/** ANDROID APP VERSIONS */
object Versions {
    const val compose = "1.1.1"
    const val composeActivity = "1.4.0"
    const val composeCompiler = "1.3.1"
    const val composeThemeAdapter = "1.1.5"
    const val androidxCore = "1.9.0"
    const val lifecycleRuntime = "2.5.1"
    const val jUnit = "4.13.2"
    const val extjUnit = "1.1.3"
    const val testManifest = "1.1.0-beta01"
    const val espressoCore = "3.4.0"
    const val uiUnitTest = "1.1.0-beta01"
    const val kotlin = "1.7.10"
    const val pluginAndroidLib = "7.4.2"
    const val pluginAndroidApp = "7.4.2"
    const val kotlinx = "1.6.4"
    const val viewModel = "2.5.1"

}

/**
 * APP DEPENDENCIES
 * How to add to build.gradle(:app)?
 * Ex: Inside dependencies {...} add: implementation Androidx.core
 *  */

object Androidx {
    const val core = "androidx.core:core-ktx:${Versions.androidxCore}"
    const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleRuntime}"
    const val viewModelLifecycle = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.viewModel}"
}

object Kotlinx {
    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinx}"
    const val coroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.kotlinx}"
}

object Compose {
    const val activity = "androidx.activity:activity-compose:${Versions.composeActivity}"
    const val foundation = "androidx.compose.foundation:foundation:${Versions.compose}"
    const val layout = "androidx.compose.foundation:foundation-layout:${Versions.compose}"
    const val material = "androidx.compose.material:material:${Versions.compose}"
    const val materialIconsExtended = "androidx.compose.material:material-icons-extended:${Versions.compose}"
    const val runtime = "androidx.compose.runtime:runtime:${Versions.compose}"
    const val themeAdapter = "com.google.android.material:compose-theme-adapter:${Versions.composeThemeAdapter}"
    const val tooling = "androidx.compose.ui:ui-tooling-data:${Versions.compose}"
    const val toolingPreview = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
    const val ui = "androidx.compose.ui:ui:${Versions.compose}"


}