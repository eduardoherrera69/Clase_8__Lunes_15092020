package com.example.clase_8__lunes_15092020.model

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

  @GET("realestate")
    fun getDataFromApi() : Call<List<Terrain>>


}