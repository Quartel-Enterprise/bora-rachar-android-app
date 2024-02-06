plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services")
    id("com.google.dagger.hilt.android")
    kotlin("kapt")
}

android {
    namespace = "com.quare.blitzsplit.groups"
    compileSdk = 33

    defaultConfig {
        minSdk = 24

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
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.8"
    }
}

dependencies {
    // Modules
    val modules = listOf("core:component", "core:theme", "feature:login")
    modules.forEach { module ->
        implementation(project(":$module"))
    }

    // Compose
    implementation(platform(libs.composeBom))
    implementation(platform(libs.firebaseBom))
    implementation(libs.ui)
    implementation(libs.uiGraphics)
    implementation(libs.uiToolingPreview)
    implementation(libs.material3)
    implementation(libs.play.services.auth)
    implementation(libs.firebase.auth.ktx)
    implementation(libs.viewModelKtx)
    implementation(libs.lifecycle.viewmodel.compose)
    implementation(libs.lifecycleRuntimeCompose)

    // Hilt
    implementation(libs.daggerHilt)
    kapt(libs.daggerHiltCompiler)

    debugImplementation(libs.uiTooling)
    debugImplementation(libs.uiTestManifest)
}
