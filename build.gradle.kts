// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {

    val hiltVersion by extra("2.45")
    val navVersion by extra("2.4.1")

    dependencies {
        classpath("com.android.tools.build:gradle-api:7.2.2")

        classpath("com.google.dagger:hilt-android-gradle-plugin:$hiltVersion")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:$navVersion")

    }
}

plugins {
    id("com.android.application") version "8.2.1" apply false
    id("org.jetbrains.kotlin.android") version "1.9.22" apply false
}

