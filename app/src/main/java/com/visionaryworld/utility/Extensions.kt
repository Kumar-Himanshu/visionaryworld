package com.visionaryworld.utility

import android.text.TextUtils


/**
 * Created by Kumar Himanshu(KHimanshu@ustechsolutions.com) on 22-07-2020.
 * Copyright (c) 2020 USTech Solutions. All rights reserved.
 */
object Extensions {
    fun String.isValidAadharNumber(): Boolean {
        var isValid = true
        this.replace("-", "").trim()
        if (TextUtils.isEmpty(this)) {
            isValid = false
        } else if (this.length in 1..11) {
            isValid = false
        } else if (this.length == 12 && !Commons.isValidAadharNumber(this)) {
            isValid = false
        } else if (this.length == 12 && Commons.isValidAadharNumber(this)) {
            if (!VerhoeffAlgorithm.validateVerhoeff(this)) {
                isValid = false
            }
        }
        return isValid
    }
}