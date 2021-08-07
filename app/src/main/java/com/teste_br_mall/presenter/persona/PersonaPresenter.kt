package com.teste_br_mall.presenter.persona

import com.teste_br_mall.model.ResultAPI
import com.teste_br_mall.model.data.PersonaDataSource
import com.teste_br_mall.presenter.ViewHome

class PersonaPresenter(val view: ViewHome.View, private val dataSource: PersonaDataSource) : PersonaHome.Presenter {

    override fun requestAll() {
        this.view.showProgressBar()
        this.dataSource.getCharacterAPI(this)
    }

    override fun onSuccess(persona: ResultAPI) {
        this.view.showPersona(persona.results)
    }

    override fun onError(message: String) {
        this.view.showFailure(message)
    }

    override fun onComplete() {
        this.view.hideProgressBar()
    }


}