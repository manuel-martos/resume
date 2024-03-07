package info.degirona.mmartos.shaders

import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Shader
import androidx.compose.ui.graphics.ShaderBrush
import org.jetbrains.skia.RuntimeEffect
import org.jetbrains.skia.RuntimeShaderBuilder

actual fun ShaderBrushBuilder.build(): ShaderBrush =
    object : ShaderBrush() {
        override fun createShader(size: Size): Shader =
            RuntimeShaderBuilder(
                effect = RuntimeEffect.makeForShader(this@build.shader),
            ).apply {
                uniforms.forEach {
                    when (it) {
                        is UniformValue.UniformFloat ->
                            uniform(it.name, it.value)

                        is UniformValue.UniformFloat2D ->
                            uniform(it.name, it.value1, it.value2)
                    }
                }
            }.makeShader()

    }
