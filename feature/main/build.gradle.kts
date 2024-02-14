plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.googleServices)
    alias(libs.plugins.hiltAndroid)
    kotlin("kapt")
}

android {
    namespace = "com.quare.blitzsplit.main"
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
    implementCore(
        Module.Core.Component,
        Module.Core.Theme,
        Module.Core.User
    )
    implementFeature(
        Module.Feature.Groups,
        Module.Feature.Activities,
        Module.Feature.Contacts
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

    // Hilt
    implementation(libs.daggerHilt)
    kapt(libs.daggerHiltCompiler)

    // Firebase
    implementation(platform(libs.firebaseBom))
    implementation(libs.firebase.auth.ktx)
    implementation(libs.play.services.auth)

    debugImplementation(libs.uiTooling)
    debugImplementation(libs.uiTestManifest)
}
