package components

import com.soywiz.korge.view.*
import com.soywiz.korim.vector.Context2d
import graphics.GateShape
import graphics.Theme
import graphics.gateGraphics

/**
 * And gate component with fixed size (Maybe dynamic size in the future?)
 */
fun Container.orGate(callback : @ViewDslMarker OrGate.() -> Unit) = OrGate().addTo(this, callback)
class OrGate : FixedSizeContainer(160.0,160.0, true) {
    init {
        //Set graphics
        gateGraphics(GateShape.OR_GATE ,160.0, 30.0) {
            stroke(Theme.COMPONENT_BORDER_COLOR, Context2d.StrokeInfo(thickness = Theme.COMPONENT_BORDER_THICKNESS_RATIO * 100.0)) {
                moveTo(80.0,50.0)
                lineTo(100.0,50.0)

                moveTo(0.0,33.3)
                lineTo(22.0,33.3)

                moveTo(0.0,66.6)
                lineTo(22.0,66.6)
            }
        }
    }
}