package com.example.advancedlayout.useCases

import com.example.advancedlayout.R
import com.example.advancedlayout.data.User
import com.example.advancedlayout.data.Weapon
import kotlin.random.Random

class DataProvider {
    private val SPACE_ASCII_VALUE = 32

    fun getRandomParagraph(minLength: Int, maxLength: Int): String {
        var spaceCounter = 0
        val paragraphLength = Random.nextInt(minLength, maxLength)
        var paragraph = ""

        for (i in 1..paragraphLength) {

            val asciiNum = checkMustSpace(spaceCounter)

            paragraph += asciiNum.toChar()

            if (asciiNum == SPACE_ASCII_VALUE) {
                spaceCounter = 0
            } else {
                spaceCounter++
            }
        }
        return paragraph
    }

    private fun checkMustSpace(spaceCounter: Int): Int {
        val maxLettersInWord = 8

        return if (spaceCounter < maxLettersInWord) {
            Random.nextInt(32, 122)
        } else {
            SPACE_ASCII_VALUE
        }
    }

    fun getUsersList(): MutableList<User> = mutableListOf(
        User(
            R.drawable.aragorn,
            87,
            "hombre",
            getRandomParagraph(10, 25),
            getRandomParagraph(10, 120)
        ),
        User(
            R.drawable.legolas,
            2931,
            "hombre",
            getRandomParagraph(10, 25),
            getRandomParagraph(10, 120)
        ),
        User(
            R.drawable.gimli,
            139,
            "hombre",
            getRandomParagraph(10, 25),
            getRandomParagraph(10, 120)
        ),
        User(
            R.drawable.sauron,
            999999,
            "hombre",
            getRandomParagraph(10, 25),
            getRandomParagraph(10, 120)
        )
    )

    fun getWeaponsList(): MutableList<Weapon> {
        val weapons = mutableListOf<Weapon>()
        val itemsQuantity = Random.nextInt(3, 11)

        for (i in 0..itemsQuantity) {
            weapons.add(Weapon(getRandomParagraph(10, 120), 12.2222f))
        }
        return weapons
    }
}