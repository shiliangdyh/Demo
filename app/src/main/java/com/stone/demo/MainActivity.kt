package com.stone.demo

import android.graphics.Color
import android.os.Bundle
import com.stone.base.SimpleActivity

class MainActivity : SimpleActivity() {
    override var titleCenter: Boolean
        get() = true
        set(value) {}
    override var toolbarTitle: String
        get() = "Main"
        set(value) {}
    override val layoutId: Int
        get() = R.layout.activity_main
    override var navigationIcon: Int
        get() = R.mipmap.ic_launcher
        set(value) {}

    override var hasToolbar: Boolean
        get() = true
        set(value) {}
    override var translucentStatu: Boolean
        get() = true
        set(value) {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSystemBarColor(Color.TRANSPARENT)
    }
}
