package com.quare.blitzsplit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.android.gms.ads.MobileAds
import com.quare.blitzsplit.ads.BannerAd
import com.quare.blitzsplit.ads.InterstitialAdClass
import com.quare.blitzsplit.ui.theme.BlitzSplitTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val interstitialAd = InterstitialAdClass()
            val rewardedAd = com.quare.blitzsplit.ads.RewardedAd()

            MobileAds.initialize(this)
            BlitzSplitTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp),
                        verticalArrangement = Arrangement.SpaceEvenly,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        BannerAd("ca-app-pub-3940256099942544/6300978111") //Mock Id; será pego do AdMob
                        Button(onClick = { interstitialAd.showInterstitialAd(this@MainActivity) }) {
                            Text("Show interstitial ad")
                        }
                        Button(onClick = { rewardedAd.showRewardedAd(this@MainActivity) }) {
                            Text("Show premium ad")
                        }
                    }
                }
            }
        }
    }
}