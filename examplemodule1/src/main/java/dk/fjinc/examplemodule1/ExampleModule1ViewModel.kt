package dk.fjinc.examplemodule1

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dk.fjinc.ccp.Provider
import dk.fjinc.examplemodule1.di.qualifiers.SomeUiExampleModule1Needs
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExampleModule1ViewModel @Inject constructor(
    @SomeUiExampleModule1Needs val provider: Provider
) : ViewModel() {

    init {
        viewModelScope.launch {
            provider.startProviding()
        }
    }
}
