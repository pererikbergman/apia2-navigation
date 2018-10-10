package com.rakangsoftware.navigation.screen

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.rakangsoftware.navigation.R
import kotlinx.android.synthetic.main.navigation_activity.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)

        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            title = "A Navigation demo"
            subtitle = "Second activity"
            setDisplayHomeAsUpEnabled(true)
        }
    }

    companion object {

        @JvmStatic
        fun start(context: Context) {
            context.startActivity(Intent(context, SecondActivity::class.java))
        }
    }
}
