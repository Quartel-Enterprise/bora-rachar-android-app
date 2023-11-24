package com.quare.blitzsplit.ads

import android.app.Activity
import android.content.ContentValues
import android.util.Log
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

class InterstitialAdClass {
    fun showInterstitialAd(activity: Activity) {
        loadInterstitialAd(activity) { interstitialAd ->
            if (interstitialAd != null) {
                // Ad loaded successfully, you can now show the interstitial ad
                interstitialAd.show(activity)
            } else {
                // Ad loading failed or was not loaded, handle accordingly
            }
        }
    }
    private fun loadInterstitialAd(activity: Activity, callback: (InterstitialAd?) -> Unit) {
        val adRequest = AdRequest.Builder().build()

        InterstitialAd.load(
            activity,
            "ca-app-pub-3940256099942544/1033173712",
            adRequest,
            object : InterstitialAdLoadCallback() {
                override fun onAdFailedToLoad(adError: LoadAdError) {
                    Log.d(ContentValues.TAG, adError.toString())
                    callback(null)
                }

                override fun onAdLoaded(interstitialAd: InterstitialAd) {
                    Log.d(ContentValues.TAG, "Ad was loaded.")
                    callback(interstitialAd)
                }
            }
        )
    }
}