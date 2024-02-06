package com.example.advancedlayout.ui.mainModule

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.advancedlayout.data.constants.Constants
import com.example.advancedlayout.data.domain.model.UserModel
import com.example.advancedlayout.data.domain.model.WeaponModel
import com.example.advancedlayout.data.domain.usecases.GetUserListUseCase
import com.example.advancedlayout.data.domain.usecases.GetWeaponsListUseCase
import com.example.advancedlayout.data.utils.RandomsGenerator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val getUsersListUseCase: GetUserListUseCase,
    private val getWeaponsListUseCase: GetWeaponsListUseCase
) : ViewModel() {

    private val _users = MutableStateFlow<MutableList<UserModel>>(mutableListOf())
    private val _weapons = MutableStateFlow<MutableList<WeaponModel>>(mutableListOf())
    val users: StateFlow<MutableList<UserModel>> = _users
    val weapons: StateFlow<MutableList<WeaponModel>> = _weapons


    fun getUsers() {
        Log.d("TAG", "l> getListPokemon")
        viewModelScope.launch(Dispatchers.IO) {
            getUsersListUseCase().collect {
                _users.value = it
            }
        }
    }


    private val _leftParagraph = MutableLiveData<String>()
    private val _rightParagraph = MutableLiveData<String>()


    val leftParagraph: LiveData<String> get() = _leftParagraph
    val rightParagraph: LiveData<String> get() = _rightParagraph


    init {
        _leftParagraph.value = RandomsGenerator.getRandomParagraph(
            Constants.MIN_LENGTH_PARAGRAPH, Constants.MAX_LENGTH_PARAGRAPH
        )
        _rightParagraph.value = RandomsGenerator.getRandomParagraph(
            Constants.MIN_LENGTH_PARAGRAPH, Constants.MAX_LENGTH_PARAGRAPH
        )
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

    /*fun changeList() {
        _weapons.value = dataProvider.getWeaponsList()
    }*/
}