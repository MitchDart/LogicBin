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

        }
    }
}