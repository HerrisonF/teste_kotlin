package com.teste_kotlin.model

import java.io.Serializable

data class Info(
    val count: Int?,
    val next: String?,
    val pages: Int?,
    val prev: String?
):Serializable