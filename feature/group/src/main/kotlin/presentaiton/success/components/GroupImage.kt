package presentaiton.success.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.quare.blitzplit.component.picture.Picture

@Composable
fun GroupImage(
    url: String?,
    modifier: Modifier = Modifier,
) {
    Picture(
        modifier = modifier
            .clip(RoundedCornerShape(28.dp))
            .width(116.dp)
            .height(92.dp),
        url = url,
        contentDescription = null,
    )
}
