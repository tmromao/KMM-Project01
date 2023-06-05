package com.example.kmmproject01.resources

/**
 *  iOS only needs the image string reference to resolve its images.
 *  Android on the other hand must resolve its reference from R.drawable first.
 *  For that reason, we offer a drawable resolver method for android only in its atual implementation
 *  */
expect class ImageResource(name: String)
