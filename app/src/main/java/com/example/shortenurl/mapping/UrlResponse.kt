package com.example.shortenurl.mapping

import com.example.shortenurl.models.NewUrlResultModel

internal fun NewUrlResponse.toModel(): NewUrlResultModel =
    NewUrlResultModel(
        code = requestNewUrl.code,
        message = requestNewUrl.message,
    )
