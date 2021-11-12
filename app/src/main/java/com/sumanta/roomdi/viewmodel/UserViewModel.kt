package com.sumanta.roomdi.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.sumanta.roomdi.model.User
import com.sumanta.roomdi.repo.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject
constructor(private val userRepository: UserRepository
    ): ViewModel() {
        val getUserData: LiveData<List<User>> = userRepository.getUserData
            .flowOn(Dispatchers.Main).asLiveData(context = viewModelScope.coroutineContext)


    fun insert(user: User) = viewModelScope.launch {
        userRepository.insert(user)
    }
}