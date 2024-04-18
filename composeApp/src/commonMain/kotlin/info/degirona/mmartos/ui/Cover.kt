package info.degirona.mmartos.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement.Absolute.spacedBy
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import resume.composeapp.generated.resources.Res
import resume.composeapp.generated.resources.github_profile

@OptIn(ExperimentalResourceApi::class)
@Composable
fun Cover(
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
                        .size(64.dp)
                        .clip(CircleShape)
                        .border(
                            width = 1.dp,
                            color = MaterialTheme.colorScheme.onPrimaryContainer,
                            shape = CircleShape
                        )
                )
                Text(
                    text = "Manel Martos",
                    style = MaterialTheme.typography.headlineMedium
                )
                Text(
                    text = "Lead Android Engineer",
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
        Button(onClick = onClick) {
            Text(text = "Read more", style = MaterialTheme.typography.bodyLarge)
        }
    }
}
