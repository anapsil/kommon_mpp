const val KOTLIN_VERSION = "1.3.50"

object BuildPlugins {

    object Versions {
        const val AGP_VERSION = "3.5.1"
    }

    const val AGP = "com.android.tools.build:gradle:${Versions.AGP_VERSION}"
    const val KGP = "org.jetbrains.kotlin:kotlin-gradle-plugin:$KOTLIN_VERSION"
    const val KOTLINX_SERIALIZATION = "org.jetbrains.kotlin:kotlin-serialization:$KOTLIN_VERSION"
    const val ANDROID_APPLICATION = "com.android.application"
    const val KOTLIN_ANDROID = "kotlin-android"
    const val KOTLIN_ANDROID_LIBRARY = "com.android.library"
    const val KOTLIN_ANDROID_EXTENSIONS = "kotlin-android-extensions"
    const val KOTLIN_MULTIPLATFORM = "multiplatform"
    const val KOTLIN_NATIVE_COCOAPODS = "org.jetbrains.kotlin.native.cocoapods"
}

object AndroidSdk {
    const val COMPILE_SDK_VERSION = 29
    const val TARGET_SDK_VERSION = 29
    const val MIN_SDK_VERSION = 21
    const val BUILS_TOOLS_VERSION = "29.0.2"
}

object Libraries {

    object Versions {
        const val ANDROIDX_VERSION = "1.1.0"
        const val CONSTRAINT_LAYOUT_VERSION = "1.1.3"
        const val COROUTINES = "1.3.1"
    }

    object AndroidX {
        const val APPCOMPAT = "androidx.appcompat:appcompat:${Versions.ANDROIDX_VERSION}"
        const val CORE_KTX = "androidx.core:core-ktx:${Versions.ANDROIDX_VERSION}"
        const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT_LAYOUT_VERSION}"
    }

    object Coroutines {
        const val COROUTINES_CORE_COMMON = "org.jetbrains.kotlinx:kotlinx-coroutines-core-common:${Versions.COROUTINES}"
        const val COROUTINES_ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINES}"
        const val COROUTINES_CORE_NATIVE = "org.jetbrains.kotlinx:kotlinx-coroutines-core-native:${Versions.COROUTINES}"
    }

    const val KOTLIN_STD_LIB = "org.jetbrains.kotlin:kotlin-stdlib"
    const val KOTLIN_STD_LIB_COMMON = "org.jetbrains.kotlin:kotlin-stdlib-common"
    const val KOTLIN_STD_LIB_JDK8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$KOTLIN_VERSION"
}

object TestLibraries {

    object Versions {
        const val JUNIT_VERSION = "4.12"
        const val TRUTH_VERSION = "1.0"
    }

    const val JUNIT = "junit:junit:${Versions.JUNIT_VERSION}"
    const val KOTLIN_TEST_COMMON = "org.jetbrains.kotlin:kotlin-test-common:$KOTLIN_VERSION"
    const val KOTLIN_TEST_ANNOTATIONS_COMMON = "org.jetbrains.kotlin:kotlin-test-annotations-common:$KOTLIN_VERSION"
    const val TRUTH = "com.google.truth:truth:${Versions.TRUTH_VERSION}"

}