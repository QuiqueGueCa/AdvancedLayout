package com.example.advancedlayout.data.domain.repository

import com.example.advancedlayout.R
import com.example.advancedlayout.data.constants.Constants
import com.example.advancedlayout.data.domain.model.UserModel
import com.example.advancedlayout.data.domain.model.WeaponModel
import com.example.advancedlayout.data.utils.RandomsGenerator
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlin.random.Random

class DataProvider : DataSource {
    companion object {
        var INSTANCE: DataProvider? = null

        @Synchronized
        fun getInstance(): DataProvider {
            if (INSTANCE == null) {
                INSTANCE = DataProvider()
            }
            return INSTANCE!!
        }
    }

    override fun getUsersList(): Flow<MutableList<UserModel>> = flow {
        emit(
            mutableListOf(
                UserModel(
                    R.drawable.aragorn,
                    87,
                    "hombre",
                    RandomsGenerator.getRandomParagraph(
                        Constants.MIN_ITEMS_LENGTH, Constants.MAX_ITEMS_LENGTH
                    ),
                    RandomsGenerator.getRandomParagraph(
                        Constants.MIN_ITEMS_LENGTH, Constants.MAX_ITEMS_LENGTH
                    )
                ),
                UserModel(
                    R.drawable.legolas,
                    2931,
                    "hombre",
                    RandomsGenerator.getRandomParagraph(
                        Constants.MIN_ITEMS_LENGTH, Constants.MAX_ITEMS_LENGTH
                    ),
                    RandomsGenerator.getRandomParagraph(
                        Constants.MIN_ITEMS_LENGTH, Constants.MAX_ITEMS_LENGTH
                    )
                ),
                UserModel(
                    R.drawable.gimli,
                    139,
                    "hombre",
                    RandomsGenerator.getRandomParagraph(
                        Constants.MIN_ITEMS_LENGTH, Constants.MAX_ITEMS_LENGTH
                    ),
                    RandomsGenerator.getRandomParagraph(
                        Constants.MIN_ITEMS_LENGTH, Constants.MAX_ITEMS_LENGTH
                    )
                ),
                UserModel(
                    R.drawable.sauron,
                    999999,
                    "hombre",
                    RandomsGenerator.getRandomParagraph(
                        Constants.MIN_ITEMS_LENGTH, Constants.MAX_ITEMS_LENGTH
                    ),
                    RandomsGenerator.getRandomParagraph(
                        Constants.MIN_ITEMS_LENGTH, Constants.MAX_ITEMS_LENGTH
                    )
                )
            )
        )
    }

    override fun getWeaponsList(): Flow<MutableList<WeaponModel>> = flow {
        emit(
            createWeaponsList()
        )
    }

    fun createWeaponsList(): MutableList<WeaponModel> {
        val weapons = mutableListOf<WeaponModel>()
        val itemsQuantity = Random.nextInt(
            Constants.MIN_ITEMS_LIST, Constants.MAX_ITEMS_LIST
        )

        for (i in 0..itemsQuantity) {
            weapons.add(
                WeaponModel(
                    RandomsGenerator.getRandomParagraph(
                        Constants.MIN_ITEMS_LENGTH, Constants.MAX_ITEMS_LENGTH
                    ),
                    Random.nextFloat() * 100
                )
            )
        }
        return weapons
    }
}