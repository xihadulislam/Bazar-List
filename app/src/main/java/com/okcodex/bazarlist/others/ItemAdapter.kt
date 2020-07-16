package com.okcodex.bazarlist.others

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.okcodex.bazarlist.R
import com.okcodex.bazarlist.data.db.entities.BazarItem
import com.okcodex.bazarlist.ui.BazarListActivity.BazarListViewModel
import kotlinx.android.synthetic.main.item_view.view.*

class ItemAdapter (var list : List<BazarItem> , private  val  viewModel: BazarListViewModel) : RecyclerView.Adapter<ItemAdapter.BazarViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BazarViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return BazarViewHolder(view)
    }

    override fun getItemCount(): Int {
     return list.size
    }

    override fun onBindViewHolder(holder: BazarViewHolder, position: Int) {

        val curentItem = list[position]

        holder.itemView.tvName.text = curentItem.name
        holder.itemView.tvAmount.text = "${curentItem.amount}"

        holder.itemView.ivDelete.setOnClickListener {
            viewModel.delete(curentItem)
        }

        holder.itemView.ivPlus.setOnClickListener {
            curentItem.amount++
            viewModel.upsert(curentItem)
        }

        holder.itemView.ivMinus.setOnClickListener {
            if(curentItem.amount > 0) {
                curentItem.amount--
                viewModel.upsert(curentItem)
            }
        }
    }

    inner class BazarViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)


}