package uz.nurlibaydev.roomautomigration

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import uz.nurlibaydev.roomautomigration.database.User
import uz.nurlibaydev.roomautomigration.database.UserDao
import uz.nurlibaydev.roomautomigration.database.UserDatabase
import uz.nurlibaydev.roomautomigration.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter = UserAdapter()
    private lateinit var dao: UserDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dao = UserDatabase.getInstance(this).userDao()

        binding.rvUsers.adapter = adapter
        adapter.users = dao.getAllUsers().toMutableList()

        binding.btn.setOnClickListener {
            dao.insert(User(id = 0, binding.etName.text.toString(), binding.etAge.text.toString().toInt()))
            binding.etName.setText("")
            binding.etAge.setText("")
            adapter.users = dao.getAllUsers().toMutableList()
        }
    }
}