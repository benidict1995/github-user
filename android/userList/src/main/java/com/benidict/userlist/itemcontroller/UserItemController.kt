package com.benidict.userlist.itemcontroller

import com.airbnb.epoxy.TypedEpoxyController
import com.benidict.domain.model.User
import com.benidict.userlist.itemmodel.userItem

class UserItemController (
    val itemClick: (String) -> Unit
): TypedEpoxyController<List<User>>(){

    override fun buildModels(data: List<User>) {
        val size = data.size

        for(i in 0 until size){
            val item = data[i]
            userItem {
                id(i)
                user(item)
                viewClickListener{ model, _, _, _ ->
                    itemClick(model.user().htmlUrl?:"")
                }
            }
        }

    }


}