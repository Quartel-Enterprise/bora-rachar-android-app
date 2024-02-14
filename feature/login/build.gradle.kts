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
    // Compose
    implementation(project(":core:theme"))
    implementation(project(":core:component"))
    implementation(project(":core:user"))
    implementation(platform(libs.composeBom))
    implementation(platform(libs.firebaseBom))
    implementation(libs.ui)
    implementation(libs.uiGraphics)
    implementation(libs.uiToolingPreview)
    implementation("androidx.compose.material3:material3-android:1.2.0-rc01") /* Temporary solution for
        loading progress indicator with material 3 (remove when it's fixed)
        https://stackoverflow.com/a/77907893/11111289
    */
    implementation(libs.activityCompose)
    implementation(libs.play.services.auth)
    implementation(libs.firebase.auth.ktx)
    implementation(libs.viewModelKtx)
    implementation(libs.hiltNavigationCompose)
    implementation(libs.lifecycleRuntimeCompose)

    // Hilt
    implementation(libs.daggerHilt)
    kapt(libs.daggerHiltCompiler)

    debugImplementation(libs.uiTooling)
    debugImplementation(libs.uiTestManifest)
}
