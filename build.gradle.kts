import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.20"
    id("com.github.johnrengelman.shadow") version "7.1.2"

}

group = "me.tropicalshadow"
version = "0.0.1"

repositories {
    mavenCentral()
    mavenLocal()

    maven("https://papermc.io/repo/repository/maven-public/")
    maven("https://repo.extendedclip.com/content/repositories/placeholderapi/")
    maven("https://repo.codemc.org/repository/maven-releases/")
    maven("https://repo.extendedclip.com/content/repositories/placeholderapi/")
}

dependencies {
    implementation("org.reflections:reflections:0.10.2")
    compileOnly("io.papermc.paper:paper-api:1.18.2-R0.1-SNAPSHOT")
    compileOnly("net.skinsrestorer:skinsrestorer-api:14.1.14")
    compileOnly("me.clip:placeholderapi:2.11.1")
}


tasks {
    withType<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar> {
        archiveFileName.set(rootProject.name + "-V" + project.version + ".jar")
        relocate("kotlin", "com.github.tropicalshadow.skinrestorerforce.dependencies.kotlin")
        relocate("org.reflections", "com.github.tropicalshadow.skinrestorerforce.dependencies.reflections")
        exclude("DebugProbesKt.bin")
        exclude("META-INF/**")
    }

    processResources {
        filter<org.apache.tools.ant.filters.ReplaceTokens>("tokens" to mapOf("version" to project.version))
    }

}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}