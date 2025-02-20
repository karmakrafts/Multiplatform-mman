/*
 * Copyright (C) Karma Krafts & associates 2025
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

plugins {
    alias(libs.plugins.kotlin.multiplatform) apply false
    alias(libs.plugins.dokka) apply false
}

group = "io.karma.mman"
version = CI.getDefaultVersion(libs.versions.multiplatformMman)

allprojects {
    group = rootProject.group
    version = rootProject.version

    repositories {
        mavenCentral()
        google()
        maven("https://files.karmakrafts.dev/maven")
    }

    if (CI.isCI) {
        dependencyLocking {
            lockAllConfigurations()
        }
        val dependenciesForAll by tasks.registering(DependencyReportTask::class) {}
    }
}