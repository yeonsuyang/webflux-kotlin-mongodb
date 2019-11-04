package com.ys.webfluxproject.router


import com.ys.webfluxproject.handler.ObjectsHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RequestPredicates.path
import org.springframework.web.reactive.function.server.RouterFunctions.nest
import org.springframework.web.reactive.function.server.router


@Configuration
class TodoRouter(private val handler: ObjectsHandler) {

    @Bean
    fun routerFunction() = nest(path("/objects"),
            router {
                listOf(
                        GET("/", handler::getAll),
                        POST("/", handler::createObj),
                        GET("/{id}", handler::getById))
            }
    )
}
