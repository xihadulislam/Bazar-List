package com.okcodex.bazarlist.data.repositories

import com.okcodex.bazarlist.data.db.BazarDatabase
import com.okcodex.bazarlist.data.db.entities.BazarItem

class BazarRepository ( private val db : BazarDatabase) {

    suspend fun upsert(item: BazarItem) = db.getBazarDao().upsert(item)

    suspend fun delete(item: BazarItem) = db.getBazarDao().delete(item)

     fun getBazarList() = db.getBazarDao().getBzarList()





}