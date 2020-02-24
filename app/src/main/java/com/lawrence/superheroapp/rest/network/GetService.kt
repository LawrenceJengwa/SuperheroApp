package com.lawrence.superheroapp.rest.network

import com.lawrence.superheroapp.rest.model.Biography
import com.lawrence.superheroapp.rest.model.Connections
import com.lawrence.superheroapp.rest.model.Id
import com.lawrence.superheroapp.rest.model.Image
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GetService {
    @GET("api/105581651029925/{id}/biography")
    fun getBio(@Path("id") characterId: String?): Call<List<Biography?>?>?

    @GET("api/105581651029925/{id}/connections")
    fun getConnections(@Path("id") characterId: String?): Call<Connections?>?

    @GET("api/105581651029925/{character-id}")
    fun getCharacterById(@Path("character-id") id: String?): Call<Id?>?

    @GET("api/105581651029925/{character-id}/image")
    fun getImage(@Path("character-id") id: String?): Call<Image?>?
}