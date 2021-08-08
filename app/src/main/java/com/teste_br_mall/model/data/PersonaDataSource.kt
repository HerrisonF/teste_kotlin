package com.teste_br_mall.model.data

import com.teste_br_mall.model.Persona
import com.teste_br_mall.model.ResultAPI
import com.teste_br_mall.network.RetrofitInstance
import com.teste_br_mall.presenter.persona.PersonaHome
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class PersonaDataSource() {

    private lateinit var personaList: ResultAPI


    fun getCharacterAPI(callback: PersonaHome.Presenter, page: Int){
        GlobalScope.launch(Dispatchers.Main) {
            val response = RetrofitInstance.api.getCharacterAPI(page)
            if(response.isSuccessful){
                response.body()?.let { persona ->
                    if(personaList.results.size > 0){}
                    callback.onSuccess(persona)
                }
                callback.onComplete()
            }else{
                callback.onError(response.message())
                callback.onComplete()
            }
        }
    }

}