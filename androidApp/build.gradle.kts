plugins {
    id(Plugins.androidApplication)
    kotlin(Plugins.android)
}

android {
    namespace = Namespaces.android
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

    flavorDimensions += "tier"
    productFlavors {
        create("development") {
            dimension = "tier"
        }
        create("production") {
            dimension = "tier"
        }
        create("integration"){
            dimension = "tier"
        }
    }

    buildTypes {
        getByName("debug") {
         applicationIdSuffix = ".debug"
            isMinifyEnabled = false
            isDebuggable = true
        }
        getByName("release") {
            isMinifyEnabled = true
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

    // Testing
    testImplementation(Test.junit)
    androidTestImplementation(TestUi.extJunit)
    androidTestImplementation(Test.instrumentedTestCompose)

    // Debugging
    debugImplementation(Compose.tooling)
}