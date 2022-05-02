package com.example.rom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.rom.database.User
import com.example.rom.databinding.ActivityMainBinding
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnUpdateUser.setOnClickListener {
            val name = binding.etUserName.text.toString()
            mainViewModel.saveUser(
                User(
                    name
                )
            )
            updateUserList()
        }
    }
        fun updateUserList(){
            mainViewModel.getUsers()
            //si es FRAGMENT es con viewLifecycleOwner en lugar de this
            mainViewModel.savedUsers.observe(this) { usersList ->
                if (!usersList.isNullOrEmpty()) {
                    binding.rvUserEntries.adapter = MainAdapter(usersList)
                } else {
                    Log.d("thesearetheusers", "null or empty")
                }
            }

        }
    }

