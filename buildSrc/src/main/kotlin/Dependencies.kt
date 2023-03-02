object ProjectCompileConfig {
    const val compileSdkVersion = 33
    const val buildToolsVersion = "33.0.2"
    const val minSdkVersion = 26
    const val targetSdkVersion = 33
    const val versionCode = 1
    const val applicationId = "com.example.randomfactapp"
}

object Google {
    const val gson = "com.google.code.gson:gson:${Versions.gsonVersion}"
    const val material = "com.google.android.material:material:${Versions.materialVersion}"

    const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hiltVersion}"
    const val hiltCompiler = "com.google.dagger:hilt-compiler:${Versions.hiltVersion}"
    const val roomCoroutines = "androidx.room:room-ktx:${Versions.room_version}"
    const val roomImplementation = "androidx.room:room-runtime:${Versions.room_version}"
    const val roomAnnotationProcessor = "androidx.room:room-compiler:${Versions.room_version}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room_version}"
}


object Third {
    const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttpVersion}"
    const val okhttpLogging = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttpVersion}"
    const val viewBindingPropertyDelegate = "com.github.kirich1409:viewbindingpropertydelegate-noreflection:1.5.3"

    const val retrofit2 = "com.squareup.retrofit2:retrofit:${Versions.retrofit2Version}"
    const val converterScalars = "com.squareup.retrofit2:converter-scalars:${Versions.retrofit2Version}"
    const val converterGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit2Version}"
    const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlinVersion}"
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesVersion}"
}

object AndroidX {
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompatVersion}"
    const val legacy = "androidx.legacy:legacy-support-v4:${Versions.legacySupportV4Version}"
    const val recyclerview = "androidx.recyclerview:recyclerview:${Versions.recyclerViewVersion}"
    const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleVersion}"
    const val lifecycleProcess = "androidx.lifecycle:lifecycle-process:${Versions.lifecycleVersion}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtxVersion}"
    const val navigationFragmentKtx = "androidx.navigation:navigation-fragment-ktx:${Versions.navigationVersion}"
    const val navigationUiKtx = "androidx.navigation:navigation-ui-ktx:${Versions.navigationVersion}"
    const val activityKtx = "androidx.activity:activity-ktx:${Versions.activityKtsVersion}"
    const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragmentKtsVersion}"
}

object Versions {
    //AndroidX
    const val appcompatVersion = "1.3.0-rc01"
    const val coreKtxVersion = "1.9.0"
    const val legacySupportV4Version = "1.0.0"
    const val lifecycleVersion = "2.5.1"
    const val navigationVersion = "2.5.3"
    const val recyclerViewVersion = "1.3.0-alpha01"
    const val fragmentKtsVersion = "1.3.4"
    const val activityKtsVersion = "1.3.0-alpha05"

    //Third
    const val materialVersion = "1.5.0"

    //Google
    const val okhttpVersion = "4.9.3"
    const val retrofit2Version = "2.9.0"
    const val gsonVersion = "2.8.6"
    const val hiltVersion = "2.45"

    const val kotlinVersion = "1.8.10"
    const val coroutinesVersion = "1.6.0"
    const val room_version = "2.4.3"

    const val ktlintVersion = "10.3.0"
}