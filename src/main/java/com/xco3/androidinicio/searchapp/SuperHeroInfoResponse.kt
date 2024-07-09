package com.xco3.androidinicio.searchapp

import com.google.gson.annotations.SerializedName

data class SuperHeroInfoResponse(
    @SerializedName("name") val name: String,
    @SerializedName("powerstats") val powerstats: PowerStatsResponse,
    @SerializedName("image") val image: SuperheroImageDetailResponse,
    @SerializedName("biography") val biography: Biography,
    @SerializedName("work") val work: Work,
    @SerializedName("connections") val connections: Connections
)

data class PowerStatsResponse(
    @SerializedName("intelligence") val intelligence: String,
    @SerializedName("strength") val strength: String,
    @SerializedName("speed") val speed: String,
    @SerializedName("durability") val durability: String,
    @SerializedName("power") val power: String,
    @SerializedName("combat") val combat: String
)

data class SuperheroImageDetailResponse(@SerializedName("url") val url: String)

data class Biography(
    @SerializedName("full-name") val fullName: String,
    @SerializedName("publisher") val publisher: String,
    @SerializedName("first-appearance") val firstAppearance: String
)

data class Work(@SerializedName("occupation") val ocu: String)

data class Connections(
    @SerializedName("group-affiliation") val group: String,
    @SerializedName("relatives") val relatives: String
)