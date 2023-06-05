package com.example.kmmproject01.resources

import com.example.kmmproject01.utils.AndroidApplication

actual class ImageResource actual constructor(private val name: String) {

    private var _id: Int = -1 // only set for android preview
    val id: Int by lazy { getDrawableRes() }

    private fun getDrawableRes(): Int {
        return if (_id == -1) {
            with(AndroidApplication.context) {
                resources.getIdentifier(name, "drawable", packageName)
            }
        } else return _id
    }

    /** internal cause only used in shared code by getPreviewImageResource bellow */
    internal fun setPreview(id: Int) {
        _id = id
    }

}

/**
 * call this function whenever you need to preview views on Android
 * @param id any R.drawable.your_id to be able to preview screens on Android while developing
 */
fun getPreviewImageResource(id: Int): ImageResource {
    val preview = ImageResource("")
    preview.setPreview(id)
    return preview
}