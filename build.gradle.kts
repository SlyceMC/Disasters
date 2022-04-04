import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.10"
}

group = "fr.uiytt"
version = "0.1"

repositories {
    mavenCentral()
    maven(url = "https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    maven(url = "https://oss.sonatype.org/content/repositories/snapshots/")
    maven(url = "https://jitpack.io")

}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("com.github.simplix-softworks:simplixstorage:3.2.1")

    compileOnly("org.spigotmc:spigot-api:1.8.8-R0.1-SNAPSHOT")
    compileOnly(files("libs/SlyceCore-1.3.1-all.jar"))
    compileOnly(files("libs/SlyceAPI-1.5.2.jar"))
}
