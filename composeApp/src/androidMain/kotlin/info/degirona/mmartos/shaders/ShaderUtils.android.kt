package info.degirona.mmartos.shaders

import android.graphics.RuntimeShader
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Shader
import androidx.compose.ui.graphics.ShaderBrush

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
actual fun ShaderBrushBuilder.build(): ShaderBrush =
    object : ShaderBrush() {
        override fun createShader(size: Size): Shader =
            RuntimeShader(this@build.shader)
                .apply {
                    uniforms.forEach {
                        when (it) {
                            is UniformValue.UniformFloat ->
                                setFloatUniform(it.name, it.value)

                            is UniformValue.UniformFloat2D ->
                                setFloatUniform(it.name, it.value1, it.value2)
                        }
                    }
                }
    }