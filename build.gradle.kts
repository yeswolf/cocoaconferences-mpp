buildscript {
    repositories {
        gradlePluginPortal()
        jcenter()
        google()
        maven { url = uri(Repos.jbKotlin) }
    }
    dependencies {
        classpath(Deps.kotlinGradle)
        classpath(Deps.androidGradle)
    }
}

allprojects {
    repositories {
        mavenCentral()
        maven { url = uri(Repos.jbKotlin) }
    }
}