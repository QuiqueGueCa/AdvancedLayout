package com.example.advancedlayout.data.utils

import com.example.advancedlayout.data.constants.Constants
import kotlin.random.Random

object RandomsGenerator {
    fun getRandomParagraph(minLength: Int, maxLength: Int): String {
        var spaceCounter = 0
        val paragraphLength = Random.nextInt(minLength, maxLength)
        var paragraph = ""

        for (i in 1..paragraphLength) {

            val asciiNum = checkMustSpace(spaceCounter)

            paragraph += asciiNum.toChar()

            if (asciiNum == Constants.SPACE_ASCII_VALUE) {
                spaceCounter = 0
            } else {
                spaceCounter++
            }
        }
        return paragraph
    }

    private fun checkMustSpace(spaceCounter: Int): Int {

        return if (spaceCounter < Constants.MAX_LETTERS_IN_WORD) {
            Random.nextInt(Constants.MIN_ASCII_VALUE, Constants.MAX_ASCII_VALUE)
        } else {
            Constants.SPACE_ASCII_VALUE
        }
    }
}