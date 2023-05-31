plugins {
    kotlin(Plugins.multiplatform)
    id(Plugins.androidLibrary)
    id(SqlDelight.pluginId)
    kotlin(Jetbrains.serializationPluginId)
}

kotlin {
    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(Kotlinx.coroutinesCore)
                implementation(SqlDelight.driverCommon)
                implementation(Jetbrains.serializationKotlinCore)
                implementation(Ktor.core)
                implementation(Ktor.jsonSerialization)
                implementation(Ktor.serialization)
                implementation(Ktor.clientContentNegotiation)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation(Kotlinx.coroutinesTest)

                // CORE TEST LIBS
                implementation(Test.kotlinCommon)
                implementation(Test.kotlinAnnotation)
        //                       implementation(Mockk.core)
      //                       implementation(Mockk.common)
            }
        }
        val androidMain by getting {
            dependencies {
                api(Androidx.viewModelLifecycle)
                implementation(SqlDelight.driverAndroid)
                implementation(Ktor.clientOkhttp)
            }
        }
        val androidTest by getting {
            dependencies {
                implementation(Test.junit)
            }
        }
        val androidAndroidTest by getting {
            dependencies {
                implementation(Test.instrumentedCommonJunit)
                implementation(Test.instrumentedCommonJunitKtx)
                implementation(Test.instrumentedCommonEspresso)
            }
        }


        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting

        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
            dependencies {
                implementation(SqlDelight.driverIos)
                implementation(Ktor.clientDarwin)
            }
        }


        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}



android {
    namespace = Namespaces.shared
    compileSdk = Playstore.compileSdk
    defaultConfig {
        minSdk = Playstore.minSdk
        targetSdk = Playstore.targetSdk
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    packagingOptions {
        resources {
            excludes += mutableSetOf("META-INF/LICENSE.md", "META-INF/LICENSE-notice.md")
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
}

// Configurar SQLDelight no build.gradle.kts do projeto
sqldelight {
    database(SqlDelight.databaseScheme) {
        packageName = SqlDelight.databasePackage
    }
}