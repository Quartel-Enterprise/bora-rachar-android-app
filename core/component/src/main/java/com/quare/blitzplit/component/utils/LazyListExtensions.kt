import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.saveable.rememberSaveable

/**
 * Manages the persistent storage of scroll states for lists, identified by
 * unique keys.
 */
private object ScrollStateStorage {
    val saveMap = mutableMapOf<String, KeyParams>()
}

/**
 * Data class representing the parameters needed to restore the scroll
 * state of a list.
 */
private data class KeyParams(
    val params: String = "",
    val index: Int,
    val scrollOffset: Int,
)

/**
 * Remembers and restores the scroll state of a lazy list across
 * recompositions, uniquely identified by a key and additional parameters.
 *
 * @param key Unique identifier for the lazy list whose state is to be
 *     saved.
 * @param params Additional parameters to differentiate lists with the same
 *     key.
 * @param initialFirstVisibleItemIndex Default index to use if no saved
 *     state exists.
 * @param initialFirstVisibleItemScrollOffset Default scroll offset to use
 *     if no saved state exists.
 * @return [LazyListState] The current state of the lazy list, either
 *     restored from saved state or initialized with provided defaults.
 */
@Composable
fun rememberForeverLazyListState(
    key: String,
    params: String = "",
    initialFirstVisibleItemIndex: Int = 0,
    initialFirstVisibleItemScrollOffset: Int = 0,
): LazyListState {
    val scrollState = rememberSaveable(saver = LazyListState.Saver) {
        ScrollStateStorage.saveMap[key]?.takeIf { it.params == params }
            ?.let { savedParams ->
                LazyListState(
                    firstVisibleItemIndex = savedParams.index,
                    firstVisibleItemScrollOffset = savedParams.scrollOffset
                )
            } ?: LazyListState(
            firstVisibleItemIndex = initialFirstVisibleItemIndex,
            firstVisibleItemScrollOffset = initialFirstVisibleItemScrollOffset
        )
    }

    DisposableEffect(Unit) {
        onDispose {
            ScrollStateStorage.saveMap[key] = KeyParams(
                params = params,
                index = scrollState.firstVisibleItemIndex,
                scrollOffset = scrollState.firstVisibleItemScrollOffset
            )
        }
    }

    return scrollState
}
