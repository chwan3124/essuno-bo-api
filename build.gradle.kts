

plugins {
    kotlin("jvm") version "1.9.10"
    kotlin("plugin.spring") version "1.9.10"
    id("org.springframework.boot") version "3.5.3"
    id("io.spring.dependency-management") version "1.1.7"
    id("org.asciidoctor.jvm.convert") version "3.3.2" // REST Docs 사용 시 필요
}

group = "com"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    implementation("org.springframework.boot:spring-boot-starter-websocket")
    implementation("org.springframework.boot:spring-boot-starter-oauth2-client")

    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("io.jsonwebtoken:jjwt-api:0.11.5")
    runtimeOnly("io.jsonwebtoken:jjwt-impl:0.11.5")
    runtimeOnly("io.jsonwebtoken:jjwt-jackson:0.11.5")

    runtimeOnly("com.mysql:mysql-connector-j")
    testImplementation("org.springframework.restdocs:spring-restdocs-mockmvc")
}
//extra["snippetsDir"] = file("build/generated-snippets")
val snippetsDir by extra { file("build/generated-snippets") } // 변수 변경

tasks.asciidoctor {
    inputs.dir(snippetsDir)
    //dependsOn(test)
    dependsOn(tasks.test) // 변경

    doFirst { // 2
        delete {
            file("src/main/resources/static/docs")
        }
    }
}

tasks.register("copyHTML", Copy::class) { // 3
    dependsOn(tasks.asciidoctor)
    from(file("build/asciidoc/html5"))
    into(file("src/main/resources/static/docs"))
}

tasks.build { // 4
    dependsOn(tasks.getByName("copyHTML"))
}

tasks.bootJar { // 5
    dependsOn(tasks.asciidoctor)
    dependsOn(tasks.getByName("copyHTML"))
}

kotlin {
    jvmToolchain(17)
}

tasks.test {
    useJUnitPlatform() // ✅ 꼭 있어야 JUnit5 테스트 인식
}