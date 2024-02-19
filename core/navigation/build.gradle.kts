@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
    kotlin("kapt")
}

android {
    namespace = "com.quare.blitzsplit.navigation"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
        consumerProguardFiles("consumer-rules.pro")
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
}

dependencies {
    // Modules
    implementCore(
        Module.Core.Theme,
        Module.Core.Component,
        Module.Core.User
    )
    implementFeature(
        Module.Feature.Login,
        Module.Feature.Group,
        Module.Feature.Groups,
        Module.Feature.Main,
    )

    // Compose
    implementation(platform(libs.composeBom))
    implementation(platform(libs.firebaseBom))
    implementation(libs.ui)
    implementation(libs.lifecycleRuntimeCompose)
    implementation(libs.uiGraphics)
    implementation(libs.uiToolingPreview)
    implementation(libs.material3)
    implementation(libs.navigationCompose)
    implementation(libs.play.services.auth)
    implementation(libs.hiltNavigationCompose)
    debugImplementation(libs.uiTooling)
    debugImplementation(libs.uiTestManifest)

    // Hilt
    implementation(libs.daggerHilt)
    kapt(libs.daggerHiltCompiler)
}
