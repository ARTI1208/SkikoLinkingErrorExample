plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("org.jetbrains.compose")
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {

    ios()
    iosSimulatorArm64()
    android {
        publishAllLibraryVariants()
        publishLibraryVariantsGroupedByFlavor = false
    }
    jvm()

    sourceSets {
        val commonMain by getting {
            dependencies {
                //put your multiplatform dependencies here
                api(compose.runtime)
                api(compose.material3)
                api(compose.ui)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val iosMain by getting
        @Suppress("UNUSED_VARIABLE")
        val iosSimulatorArm64Main by getting {
            dependsOn(iosMain)
        }
    }
}

android {
    namespace = "com.example.ui"
    compileSdk = 33
    defaultConfig {
        minSdk = 24
    }
}