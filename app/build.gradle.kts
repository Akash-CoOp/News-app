plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
//    added these two for the dagger hilt one
    alias(libs.plugins.hilt)
    id("kotlin-kapt")// id one worked

   // alias(libs.plugins.kotlin.kapt)/// this mofking dont work
//either use lib one, its too much hedachefor small projects



}



android {
    namespace = "com.example.demonewsapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.demonewsapp"
        minSdk = 29
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.navigation.compose)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

   //addinng utities module in here the app module
    implementation(project(":utilities"))
//hilt and kapt are must for di these two
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)
    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.androidx.navigation.compose.v275)

    // Retrofit
    implementation(libs.retrofit)

// OkHttp
    implementation(libs.okhttp)

// Retrofit Gson Converter
    implementation(libs.converter.gson)

// Moshi
    implementation(libs.moshi.kotlin)

// Retrofit Moshi Converter
    implementation(libs.converter.moshi)

// OkHttp Logging Interceptor
    implementation(libs.logging.interceptor)

    // Kotlin Coroutines
        //ye bhn ka loda google gemini sab autocomplete krdera , mdrchod
//ye bulb use krke library catalogue wala form me change krr dera

    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)

    //splash screen dependency yeri
    implementation(libs.androidx.core.splashscreen)
    // coil dependency for image loading
    implementation(libs.coil.compose)
    implementation(libs.coil.network.okhttp)

}
kapt {
    correctErrorTypes = true
}

