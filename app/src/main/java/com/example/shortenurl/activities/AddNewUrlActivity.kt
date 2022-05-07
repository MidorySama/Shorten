package com.example.shortenurl.activities

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.shortenurl.databinding.AddNewUrlBinding
import com.example.shortenurl.models.NewUrlResultModel
import com.example.shortenurl.viewmodel.NewUrlViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddNewUrlActivity : AppCompatActivity() {
    var binding: AddNewUrlBinding? = null

    private val newUrlViewModel = NewUrlViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AddNewUrlBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.btnEnviar?.setOnClickListener {
            Toast.makeText(this, "Ingrese Url o Link", Toast.LENGTH_SHORT).show()
            initNewUrlObserver()
        }
    }

    // este es mi callback
    private val newUrlObserve = Observer<NewUrlResultModel> { accesResultModel ->
        if (accesResultModel.code == "0") {
            Toast.makeText(this, "Url Original", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "error", Toast.LENGTH_SHORT).show()
        }
    }

    private fun NewUrlList(
        alias: String,
        links: String

    ) {
        newUrlViewModel.newUrlnewUrl(alias, links)
    }

    private fun initNewUrlObserver() {
        newUrlViewModel.url.observe(this, newUrlObserve)
    }
}
