// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    dependencies {
        classpath(libs.gradle.androidGradlePlugin)
        classpath(libs.gradle.kotlinPlugin)
        classpath(libs.gradle.hiltPlugin)
    }
}

plugins {
    id("com.android.application") version("7.3.1") apply false
    id("com.google.dagger.hilt.android") version("2.44.2") apply false
}

