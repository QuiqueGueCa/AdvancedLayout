package com.example.advancedlayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.example.advancedlayout.adapter.UsersPagerAdapter
import com.example.advancedlayout.databinding.ActivityMainBinding
import com.example.advancedlayout.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mViewModel: MainViewModel
    private lateinit var mAdapter: UsersPagerAdapter

    //private var mUsers = mutableListOf<User>()
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
            //mUsers =  it
            mAdapter.updateUsers(it)

        }
    }

    private fun setupAdapter() {
        //mAdapter = UsersPagerAdapter(mUsers)
        mAdapter = UsersPagerAdapter(mutableListOf())
        val viewPager: ViewPager2 = binding.viewPager

        viewPager.adapter = mAdapter

        // viewPager.clipToPadding = false
    }
}