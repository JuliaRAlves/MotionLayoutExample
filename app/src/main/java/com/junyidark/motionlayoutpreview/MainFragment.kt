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
        return inflater.inflate(R.layout.layout_after, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        toolbar = view.findViewById(R.id.toolbar)
        background = view.findViewById(R.id.background)
        backgroundColor = view.findViewById(R.id.background_color)

        setupToolbar()

        val bgResId = getBackgroundResId()

        setBackgroundAndColor(view, bgResId)
    }

    /**
     * This method selects a random drawable id from a list of drawable ids.
     *
     * @return a random drawable id from the list
     */
    private fun getBackgroundResId(): Int {
        val bgList = listOf(R.drawable.bg_blue, R.drawable.bg_black, R.drawable.bg_pink)

        return bgList.shuffled()[0]
    }

    /**
     * This method sets the selected background into the background view and also sets
     * the correct color into the background color view, according to the selected image.
     *
     * @param view the root view that's being inflated by the fragment
     * @param bgResId the resource id from the drawable to be used as reference
     */
    private fun setBackgroundAndColor(view: View, bgResId: Int) {
        background.setImageResource(bgResId)

        val dominantColor = getDominantColorByDrawableResId(view, bgResId)

        backgroundColor.background = dominantColor
    }

    /**
     * This method uses the Palette library to get the dominant color from a drawable.
     * The drawable is converted to bitmap and then, using the Palette object, the
     * corresponding palette of the image is generated and the dominant color is picked.
     *
     * @param view the root view that's being inflated by the fragment
     * @param bgResId the resource id from the drawable to be used as reference
     * @return the ColorDrawable representing the dominant color of the image's palette
     */
    private fun getDominantColorByDrawableResId(view: View, bgResId: Int): ColorDrawable {
        val bgBitmap = BitmapFactory.decodeResource(view.context.resources, bgResId)
        val bgColor = Palette.from(bgBitmap).generate().getDominantColor(Color.BLACK)

        return ColorDrawable(bgColor)
    }

    /**
     * This method sets an icon to the toolbar and also sets the correct action when
     * clicking on it.
     */
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