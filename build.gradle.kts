import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.20-M1"
    `java-library`
    idea

    id("org.screamingsandals.plugin-builder") version "1.0.76"
}

group = "network.hoz"
version = "1.0.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    compileOnly(group = "com.github.ben-manes.caffeine", name = "caffeine", version = "3.0.5")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}