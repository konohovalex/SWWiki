package ru.konohovalex.swwiki.feature.vehicle.common.data.api.network

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.konohovalex.swwiki.feature.vehicle.common.data.api.dto.VehicleDto
import ru.konohovalex.swwiki.feature.vehicle.common.data.api.dto.VehiclePagingDto

interface VehicleApi {
    @GET("vehicles")
    suspend fun getAllVehicles(@Query("page") page: Int): VehiclePagingDto

    @GET("vehicles/{id}")
    suspend fun getVehicle(@Path("id") id: Int): VehicleDto

    @GET("vehicles")
    suspend fun findVehicles(
        @Query("page") page: Int,
        @Query("search") query: String,
    ): VehiclePagingDto
}
