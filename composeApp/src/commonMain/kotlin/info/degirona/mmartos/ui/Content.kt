package info.degirona.mmartos.ui

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.Absolute.spacedBy
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import resume.composeapp.generated.resources.Res
import resume.composeapp.generated.resources.github_profile

sealed interface State {
    data object Cover : State
    data object Details : State
}

@Composable
fun Content(modifier: Modifier = Modifier) {
    var state by remember { mutableStateOf<State>(State.Cover) }

    AnimatedContent(
        state
    ) {
        when (it) {
            is State.Cover ->
                Cover(modifier) {
                    state = State.Details
                }

            is State.Details ->
                Details(modifier)

        }
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun Cover(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier,
    ) {
        GridBackground(
            hue = 216f,
            modifier = Modifier
                .fillMaxSize()
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Absolute.spacedBy(16.dp),
        ) {
            OutlinedCard(
                onClick = onClick,
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Absolute.spacedBy(4.dp),
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
}

@Composable
fun Details(modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier,
    ) {
        GridBackground(
            hue = 36f,
            modifier = Modifier
                .fillMaxSize()
        )
        OutlinedCard(
            modifier = Modifier
                .align(BiasAlignment(-0.4f, -0.4f))
        ) {
            Column(
                verticalArrangement = spacedBy(4.dp),
                modifier = Modifier
                    .requiredWidth(320.dp)
                    .padding(16.dp)
            ) {
                Text(text = "Lorem Ipsum", style = MaterialTheme.typography.titleLarge)
                Text(
                    text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }

        Card(
            modifier = Modifier
                .align(BiasAlignment(0.2f, -0.3f))
        ) {
            Column(
                verticalArrangement = spacedBy(4.dp),
                modifier = Modifier
                    .requiredWidth(320.dp)
                    .padding(16.dp)
            ) {
                Text(text = "Lorem Ipsum", style = MaterialTheme.typography.titleLarge)
                Text(
                    text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }

        Card(
            modifier = Modifier
                .align(BiasAlignment(-0.5f, 0.2f))
        ) {
            Column(
                verticalArrangement = spacedBy(4.dp),
                modifier = Modifier
                    .requiredWidth(320.dp)
                    .padding(16.dp)
            ) {
                Text(text = "Lorem Ipsum", style = MaterialTheme.typography.titleLarge)
                Text(
                    text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }

        OutlinedCard(
            modifier = Modifier
                .align(BiasAlignment(0.25f, 0.35f))
        ) {
            Column(
                verticalArrangement = spacedBy(4.dp),
                modifier = Modifier
                    .requiredWidth(320.dp)
                    .padding(16.dp)
            ) {
                Text(text = "Lorem Ipsum", style = MaterialTheme.typography.titleLarge)
                Text(
                    text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}