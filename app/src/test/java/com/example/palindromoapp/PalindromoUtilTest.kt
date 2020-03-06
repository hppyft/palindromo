package com.example.palindromoapp

import android.os.Build
import com.example.palindromoapp.view.util.PalindromoUtil
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.P])
class PalindromoUtilTest {

    @Test
    fun isPalindromoTest() {
        val truePalindromo = "asa"
        val truePlaindromo2 = "osso"

        assertTrue(PalindromoUtil.isTextPalindromo(truePalindromo))
        assertTrue(PalindromoUtil.isTextPalindromo(truePlaindromo2))

        val falsePalindromo = "asaa"
        val falsePalindromo2 = "jo0j"

        assertFalse(PalindromoUtil.isTextPalindromo(falsePalindromo))
        assertFalse(PalindromoUtil.isTextPalindromo(falsePalindromo2))
    }
}