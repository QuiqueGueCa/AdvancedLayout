package com.example.advancedlayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.example.advancedlayout.adapter.UsersPagerAdapter
import com.example.advancedlayout.data.User
import com.example.advancedlayout.databinding.ActivityMainBinding
import com.example.advancedlayout.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupAdapter()

        setupViewModel()
    }

    private fun setupViewModel() {
        mViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        mViewModel.leftParagraph.observe(this) { binding.tvleftParagraph.text = it }
        mViewModel.rightParagraph.observe(this) { binding.tvRightParagraph.text = it }
    }

    private fun setupAdapter() {
        val adapter = UsersPagerAdapter(
            mutableListOf(
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
        )
        val viewPager: ViewPager2 = binding.viewPager

        viewPager.adapter = adapter

        // viewPager.clipToPadding = false
    }
}