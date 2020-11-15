package graphics

import com.soywiz.korge.view.Container
import com.soywiz.korge.view.Graphics
import com.soywiz.korge.view.ViewDslMarker
import com.soywiz.korge.view.addTo
import com.soywiz.korim.vector.Context2d
import com.soywiz.korim.vector.Shape
import com.soywiz.korma.geom.vector.VectorBuilder
import com.soywiz.korma.geom.vector.circle

fun Container.gateGraphics(shape: GateShape,size: Double, padding: Double,callback : @ViewDslMarker GateGraphics.() -> Unit) = GateGraphics(shape, size, padding).addTo(this, callback)
class GateGraphics(shape: GateShape, size: Double, padding: Double) : Graphics(true) {
    init {
        //Set Padding
        x = padding
        y = padding

        //Set scale
        val s = size - (padding * 2)

        //Get shape vector
        val vector = GateShape.getShapeVector(shape, s)

        //Fill background
        fill(Theme.COMPONENT_BACKGROUND_COLOR, vector)

        //Draw border
        stroke(Theme.COMPONENT_BORDER_COLOR, Context2d.StrokeInfo(thickness = Theme.COMPONENT_BORDER_THICKNESS_RATIO * s), vector)

        //Draw inputs
        val inputCircle1 : @ViewDslMarker VectorBuilder.() -> Unit = {
            circle(-s/10/2*2,1.0/3.0*s, s/10)
        }

        val inputCircle2 : @ViewDslMarker VectorBuilder.() -> Unit = {
            circle(-s/10/2*2,1.0/3.0*s*2.0, s/10)
        }

        fill(Theme.COMPONENT_BACKGROUND_COLOR,inputCircle1)
        stroke(Theme.COMPONENT_BORDER_COLOR, Context2d.StrokeInfo(thickness = 1.0),inputCircle1)
        fill(Theme.COMPONENT_BACKGROUND_COLOR,inputCircle2)
        stroke(Theme.COMPONENT_BORDER_COLOR, Context2d.StrokeInfo(thickness = 1.0),inputCircle2)
    }
}