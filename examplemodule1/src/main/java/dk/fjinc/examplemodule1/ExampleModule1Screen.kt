package dk.fjinc.examplemodule1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import dk.fjinc.examplemodule1.di.compositions.LocalUiNeededInExampleModule1Composition

@Composable
fun ExampleModule1Screen(
    viewModel: ExampleModule1ViewModel = hiltViewModel()
) {
    viewModel.provider.LocalProvider {
        Column(
            modifier = Modifier
                .verticalScroll(
                    state = rememberScrollState()
                )
        ) {
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .background(Color.Blue),
                contentAlignment = Alignment.Center
            ) {
                Greeting("exampleModule1")
            }
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(400.dp),
                contentAlignment = Alignment.Center
            ) {
                val currentLocalComposition = LocalUiNeededInExampleModule1Composition.current
                currentLocalComposition?.let {
                    val localState by currentLocalComposition.collectAsState()
                    localState.composable.invoke()
                }
            }
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .background(Color.Green),
                contentAlignment = Alignment.Center
            ) {
                Greeting("exampleModule1")
            }
        }
    }
}

@Composable
private fun Greeting(
    name: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = "Hello from $name!",
        modifier = modifier,
        fontSize = 32.sp,
        fontWeight = FontWeight.Bold
    )
}
