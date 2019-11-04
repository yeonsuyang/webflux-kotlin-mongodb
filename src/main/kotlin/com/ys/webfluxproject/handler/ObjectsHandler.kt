package com.ys.webfluxproject.handler




import com.ys.webfluxproject.domain.Object
import com.ys.webfluxproject.service.ObjectsService
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserters.fromObject
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.web.reactive.function.server.ServerResponse.*


@Component
class ObjectsHandler(private val objectsService: ObjectsService) {


    fun getById(request: ServerRequest) = objectsService.findById(request.pathVariable("id").toInt())
            .flatMap { ok().body(fromObject(it)) }
            .switchIfEmpty(notFound().build())
    // .flatMap{obj -> ServerResponse.ok().contentType(APPLICATION_JSON).body(fromObject(obj)) }
    //            .switchIfEmpty(notFound)

    fun getAll(request: ServerRequest) = ServerResponse.ok().contentType(APPLICATION_JSON).body(objectsService.findAll(),Object::class.java)

    fun createObj(request: ServerRequest) = request.bodyToMono(Object::class.java)
            .flatMap { ok().contentType(APPLICATION_JSON).body(objectsService.createObject(it),Object::class.java) }
}
