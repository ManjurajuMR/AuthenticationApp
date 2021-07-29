package com.example.authenticationapp

import android.content.Intent
import android.hardware.biometrics.BiometricManager
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

import androidx.core.content.ContextCompat

import java.util.concurrent.Executor


class SigninFragment : Fragment() {
     lateinit var phonenumber:TextView
    lateinit var password:TextView
    lateinit var signinbtn:Button
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState:Bundle?):View? {
        val root = inflater.inflate(R.layout.fragment_signin, container, false)

       phonenumber=root.findViewById(R.id.signin_mobileNo)
        password=root.findViewById(R.id.signin_password)
        signinbtn=root.findViewById(R.id.signin_btn)
        val tempbtn=root.findViewById<TextView>(R.id.text1)
        tempbtn.setOnClickListener {
          //  LoginActivity.mydatabase!!.userfolderDao().deleteAllfolders()
        }


        signinbtn.setOnClickListener {
            val phonenum=phonenumber.text.toString()
            val password=password.text.toString()
            Toast.makeText(activity,"${phonenum},${password}",Toast.LENGTH_SHORT).show()
            if (phonenum=="" || password==""){
                Toast.makeText(activity,"Either userid or Password are empty!!",Toast.LENGTH_SHORT).show()
            }else{
                val exixt=LoginActivity.mydatabase!!.signInDao().IsUserExist(phonenum,password)
                Log.d("error","$exixt")
                if (exixt==true){
                    val intent=Intent(activity,MainActivity::class.java)
                    activity?.startActivity(intent)
                    activity?.finish()
                }else{
                    Toast.makeText(activity,"Invalid userid or Password",Toast.LENGTH_SHORT).show()
                }
            }
        }
        //

        //

        return root
    }
}