package com.example.airecog.presentation

import android.icu.number.NumberFormatter.UnitWidth
import android.media.Image
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import com.example.airecog.domain.LandmarkClassifier
import com.example.airecog.domain.classification

class landmarkImageAnalyzer(
    private val classifier:LandmarkClassifier,
    private val onResults: (List<classification>)->Unit
):ImageAnalysis.Analyzer {
    private var frameSkipCounter=0

    override fun analyze(image: ImageProxy) {
        if(frameSkipCounter%60==0) {


            val rotationDegrees = image.imageInfo.rotationDegrees
            val bitmap = image.toBitmap()
                .centerCrop(321, 321)
            val results = classifier.classify(bitmap, rotationDegrees)
            onResults(results)
        }
        frameSkipCounter++
        image.close()
    }

}