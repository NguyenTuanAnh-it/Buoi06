plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
//    id ("androidx.navigation.safeargs.kotlin")
//    id ("com.google.devtools.ksp")version ("1.8.0-1.0.8")


}

android {
    namespace = "com.example.buoi06"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.buoi06"
        minSdk = 24
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.support.annotations)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    // Room components
    implementation (libs.androidx.room.ktx)
    androidTestImplementation (libs.androidx.room.testing)
    annotationProcessor(libs.androidx.room.compiler)
    //em làm được 3 dòng trên ạ



}