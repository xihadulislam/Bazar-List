package com.okcodex.bazarlist.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.okcodex.bazarlist.data.db.entities.BazarItem


@Database(

    entities = [BazarItem::class],
    version = 1
)
abstract class BazarDatabase : RoomDatabase() {

    abstract fun getBazarDao(): BazarDao

    companion object {
        private var instance: BazarDatabase? = null
        private var LOC = Any()
        operator fun invoke(context: Context) = instance
            ?: synchronized(LOC) {
            instance
                ?: createDatabase(
                    context
                ).also {
                instance = it
            }
        }


        private fun createDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext, BazarDatabase::class.java, "Bazarg.db")
                .build()


    }


}