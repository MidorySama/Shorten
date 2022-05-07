package com.example.shortenurl.models

import com.google.gson.annotations.SerializedName

data class NewUrlResult(
    @SerializedName("code") var code: String = "",
    @SerializedName("message") var message: String = ""
)
