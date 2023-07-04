import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework

plugins {
    kotlin("multiplatform")
}

val dependencies = listOf(
//    "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2-native-mt",
    project(":ui"),
)

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()


    val xcf = XCFramework()
    val iOSTargets = listOf(iosX64(), iosArm64(), iosSimulatorArm64())

    // configure iosMain source set
    ios()

    iOSTargets.forEach {
        it.binaries.framework {
            baseName = "shared"

            for (dependency in dependencies) export(dependency)
            transitiveExport = true

            freeCompilerArgs += listOf(
                "-linker-option", "-framework", "-linker-option", "Metal",
                "-linker-option", "-framework", "-linker-option", "CoreText",
                "-linker-option", "-framework", "-linker-option", "CoreGraphics",
            )

            xcf.add(this)
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                //put your multiplatform dependencies here
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val iosMain by getting {
            dependencies {
                for (dependency in dependencies) api(dependency)
            }
        }
        val iosSimulatorArm64Main by getting {
            dependsOn(iosMain)
        }
    }
}
