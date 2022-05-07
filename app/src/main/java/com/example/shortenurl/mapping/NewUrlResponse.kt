package com.example.shortenurl.mapping

import com.example.shortenurl.models.NewUrlResult
import com.google.gson.annotations.SerializedName

data class NewUrlResponse(
    @SerializedName("result")
    val requestNewUrl: NewUrlResult = NewUrlResult()
)


