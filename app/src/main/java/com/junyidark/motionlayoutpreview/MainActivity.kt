package com.junyidark.motionlayoutpreview

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        setupStatusBar()
    }

    /**
     * This method sets the status bar to be translucent and the navigation bar
     * to be opaque.
     */
    private fun setupStatusBar() {
        if (!(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N && isInMultiWindowMode)) {
            window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_IN_OVERSCAN);
            window.statusBarColor = Color.TRANSPARENT
        }

        val decorView = window.decorView

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.setDecorFitsSystemWindows(false)
        } else {
            decorView.systemUiVisibility = decorView.systemUiVisibility or SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        }
        window.statusBarColor = Color.TRANSPARENT
    }
}