plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.googleServices)
    alias(libs.plugins.hiltAndroid)
    kotlin("kapt")
}

android {
    namespace = "com.quare.blitzsplit.group"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = libs.versions.jvmTarget.get()
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.kotlinCompilerExtension.get()
    }
}

dependencies {
    // Modules
    implementUi(
        Module.Ui.Component,
        Module.Ui.Theme
    )
    implementCore(
        Module.Core.Utils,
    )

    // Compose
    implementation(platform(libs.composeBom))
    implementation(libs.ui)
    implementation(libs.uiGraphics)
    implementation(libs.uiToolingPreview)
    implementation(libs.viewModelKtx)
    implementation(libs.lifecycleRuntimeCompose)
    implementation(libs.hiltNavigationCompose)
    implementation(libs.material3)
    debugImplementation(libs.uiTooling)
    debugImplementation(libs.uiTestManifest)

    // Hilt
    implementation(libs.daggerHilt)
    kapt(libs.daggerHiltCompiler)

}
