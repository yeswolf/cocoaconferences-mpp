plugins {
    kotlin(Plugins.mpp)
    id(Plugins.androidApplication)
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
                implementation(project(Projects.shared))
                implementation(Deps.androidMaterial)
                implementation(Deps.androidAppCompat)
                implementation(Deps.androidConstraintLayout)
                implementation(Deps.androidCoroutines)
                implementation(Deps.koinAndroid)
                implementation(Deps.koinAndroidCompat)
            }
        }
    }
}

android {
    compileSdkVersion(ConfigData.compileSdk)
    defaultConfig {
        applicationId = ConfigData.androidID
        minSdkVersion(ConfigData.minSdk)
        targetSdkVersion(ConfigData.targetSdk)
        versionCode = ConfigData.versionCode
        versionName = ConfigData.versionName
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