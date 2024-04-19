package info.degirona.mmartos.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement.Absolute.spacedBy
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import info.degirona.mmartos.models.ResumeModel
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import resume.composeapp.generated.resources.Res
import resume.composeapp.generated.resources.github_profile

@OptIn(ExperimentalResourceApi::class)
@Composable
fun Cover(
    resumeModel: ResumeModel,
    uiSpecs: UiSpecs,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = spacedBy(16.dp, Alignment.CenterVertically),
        modifier = modifier
    ) {
        OutlinedCard(
            onClick = onClick,
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = spacedBy(4.dp),
                modifier = Modifier.padding(16.dp),
            ) {
                Image(
                    painter = painterResource(Res.drawable.github_profile),
                    contentDescription = null,
                    modifier = Modifier
                        .size(uiSpecs.profilePictureSize)
                        .clip(CircleShape)
                        .border(
                            width = 4.dp,
                            color = MaterialTheme.colorScheme.onPrimaryContainer,
                            shape = CircleShape
                        )
                )
                Text(
                    text = resumeModel.profile.name,
                    style = MaterialTheme.typography.titleLarge,
                )
                Text(
                    text = resumeModel.profile.title,
                    style = MaterialTheme.typography.titleMedium,
                )
                Spacer(
                    modifier = Modifier
                        .padding(vertical = 8.dp)
                        .size(250.dp, 1.dp)
                        .background(MaterialTheme.colorScheme.surfaceVariant),
                )
                Text(
                    text = resumeModel.profile.description,
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.width(250.dp),
                )
            }
        }
        Button(onClick = onClick) {
            Text(text = "Read more", style = MaterialTheme.typography.bodyLarge)
        }
    }
}
