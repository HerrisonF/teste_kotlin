package com.teste_br_mall.model

import java.io.Serializable

data class ResultAPI(
    val info: Info?,
    val results: MutableList<Persona>,
) : Serializable