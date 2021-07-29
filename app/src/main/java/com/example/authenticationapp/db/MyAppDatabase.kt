package com.example.authenticationapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [UserSignInEntity::class],version =1)
abstract class MyAppDatabase : RoomDatabase() {
    abstract fun signInDao(): SignInDao

}