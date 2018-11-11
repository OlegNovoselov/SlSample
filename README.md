# SLlibrary

Our library is closely related to developing cross-platform framework for interactive overlay content.

Prerequisites
--------------
- Android SDK v27
- Latest Android Build Tools
- Android Support Repository

Installation
--------------
Add the following to your build.gradle

```
repositories {
    maven {
        url 'https://kusto.bintray.com/maven/'
    }
}

dependencies {
    compile 'com.github.onovoselov:sllibrary:1.0.0'
}
```
Usage
--------------
Add to the end of your layout.xml

```
<com.makeomatic.sllibrary.SLView
    android:layout_width="match_parent"
    android:layout_height="match_parent" />
```
Example
--------------

```
<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context="com.makeomatic.myapplication.MainActivity">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Hello World!"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <com.makeomatic.sllibrary.SLView
        android:layout_width="match_parent"
        android:layout_height="match_parent" />

</android.support.constraint.ConstraintLayout>
```
