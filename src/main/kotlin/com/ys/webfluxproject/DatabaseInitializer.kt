package com.ys.webfluxproject

import com.ys.webfluxproject.domain.Object
import com.ys.webfluxproject.domain.ObjectsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.ReactiveMongoOperations
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct

@Component
class DatabaseInitializer {

    @Autowired
    lateinit var mongoOperations: ReactiveMongoOperations

    @Autowired
    lateinit var objectsRepository: ObjectsRepository

    @PostConstruct
    fun initDate(){
        mongoOperations.collectionExists("objects").subscribe(){
            if( it != true){
                mongoOperations.createCollection("objects").subscribe(){
                    println("object collection created")
                }
            }else{ println("object collections already exist")
                objectsRepository.save(Object(1,"1")).subscribe(){
                println("data add")}
            }
        }
    }
}
