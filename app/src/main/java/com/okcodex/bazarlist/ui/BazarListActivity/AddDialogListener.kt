package com.okcodex.bazarlist.ui.BazarListActivity

import com.okcodex.bazarlist.data.db.entities.BazarItem

interface AddDialogListener {
    fun onAddButtonClicked(item: BazarItem)
}