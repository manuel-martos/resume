package info.degirona.mmartos.modifiers

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.drawscope.ContentDrawScope
import androidx.compose.ui.node.DrawModifierNode
import androidx.compose.ui.node.ModifierNodeElement
import androidx.compose.ui.platform.InspectorInfo
import info.degirona.mmartos.shaders.shaderBrushBuilder

fun Modifier.vignette(
    intensity: Float,
    decayFactor: Float,
    tintColor: Color,
): Modifier =
    this then VignetteNodeElement(intensity, decayFactor, tintColor)

private data class VignetteNodeElement(
    val intensity: Float,
    val decayFactor: Float,
    val tintColor: Color,
) : ModifierNodeElement<VignetteModifier>() {
    override fun create() = VignetteModifier(intensity, decayFactor, tintColor)

    override fun update(node: VignetteModifier) {
        node.intensity = intensity
        node.decayFactor = decayFactor
        node.tintColor = tintColor
    }

    override fun InspectorInfo.inspectableProperties() {
        name = "vignette"
        properties["intensity"] = intensity
        properties["decayFactor"] = decayFactor
        properties["tintColor"] = tintColor
    }
}

private class VignetteModifier(
    var intensity: Float,
    var decayFactor: Float,
    var tintColor: Color,
) : Modifier.Node(), DrawModifierNode {

    override fun ContentDrawScope.draw() {
        drawContent()
        drawRect(
            brush = shaderBrushBuilder {
                uniform("iResolution", size.width, size.height)
                uniform("iIntensity", intensity)
                uniform("iDecayFactor", decayFactor)
                shader(
                    """
                        uniform float2 iResolution;
                        uniform float iIntensity;
                        uniform float iDecayFactor;

                        half4 main(vec2 fragCoord) {
                            vec2 uv = fragCoord.xy / iResolution.xy;
                            uv *=  1.0 - uv.yx;
                            float vig = uv.x*uv.y * iIntensity; // multiply with sth for intensity
                            vig = pow(vig, iDecayFactor);
                            return vec4(1.0 - vig); 
                        }
                    """.trimIndent()
                )
            },
            colorFilter = ColorFilter.tint(tintColor)
        )
    }
}
