package info.degirona.mmartos

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform