package com.example.advancedlayout.useCases

import com.example.advancedlayout.R
import com.example.advancedlayout.model.User
import com.example.advancedlayout.model.Weapon
import com.example.advancedlayout.utils.Constants
import com.example.advancedlayout.utils.RandomsGenerator
import kotlin.random.Random

class DataProvider {

    fun getUsersList(): MutableList<User> = mutableListOf(
        User(
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
        User(
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
        User(
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
        User(
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

    fun getWeaponsList(): MutableList<Weapon> {
        val weapons = mutableListOf<Weapon>()
        val itemsQuantity = Random.nextInt(
            Constants.MIN_ITEMS_LIST, Constants.MAX_ITEMS_LIST
        )

        for (i in 0..itemsQuantity) {
            weapons.add(
                Weapon(
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