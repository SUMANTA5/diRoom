package com.sumanta.roomdi.userdatabase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sumanta.roomdi.dao.UserDao
import com.sumanta.roomdi.model.User

@Database(entities = [User::class],version = 1,exportSchema = false)
abstract class UserDatabase : RoomDatabase(){
    abstract fun userDao(): UserDao
}