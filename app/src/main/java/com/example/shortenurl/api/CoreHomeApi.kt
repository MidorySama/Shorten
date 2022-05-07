package com.example.shortenurl.api

import com.example.shortenurl.mapping.NewUrlResponse
import com.example.shortenurl.models.NewUrlRequest
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface CoreHomeApi {

    @GET("/id:")
    @Headers("Content-Type: application/json ")
    fun getAlias(): Single<>

    @POST("/alias")
    @Headers("Content-Type: application/json ")
    fun newUrl(@Body newUrl: NewUrlRequest): Single<NewUrlResponse>
}
