package dk.fjinc.ccp

import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.compositionLocalOf
import kotlinx.coroutines.flow.StateFlow

fun defaultLocalComposition(): ProvidableCompositionLocal<StateFlow<ProvidedComposable>?> {
    return compositionLocalOf { null }
}
