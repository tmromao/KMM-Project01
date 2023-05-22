plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "com.example.kmm_project01.android"
    compileSdk = Playstore.compileSdk
    defaultConfig {
        applicationId = "com.example.kmm_project01.android"
        minSdk = Playstore.minSdk
        targetSdk = Playstore.targetSdk
        versionCode = Playstore.versionCode
        versionName = Playstore.versionName
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.composeCompiler
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(":shared"))

    // CORE
    implementation(Androidx.core)
    implementation(Androidx.lifecycleRuntime)

    // CORE LIBS
    implementation(Compose.ui)
    implementation(Compose.activity)
    implementation(Compose.material)
    implementation(Compose.toolingPreview)
    implementation(Compose.foundation)
    implementation(Compose.activity)
    implementation(Compose.layout)
    implementation(Compose.themeAdapter)
    implementation(Compose.runtime)
    implementation(Compose.materialIconsExtended)
}