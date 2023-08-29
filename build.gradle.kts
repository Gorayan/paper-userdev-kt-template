plugins {

    // Kotlinのソースコードをコンパイルするためのプラグイン
    alias(libs.plugins.kotlin.jvm)

    // Paperプラグイン開発で便利なプラグイン
    alias(libs.plugins.paperweight.userdev)

    // Gradle上でテストサーバーを起動するためのプラグイン
    alias(libs.plugins.run.paper)

}

group = project.property("maven-group")!!
version = project.property("plugin-version")!!

java {

    // Configure the java toolchain. This allows gradle to auto-provision JDK 17 on systems that only have JDK 8 installed for example.
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))

}

kotlin {

    jvmToolchain(17)

}

dependencies {

    paperweight.paperDevBundle(libs.versions.paper.asProvider())

}

tasks {

    // Configure reobfJar to run when invoking the build task
    assemble {
        dependsOn(reobfJar)
    }

    compileJava {

        options.encoding = Charsets.UTF_8.name() // We want UTF-8 for everything

        // Set the release flag. This configures what version bytecode the compiler will emit, as well as what JDK APIs are usable.
        // See https://openjdk.java.net/jeps/247 for more information.
        options.release.set(17)

    }

    javadoc {

        options.encoding = Charsets.UTF_8.name() // We want UTF-8 for everything

    }

    processResources {

        filteringCharset = Charsets.UTF_8.name() // We want UTF-8 for everything

        val props = mapOf(
            "name" to project.property("plugin-name")!!,
            "version" to project.version,
            "description" to project.property("plugin-description")!!,
            "kotlinVersion" to libs.versions.kotlin.get(),
            "apiVersion" to libs.versions.paper.api.get()
        )

        inputs.properties(props)

        filesMatching("plugin.yml") {
            expand(props)
        }

    }

}
