pluginManagement {
    repositories {
        google()
        jcenter()
        gradlePluginPortal()
        maven { url = uri("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/dev") }
        maven { url = uri("https://repo.labs.intellij.net/mobile-ide-tmp/") }
    }
    
}
rootProject.name = "mppsample"


include(":iosApp")
include(":androidApp")
include(":shared")

