package com.example.advancedlayout

import android.os.Bundle
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.example.advancedlayout.adapter.UsersPagerAdapter
import com.example.advancedlayout.data.User
import com.example.advancedlayout.data.Weapon
import com.example.advancedlayout.databinding.ActivityMainBinding
import com.example.advancedlayout.databinding.ItemBoxBinding
import com.example.advancedlayout.viewModel.MainViewModel


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mViewModel: MainViewModel
    private lateinit var mAdapter: UsersPagerAdapter
    private var mUsers = mutableListOf<User>()
    private var mWeapons = mutableListOf<Weapon>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViewModel()

        setupAdapter()
    }

    private fun setupViewModel() {
        mViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        mViewModel.leftParagraph.observe(this) { binding.tvleftParagraph.text = it }
        mViewModel.rightParagraph.observe(this) { binding.tvRightParagraph.text = it }
        mViewModel.users.observe(this) {
            mUsers.clear()
            mUsers.addAll(it)
            mAdapter.notifyDataSetChanged()
        }
        mViewModel.weapons.observe(this) {
            mWeapons.clear()
            mWeapons.addAll(it)
            setupList()
        }
    }

    private fun setupList() {
        for (weapon in mWeapons) {
            val itemBinding = ItemBoxBinding.inflate(layoutInflater)
            binding.linearLayout.addView(itemBinding.root)
            val param = itemBinding.root.layoutParams as ViewGroup.MarginLayoutParams
            param.setMargins(0, 16, 0, 16)
            itemBinding.root.layoutParams = param
            itemBinding.tvTxt.text = weapon.txt
            itemBinding.tvPrice.text = weapon.price.toString().substring(
                0, weapon.price.toString().length - 2
            ) + "€"
        }
    }

    private fun setupAdapter() {
        mAdapter = UsersPagerAdapter(mUsers)
        val viewPager: ViewPager2 = binding.viewPager

        viewPager.adapter = mAdapter

        // viewPager.clipToPadding = false
    }
}