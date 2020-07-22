package com.visionaryworld.utility

import java.util.regex.Pattern


/**
 * Created by Kumar Himanshu(KHimanshu@ustechsolutions.com) on 22-07-2020.
 * Copyright (c) 2020 USTech Solutions. All rights reserved.
 */
object Commons {
    const val AADHAAR_REGEX = "^\\d{4}\\d{4}\\d{4}$"
    fun isValidAadharNumber(pAadharNumber: String?): Boolean {
        val validRegexPattern =
            Pattern.compile(AADHAAR_REGEX)
        return validRegexPattern.matcher(pAadharNumber!!).matches()
    }

}