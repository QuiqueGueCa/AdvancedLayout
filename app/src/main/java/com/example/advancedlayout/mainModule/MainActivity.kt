package com.example.advancedlayout.mainModule

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.example.advancedlayout.R
import com.example.advancedlayout.data.User
import com.example.advancedlayout.data.Weapon
import com.example.advancedlayout.databinding.ActivityMainBinding
import com.example.advancedlayout.databinding.ItemBoxBinding
import com.example.advancedlayout.mainModule.adapter.HorizontalMarginItemDecoration
import com.example.advancedlayout.mainModule.adapter.UsersPagerAdapter


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

        setupViewPager()
    }

    @SuppressLint("NotifyDataSetChanged")
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

    @SuppressLint("SetTextI18n")
    private fun setupList() {
        for (weapon in mWeapons) {
            val itemBinding = ItemBoxBinding.inflate(layoutInflater)
            binding.linearLayout.addView(itemBinding.root)
            val param = itemBinding.root.layoutParams as ViewGroup.MarginLayoutParams
            param.setMargins(0, 16, 0, 16)
            itemBinding.root.layoutParams = param
            itemBinding.tvTxt.text = weapon.txt
            itemBinding.tvPrice.text =
                weapon.price.toString().substring(
                    0, weapon.price.toString().length - 2
                ) + "€"
        }
    }

    private fun setupViewPager() {
        mAdapter = UsersPagerAdapter(mUsers)
        val viewPager: ViewPager2 = binding.viewPager

        viewPager.adapter = mAdapter

        setupCardsVisionConfig(viewPager)
    }

    private fun setupCardsVisionConfig(viewPager: ViewPager2) {
        viewPager.offscreenPageLimit = 1

        // Add a PageTransformer that translates the next and previous items horizontally
// towards the center of the screen, which makes them visible
        val nextItemVisiblePx = resources.getDimension(R.dimen.viewpager_next_item_visible)
        val currentItemHorizontalMarginPx =
            resources.getDimension(R.dimen.viewpager_current_item_horizontal_margin)
        val pageTranslationX = nextItemVisiblePx + currentItemHorizontalMarginPx
        val pageTransformer = ViewPager2.PageTransformer { page: View, position: Float ->
            page.translationX = -pageTranslationX * position
            // Next line scales the item's height. You can remove it if you don't want this effect
            page.scaleY = 1 - (0.25f * kotlin.math.abs(position))
            // If you want a fading effect uncomment the next line:
            // page.alpha = 0.25f + (1 - abs(position))
        }
        viewPager.setPageTransformer(pageTransformer)

        // The ItemDecoration gives the current (centered) item horizontal margin so that
// it doesn't occupy the whole screen width. Without it the items overlap
        val itemDecoration = HorizontalMarginItemDecoration(
            this,
            R.dimen.viewpager_current_item_horizontal_margin
        )
        viewPager.addItemDecoration(itemDecoration)
    }
}