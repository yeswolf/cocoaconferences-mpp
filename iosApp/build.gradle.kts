plugins {
    id(Plugins.apple) version Versions.apple
}

apple {
    iosApp {
        productName = ConfigData.appName

        sceneDelegateClass = "SceneDelegate"
        launchStoryboard = "LaunchScreen"

        //productInfo["NSAppTransportSecurity"] = mapOf("NSAllowsArbitraryLoads" to true)
        //buildSettings["OTHER_LDFLAGS"] = ""

        dependencies {
            implementation(project(Projects.shared))
        }
    }
}
