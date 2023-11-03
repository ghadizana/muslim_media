plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-parcelize") // implementing the Parcelable (send bundle of data)
    id("com.google.devtools.ksp") // kotlin symbol processing : processing the json file processing when processing the data
}

android {
    namespace = "com.ghadiza.muslimmediaapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.ghadiza.muslimmediaapp"
        minSdk = 28
        targetSdk = 33
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
    buildFeatures {
        viewBinding = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation("androidx.core:core-splashscreen:1.1.0-alpha02")

    // Picasso : for image loader
    implementation("com.squareup.picasso:picasso:2.8")

    /* Moshi -> JSON converter, GSON : same with Moshi
    Serialize: changing the Kotlin object to JSON object
    Deserialize: changing the JSON object to Kotlin object */
    implementation("com.squareup.moshi:moshi:1.14.0")

    // Kotlin Codegen = code generator
    ksp("com.squareup.moshi:moshi-kotlin-codegen:1.14.0")

    // Retrofit = if we want to use data from API
    // HTTP client - with OkHttp
    // to retrieve data via REST based webservice
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-moshi:2.9.0")

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")}