//import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.8.0"
}

group = "com.rcode"
version = "1.0-SNAPSHOT"

var kotlinVersion = "1.8.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    implementation("org.jetbrains.kotlin:kotlin-reflect:$kotlinVersion")
    testImplementation(kotlin("test"))
    testImplementation("junit:junit:4.13.2")
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.2")
    testImplementation("io.mockk:mockk:1.13.3")
}

tasks.test {
    useJUnitPlatform()
}

/*
tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}*/
