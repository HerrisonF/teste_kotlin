package com.teste_kotlin.presenter

import com.teste_kotlin.model.Persona

interface ViewHome {
    interface View {
        fun showProgressBar()
        fun showFailure(message: String)
        fun hideProgressBar()
        fun showPersona(persona: MutableList<Persona>)
    }
}