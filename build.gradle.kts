plugins {
    id("org.jetbrains.kotlin.jvm") version "2.0.21"
    id("fabric-loom") version "1.8-SNAPSHOT"
}

loom {
    accessWidenerPath.set(file("src/main/resources/boua.aw"))
}

fabricApi {
    configureDataGeneration()
}

group = "com.harleylizard"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://maven.minecraftforge.net/")
}

dependencies {
    minecraft("com.mojang:minecraft:1.21.1")
    mappings(loom.officialMojangMappings())

    modImplementation("net.fabricmc:fabric-loader:0.16.7")
    modImplementation("net.fabricmc.fabric-api:fabric-api:0.106.0+1.21.1")
    modImplementation("net.fabricmc:fabric-language-kotlin:1.12.3+kotlin.2.0.21")

    modImplementation("com.github.glitchfiend:TerraBlender-fabric:1.21.1-4.1.0.3")

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}
