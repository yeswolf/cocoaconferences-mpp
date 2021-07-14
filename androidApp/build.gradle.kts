plugins {
    kotlin("multiplatform")
    id("com.android.application")
}

repositories {
    google()
    jcenter()
}

kotlin {
    android()
    sourceSets {
        val androidMain by getting {
            dependencies {
                implementation(project(":shared"))
                implementation("com.google.android.material:material:1.2.1")
                implementation("androidx.appcompat:appcompat:1.2.0")
                implementation("androidx.constraintlayout:constraintlayout:2.0.2")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.0")
                implementation ("io.insert-koin:koin-android:3.1.2")
                implementation ("io.insert-koin:koin-android-compat:3.1.2")
            }
        }
    }
}

android {
    compileSdkVersion(29)
    defaultConfig {
        applicationId = "me.user.androidApp"
        minSdkVersion(26)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "1.0"
    }
    compileOptions {
        // Flag to enable support for the new language APIs
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}