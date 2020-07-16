package com.okcodex.bazarlist.ui.BazarListActivity

import androidx.lifecycle.ViewModel
import com.okcodex.bazarlist.data.db.entities.BazarItem
import com.okcodex.bazarlist.data.repositories.BazarRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class BazarListViewModel (private  val repository: BazarRepository) : ViewModel() {

    
    fun upsert(item: BazarItem) =
        GlobalScope.launch {
            repository.upsert(item)
        }

    fun delete(item: BazarItem) = GlobalScope.launch {
        repository.delete(item)
    }

    fun getBazarList() = repository.getBazarList()


}