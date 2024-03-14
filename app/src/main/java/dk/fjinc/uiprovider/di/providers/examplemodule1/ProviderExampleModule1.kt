package dk.fjinc.uiprovider.di.providers.examplemodule1

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dk.fjinc.ccp.CompositionComposableProvider
import dk.fjinc.ccp.Provider
import dk.fjinc.examplemodule1.di.compositions.LocalUiNeededInExampleModule1Composition
import dk.fjinc.examplemodule1.di.qualifiers.SomeUiExampleModule1Needs
import dk.fjinc.examplemodule2.ExampleModule2UiProviderUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ProviderExampleModule1 {

    /**
     * Collects needed components for showing UI from exampleModule2, inside exampleModule1.
     * exampleModule1 knows what it needs, exampleModule2 knows how to provide it,
     * and app module glues it together.
     */
    @Provides
    @Singleton
    @SomeUiExampleModule1Needs
    fun provideSomeUiExampleModule1Needs(
        exampleModule2UiProviderUseCase: ExampleModule2UiProviderUseCase
    ): Provider {
        return CompositionComposableProvider(
            provider = exampleModule2UiProviderUseCase,
            localComposition = LocalUiNeededInExampleModule1Composition
        )
    }
}
