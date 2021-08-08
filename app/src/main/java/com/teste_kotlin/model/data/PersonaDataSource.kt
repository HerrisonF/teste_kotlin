package com.teste_kotlin.model.data

import com.teste_kotlin.model.ResultAPI
import com.teste_kotlin.network.RetrofitInstance
import com.teste_kotlin.presenter.persona.PersonaHome
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class PersonaDataSource() {

    fun getCharacterAPI(callback: PersonaHome.Presenter, page: Int){
        GlobalScope.launch(Dispatchers.Main) {
            val response = RetrofitInstance.api.getCharacterAPI(page)
            if(response.isSuccessful){
                response.body()?.let { persona ->
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