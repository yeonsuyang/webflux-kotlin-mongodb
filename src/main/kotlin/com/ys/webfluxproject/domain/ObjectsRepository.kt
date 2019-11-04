package com.ys.webfluxproject.domain


import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono


interface ObjectsRepository : ReactiveCrudRepository<Object, Integer>{

    fun findById(id: Int): Mono<Object>
    fun findByName(name : String) : Flux<Object>
}

