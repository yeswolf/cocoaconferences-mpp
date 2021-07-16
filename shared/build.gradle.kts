plugins {
    kotlin(Plugins.mpp)
    id(Plugins.androidLib)
    kotlin(Plugins.serialization) version Versions.serialization
}

repositories {
    google()
    jcenter()
}

kotlin {
    android()
    ios {
        binaries {
            framework {
                baseName = "shared"
            }
        }
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(Deps.yaml)
                implementation(Deps.ktorCore)
                implementation(Deps.coroutinesCore)
                implementation(Deps.koinCore)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin(Deps.kTestCommon))
                implementation(kotlin(Deps.kTestAnnotationsCommon))
                implementation(Deps.coroutinesCore)
                implementation(Deps.koinTest)
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(Deps.ktorCIO)
            }
        }
        val androidTest by getting {
            dependencies {
                implementation(kotlin(Deps.kjunit))
                implementation(Deps.junit)
            }
        }
        val iosMain by getting {
            dependencies {
                implementation(Deps.ktorIOS)
            }
        }
        val iosTest by getting {
            dependencies {
                implementation(Deps.koinTest)
            }
        }
    }
}

android {

    compileSdkVersion(ConfigData.compileSdk)
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdkVersion(ConfigData.minSdk)
        targetSdkVersion(ConfigData.targetSdk)
    }
}