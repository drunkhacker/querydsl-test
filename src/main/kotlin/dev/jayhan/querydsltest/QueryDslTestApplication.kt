package dev.jayhan.querydsltest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled

@SpringBootApplication
@EnableScheduling
class QueryDslTestApplication

fun main(args: Array<String>) {
    runApplication<QueryDslTestApplication>(*args)
}

@Scheduled(fixedDelay = 1000 * 60 * 60) // every hour
fun doNothing() {
    println("hi")
    // Forces Spring Scheduling managing thread to start
}