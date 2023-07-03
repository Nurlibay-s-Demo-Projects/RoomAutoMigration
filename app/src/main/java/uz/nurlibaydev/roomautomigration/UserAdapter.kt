package uz.nurlibaydev.roomautomigration

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.nurlibaydev.roomautomigration.database.User
import uz.nurlibaydev.roomautomigration.databinding.ItemUserBinding

class UserAdapter : RecyclerView.Adapter<UserAdapter.ContactViewHolder>() {

    var users = mutableListOf<User>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class ContactViewHolder(private val binding: ItemUserBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User) {
            binding.apply {
                tvUser.text = "${user.id} ${user.name} ${user.user_age}"
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        return ContactViewHolder(
            ItemUserBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount() = users.size

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.bind(users[position])
    }
}