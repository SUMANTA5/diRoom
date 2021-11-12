package com.sumanta.roomdi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Adapter
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.sumanta.roomdi.adapter.UserAdapter
import com.sumanta.roomdi.databinding.ActivityMainBinding
import com.sumanta.roomdi.model.User
import com.sumanta.roomdi.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var userAdapter: UserAdapter
    private val userViewModel: UserViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initRecyclerView()
        userViewModel.getUserData.observe(this, Observer {
            userAdapter.setUser(it as ArrayList<User>)
        })

        binding.save.setOnClickListener {
            insertInToRoom()
        }

    }

    private fun insertInToRoom() {
        val gateName = binding.name.text.toString().trim()
        val gatAge = binding.age.text.toString().trim()
        if (!TextUtils.isEmpty(gateName) && !TextUtils.isEmpty(gatAge)){
            val user = User(gateName,gatAge.toInt())
            userViewModel.insert(user)
            Toast.makeText(applicationContext,"insert...",Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(applicationContext,"fill all fields",Toast.LENGTH_SHORT).show()
        }
    }

    private fun initRecyclerView() {
        userAdapter = UserAdapter(this, ArrayList())
        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = userAdapter
        }
    }
}