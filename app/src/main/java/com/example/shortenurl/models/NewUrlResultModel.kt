package com.example.shortenurl.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class NewUrlResultModel(
    var code: String = "",
    var message: String = "",
) : Parcelable
