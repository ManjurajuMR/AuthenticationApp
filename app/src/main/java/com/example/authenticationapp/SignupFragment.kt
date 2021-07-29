package com.example.authenticationapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

import com.example.authenticationapp.db.MyAppDatabase
import com.example.authenticationapp.db.UserSignInEntity


class SignupFragment : Fragment() {
    lateinit var phonenumber:TextView
    lateinit var password:TextView
    lateinit var Repassword:TextView
    lateinit var signinbtn:TextView
    lateinit var db: MyAppDatabase
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState:Bundle?):View? {
        val root = inflater.inflate(R.layout.fragment_signup, container, false)

         phonenumber=root.findViewById<TextView>(R.id.signup_mobileNo)
         password=root.findViewById<TextView>(R.id.signup_password)
         Repassword=root.findViewById<TextView>(R.id.signup_repassword)
         signinbtn=root.findViewById<Button>(R.id.signup_btn)

        signinbtn.setOnClickListener {
            adduser()
        }
        return root
    }

    fun adduser(){
        val phonenum=phonenumber.text.toString()
        val password=password.text.toString()
        val repassword=Repassword.text.toString()
        val sign_user= UserSignInEntity(phonenum,repassword)
        if (phonenum=="" || password=="" ||repassword=="" ||password!=repassword){
            Toast.makeText(activity,"Enter all parameters correctly!!",Toast.LENGTH_SHORT).show()
        }else{
            LoginActivity.mydatabase!!.signInDao().Register_user(sign_user)
            Toast.makeText(activity,"SignedUp sucessfully!!",Toast.LENGTH_SHORT).show()
            val intent= Intent(activity,MainActivity::class.java)
            activity?.startActivity(intent)
            activity?.finish()
        }
    }
}