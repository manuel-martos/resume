package info.degirona.mmartos.shaders

import androidx.compose.ui.graphics.ShaderBrush

sealed interface UniformValue {
    val name: String

    data class UniformFloat(
        override val name: String,
        val value: Float,
    ) : UniformValue

    data class UniformFloat2D(
        override val name: String,
        val value1: Float,
        val value2: Float,
    ) : UniformValue
}

class ShaderBrushBuilder {
    internal val uniforms = mutableListOf<UniformValue>()
    internal var shader: String = ""

    fun uniform(name: String, value: Float) {
        uniforms.add(UniformValue.UniformFloat(name, value))
    }

    fun uniform(name: String, value1: Float, value2: Float) {
        uniforms.add(UniformValue.UniformFloat2D(name, value1, value2))
    }

    fun shader(shader: String) {
        this.shader = shader
    }
}

fun shaderBrushBuilder(block: ShaderBrushBuilder.() -> Unit): ShaderBrush =
    ShaderBrushBuilder().apply {
        block()
    }.build()

expect fun ShaderBrushBuilder.build(): ShaderBrush
