package com.teste_br_mall.presenter

import com.teste_br_mall.model.Persona

interface ViewHome {
    interface View {
        fun showProgressBar()
        fun showFailure(message: String)
        fun hideProgressBar()
        fun showPersona(character: List<Persona>)
    }
}