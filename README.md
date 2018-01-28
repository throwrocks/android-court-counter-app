# android-court-counter-app

I developed this project as part of the Udacity Code Reviewer training.

The requirements were to create a layout with two columns, one for each team, with buttons to add one, two, or three points. I designed the layout using nested LinearLayouts with the layout_weight attribute so the two columns cover 50% of the screen each even when the device is rotated. The app uses the SavedOnInstance method to maintain the score when the device is rotated or when the Activity is paused. All the methods to update the counts are set programtically in the MainActivity. See how it looks below.

![ScreenShot](https://github.com/throwrocks/android-project-images/blob/master/court-counter/android-court-counter.png)

