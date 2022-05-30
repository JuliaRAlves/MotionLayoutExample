package com.junyidark.motionlayoutpreview

import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.palette.graphics.Palette
import com.google.android.material.appbar.MaterialToolbar


class MainFragment : Fragment() {

    private lateinit var toolbar: MaterialToolbar
    private lateinit var background: AppCompatImageView
    private lateinit var backgroundColor: AppCompatImageView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.layout_before, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        toolbar = view.findViewById(R.id.toolbar)
        background = view.findViewById(R.id.background)

        setupToolbar()
    }

    private fun getBackgroundResId(): Int {
        val bgList = listOf(R.drawable.bg_blue, R.drawable.bg_black, R.drawable.bg_pink)

        return bgList.shuffled()[0]
    }

    private fun setBackgroundAndColor(view: View, bgResId: Int) {
        background.setImageResource(bgResId)

        val dominantColor = getDominantColorByDrawableResId(view, bgResId)

        backgroundColor.background = dominantColor
    }

    private fun getDominantColorByDrawableResId(view: View, bgResId: Int): ColorDrawable {
        val bgBitmap = BitmapFactory.decodeResource(view.context.resources, bgResId)
        val bgColor = Palette.from(bgBitmap).generate().getDominantColor(Color.BLACK)

        return ColorDrawable(bgColor)
    }

    private fun setupToolbar() {
        toolbar.let {
            val navController = findNavController()

            it.setNavigationOnClickListener {
                if (!navController.navigateUp()) {
                    requireActivity().finish()
                }
            }

            navController.addOnDestinationChangedListener { _, _, _ ->
                it.setNavigationIcon(R.drawable.ic_nav_back)
                it.setNavigationIconTint(Color.WHITE)
            }
        }
    }
}