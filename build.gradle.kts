/*
 * Copyright (C) 2019 Oleksii Kucheruk <oleksii.kucheruk@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

/*
 * Gradle build automation script written using Kotlin DSL
 *
 * Written by: Oleksii Kucheruk on Wed May 29 2019
 */

/*
 * Create read-only ext variables
 */
val checkstyleVersion by extra { "8.20" }
val checkstyleConfigFile by extra { "config/checkstyle/google_checks.xml" }

val junitApiVersion by extra { "5.4.2" }

val mainClass by extra { "AnalogWatch" }
val jacocoVersion by extra { "0.8.3" }
val minimumBundleCoverage by extra { 0.5 }
val minimumClassCoverage by extra { 0.5 }

val guavaVersion by extra { "27.1-jre" }

val slf4jApiVersion by extra { "1.7.26" }

plugins {
    idea
    java
    checkstyle // Static code analysis for Java source code
    jacoco // Java Code Coverage Library
    `build-dashboard`
    id("org.sonarqube") version "2.7" // Continuous inspection of code quality
}

group = "AnalogWatch"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testCompile("org.junit.jupiter:junit-jupiter-api:" + junitApiVersion)
    testImplementation("org.junit.jupiter:junit-jupiter-api:" + junitApiVersion)
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:" + junitApiVersion)
    compile("org.slf4j:slf4j-api:" + slf4jApiVersion)
    compile("org.slf4j:slf4j-log4j12:"+ slf4jApiVersion)
    implementation("com.google.guava:guava:" + guavaVersion)
}

checkstyle {
    toolVersion = checkstyleVersion
    configFile = file(checkstyleConfigFile)
    isIgnoreFailures = true
}

jacoco {
    toolVersion = jacocoVersion
}

sonarqube {
    properties {
        property("sonar.projectKey", "okucheruk_AnalogWatch")
        property("sonar.organization","okucheruk-github")
        property("sonar.host.url", "https://sonarcloud.io")
        property("sonar.login", "fde76f534e76294c8728bd40ab37f58030800f12")
        property("sonar.branch.name", "master")
        // property("sonar.branch.target", "master") // commented because the main(master) branch must not have a target
        property("sonar.java.checkstyle.reportPaths",
                "build/reports/checkstyle/main.xml,build/reports/checkstyle/test.xml")
    }
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}

tasks {
    /*
    * Enable required JaCoCo reports formats (HTML, XML, CSV).
    * Note: build-dashboard plugin depends on these setting;
    * coveralls plugin depends on xml format report
    */
    val jacocoTestReport by getting(JacocoReport::class) {
        reports.html.isEnabled = true
        reports.xml.isEnabled = true
        reports.csv.isEnabled = false
    }

    /*
     * Enable native support for JUnit.
     * Add to test task jacocoTestReport execution
     */
    val test by getting(Test::class) {
        useJUnitPlatform()
        finalizedBy(jacocoTestReport)
    }
}
