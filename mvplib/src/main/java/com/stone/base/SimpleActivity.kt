package com.stone.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * @package: com.stone.base
 * @fileName: SimpleActivity
 * @data: 2018/4/2 10:11
 * @author: ShiLiang
 * @describe:
 */
abstract class SimpleActivity :AppCompatActivity(),IView {

    abstract val layoutId: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        fetchData()
    }

}