package com.ys.webfluxproject.service

import com.ys.webfluxproject.domain.Object
import com.ys.webfluxproject.domain.ObjectsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import reactor.core.publisher.Flux
import reactor.core.publisher.toMono
import java.util.concurrent.ConcurrentHashMap


interface ObjectsService{

    fun findAll(): Flux<Object>
    fun findById(id: Int): Mono<Object>

    fun createObject(obj: Object): Mono<Object>
    fun printObject(obj: Mono<Object>) : Mono<*>
}

@Service("objectService")
class ObjectServiceImpl : ObjectsService{

    @Autowired
    lateinit var objectsRepository: ObjectsRepository


    override fun findAll(): Flux<Object> {
       return objectsRepository.findAll()
    }

    override fun findById(id: Int): Mono<Object> {
        return objectsRepository.findById(id)
    }

    override fun createObject(obj: Object ): Mono<Object> {
        return objectsRepository.save(obj)
    }

    override fun printObject(obj: Mono<Object>): Mono<*> {
       return obj.subscribe {
           println(obj)
       }.toMono()
    }
}

