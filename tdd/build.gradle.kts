plugins {
    id("java")
    id("application")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
    implementation(kotlin("stdlib", "1.8.21"))

}
application {
    // Définir la classe principale avec la méthode main()
    mainClass.set("org.example.TicTacToe") // Assurez-vous que le nom de la classe est correct
}
tasks.test {
    useJUnitPlatform()
}