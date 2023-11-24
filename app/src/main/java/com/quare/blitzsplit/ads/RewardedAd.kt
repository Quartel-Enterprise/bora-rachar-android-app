package com.quare.blitzsplit.ads

import android.app.Activity
import android.content.ContentValues
import android.content.ContentValues.TAG
import android.util.Log
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.OnUserEarnedRewardListener
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback

class RewardedAd {
    fun showRewardedAd(activity: Activity) {
        loadRewardedAd(activity) { rewardedAd ->
            if (rewardedAd != null) {
                rewardedAd.show(activity, OnUserEarnedRewardListener { rewardItem ->
                    // Handle the reward.
                    val rewardAmount = rewardItem.amount
                    val rewardType = rewardItem.type
                    Log.d(TAG, "User earned the reward.")
                })
            } else {
                // Ad loading failed or was not loaded, handle accordingly
                Log.d(TAG, "The rewarded ad wasn't ready yet.")
            }
        }
    }
    private fun loadRewardedAd(activity: Activity, callback: (RewardedAd?) -> Unit) {
        val adRequest = AdRequest.Builder().build()

        RewardedAd.load(
            activity,
            "ca-app-pub-3940256099942544/5224354917",
            adRequest,
            object : RewardedAdLoadCallback() {
                override fun onAdFailedToLoad(adError: LoadAdError) {
                    Log.d(ContentValues.TAG, adError.toString())
                    callback(null)
                }

                override fun onAdLoaded(rewardedAd: RewardedAd) {
                    Log.d(ContentValues.TAG, "Ad was loaded.")
                    callback(rewardedAd)
                }
            }
        )
    }
}
