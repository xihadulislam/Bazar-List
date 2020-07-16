package com.okcodex.bazarlist

import android.app.Application
import com.okcodex.bazarlist.data.db.BazarDatabase
import com.okcodex.bazarlist.data.repositories.BazarRepository
import com.okcodex.bazarlist.ui.BazarListActivity.BazarLisrtViewFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class MyApp() :Application(), KodeinAware {

    override val kodein: Kodein = Kodein.lazy {
        import(androidXModule(this@MyApp))

        bind() from singleton { BazarDatabase(instance()) }
        bind() from singleton { BazarRepository(instance()) }
        bind() from provider { BazarLisrtViewFactory(instance()) }

    }
}