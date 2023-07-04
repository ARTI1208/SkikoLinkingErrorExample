plugins {
    //trick: for the same plugin versions in all sub-modules
    id("com.android.application").version("8.0.2").apply(false)
    id("com.android.library").version("8.0.2").apply(false)
    kotlin("android").version("1.9.0-RC").apply(false)
    kotlin("multiplatform").version("1.9.0-RC").apply(false)
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
