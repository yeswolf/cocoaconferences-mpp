import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("multiplatform")
    id("com.android.application")
    id("kotlin-android-extensions")
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
//                implementation("com.google.android.material:material:1.2.1")
//                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.0")
                implementation(project(":shared"))
//                implementation("com.google.android.material:material:1.2.1")
                implementation("androidx.constraintlayout:constraintlayout:2.0.2")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.0")

                implementation ("androidx.core:core-ktx:1.6.0")
                implementation ("androidx.appcompat:appcompat:1.3.0")

                implementation ("androidx.compose.ui:ui:1.0.0-rc01")
                // Tooling support (Previews, etc.)
                implementation ("androidx.compose.ui:ui-tooling:1.0.0-rc01")
                // Foundation (Border, Background, Box, Image, Scroll, shapes, animations, etc.)
                implementation ("androidx.compose.foundation:foundation:1.0.0-rc01")
                // Material Design
                implementation ("androidx.compose.material:material:1.0.0-rc01")
                // Material design icons
                implementation ("androidx.compose.material:material-icons-core:1.0.0-rc01")
                implementation ("androidx.compose.material:material-icons-extended:1.0.0-rc01")
                // Integration with activities
                implementation ("androidx.activity:activity-compose:1.3.0-rc01")
                // Integration with ViewModels
                implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-alpha07")
                // Integration with observables
                implementation ("androidx.compose.runtime:runtime-livedata:1.0.0-rc01")
                implementation ("androidx.compose.runtime:runtime-rxjava2:1.0.0-rc01")

                // UI Tests
//                androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.0.0-rc01")
//                testImplementation("junit:junit:4.+")
//                androidTestImplementation("androidx.test.ext:junit:1.1.2")
//                androidTestImplementation("androidx.test.espresso:espresso-core:3.3.0")
            }
        }
    }
}
android {
    compileSdkVersion(30)
    defaultConfig {
        applicationId = "com.example.compose"
        minSdkVersion(30)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
//    kotlinOptions {
//        jvmTarget = "1.8"
//    }
    buildFeatures {
        viewBinding  = true
        compose = true

    }

    composeOptions {
        kotlinCompilerVersion = "1.5.20-RC-184"
        kotlinCompilerExtensionVersion  = "1.0.0-rc01"
    }
}
tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
        useIR = true
        freeCompilerArgs = listOf(
            "-Xallow-jvm-ir-dependencies", "-Xskip-prerelease-check", "-Xallow-unstable-dependencies",
            "-Xskip-metadata-version-check",
            "-Xuse-experimental=kotlinx.coroutines.ExperimentalCoroutinesApi",
            "-P",
            "plugin:androidx.compose.compiler.plugins.kotlin:suppressKotlinVersionCompatibilityCheck=true"
        )
    }
}
