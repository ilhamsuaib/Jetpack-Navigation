package dev.ilhamsuaib.navi.adapter

import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import dev.ilhamsuaib.navi.R
import dev.ilhamsuaib.navi.common.loadImage
import kotlinx.android.synthetic.main.item_home.view.*

/**
 * Created by @ilhamsuaib on 2019-09-11.
 * github.com/ilhamsuaib
 */

class HomeAdapter(private val onClick: (String) -> Unit) : Item() {

    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.itemView.run {
            val item = "Item ${position.plus(1)}"

            tvName.text = item
            setOnClickListener { onClick(item) }
            imgAvatar.loadImage(R.drawable.img_avatar)
        }
    }

    override fun getLayout(): Int = R.layout.item_home
}