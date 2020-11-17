package components

import com.soywiz.korge.view.*
import graphics.GateShape
import graphics.gateBodyGraphics

/**
 * And gate component with fixed size (Maybe dynamic size in the future?)
 */
fun Container.xorGate(callback : @ViewDslMarker XOrGate.() -> Unit) = XOrGate().addTo(this, callback)
class XOrGate : FixedSizeContainer(160.0,160.0, true) {
    init {
        //Set graphics
        gateBodyGraphics(GateShape.XOR_GATE ,160.0, 30.0) {

        }
    }
}