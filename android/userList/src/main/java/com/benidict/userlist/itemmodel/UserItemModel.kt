package com.benidict.userlist.itemmodel

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.benidict.core.helper.KotlinEpoxyHolder
import com.benidict.core.util.ImageUtil
import com.benidict.domain.model.User
import com.benidict.userlist.R

@EpoxyModelClass
abstract class UserItemModel : EpoxyModelWithHolder<UserItemModel.Holder>(){

    @EpoxyAttribute
    lateinit var user: User

    @EpoxyAttribute
    lateinit var viewClickListener: View.OnClickListener

    override fun getDefaultLayout(): Int = R.layout.item_user

    override fun bind(holder: Holder) {
        super.bind(holder)
        holder.tvUserName.text = user.login
        holder.tvScore.text = user.score
        holder.clContainer.setOnClickListener(viewClickListener)
        ImageUtil.loadImage(user.avatarUrl, holder.ivUserPicture)
    }

    class Holder : KotlinEpoxyHolder(){
        val tvUserName by bind<AppCompatTextView>(R.id.tv_user_name)
        val tvScore by bind<AppCompatTextView>(R.id.tv_score)
        val ivUserPicture by bind<AppCompatImageView>(R.id.iv_user_picture)
        val clContainer by bind<ConstraintLayout>(R.id.cl_container)
    }
}