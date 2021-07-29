package com.example.authenticationapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.authenticationapp.db.MyAppDatabase

class LoginActivity : AppCompatActivity() {
    companion object{
        var  mydatabase : MyAppDatabase? = null
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide()

        val signup_btn=findViewById<TextView>(R.id.signup_navbtn)
        val signin_btn=findViewById<TextView>(R.id.signin_navbtn)
        val visible_signin=findViewById<View>(R.id.visible_signin)
        val visible_signup=findViewById<View>(R.id.visible_signup)

        if (savedInstanceState==null){
            supportFragmentManager.beginTransaction().add(R.id.frame_host,SigninFragment()).commit()
        }

        signup_btn.setOnClickListener {
            val userexist=mydatabase!!.signInDao().getuser()
            Log.d("erro","$userexist")
           // if (userexist?.isEmpty() == true){
                supportFragmentManager.beginTransaction().replace(R.id.frame_host,SignupFragment()).commit()
                visible_signin.visibility=View.INVISIBLE
                visible_signup.visibility=View.VISIBLE
           // }else{
           //  Toast.makeText(this,"Account already exist!!... Need to singIn",Toast.LENGTH_SHORT).show()
              //  }
        }

        signin_btn.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.frame_host,SigninFragment()).commit()
            visible_signin.visibility=View.VISIBLE
            visible_signup.visibility=View.INVISIBLE
        }

      /* val MIGRATION_1_2 = object : Migration(1, 2){
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("CREATE TABLE IF NOT EXISTS 'usersites_table' (`Folder` TEXT,"+"'SiteName' TEXT,"+"'URL' TEXT,"+"'Username' TEXT,"+"'Sitepassword' TEXT,"+"'Notes' TEXT, PRIMARY KEY('Folder'))")
                //database.execSQL("CREATE TABLE IF NOT EXISTS 'userfolders_table' ('FolderName' TEXT, PRIMARY KEY('FolderName'))")
            }
        }*/
        mydatabase=Room.databaseBuilder<MyAppDatabase>(applicationContext,MyAppDatabase::class.java,"mydatabase").allowMainThreadQueries().fallbackToDestructiveMigration().build()
    }
}