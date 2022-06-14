package com.coldweather.library

import androidx.fragment.app.FragmentActivity

object PermissionX {

    private const val TAG = "InvisibleFragment"


    // 这个FragmentActivity是系统内置的Activity
    // 是AppCompatActivity的父类
    // PermissionCallback是函数数据类型的别名
    fun request(activity:FragmentActivity,vararg permission:String,callback: PermissionCallback){

        // 获取fragment的管理器
        val fragmentManager = activity.supportFragmentManager

        val existedFragment = fragmentManager.findFragmentByTag(TAG)

        val fragment = if(existedFragment != null){

            existedFragment as InvisibleFragment

        }else{

            val invisibleFragment = InvisibleFragment()

            fragmentManager.beginTransaction().add(invisibleFragment, TAG).commitNow()

            invisibleFragment

        }

        // 这里的*的意思是将一个数组转换成可变长度的参数传递出去
        // 因为fragment.requestNow()方法中第二个参数接受的是的可变长度的参数
        fragment.requestNow(callback,*permission)


    }

}