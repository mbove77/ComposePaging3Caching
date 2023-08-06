package com.martinbove.paging3compose.presentation.utils

import android.graphics.Bitmap
import android.graphics.Matrix
import coil.size.Size
import coil.transform.Transformation

/**
 * Created by Martín Bove on 01/08/2023.
 * E-mail: mbove77@gmail.com
 */

class RotateImgTransformation(private val degrees: Float, override val cacheKey: String) :
    Transformation {

    override suspend fun transform(input: Bitmap, size: Size): Bitmap {
        val matrix = Matrix().apply {
            postRotate(degrees)
        }
        return Bitmap.createBitmap(input, 0, 0, input.width, input.height, matrix, true)
    }
}
