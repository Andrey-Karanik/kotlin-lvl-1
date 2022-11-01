package com.andreykaranik.homework1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragmentManager = supportFragmentManager
        val fragment = fragmentManager.findFragmentByTag("first_fragment")
        val newFragment: MainFragment
        if (fragment == null) {
            newFragment = MainFragment()
        } else {
            newFragment = fragment as MainFragment
        }
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, newFragment, "first_fragment")
        fragmentTransaction.commit()

    }
}