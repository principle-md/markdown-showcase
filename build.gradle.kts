plugins {
    id("java") // or kotlin("jvm") if you prefer Kotlin for build script too
    id("org.jetbrains.intellij") version "1.17.3" // Latest stable version for IntelliJ plugin development
    kotlin("jvm") version "1.9.22" // Ensure this matches your Kotlin version
}

group = "com.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

// Configure IntelliJ Platform plugin development settings
intellij {
    version.set("2023.3.6") // Specify the IntelliJ Platform version to build against (e.g., latest stable)
    type.set("IC") // Use "IC" for IntelliJ IDEA Community Edition, "IU" for Ultimate
    plugins.set(listOf("org.jetbrains.kotlin")) // Bundled plugins your plugin depends on, e.g., Kotlin
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.2")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher:1.9.2") // Ensure launcher is present
    implementation("org.commonmark:commonmark:0.21.0")
    // Add other dependencies here if needed, e.g., a markdown library for SlideRenderer
    // implementation("org.commonmark:commonmark:0.21.0") // Example for CommonMark
}

tasks {
    // Set the JVM compatibility options
    withType<JavaCompile> {
        sourceCompatibility = "17"
        targetCompatibility = "17"
    }
    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions.jvmTarget = "17"
    }

    patchPluginXml {
        sinceBuild.set("233") // Corresponds to 2023.3. Set min supported IDE version.
        // untilBuild.set("241.*") // Optional: Set max supported IDE version.
    }

    test {
        useJUnitPlatform()
        testClassesDirs = files(project.tasks.compileTestKotlin.map { it.destinationDirectory })
        classpath = sourceSets.test.get().runtimeClasspath
    }
}
