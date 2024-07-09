package com.xco3.androidinicio.searchapp

import com.google.gson.annotations.SerializedName

data class SuperHeroDataResponse(@SerializedName("response") val response:String,
    @SerializedName("results") val superH: List<SuperHeroItemResponse>)

data class SuperHeroItemResponse(@SerializedName("id") val id:String,
    @SerializedName("name") val name:String,
    @SerializedName("image") val superheroImage: SuperHeroImageResponse)

data class SuperHeroImageResponse(@SerializedName("url") val url:String)