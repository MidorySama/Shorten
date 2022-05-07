package com.example.shortenurl.activities

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shortenurl.databinding.ActivityMainBinding
import com.example.shortenurl.models.NeUrlResul
import com.example.shortenurl.models.NewUrl
import com.example.shortenurl.viewmodel.NewUrlViewModel
import com.example.shortenurl.views.adapter.NewUrlAdapter
import com.example.shortenurl.views.component.NewUrlDetBottomSheet
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class  MainActivity : AppCompatActivity() {

    var binding: ActivityMainBinding? = null
    private val newUrlModel: NewUrlViewModel by viewModels()

    private var listNewUrlObserver = Observer<NeUrlResul> { neUrlResult ->
        if (neUrlResult.susses) {
            neUrlResult.list?.let {
                val adapter = NewUrlAdapter(
                    it,
                    onItemClickListener,
                    applicationContext
                )
                binding?.recyclerView?.adapter = adapter
                adapter.notifyDataSetChanged()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        initRecycler()
        initObserver()

        //urlViewModel.getRecipeBook()
    }

   /* private var onItemClickListener: ((newUrl: NewUrl) -> Unit) = { newURl ->*/
   /*     Toast.makeText(this, "Url:" + newURl.alias,newURl.links, Toast.LENGTH_SHORT).show()*/
   /*     NewUrlDetBottomSheet.newInstance(*/
   /*         newURl.alias,*/
   /*         newURl.links,*/

  /*      )*/
  /*          .show(supportFragmentManager, "")*/
  /*  }*/

    private fun initObserver() {
        newUrlModel.url.observe(this, listNewUrlObserver )
    }

    private fun initRecycler() {
        val linearLayoutManager = LinearLayoutManager(this)
        binding?.recyclerView?.apply {
            layoutManager = linearLayoutManager
            isNestedScrollingEnabled = false
            setHasFixedSize(true)

        }
    }
}

