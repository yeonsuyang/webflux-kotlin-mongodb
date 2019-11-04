package com.ys.webfluxproject.service

import com.ys.webfluxproject.domain.Object
import com.ys.webfluxproject.domain.ObjectsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import reactor.core.publisher.Flux



interface ObjectsService{

    fun findAll(): Flux<Object>
    fun findById(id: Int): Mono<Object>

    fun createObject(obj: Object): Mono<Object>

    //fun updateObject(obj: Object, id: Int): Mono<Object>

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



}

