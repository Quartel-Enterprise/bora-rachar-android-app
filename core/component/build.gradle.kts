@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
}

android {
    namespace = "com.quare.blitzsplit.component"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3"
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
    // Compose
    implementation(project(":core:theme"))
    implementation(project(":core:utils"))
    implementation(platform(libs.composeBom))
    implementation(libs.ui)
    implementation(libs.uiGraphics)
    implementation(libs.uiToolingPreview)
    implementation("androidx.compose.material3:material3-android:1.2.0-rc01") /* Temporary solution for
        loading progress indicator with material 3 (remove when it's fixed)
        https://stackoverflow.com/a/77907893/11111289
    */
    implementation(libs.coil)
    debugImplementation(libs.uiTooling)
    debugImplementation(libs.uiTestManifest)
}
