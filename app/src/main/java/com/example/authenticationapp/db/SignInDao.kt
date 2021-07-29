package com.example.authenticationapp.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface SignInDao {

    @Insert
    fun Register_user(user:UserSignInEntity)

    @Query("Select * from userlogin_table")
    fun getuser():List<UserSignInEntity>

    @Query("SELECT EXISTS(SELECT * FROM userlogin_table WHERE PhoneNumber = :phonenumu and password=:password)")
    fun IsUserExist(phonenumu : String,password:String) : Boolean
}