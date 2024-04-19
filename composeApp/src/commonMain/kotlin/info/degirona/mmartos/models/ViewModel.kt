package info.degirona.mmartos.models

import androidx.compose.runtime.Immutable

@Immutable
data class ViewModel(
    val resumeModel: ResumeModel,
    val activePage: Page,
)

@Immutable
sealed interface Page {
    @Immutable
    data object Cover : Page

    @Immutable
    data object Details : Page
}

