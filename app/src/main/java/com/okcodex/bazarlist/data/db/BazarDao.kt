package com.okcodex.bazarlist.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.okcodex.bazarlist.data.db.entities.BazarItem

@Dao
interface BazarDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: BazarItem)

    @Query(" SELECT * FROM bazar_item ")
    fun getBzarList(): LiveData<List<BazarItem>>

    @Delete
    suspend fun delete(item: BazarItem)


}