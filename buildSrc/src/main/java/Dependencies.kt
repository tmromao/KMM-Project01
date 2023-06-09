/** PLAYSTORE VERSIONS */
object Playstore {
    const val applicationId = "com.example.kmmproject01.android" // Can't be changed
    const val compileSdk = 33
    const val minSdk = 23
    const val targetSdk = 31
    const val versionCode = 1 // Increment on every release
    const val versionName = "1.0.0" // Increment on every release. Suggested approach https://semver.org/
}

object Namespaces {
    const val android = "com.example.kmmproject01.android"
    const val shared = "com.example.kmmproject01"
}

object Plugins {
    const val android = "android"
    const val androidLibrary = "com.android.library"
    const val androidApplication = "com.android.application"
    const val kotlin = "kotlin"
    const val multiplatform = "multiplatform"
}

/** ANDROID APP VERSIONS */
object Versions {
    const val compose = "1.1.1"
    const val composeActivity = "1.4.0"
    const val composeCompiler = "1.3.1"
    const val composeThemeAdapter = "1.1.5"
    const val androidxCore = "1.9.0"
    const val lifecycleRuntime = "2.5.1"
    const val junit = "4.13.2"
    const val extJunit = "1.1.3"
    const val instrumentedTestCompose = "1.2.1"
    const val testManifest = "1.1.0-beta01"
    const val espressoCore = "3.4.0"
    const val uiUnitTest = "1.1.0-beta01"
    const val kotlin = "1.7.10"
    const val pluginAndroidLib = "7.3.0"
    const val pluginAndroidApp = "7.3.0"
    const val kotlinx = "1.6.4"
    const val viewModel = "2.5.1"
    const val mockkCommon = "1.12.5"
    const val mockkCore = "1.13.2"
    const val sqlDelight = "1.5.3"
    const val kotlinSerializationCore = "1.3.2"
    const val buildTools = "7.3.0"
    const val shimmer = "1.0.3"
    const val espresso = "3.4.0"
    const val ktor = "2.3.0" // Releases -> https://ktor.io/docs/releases.html
    const val uiGraphics = "1.3.2"
    const val settings = "1.0.0"
    const val preferences = "1.2.0"
}

object Jetbrains {
    const val serializationPluginId = "plugin.serialization"
    const val serializationKotlin = "org.jetbrains.kotlin:kotlin-serialization:${Versions.kotlin}"
    const val serializationKotlinCore = "org.jetbrains.kotlinx:kotlinx-serialization-core:${Versions.kotlinSerializationCore}"
}

object Gradle {
    const val pluginSqlDelight = "com.squareup.sqldelight:gradle-plugin:${Versions.sqlDelight}"
    const val pluginKotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val buildTools = "com.android.tools.build:gradle:${Versions.buildTools}"
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
    const val uiTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
    const val preferences = "androidx.preference:preference-ktx:${Versions.preferences}"
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
    const val uiTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
    const val tooling = "androidx.compose.ui:ui-tooling-data:${Versions.compose}"
    const val toolingPreview = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
    const val ui = "androidx.compose.ui:ui:${Versions.compose}"
    const val uiGraphics = "androidx.compose.ui:ui-graphics:${Versions.uiGraphics}"

}

object Ktor {
    const val clientOkhttp = "io.ktor:ktor-client-okhttp:${Versions.ktor}"
    const val clientDarwin = "io.ktor:ktor-client-darwin:${Versions.ktor}"
    const val core = "io.ktor:ktor-client-core:${Versions.ktor}"
    const val serialization = "io.ktor:ktor-client-serialization:${Versions.ktor}"
    const val clientContentNegotiation = "io.ktor:ktor-client-content-negotiation:${Versions.ktor}"
    const val jsonSerialization = "io.ktor:ktor-serialization-kotlinx-json:${Versions.ktor}"
}

object Russhwolf {
    const val settings = "com.russhwolf:multiplatform-settings:${Versions.settings}"
}

/**
 * UNIT TEST
 *  How to add to build.gradle(:app)
 *  Ex: Inside dependencies {...} add: testImplementation Test.jUnit
 *  */

object Test {
    const val junit = "junit:junit:${Versions.junit}"
    const val kotlinCommon = "org.jetbrains.kotlin:kotlin-test-common:${Versions.kotlin}"
    const val kotlinAnnotation = "org.jetbrains.kotlin:kotlin-test-annotations-common:${Versions.kotlin}"
    const val instrumentedTestCompose = "androidx.compose.ui:ui-test-junit4:${Versions.instrumentedTestCompose}"

    // Instrumented test common
    const val instrumentedCommonJunit = "androidx.test.ext:junit:${Versions.extJunit}"
    const val instrumentedCommonJunitKtx = "androidx.test.ext:junit-ktx:${Versions.extJunit}"
    const val instrumentedCommonEspresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
}

object Mockk {
    const val core = "io.mockk:mockk:${Versions.mockkCore}"
    const val common = "io.mockk:mockk-common:${Versions.mockkCommon}"
}

/**
 * ANDROID UI TESTS
 * how to add to build.gradle(:app)?
 * Ex: Inside dependencies {...} add: androidTestImplementation Androidx.espressoCore
 * */
object TestUi {
    const val extJunit = "androidx.test.ext:junit:${Versions.extJunit}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
    const val uiUnitTest = "androidx.compose.ui:ui-test-junit4:${Versions.uiUnitTest}"
}

object SqlDelight {
    const val pluginId = "com.squareup.sqldelight"
    const val driverCommon = "com.squareup.sqldelight:runtime:${Versions.sqlDelight}"
    const val driverAndroid = "com.squareup.sqldelight:android-driver:${Versions.sqlDelight}"
    const val driverIos = "com.squareup.sqldelight:native-driver:${Versions.sqlDelight}"
    const val databasePackage = "com.example.kmmproject01.database"
    const val databaseScheme = "CommonDatabase"
}