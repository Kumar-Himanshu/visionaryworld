package com.visionaryworld

import android.text.TextUtils
import android.util.Log
import com.google.android.gms.vision.Detector
import com.google.android.gms.vision.text.TextBlock
import com.visionaryworld.camera.GraphicOverlay
import com.visionaryworld.interfaces.ITextObserver
import com.visionaryworld.utility.Extensions.isValidAadharNumber


/**
 * Created by Kumar Himanshu(KHimanshu@ustechsolutions.com) on 22-07-2020.
 * Copyright (c) 2020 USTech Solutions. All rights reserved.
 */
class OcrDetectorProcessor internal constructor(
    private val mGraphicOverlay: GraphicOverlay<OcrGraphic>,
    private val iTextProcessor: ITextObserver
) : Detector.Processor<TextBlock> {
    override fun release() {
        mGraphicOverlay.clear()
    }

    override fun receiveDetections(detections: Detector.Detections<TextBlock>?) {
        mGraphicOverlay.clear()
        val textStringBuilder = StringBuilder()
        var validAadhar = ""
        val items = detections!!.detectedItems
        for (i in 0 until items.size()) {
            val item = items.valueAt(i)
            if (item != null && item.value != null) {
                Log.d("Text Processor", "Text detected! " + item.value)
                if (item.value.isValidAadharNumber()){
//                    validAadhar = item.value
                    iTextProcessor.onTextRecieve(item.value)
                }
                textStringBuilder.append(item.value).append("\n")
//                val graphic = OcrGraphic(mGraphicOverlay, item)
//                mGraphicOverlay.add(graphic)
            }
        }
        textStringBuilder.setLength((textStringBuilder.length - 1).coerceAtLeast(0))
//        val lines: Array<String> = textStringBuilder.toString().split("\n").toTypedArray()
//        for (s in lines) if (s.isValidAadharNumber()) validAadhar = s
//        if(!TextUtils.isEmpty(validAadhar)) iTextProcessor.onTextRecieve(validAadhar)
    }
}