package com.teste_kotlin.presenter.persona

import com.teste_kotlin.model.ResultAPI
import com.teste_kotlin.model.data.PersonaDataSource
import com.teste_kotlin.presenter.ViewHome

class PersonaPresenter(private val view: ViewHome.View, private val dataSource: PersonaDataSource) : PersonaHome.Presenter {

    private var page : Int = 0
    private var resultFromAPI: ResultAPI = ResultAPI(null, null)

    override fun requestAll() {
        page++
        this.view.showProgressBar()
        this.dataSource.getCharacterAPI(this, page)
    }

    override fun onSuccess(resultAPI: ResultAPI) {
        if(resultFromAPI.results == null){
            resultFromAPI = ResultAPI(resultAPI.info, resultAPI.results)
        }else{
            resultAPI.results?.let {
                resultFromAPI.results!!.addAll(it)
            }
        }
        resultFromAPI.results?.let { this.view.showPersona(it) }
    }

    override fun onError(message: String) {
        this.view.showFailure(message)
    }

    override fun onComplete() {
        this.view.hideProgressBar()
    }


}