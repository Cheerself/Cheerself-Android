//plugins {
//    id("com.android.application")
////    id("org.jetbrains.kotlin.android")
//    id("com.google.dagger.hilt.android")
////    kotlin("kapt")
////    kotlin("android")
////    kotlin("parcelize")
//}

plugins {
    id("com.android.application")
//    id "org.jetbrains.kotlin.android"
    id("kotlin-kapt")
    id("kotlin-android")
    id("dagger.hilt.android.plugin")
    id("kotlin-parcelize")
//    id ("com.google.devtools.ksp") version "1.6.10-1.0.2"
}

kapt {
    correctErrorTypes = true
}
//kotlin {
//    sourceSets {
//        debug {
//            kotlin.srcDir("build/generated/ksp/debug/kotlin")
//        }
//        release {
//            kotlin.srcDir("build/generated/ksp/release/kotlin")
//        }
//    }
//}

android {
    compileSdk = libs.versions.compileSdk.get().toInt()
    namespace = "com.cheerself.cheerself"
    defaultConfig {
        applicationId = "com.cheerself.cheerself"
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
        vectorDrawables.useSupportLibrary = true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
//    tasks.withType(org.jetbrains.kotlin.gradle.tasks.KotlinCompile).configureEach {
//        kotlinOptions {
//            freeCompilerArgs += "-opt-in=kotlin.RequiresOptIn"
//        }
//    }
}

dependencies {
    val composeBom = platform(libs.androidx.compose.bom)
    implementation(composeBom)
    androidTestImplementation(composeBom)
    implementation(libs.accompanist.adaptive)
    implementation(libs.accompanist.drawablePainter)
    implementation(libs.accompanist.flowLayouts)
    implementation(libs.accompanist.navigationAnimation)
    implementation(libs.accompanist.navigationMaterial)
    implementation(libs.accompanist.pager)
    implementation(libs.accompanist.permissions)
    implementation(libs.accompanist.placeHolder)
    implementation(libs.accompanist.systemUIController)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.benchmark.macrobenchmark)
    implementation(libs.androidx.benchmark.macrobenchmark.junit4)
    implementation(libs.androidx.compose.animation)
    implementation(libs.androidx.compose.foundation)
    implementation(libs.androidx.compose.foundation.layout)
    implementation(libs.androidx.compose.material.iconsExtended)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.material3.window)
    implementation(libs.androidx.compose.runtime)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.googleFonts)
    implementation(libs.androidx.compose.ui.tooling)
    implementation(libs.androidx.compose.ui.toolingPreview)
    implementation(libs.androidx.compose.ui.util)
    implementation(libs.androidx.compose.ui.viewBinding)
    implementation(libs.androidx.constraintLayout.compose)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.core.splashScreen)
    implementation(libs.androidx.lifecycle.compiler)
    implementation(libs.androidx.lifecycle.livedata)
    implementation(libs.androidx.lifecycle.runtime)
    implementation(libs.androidx.lifecycle.runtime.compose)
    implementation(libs.androidx.lifecycle.viewModel)
    implementation(libs.androidx.lifecycle.viewModel.compose)
    implementation(libs.androidx.lifecycle.viewModel.savedState)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.navigation.compose.hiltNavigation)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(libs.androidx.window)
    implementation(libs.google.android.material)
    implementation(libs.hilt.android)
    implementation(libs.hilt.android.compiler)
    implementation(libs.hilt.ext.compiler)
    implementation(libs.kotlin.extensions)
    implementation(libs.kotlin.stdlib)
    implementation(libs.kotlinx.coroutines.android)
    testImplementation(libs.test.unit.junit)
    androidTestImplementation(libs.test.androidInstrumental.androidxJunit)
    androidTestImplementation(libs.test.androidInstrumental.expressoCore)
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
}