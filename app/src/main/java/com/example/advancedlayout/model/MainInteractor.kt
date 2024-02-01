package com.example.advancedlayout.model

import com.example.advancedlayout.R
import com.example.advancedlayout.data.User
import kotlin.random.Random

class MainInteractor() {
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

        if (spaceCounter < maxLettersInWord) {
            return Random.nextInt(32, 122)
        } else {
            return SPACE_ASCII_VALUE
        }
    }

    fun getUsersList(): MutableList<User> = mutableListOf(
        User(
            R.drawable.aragorn,
            87,
            "hombre",
            "Liderar ejércitos, perderse por el bosque",
            "Aragorn, hijo de Arathorn, heredero de Isildur"
        ),
        User(
            R.drawable.legolas,
            2931,
            "hombre",
            "Dar paseos por el campo, tocar la flauta",
            "Un elfo arquero como todos"
        ),
        User(
            R.drawable.gimli,
            139,
            "hombre",
            "Ir a la mina, atusarse la barba",
            "El estereotipo de enano clásico"
        ),
        User(
            R.drawable.sauron,
            999999,
            "hombre",
            "Hacer cosas malas, hacer cosas muy malas",
            "Un ser horrible y maligno"
        )
    )
}