package com.teste_br_mall.model.data

import com.teste_br_mall.network.RetrofitInstance
import com.teste_br_mall.presenter.persona.PersonaHome
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class PersonaDataSource() {


    fun getCharacterAPI(callback: PersonaHome.Presenter){
        GlobalScope.launch(Dispatchers.Main) {
            val response = RetrofitInstance.api.getCharacterAPI()
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