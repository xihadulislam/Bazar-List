package com.okcodex.bazarlist.ui.BazarListActivity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.okcodex.bazarlist.data.repositories.BazarRepository

@Suppress("UNCHECKED_CAST")
class BazarLisrtViewFactory  (private  val  repository: BazarRepository): ViewModelProvider.NewInstanceFactory()  {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        return  BazarListViewModel(repository) as T
    }

}