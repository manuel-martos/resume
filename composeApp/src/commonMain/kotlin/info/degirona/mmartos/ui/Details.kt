package info.degirona.mmartos.ui

import androidx.compose.foundation.layout.Arrangement.Absolute.spacedBy
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Details(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
    ) {
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