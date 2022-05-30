# MotionLayoutExample
Example of how to use MotionLayout for an artist page (based on artist page from [Letras App](https://play.google.com/store/apps/details?id=com.studiosol.player.letras)). The purpose of this repository is to show how to create the collapsing toolbar animation using only layout tools. The only code needed for this was for setting the Android UI according to the original version and to set the background image and color to simulate different backgrounds.

## Branches

- **master:** Has layouts from before and after adding MotionLayout to a regular page. There are also comments about the functions, views and other things used for that purpose. When running the app, it's gonna show the post-MotionLayout page.
- **before-motion-layout**: Contains only the layout before adding MotionLayout, so when running, this is what's going to be shown. This branch is more of a "do it yourself from scratch" thing, so feel free to fork it.

## Original vs Clone

This app should be a clone from the artist page on [Letras App](https://play.google.com/store/apps/details?id=com.studiosol.player.letras). Nothing used in this app comes directly from their app, it's all made up by me, except for the images which I found on Google.

*Original / Clone before MotionLayout / Clone after MotionLayout*
<p float="left">
  <img src="https://user-images.githubusercontent.com/50219994/171047372-69d274df-d0d9-451d-b188-8305748111e7.gif" width="200" />
  <img src="https://user-images.githubusercontent.com/50219994/171047381-d74f2460-7ac2-4cf0-af6b-862103c280dd.gif" width="200" />
  <img src="https://user-images.githubusercontent.com/50219994/171047392-94e3f76c-eefa-471f-aae3-7d35c4a6c9c7.gif" width="200" />
</p>

## Some documentation

- [MotionLayout | Android Developers](https://developer.android.com/reference/androidx/constraintlayout/motion/widget/MotionLayout?hl=pt-br)
- [Palette | Android Developers](https://developer.android.com/reference/android/support/v7/graphics/Palette.html)
- [Motion Layout In Action | Android Studio Tutorial (video)](https://www.youtube.com/watch?v=ROkKPgXpd1Y)
