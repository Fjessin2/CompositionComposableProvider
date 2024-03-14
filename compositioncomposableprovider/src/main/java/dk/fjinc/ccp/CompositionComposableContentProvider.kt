package dk.fjinc.ccp

import kotlinx.coroutines.flow.MutableStateFlow
import java.io.Serializable

/*
* To be implemented by whoever knows how to display specific Ui
*/
interface CompositionComposableContentProvider : Serializable {
    suspend fun startProviding(
        flow: MutableStateFlow<ProvidedComposable>
    )

    fun initialComposable(): ProvidedComposable
}
