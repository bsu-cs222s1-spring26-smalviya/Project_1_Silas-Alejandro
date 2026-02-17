plugins {
    id("java")
    id("application")
    id("org.openjfx.javafxplugin") version "0.1.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.jayway.jsonpath:json-path:2.9.0")
    implementation("org.slf4j:slf4j-simple:2.0.9")

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.1")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher:1.10.1")
}

tasks.test {
    useJUnitPlatform()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(25)) // <- match your installed JDK
    }
}

javafx {
    // Use a stable release that matches your JDK (e.g., 21.x with JDK 21)
    version = "21.0.5"
    modules("javafx.controls", "javafx.fxml")
}

application {
    // If you have module-info.java, also set mainModule below.
    mainClass.set("edu.bsu.cs.UI")
    // mainModule.set("edu.bsu.cs") // <- uncomment if you have a module-info.java named 'module edu.bsu.cs { ... }'
}