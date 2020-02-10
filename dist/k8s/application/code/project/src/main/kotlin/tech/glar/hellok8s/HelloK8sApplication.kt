package tech.glar.hellok8s

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HelloK8sApplication

fun main(args: Array<String>) {
    runApplication<HelloK8sApplication>(*args)
}
