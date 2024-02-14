plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services")
    id("com.google.dagger.hilt.android")
    kotlin("kapt")
}

android {
    namespace = "com.quare.blitzsplit.login"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    // Compose
    implementation(platform(libs.composeBom))
    implementation(libs.ui)
    implementation(libs.uiGraphics)
    implementation(libs.uiToolingPreview)
    implementation(libs.material3)
    implementation(libs.activityCompose)
    implementation(libs.viewModelKtx)
    implementation(libs.hiltNavigationCompose)
    implementation(libs.lifecycleRuntimeCompose)

    // Firebase
    implementation(platform(libs.firebaseBom))
    implementation(libs.firebase.auth.ktx)
    implementation(libs.play.services.auth)

    // Hilt
    implementation(libs.daggerHilt)
    kapt(libs.daggerHiltCompiler)

    debugImplementation(libs.uiTooling)
    debugImplementation(libs.uiTestManifest)
}
