pluginManagement {
    repositories {
        google()
        jcenter()
        gradlePluginPortal()
        maven { url = uri("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/dev") }
    }

}
rootProject.name = "cocoaconferences-mpp"


include(":iosApp")
include(":androidApp")
include(":shared")

