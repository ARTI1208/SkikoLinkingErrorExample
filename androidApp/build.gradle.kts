plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "com.example.skikoexample.android"
    compileSdk = 33
    defaultConfig {
        applicationId = "com.example.skikoexample.android"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
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
    implementation("androidx.activity:activity-compose:1.7.1")
    implementation(project(":ui"))
}