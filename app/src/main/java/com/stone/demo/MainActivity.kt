package com.stone.demo

import android.os.Bundle
import com.stone.base.SimpleActivity

class MainActivity : SimpleActivity() {
    override val layoutId: Int
        get() = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}
