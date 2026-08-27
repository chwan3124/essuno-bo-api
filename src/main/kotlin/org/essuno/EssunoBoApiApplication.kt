package org.essuno

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class EssunoBoApiApplication

fun main(args: Array<String>) {
    runApplication<EssunoBoApiApplication>(*args)
}
