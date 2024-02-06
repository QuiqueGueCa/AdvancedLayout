package com.example.advancedlayout.data.domain.repository

import com.example.advancedlayout.data.domain.model.UserModel
import com.example.advancedlayout.data.domain.model.WeaponModel
import kotlinx.coroutines.flow.Flow

interface DataSource {
    fun getUsersList(): Flow<MutableList<UserModel>>
    fun getWeaponsList(): Flow<MutableList<WeaponModel>>
}