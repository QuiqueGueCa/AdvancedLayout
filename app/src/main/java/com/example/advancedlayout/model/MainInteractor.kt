package com.example.advancedlayout.model

import kotlin.random.Random

class MainInteractor() {
    val spaceValue = 32

    fun getRandomParagraph(minLength: Int, maxLength: Int): String {
        var spaceCounter = 0
        val paragraphLength = Random.nextInt(minLength, maxLength)
        var paragraph = ""

        for (i in 1..paragraphLength) {

            var asciiNum = checkMustSpace(spaceCounter)

            paragraph += asciiNum.toChar()

            if (asciiNum == spaceValue) {
                spaceCounter = 0

            } else {
                spaceCounter++
            }
        }
        return paragraph
    }


    private fun checkMustSpace(spaceCounter: Int): Int {
        val maxLettersInWord = 8

        if (spaceCounter < maxLettersInWord) {
            return Random.nextInt(32, 122)
        } else {
            return spaceValue
        }
    }
}