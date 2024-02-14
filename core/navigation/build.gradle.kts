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

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    val modules = listOf(
        "feature:login",
        "feature:groups",
        "feature:main",
        "core:theme",
        "core:component",
        "core:user"
    )
    modules.forEach { module ->
        implementation(project(":$module"))
    }

    // Compose
    implementation(platform(libs.composeBom))
    implementation(platform(libs.firebaseBom))
    implementation(libs.ui)
    implementation(libs.lifecycleRuntimeCompose)
    implementation(libs.uiGraphics)
    implementation(libs.uiToolingPreview)
    implementation("androidx.compose.material3:material3-android:1.2.0-rc01") /* Temporary solution for
        loading progress indicator with material 3 (remove when it's fixed)
        https://stackoverflow.com/a/77907893/11111289
    */
    implementation(libs.navigation.compose)
    implementation(libs.play.services.auth)
    implementation(libs.firebase.auth.ktx)
    implementation(libs.hiltNavigationCompose)
    debugImplementation(libs.uiTooling)
    debugImplementation(libs.uiTestManifest)

    // Firebase
    implementation(platform(libs.firebaseBom))

    // Hilt
    implementation(libs.daggerHilt)
    kapt(libs.daggerHiltCompiler)
}
