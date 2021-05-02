package com.benidict.ben_exam.injection

import com.benidict.domain.interactor.user.GetUserListUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single { GetUserListUseCase(get()) }
}