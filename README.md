
# Ten Percent Happier Android Task

### Overview

The goal of this assignment is to implement a RecyclerView that populates the data of Featured Topics from the topics API call. For the purpose of this application I have used Kotlin as my choice of Programming Language.
In this application, I have used Retrofit for network calls with a Gson Convertor Factory that converts the data from Json to Kotlin Data Classes.
The Topics list displays the title of the topic, the number of meditations in each topic and when clicked on any one of the list item it displays an AlertDialog that shows the short description of the topic.

The Main Activity calls the TenPercent get topics API and renders the featured topics on the landing page of the app. The call is made using Retrofit and it is delivered through LiveData from a ViewModel.
As it is using Android Architectural Components, the application is lifecycle  aware and the data delivery is also lifecycle aware.

# Screens

### Light Mode

The application when opened with the System Light Mode shows the following screens.

<img src="https://github.com/anizmo/tenpercenttask/raw/master/screens/LightMode.png?raw=true" alt="alt text" style="zoom:20%;" />

### Dark Mode

The application also supports the default dark mode, for this the appropriate values are added in the -night variant of the color XML file, the app when opened with the System Dark Mode shows the following screens.

<img src="https://github.com/anizmo/tenpercenttask/raw/master/screens/DarkMode.png?raw=true" alt="alt text" style="zoom:20%;" />

# Release Info

### TenPercentTaskLight.apk

This is a release APK that only supports the LightMode, the application is forced to LightMode on startup.

### TenPercentTask.apk

This is a release APK that supports both the Light and the Dark Mode i.e. there is no forced Mode change in this release.

Both, the release are marked as the same version number and the same app name, package id, hence only one can reside on a device at any given time.





