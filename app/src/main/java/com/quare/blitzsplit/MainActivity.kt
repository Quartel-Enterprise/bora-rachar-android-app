package com.quare.blitzsplit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.quare.blitzsplit.ui.theme.BlitzSplitTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MobileAds.initialize(this)
            BlitzSplitTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BannerAd("ca-app-pub-3940256099942544/6300978111") //Mock Id; será pego do AdMob
                }
            }
        }
    }
}

@Composable
fun BannerAd(adId: String) {
    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(Modifier.height(16.dp))
        AndroidView(
            modifier = Modifier.fillMaxWidth(),
            factory = { context ->
                AdView(context).apply {
                    setAdSize(AdSize.BANNER)
                    adUnitId = adId
                    loadAd(AdRequest.Builder().build())
                }
            }
        )
    }
}
