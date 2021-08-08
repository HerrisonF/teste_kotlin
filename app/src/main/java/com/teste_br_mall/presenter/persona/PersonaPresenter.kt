package com.teste_br_mall.presenter.persona

import com.teste_br_mall.model.Persona
import com.teste_br_mall.model.ResultAPI
import com.teste_br_mall.model.data.PersonaDataSource
import com.teste_br_mall.presenter.ViewHome

class PersonaPresenter(private val view: ViewHome.View, private val dataSource: PersonaDataSource) : PersonaHome.Presenter {

    private var page : Int = 0
    private var personaList: MutableList<Persona> = ArrayList()

    override fun requestAll() {
        page++
        this.view.showProgressBar()
        this.dataSource.getCharacterAPI(this, page)
    }

    override fun onSuccess(persona: ResultAPI) {
        //adicionar mais itens
        persona.results?.let { this.view.showPersona(it) }
    }

    override fun onError(message: String) {
        this.view.showFailure(message)
    }

    override fun onComplete() {
        this.view.hideProgressBar()
    }


}