package com.ys.webfluxproject.controller

import com.ys.webfluxproject.domain.Object
import com.ys.webfluxproject.service.ObjectsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class ObjectController {

    @Autowired
    private lateinit var objectsService: ObjectsService

    @GetMapping(value = ["/id/{id}"])
    fun getObjectbyId(@PathVariable id: Int) = Object(id,"hi")

    @GetMapping(value = ["/name/{name}"])
    fun getObjectbyName(@PathVariable name:String): ResponseEntity<Object>{
        return ResponseEntity(Object(7,name), HttpStatus.OK)
    }

    @GetMapping(value=["/objectAll"])
    fun getObjects() = objectsService.findAll()

}