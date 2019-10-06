plugins {
    id(BuildPlugins.ANDROID_APPLICATION)
    id(BuildPlugins.KOTLIN_ANDROID)
    id(BuildPlugins.KOTLIN_ANDROID_EXTENSIONS)
}

android {
    compileSdkVersion(AndroidSdk.COMPILE_SDK_VERSION)
    buildToolsVersion(AndroidSdk.BUILS_TOOLS_VERSION)

    defaultConfig {
        applicationId = "dev.anapsil.kommon.sample"
        minSdkVersion(AndroidSdk.MIN_SDK_VERSION)
        targetSdkVersion(AndroidSdk.TARGET_SDK_VERSION)
        versionCode = 1
        versionName = "1.0.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildTypes {
            getByName("release") {
                isMinifyEnabled = false
                proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            }
        }
    }
}

dependencies {
    implementation(project(":kommon"))
    implementation(Libraries.KOTLIN_STD_LIB_JDK8)
    implementation(Libraries.AndroidX.APPCOMPAT)
    implementation(Libraries.AndroidX.CORE_KTX)
    implementation(Libraries.AndroidX.CONSTRAINT_LAYOUT)

    testImplementation(TestLibraries.JUNIT)
    testImplementation(TestLibraries.TRUTH)
}
