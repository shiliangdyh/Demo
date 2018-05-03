package com.stone.base

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.WindowManager
import android.widget.FrameLayout
import android.widget.TextView
import com.readystatesoftware.systembartint.SystemBarTintManager
import com.stone.R

/**
 * @package: com.stone.base
 * @fileName: SimpleActivity
 * @data: 2018/4/2 10:11
 * @author: ShiLiang
 * @describe:
 */
abstract class SimpleActivity : AppCompatActivity(), IView {

    abstract val layoutId: Int
    open var hasToolbar: Boolean = true
    open var toolbarColorRes: Int = R.color.colorAccent
    open var navigationIcon: Int = -1
    open var translucentStatu: Boolean = true
    open var titleCenter = true
    open var toolbarTitle = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setTranslucentStatus(translucentStatu)

        val actionBarSize = getActionBarSize()

        val statusBarHeight = getStatusBarHeight(this)

        val container = findViewById<FrameLayout>(android.R.id.content)

        var marginTop: Int = 0

        if (hasToolbar) {
            marginTop = actionBarSize
            val toolbar = layoutInflater.inflate(R.layout.base_toolbar_layout, container, false) as Toolbar
            toolbar.setBackgroundColor(ContextCompat.getColor(this, toolbarColorRes))
            if (titleCenter) {
                toolbar.title = ""
                val tvToolbarTitle = toolbar.findViewById<TextView>(R.id.toolbar_title)
                tvToolbarTitle.text = toolbarTitle
            } else {
                toolbar.title = toolbarTitle
            }
            if (navigationIcon != -1) {
                toolbar.setNavigationIcon(navigationIcon)
            }
            if (Build.VERSION.SDK_INT >= 19) {
                val lp = toolbar.layoutParams as FrameLayout.LayoutParams
                if (translucentStatu) {
                    toolbar.setPadding(0, statusBarHeight, 0, 0)
                    lp.height = actionBarSize + statusBarHeight
                } else {
                    lp.height = actionBarSize
                }
                toolbar.layoutParams = lp
            }
            container.addView(toolbar)
            setSupportActionBar(toolbar)
            if (navigationIcon != -1) {
                toolbar.setNavigationIcon(navigationIcon)
                supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            }

        }
        if (translucentStatu) {
            marginTop += statusBarHeight
        }
        val view = layoutInflater.inflate(layoutId, null)
        val params = FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT)
        params.setMargins(0, marginTop, 0, 0)
        view.layoutParams = params
        container.addView(view)

        fetchData()
    }

    private fun getActionBarSize(): Int {
        val actionbarSizeTypedArray = obtainStyledAttributes(intArrayOf(android.R.attr.actionBarSize))
        val actionBarSize = actionbarSizeTypedArray.getDimensionPixelOffset(0, 0)
        actionbarSizeTypedArray.recycle()
        return actionBarSize
    }

    private fun getStatusBarHeight(context: Context): Int {
        var result = 0
        val resourceId = context.resources.getIdentifier("status_bar_height", "dimen", "android")
        if (resourceId > 0) {
            result = context.resources.getDimensionPixelSize(resourceId)
        }
        return result
    }

    fun setSystemBarColor(color: Int) {
        val tintManager = SystemBarTintManager(this)
        tintManager.isStatusBarTintEnabled = true
        tintManager.setNavigationBarTintEnabled(true)
        tintManager.setTintColor(color)
        tintManager.setStatusBarTintColor(color)
    }

    private fun setTranslucentStatus(on: Boolean) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            val winParams = window.attributes
            val bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
            if (on) {
                winParams.flags = winParams.flags or bits
            } else {
                winParams.flags = winParams.flags and bits.inv()
            }
            window.attributes = winParams
        }
    }
}