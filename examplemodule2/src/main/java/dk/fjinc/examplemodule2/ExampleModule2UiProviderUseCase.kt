package dk.fjinc.examplemodule2

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.sp
import dk.fjinc.ccp.CompositionComposableContentProvider
import dk.fjinc.ccp.ProvidedComposable
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

/**
* Example of providing UI from exampleModule2.
* Could have loaded data from where ever, and mapped it into composables
*/
class ExampleModule2UiProviderUseCase @Inject constructor() : CompositionComposableContentProvider {

    override suspend fun startProviding(flow: MutableStateFlow<ProvidedComposable>) {
        while (true) {
            delay(2000)
            flow.value = provideText()
        }
    }

    override fun initialComposable(): ProvidedComposable {
        return ProvidedComposable(
            composable = {
                CircularProgressIndicator()
            }
        )
    }

    private var increment = 0

    private fun provideText(): ProvidedComposable {
        increment = increment.plus(1)
        return ProvidedComposable(
            composable = {
                Greeting(
                    increment = increment.toString()
                )
            }
        )
    }


    @Composable
    fun Greeting(
        increment: String,
        modifier: Modifier = Modifier
    ) {
        Text(
            text = "Hello from examplemodule2! : $increment",
            modifier = modifier,
            fontSize = 32.sp,
            fontStyle = FontStyle.Italic
        )
    }
}
