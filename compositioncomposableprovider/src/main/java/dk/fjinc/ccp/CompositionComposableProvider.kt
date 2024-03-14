package dk.fjinc.ccp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ProvidableCompositionLocal
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.io.Serializable

typealias Provider = CompositionComposableProvider

/**
* Knows how to start the composable flow, and bind the local composition to the flow
*/
class CompositionComposableProvider(
    private val provider: CompositionComposableContentProvider,
    private val localComposition: ProvidableCompositionLocal<StateFlow<ProvidedComposable>?>
) : Serializable {

    private val _composables: MutableStateFlow<ProvidedComposable> = MutableStateFlow(provider.initialComposable())
    private val composables: StateFlow<ProvidedComposable> = _composables

    @Composable
    fun LocalProvider(
        content: @Composable () -> Unit
    ) {
        CompositionLocalProvider(
            localComposition provides composables,
            content = content
        )
    }

    suspend fun startProviding() {
        provider.startProviding(
            flow = _composables
        )
    }
}
