package com.example.airecog.domain

import android.graphics.Bitmap
import org.tensorflow.lite.task.vision.classifier.Classifications

interface LandmarkClassifier {
    fun classify(bitmap: Bitmap,rotation:Int) : List<classification>

}