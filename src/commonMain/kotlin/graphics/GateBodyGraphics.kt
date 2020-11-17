package graphics

import com.soywiz.korge.view.*
import com.soywiz.korim.vector.Context2d

fun Container.gateBodyGraphics(shape: GateShape, size: Double, padding: Double, callback : @ViewDslMarker GateGraphics.() -> Unit = {}) = GateGraphics(shape, size, padding).addTo(this, callback)
class GateGraphics(shape: GateShape, size: Double, padding: Double) : Graphics(true) {
    init {
        //Set Padding
        x = padding
        y = padding

        //Set scale
        val s = size - (padding * 2)

        //Get shape vector
        val vector = GateShape.getShapeVector(shape, s)

        //Draw IO lines
        stroke(Theme.COMPONENT_BORDER_COLOR, Context2d.StrokeInfo(thickness = Theme.COMPONENT_BORDER_THICKNESS_RATIO * s)) {
            moveTo(0.8*s,0.5*s)
            lineTo(1.0*s,0.5*s)

            moveTo(0.0*s,0.333*s)
            lineTo(0.2*s,0.333*s)

            moveTo(0.0*s,0.666*s)
            lineTo(0.2*s,0.666*s)
        }

        //Fill background
        fill(Theme.COMPONENT_BACKGROUND_COLOR, vector)

        //Draw border
        stroke(Theme.COMPONENT_BORDER_COLOR, Context2d.StrokeInfo(thickness = Theme.COMPONENT_BORDER_THICKNESS_RATIO * s), vector)
    }
}