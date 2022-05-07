package com.example.shortenurl.repositories

import com.example.shortenurl.api.CoreHomeApi
import com.example.shortenurl.mapping.toModel
import com.example.shortenurl.models.NewUrlRequest
import com.example.shortenurl.models.NewUrlResultModel
import io.reactivex.Single
import javax.inject.Inject

class NewUrlRepository @Inject constructor(
    private val apiService: CoreHomeApi
) {

    fun newUr(
        alias: String,
        links: String,

    ): Single<NewUrlResultModel> {
        return apiService.newUrl(
            newUrl = NewUrlRequest(
                alias = alias,
                links = links,
            )
        )
            .map { newUrl ->
                newUrl.toModel()
            }
    }
}
