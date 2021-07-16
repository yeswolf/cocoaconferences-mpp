@file:Suppress("unused")

object Repos {
    const val jbKotlin = "https://maven.pkg.jetbrains.space/kotlin/p/kotlin/dev"
}

object Plugins {
    const val mpp = "multiplatform"
    const val androidLib = "com.android.library"
    const val serialization = "plugin.serialization"
    const val androidApplication = "com.android.application"
    const val apple = "org.jetbrains.gradle.apple.applePlugin"
}

object Versions {
    const val yaml = "0.9.0"
    const val ktor = "1.6.0"
    const val coroutines = "1.5.0"
    const val coroutinesNative = "$coroutines-native-mt"
    const val koin = "3.1.2"
    const val junit = "4.13"
    const val serialization = "1.5.0"
    const val androidMaterial = "1.2.1"
    const val androidAppCompat = "1.2.0"
    const val androidConstraintLayout = "2.0.2"
    const val apple = "211.5739-0.12"
    const val androidGradle = "4.0.1"
    const val kotlinGradle = "1.5.20-RC-184"
}

object Deps {
    val yaml by lazy {"net.mamoe.yamlkt:yamlkt:${Versions.yaml}"}

    val ktorCore by lazy { "io.ktor:ktor-client-core:${Versions.ktor}" }
    val ktorCIO by lazy { "io.ktor:ktor-client-cio:${Versions.ktor}" }
    val ktorIOS by lazy { "io.ktor:ktor-client-ios:${Versions.ktor}" }

    val coroutinesCore by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesNative}" }

    val koinCore by lazy { "io.insert-koin:koin-core:${Versions.koin}" }
    val koinTest by lazy { "io.insert-koin:koin-test:${Versions.koin}" }
    val koinAndroid by lazy { "io.insert-koin:koin-android:${Versions.koin}" }
    val koinAndroidCompat by lazy { "io.insert-koin:koin-android-compat:${Versions.koin}" }

    val junit by lazy { "junit:junit:${Versions.junit}"}
    val kjunit by lazy { "test-junit" }
    val kTestCommon by lazy { "test-common" }
    val kTestAnnotationsCommon by lazy { "test-annotations-common" }

    val androidMaterial by lazy { "com.google.android.material:material:${Versions.androidMaterial}" }
    val androidAppCompat by lazy { "androidx.appcompat:appcompat:${Versions.androidAppCompat}" }
    val androidConstraintLayout by lazy { "androidx.constraintlayout:constraintlayout:${Versions.androidConstraintLayout}" }

    val androidCoroutines by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}" }
    val androidGradle by lazy { "com.android.tools.build:gradle:${Versions.androidGradle}" }
    val kotlinGradle by lazy { "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinGradle}" }
}

object ConfigData {
    const val compileSdk = 29
    const val minSdk = 26
    const val targetSdk = 29
    const val versionCode = 1
    const val versionName = "1.0"
    const val androidID = "me.user.androidApp"
    const val appName = "cocoaconferences-mpp"
}

object Projects {
    const val iosApp = ":iosApp"
    const val androidApp = ":androidApp"
    const val shared = ":shared"
}