plugins {
    id("org.jetbrains.gradle.apple.applePlugin") version "211.5739-0.13-dev-5"
}

apple {
    iosApp {
        productName = "cocoaconferences-mpp"

        sceneDelegateClass = "SceneDelegate"
        launchStoryboard = "LaunchScreen"

        //productInfo["NSAppTransportSecurity"] = mapOf("NSAllowsArbitraryLoads" to true)
        //buildSettings["OTHER_LDFLAGS"] = ""

        dependencies {
            implementation(project(":shared"))
        }
    }
}
