plugins {
    kotlin("jvm") version "2.1.10"
}

group = "OSA"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("com.codeborne:selenide:7.7.3")

    implementation("org.slf4j:slf4j-api:2.0.0")
//    implementation("ch.qos.logback:logback-classic:1.4.5")

//    implementation("org.yaml:snakeyaml:2.4")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.18.3")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.18.3")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.3") // API для JUnit 5
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.3") // Движок для запуска тестов
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.9.3") // Нужен для @ParameterizedTest
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}