package com.example.shortenurl.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shortenurl.models.NewUrlResultModel
import com.example.shortenurl.repositories.NewUrlRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class NewUrlViewModel @Inject constructor(
    var newUrlRepository: NewUrlRepository
) : ViewModel() {

    // libera los recursos al usar programación reactiva
    private val compositeDisposable = CompositeDisposable()

    val url: MutableLiveData<NewUrlResultModel> by lazy {
        MutableLiveData<NewUrlResultModel>()
    }

    fun newUrl(
        alias: String,
        links: String,

    ) {
        compositeDisposable += newUrlRepository.newUr(
            alias = alias,
            links = links
        )
            .subscribeOn(Schedulers.io())
            .subscribe({ newUr ->
                url.postValue(newUr)
            }, {
                url.postValue(
                    NewUrlResultModel(
                        code = "-1",
                        message = "error!"
                    )
                )
            })
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}
