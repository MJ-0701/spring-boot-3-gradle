import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

//buildscript {
//    dependencies {
//        classpath("gradle.plugin.com.ewerk.gradle.plugins:querydsl-plugin:1.0.10")
//        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.21")
//        classpath("org.jetbrains.kotlin:kotlin-allopen:1.8.21")
//        classpath("org.jetbrains.kotlin:kotlin-noarg:1.8.21")
//    }
//}

plugins {

    id("org.springframework.boot") version "3.1.0"
    id("io.spring.dependency-management") version "1.1.0"
    kotlin("jvm") version "1.8.21"
    kotlin("plugin.spring") version "1.8.21"
    kotlin("plugin.jpa") version "1.8.21"
    kotlin("kapt") version "1.8.21"


}

//allOpen {
//    // Spring Boot 3.X.X
//    annotation("jakarta.persistence.Entity")
//    annotation("jakarta.persistence.MappedSuperclass")
//    annotation("jakarta.persistence.Embeddable")
//}


group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    runtimeOnly("com.mysql:mysql-connector-j")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    //하이버네이트
    implementation("org.hibernate.validator:hibernate-validator:7.0.1.Final")

    // 코틀린
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
//    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    // Spring Boot 3.X.X
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.1.0")
    implementation("com.vladmihalcea:hibernate-types-60:2.21.1")
    implementation("com.infobip:infobip-spring-data-jpa-querydsl-boot-starter:8.1.1")
    kapt("com.querydsl:querydsl-apt:5.0.0:jakarta")
}

tasks.withType<org.jetbrains.kotlin.gradle.internal.KaptWithoutKotlincTask>()
    .configureEach {
        kaptProcessJvmArgs.add("-Xmx512m")
    }


tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
    sourceSets.main {
        withConvention(org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet::class) {
            kotlin.srcDir("$buildDir/generated/source/kapt/main")
        }
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
