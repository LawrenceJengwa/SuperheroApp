package com.lawrence.superheroapp.rest.network;

import com.lawrence.superheroapp.rest.model.Biography;
import com.lawrence.superheroapp.rest.model.Connections;
import com.lawrence.superheroapp.rest.model.Id;
import com.lawrence.superheroapp.rest.model.Image;
import com.lawrence.superheroapp.rest.model.Result;
import com.lawrence.superheroapp.rest.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface GetService {

    @GET("api/105581651029925/{id}/biography")
    Call<List<Biography>> getBio(@Path("id") String characterId);

    @GET("api/105581651029925/{id}/connections")
    Call<Connections> getConnections(@Path("id") String characterId);

    @GET("api/105581651029925/{character-id}")
    Call<Id>getCharacterById(@Path("character-id") String id);

    @GET("api/105581651029925/{character-id}/image")
    Call<Image>getImage(@Path("character-id") String id);

}
