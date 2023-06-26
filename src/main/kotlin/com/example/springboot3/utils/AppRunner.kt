package com.example.springboot3.utils

import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.core.env.Environment
import org.springframework.stereotype.Component

@Component
class AppRunner(private val environment: Environment) : ApplicationRunner {
    override fun run(args: ApplicationArguments?) {
        println("===================다중 프로파일 테스트===================")
        println("Active profiles : ${environment.activeProfiles.toList()}")
        println("Datasource driver : ${environment.getProperty("spring.datasource.driver-class-name")}")
        println("Datasource url : ${environment.getProperty("spring.datasource.url")}")
        println("Datasource username : ${environment.getProperty("spring.datasource.username")}")
        println("Datasource password : ${environment.getProperty("spring.datasource.password")}")
        println("Server Port : ${environment.getProperty("server.port")}")
        println("Default Property : ${environment.getProperty("default.string")}")
        println("Common Property : ${environment.getProperty("common.string")}")
        println("====================================================")
    }
}