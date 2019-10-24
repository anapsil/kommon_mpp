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

    sourceSets {
        commonMain {
            dependencies {
                implementation(Libraries.KOTLIN_STD_LIB_COMMON)
            }
        }
        commonTest {
            dependencies {
                implementation(TestLibraries.KOTLIN_TEST_COMMON)
                implementation(TestLibraries.KOTLIN_TEST_ANNOTATIONS_COMMON)
            }
        }
        getByName("androidMain"){
            dependencies {
                implementation(Libraries.KOTLIN_STD_LIB)
            }
        }
        getByName("androidTest") {
            dependencies {
                implementation(TestLibraries.KOTLIN_TEST_COMMON)
                implementation(TestLibraries.KOTLIN_TEST_JUNIT)
            }
        }
    }

    cocoapods {
        summary = "Kotlin multiplatform library for Android and iOS"
        homepage = "http://github.com/anapsil/kommon-mpp"
    }
}