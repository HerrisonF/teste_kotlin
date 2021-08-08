package com.teste_kotlin.presenter.persona

import com.teste_kotlin.model.ResultAPI

interface PersonaHome {

    interface Presenter {
        fun requestAll()
        fun onSuccess(persona: ResultAPI)
        fun onError(message: String)
        fun onComplete()
    }

}