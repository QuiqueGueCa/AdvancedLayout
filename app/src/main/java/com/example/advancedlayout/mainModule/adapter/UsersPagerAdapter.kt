package com.example.advancedlayout.mainModule.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.advancedlayout.R
import com.example.advancedlayout.data.User
import com.example.advancedlayout.databinding.ItemUserBinding

class UsersPagerAdapter(
    private var users: MutableList<User>
) :
    RecyclerView.Adapter<UsersPagerAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemUserBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        with(holder.binding) {
            imgUser.setImageResource(users[position].img)
            tvAgeContent.text = users[position].age.toString()
            tvSexContent.text = users[position].sex
            tvHobbyContent.text = users[position].hobbies
            tvDescriptionContent.text = users[position].description
        }
    }

    override fun getItemCount(): Int = users.size
}