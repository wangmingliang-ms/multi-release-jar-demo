plugins {
    id("java")
    id("org.jetbrains.intellij") version "1.5.2"
}

group = "com.example"
version = "1.0.0-AZURE"

repositories {
    mavenLocal()
    mavenCentral()
}

// Configure Gradle IntelliJ Plugin - read more: https://github.com/JetBrains/gradle-intellij-plugin
intellij {
    version.set("LATEST-EAP-SNAPSHOT")
    type.set("IC") // Target IDE Platform

    plugins.set(listOf(/* Plugin Dependencies */))
}

dependencies {
    implementation("org.example:multi-release-jar:1.0-SNAPSHOT")
    implementation("org.example:multi-release-jar-9:1.0-SNAPSHOT")
    implementation("com.azure:azure-core:1.30.0")
}

tasks {
    // Set the JVM compatibility versions
    withType<JavaCompile> {
        sourceCompatibility = "11"
        targetCompatibility = "11"
    }

    patchPluginXml {
        sinceBuild.set("212")
        untilBuild.set("222.*")
    }
}
