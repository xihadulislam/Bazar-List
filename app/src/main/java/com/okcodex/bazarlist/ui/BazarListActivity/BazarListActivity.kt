package com.okcodex.bazarlist.ui.BazarListActivity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.okcodex.bazarlist.R
import com.okcodex.bazarlist.data.db.entities.BazarItem
import com.okcodex.bazarlist.others.ItemAdapter
import kotlinx.android.synthetic.main.activity_bazar_list.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class BazarListActivity : AppCompatActivity(), KodeinAware {


    override val kodein by kodein()
    private val factory by instance<BazarLisrtViewFactory>()
    private val viewModel by viewModels<BazarListViewModel> { factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bazar_list)


        val adapter = ItemAdapter(listOf(), viewModel)

        rvShoppingItems.layoutManager = LinearLayoutManager(this)
        rvShoppingItems.adapter = adapter

        viewModel.getBazarList().observe(this, Observer {
            adapter.list = it
            adapter.notifyDataSetChanged()

        })

        fab.setOnClickListener {
            AddItemDialog(
                this,
                object : AddDialogListener {
                    override fun onAddButtonClicked(item: BazarItem) {
                        viewModel.upsert(item)
                    }
                }).show()
        }


    }
}

