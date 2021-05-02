package com.benidict.userlist

import android.content.Intent
import android.net.Uri
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.benidict.core.BaseFragment
import com.benidict.core.state.UIState
import com.benidict.userlist.databinding.FragmentUserListBinding
import com.benidict.userlist.itemcontroller.UserItemController
import org.koin.androidx.viewmodel.ext.android.viewModel


class UserListFragment : BaseFragment<FragmentUserListBinding>(
    FragmentUserListBinding::inflate
), SearchView.OnQueryTextListener{

    private val vm: UserListViewModel by viewModel()

    private val controller: UserItemController by lazy {
        UserItemController{
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(it))
            startActivity(browserIntent)
        }
    }

    private lateinit var mLayoutManager: LinearLayoutManager

    override fun setUpView() {
        super.setUpView()
        viewBinding.svUser.setOnQueryTextListener(this)
        initRecyclerView()
    }

    override fun loadContent() {
        super.loadContent()
        vm.doLoadUserList.value = null
    }

    private fun initRecyclerView(){
        mLayoutManager = LinearLayoutManager(activity)

        viewBinding.userListRv.apply {
            layoutManager = mLayoutManager
        }.setController(controller)
    }

    override fun setUpObservable() {
        super.setUpObservable()
        vm.loadUserList.observe(this, { result ->
            when (result) {
                UIState.Loading -> {
                    // Do Loading state
                }
                is UIState.Success -> {
                    controller.setData(result.data)
                }
                is UIState.Error -> {
                    // Show Error message
                }
            }

        })
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        return false
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        vm.doLoadUserList.value = if (newText.isNullOrEmpty()) "a" else newText
        return true
    }
}