plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    implementation("org.example:multi-release-jar:1.0-SNAPSHOT")
    implementation("org.example:multi-release-jar-9:1.0-SNAPSHOT")
    implementation("com.azure:azure-core:1.30.0")
}

tasks {
    // Set the JVM compatibility versions
    withType<JavaCompile> {
        sourceCompatibility = "8"
        targetCompatibility = "8"
    }
}
