package com.example.kmmproject01.resources

// 1) Specify the windows size
// 2) Get the windows size (Android and iOS)
// 3) Implement the Android and iOS (iOS tricky)
// 4) Create spacing resources
// 5) Use the resources

/**
 *
 * Indicates which port view (windows size) the app is running on
 *
 * */
expect fun getWindowSize(): WindowSize

expect class SpacingResource(unit: Int)

enum class WindowSize(val size: Int){
    // Those break points are defined by your UI/UX team
    Small(320), Medium(375), Large(430)
}