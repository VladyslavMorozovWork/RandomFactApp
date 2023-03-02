plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("androidx.navigation.safeargs")
    id("kotlin-parcelize")
    id("dagger.hilt.android.plugin")
    id("org.jetbrains.kotlin.android")
}

android {
    compileSdk = ProjectCompileConfig.compileSdkVersion
    buildToolsVersion = ProjectCompileConfig.buildToolsVersion

    defaultConfig {
        applicationId = ProjectCompileConfig.applicationId

        minSdk = ProjectCompileConfig.minSdkVersion
        targetSdk = ProjectCompileConfig.targetSdkVersion
        versionCode = 1
        versionName = "test"

    }

    buildTypes {
        debug {
            isMinifyEnabled = false
            buildConfigField(type = "String", name = "API_URL", value = "\"http://numbersapi.com\"")
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

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation(Third.stdlib)
    implementation(Third.coroutines)
    implementation(Google.material)
    implementation(Google.gson)
    implementation(Google.roomImplementation)
    implementation(Google.roomCoroutines)
    implementation("androidx.core:core-ktx:+")
    annotationProcessor(Google.roomAnnotationProcessor)
    kapt(Google.roomCompiler)
    implementation(AndroidX.recyclerview)
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1")
    implementation(AndroidX.coreKtx)
    implementation(AndroidX.lifecycleRuntime)
    implementation(AndroidX.appcompat)
    implementation(AndroidX.legacy)
    implementation(AndroidX.lifecycleProcess)
    implementation(AndroidX.navigationFragmentKtx)
    implementation(AndroidX.navigationUiKtx)
    implementation(AndroidX.activityKtx)
    implementation(AndroidX.fragmentKtx)
    implementation(Third.viewBindingPropertyDelegate)
    implementation(Third.okhttp)
    implementation(Third.okhttpLogging)
    implementation(Third.retrofit2)
    implementation(Third.converterGson)
    implementation(Third.converterScalars)

    implementation(Google.hiltAndroid)
    kapt(Google.hiltCompiler)
}