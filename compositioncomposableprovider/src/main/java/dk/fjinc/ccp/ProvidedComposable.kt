package dk.fjinc.ccp

import androidx.compose.runtime.Composable
import java.io.Serializable

data class ProvidedComposable(
    val composable: @Composable () -> Unit
) : Serializable
