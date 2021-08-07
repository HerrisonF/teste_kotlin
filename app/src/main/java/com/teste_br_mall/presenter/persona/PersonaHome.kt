package com.teste_br_mall.presenter.persona

import com.teste_br_mall.model.Persona
import com.teste_br_mall.model.ResultAPI

interface PersonaHome {

    interface Presenter {
        fun requestAll()
        fun onSuccess(persona: ResultAPI)
        fun onError(message: String)
        fun onComplete()
    }

}