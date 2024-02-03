package com.example.advancedlayout.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.advancedlayout.data.User
import com.example.advancedlayout.data.Weapon
import com.example.advancedlayout.model.MainInteractor

class MainViewModel : ViewModel() {

    private val interactor = MainInteractor()
    private val _leftParagraph = MutableLiveData<String>()
    private val _rightParagraph = MutableLiveData<String>()
    private val _users = MutableLiveData<MutableList<User>>()
    private val _weapons = MutableLiveData<MutableList<Weapon>>()

    val leftParagraph: LiveData<String> get() = _leftParagraph
    val rightParagraph: LiveData<String> get() = _rightParagraph
    val users: LiveData<MutableList<User>> get() = _users

    val weapons: LiveData<MutableList<Weapon>> get() = _weapons

    init {
        _leftParagraph.value = interactor.getRandomParagraph(50, 401)
        _rightParagraph.value = interactor.getRandomParagraph(50, 401)
        _users.value = interactor.getUsersList()
        _weapons.value = interactor.getWeaponsList()
    }
}