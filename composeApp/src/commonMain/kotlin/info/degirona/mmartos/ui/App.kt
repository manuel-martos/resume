package info.degirona.mmartos.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import info.degirona.mmartos.models.myResumeModel
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App(
    modifier: Modifier = Modifier
) {
    MaterialTheme(
        colorScheme = darkColorScheme()
    ) {
        Surface(
            modifier = modifier,
        ) {
            ResumeScreen(
                resumeModel = myResumeModel,
                uiSpecs = getUiSpecs(),
                modifier = modifier.fillMaxSize()
            )
        }
    }
}
