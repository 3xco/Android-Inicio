package com.xco3.androidinicio.searchapp

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("api/a88be984d95ad028c1342f5bcd69e5fe/search/{name}")
    suspend fun getSuperheroes(@Path("name") shName: String): Response<SuperHeroDataResponse>

    @GET("api/a88be984d95ad028c1342f5bcd69e5fe/{id}")
    suspend fun getSuperheroesInfo(@Path("id") shId: String): Response<SuperHeroInfoResponse>
}
