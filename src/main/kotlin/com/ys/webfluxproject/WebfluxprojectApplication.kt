package com.ys.webfluxproject


import com.mongodb.ConnectionString
import com.mongodb.MongoClientSettings
import com.mongodb.connection.ClusterSettings
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration
import com.mongodb.reactivestreams.client.MongoClient
import com.mongodb.reactivestreams.client.MongoClients
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories

@SpringBootApplication(exclude = [MongoAutoConfiguration::class, MongoDataAutoConfiguration::class])
@EnableReactiveMongoRepositories
class WebfluxprojectApplication: AbstractReactiveMongoConfiguration() {

    @Bean
    override fun reactiveMongoClient(): MongoClient = MongoClients.create("mongodb://tester:1234@10.20.1.216:27017/testdb")
    override fun getDatabaseName(): String = "testdb"
}

    fun main(args: Array<String>) {
        runApplication<WebfluxprojectApplication>(*args)
    }

