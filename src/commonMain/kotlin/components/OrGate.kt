package components

import com.soywiz.korge.view.*
import graphics.GateShape
import graphics.gateBodyGraphics

/**
 * And gate component with fixed size (Maybe dynamic size in the future?)
 */
fun Container.orGate(callback : @ViewDslMarker OrGate.() -> Unit) = OrGate().addTo(this, callback)
class OrGate : FixedSizeContainer(160.0,160.0, true) {
    init {
        //Set graphics
        gateBodyGraphics(GateShape.OR_GATE ,160.0, 30.0) {

        }
    }
}