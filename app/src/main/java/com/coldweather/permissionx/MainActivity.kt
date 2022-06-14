package com.coldweather.permissionx

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.coldweather.library.PermissionX
import com.coldweather.permissionx.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.button.setOnClickListener {

            PermissionX.request(this, Manifest.permission.CALL_PHONE){

                allGranted,deniedList ->

                if(allGranted){

                    call()

                }else{

                    Toast.makeText(this,"You denid $deniedList",Toast.LENGTH_SHORT).show()

                }


            }

        }

    }

    private fun call(){

        try{

            val intent = Intent(Intent.ACTION_CALL)

            intent.data = Uri.parse("tel:10086")

            startActivity(intent)

        }catch (e:SecurityException){

            e.printStackTrace()

        }

    }

}