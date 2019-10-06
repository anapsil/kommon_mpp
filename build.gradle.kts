buildscript {
    repositories {
        google()
        jcenter()
    }

    dependencies {
        classpath(BuildPlugins.AGP)
        classpath(BuildPlugins.KGP)
        classpath(BuildPlugins.KOTLINX_SERIALIZATION)
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

tasks.register("clean").configure {
    delete("build")
}