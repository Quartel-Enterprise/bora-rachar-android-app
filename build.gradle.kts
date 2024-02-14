buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(libs.googleServices)
        classpath(libs.kotlinSerialization)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}


plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.kotlinAndroid) apply false
    alias(libs.plugins.hiltAndroid) apply false
    alias(libs.plugins.googleServices) apply false
    alias(libs.plugins.org.jetbrains.kotlin.jvm) apply false
}
