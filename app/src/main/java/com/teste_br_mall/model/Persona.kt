package com.teste_br_mall.model

import java.io.Serializable

data class Persona(
    val created: String?,
    val episode: MutableList<String>,
    val gender: String?,
    val id: Int?,
    val image: String?,
    val location: Location?,
    val name: String?,
    val origin: Origin?,
    val species: String?,
    val status: String?,
    val type: String?,
    val url: String?
): Serializable