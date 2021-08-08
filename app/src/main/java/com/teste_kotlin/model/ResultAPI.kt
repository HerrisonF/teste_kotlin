package com.teste_kotlin.model

import java.io.Serializable

data class ResultAPI(
    val info: Info?,
    val results: MutableList<Persona>?,
) : Serializable