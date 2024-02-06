package com.example.advancedlayout.data.domain.usecases

import com.example.advancedlayout.data.domain.model.WeaponModel
import com.example.advancedlayout.data.domain.repository.DataProvider
import kotlinx.coroutines.flow.Flow

class GetWeaponsListUseCase(private val dataProvider: DataProvider) {
    operator fun invoke(): Flow<MutableList<WeaponModel>> {
        return dataProvider.getWeaponsList()
    }
}