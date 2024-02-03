package com.example.advancedlayout.ui.mainModule

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.advancedlayout.model.User
import com.example.advancedlayout.model.Weapon
import com.example.advancedlayout.useCases.DataProvider
import com.example.advancedlayout.utils.Constants
import com.example.advancedlayout.utils.RandomsGenerator

class MainViewModel : ViewModel() {

    private val dataProvider = DataProvider()
    private val _leftParagraph = MutableLiveData<String>()
    private val _rightParagraph = MutableLiveData<String>()
    private val _users = MutableLiveData<MutableList<User>>()
    private val _weapons = MutableLiveData<MutableList<Weapon>>()

    val leftParagraph: LiveData<String> get() = _leftParagraph
    val rightParagraph: LiveData<String> get() = _rightParagraph
    val users: LiveData<MutableList<User>> get() = _users
    val weapons: LiveData<MutableList<Weapon>> get() = _weapons

    init {
        _leftParagraph.value = RandomsGenerator.getRandomParagraph(
            Constants.MIN_LENGTH_PARAGRAPH, Constants.MAX_LENGTH_PARAGRAPH
        )
        _rightParagraph.value = RandomsGenerator.getRandomParagraph(
            Constants.MIN_LENGTH_PARAGRAPH, Constants.MAX_LENGTH_PARAGRAPH
        )
        _users.value = dataProvider.getUsersList()
        _weapons.value = dataProvider.getWeaponsList()
    }

    fun setLeftParagraph() {
        _leftParagraph.value = RandomsGenerator.getRandomParagraph(
            Constants.MIN_LENGTH_PARAGRAPH, Constants.MAX_LENGTH_PARAGRAPH
        )
    }

    fun setRightParagraph() {
        _rightParagraph.value = RandomsGenerator.getRandomParagraph(
            Constants.MIN_LENGTH_PARAGRAPH, Constants.MAX_LENGTH_PARAGRAPH
        )
    }

    fun changeList() {
        _weapons.value = dataProvider.getWeaponsList()
    }
}