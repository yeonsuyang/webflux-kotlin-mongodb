package com.ys.webfluxproject.domain

import org.springframework.data.mongodb.core.mapping.Document

@Document(collection="objects")
data class Object(
        val id: Int? = null,
        val name: String? = null
       // val createdAt: LocalDate? = null,
      //  val modifiedAt: LocalDate? = null
)
