plugins {
    java
}

group = "com.dfsek"
version = "0.1.0"

repositories {
    mavenCentral()
    maven { url = uri("https://papermc.io/repo/repository/maven-public/") }
    maven { url = uri("https://mvn.lumine.io/repository/maven-public/") }
    maven { url = uri("https://repo.codemc.org/repository/maven-public") }
    maven { url = uri("https://jitpack.io") }
}

dependencies {
    testImplementation("junit", "junit", "4.12")
    compileOnly("com.destroystokyo.paper:paper-api:1.16.5-R0.1-SNAPSHOT")
    compileOnly("com.dfsek.terra.common:common:5.0.0-BETA+7f11373f")
    compileOnly("com.dfsek.terra.bukkit:bukkit:5.0.0-BETA+7f11373f")
    compileOnly("com.dfsek:Tectonic:1.2.3")
    compileOnly("io.lumine.xikage:MythicMobs:4.9.1")
    compileOnly("com.github.LoneDev6:API-ItemsAdder:2.3.8")

}
