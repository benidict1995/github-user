package com.benidict.ben_exam.injection

import com.benidict.userlist.UserListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { UserListViewModel(get()) }
}