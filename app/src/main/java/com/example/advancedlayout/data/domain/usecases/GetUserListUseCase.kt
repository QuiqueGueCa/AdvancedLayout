package com.example.advancedlayout.data.domain.usecases

import com.example.advancedlayout.data.domain.model.UserModel
import com.example.advancedlayout.data.domain.repository.DataProvider
import kotlinx.coroutines.flow.Flow

class GetUserListUseCase(private val dataProvider: DataProvider) {
    operator fun invoke(): Flow<MutableList<UserModel>> {
        return dataProvider.getUsersList()
    }
}