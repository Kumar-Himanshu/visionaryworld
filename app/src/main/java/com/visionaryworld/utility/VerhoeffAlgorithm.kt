package com.visionaryworld.utility

/**
 * The type Verhoeff algorithm.
 *@author Kumar Himanshu in kotlin
 * @author Colm Rice in Java
 * @see [More Info](http://en.wikipedia.org/wiki/Verhoeff_algorithm)
 *
 * @see [Dihedral Group](http://en.wikipedia.org/wiki/Dihedral_group)
 *
 * @see [Dihedral Group Order 10](http://mathworld.wolfram.com/DihedralGroupD5.html)
 */
object VerhoeffAlgorithm {
    /**
     * The constant d.
     */
    // The multiplication table
    var d = arrayOf(
        intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9),
        intArrayOf(1, 2, 3, 4, 0, 6, 7, 8, 9, 5),
        intArrayOf(2, 3, 4, 0, 1, 7, 8, 9, 5, 6),
        intArrayOf(3, 4, 0, 1, 2, 8, 9, 5, 6, 7),
        intArrayOf(4, 0, 1, 2, 3, 9, 5, 6, 7, 8),
        intArrayOf(5, 9, 8, 7, 6, 0, 4, 3, 2, 1),
        intArrayOf(6, 5, 9, 8, 7, 1, 0, 4, 3, 2),
        intArrayOf(7, 6, 5, 9, 8, 2, 1, 0, 4, 3),
        intArrayOf(8, 7, 6, 5, 9, 3, 2, 1, 0, 4),
        intArrayOf(9, 8, 7, 6, 5, 4, 3, 2, 1, 0)
    )

    /**
     * The constant p.
     */
    // The permutation table
    var p = arrayOf(
        intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9),
        intArrayOf(1, 5, 7, 6, 2, 8, 3, 0, 9, 4),
        intArrayOf(5, 8, 0, 3, 7, 9, 6, 1, 4, 2),
        intArrayOf(8, 9, 1, 6, 0, 4, 3, 5, 2, 7),
        intArrayOf(9, 4, 5, 3, 1, 2, 6, 8, 7, 0),
        intArrayOf(4, 2, 8, 6, 5, 7, 3, 9, 0, 1),
        intArrayOf(2, 7, 9, 3, 8, 0, 6, 4, 1, 5),
        intArrayOf(7, 0, 4, 6, 9, 1, 3, 2, 5, 8)
    )

    /**
     * The Inv.
     */
    // The inverse table
    var inv = intArrayOf(0, 4, 3, 2, 1, 5, 6, 7, 8, 9)

    /**
     * Validate verhoeff boolean.
     *
     * @param num the num
     * @return the boolean
     */
    /*
	 * Validates that an entered number is VerhoeffAlgorithm compliant.
	 * NB: Make sure the check digit is the last one.
	 */
    fun validateVerhoeff(num: String): Boolean {
        var c = 0
        val myArray = stringToReversedIntArray(num)
        for (i in myArray.indices) {
            c = d[c][p[i % 8][myArray[i]]]
        }
        return c == 0
    }

    /*
	 * Converts a string to a reversed integer array.
	 */
    private fun stringToReversedIntArray(num: String): IntArray {
        var myArray = IntArray(num.length)
        for (i in 0 until num.length) {
            myArray[i] = num.substring(i, i + 1).toInt()
        }
        myArray = reverse(myArray)
        return myArray
    }

    /*
	 * Reverses an int array
	 */
    private fun reverse(myArray: IntArray): IntArray {
        val reversed = IntArray(myArray.size)
        for (i in myArray.indices) {
            reversed[i] = myArray[myArray.size - (i + 1)]
        }
        return reversed
    }
}