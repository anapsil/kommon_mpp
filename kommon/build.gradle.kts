import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin(BuildPlugins.KOTLIN_MULTIPLATFORM)
    id(BuildPlugins.KOTLIN_NATIVE_COCOAPODS)
}

version = "1.0"

kotlin {
    val buildForDevice = project.findProperty("kotlin.native.cocoapods.target") == "ios_arm"
    if (buildForDevice) {
        iosArm64("iOS64")
        iosArm32("iOS32")

        val iosMain by sourceSets.creating
        sourceSets["iOS64Main"].dependsOn(iosMain)
        sourceSets["iOS32Main"].dependsOn(iosMain)
    } else {
        iosX64("iOS")
    }

    jvm("android")

    sourceSets["commonMain"].dependencies {
        implementation(Libraries.KOTLIN_STD_LIB_COMMON)
    }

    sourceSets["commonTest"].dependencies {
        implementation(TestLibraries.KOTLIN_TEST_COMMON)
        implementation(TestLibraries.KOTLIN_TEST_ANNOTATIONS_COMMON)
    }

    sourceSets["androidMain"].dependencies {
        implementation(Libraries.KOTLIN_STD_LIB)
    }

    cocoapods {
        summary = "Kotlin multiplatform library for Android and iOS"
        homepage = "http://github.com/anapsil/kommon-mpp"
    }
}