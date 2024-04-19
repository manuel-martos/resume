package info.degirona.mmartos.models

import androidx.compose.runtime.Immutable

@Immutable
data class ResumeModel(
    val profile: Profile,
)

@Immutable
data class Profile(
    val name: String,
    val title: String,
    val description: String,
)

val myResumeModel = ResumeModel(
    profile = Profile(
        name = "Manel Martos Roldán",
        title = "Lead Android Engineer",
        description = "I'm passionate about tech in general, especially computer graphics. What" +
                " motivates me is delivering high-quality products to end-users using the latest" +
                " tools on my hands.",
    ),
)