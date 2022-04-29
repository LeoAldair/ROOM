package com.example.rom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.rom.database.User

class MainActivity : AppCompatActivity() {
    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
/*
        mainViewModel.saveUser(
            User(
                "user_2",
                "Leonardo Aldiar Resendiz",
                1.78,
                65.0,
                "leoaldr@gmail.com"
        )
        )
*/
        mainViewModel.getUsers()
        //si es FRAGMENT es con viewLifecycleOwner en lugar de this
        mainViewModel.savedUsers.observe(this) { usersList ->
            if (!usersList.isNullOrEmpty()) {
                for (user in usersList) {
                    Log.d("thesearetheusers", user.user_name)
                }
            } else {
                Log.d("thesearetheusers", "null or empty")
            }
        }


    }
}
