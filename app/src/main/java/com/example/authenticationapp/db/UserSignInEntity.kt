package com.example.authenticationapp.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "userlogin_table")
data class UserSignInEntity (
    @PrimaryKey
    var PhoneNumber : String,
    @ColumnInfo(name = "password")
    var Password:String
)