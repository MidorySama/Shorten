package com.example.shortenurl.models

import com.google.gson.annotations.SerializedName

class NewUrlRequest(
    @SerializedName("alias") var alias: String = "",
    @SerializedName("_links") var links: String = "",
   /* @SerializedName("self") var self: String = "",
    @SerializedName("short") var short: String = "",*/
)




