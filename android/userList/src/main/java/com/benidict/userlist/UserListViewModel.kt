package com.benidict.userlist

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.switchMap
import com.benidict.core.state.UIState
import com.benidict.domain.exception.ServiceException
import com.benidict.domain.interactor.user.GetUserListUseCase

class UserListViewModel(
    private val getUserListUseCase: GetUserListUseCase
) : ViewModel(){

    val doLoadUserList = MutableLiveData<String?>()
    val loadUserList = doLoadUserList.switchMap {
        liveData {
            emit(UIState.Loading)
            try{
                Log.d("makerChecker", "search:$it")
                val data = getUserListUseCase.invoke(it)
                emit(UIState.Success(data))
            }catch (e: ServiceException){
                Log.d("makerChecker", "Error:${e.message}")
                //emit(UIState.Error(e.message))
            }
        }
    }


}