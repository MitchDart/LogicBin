package components

import com.soywiz.korge.view.*
import graphics.GateShape
import graphics.gateBodyGraphics

/**
 * And gate component with fixed size (Maybe dynamic size in the future?)
 */
fun Container.norGate(callback : @ViewDslMarker NOrGate.() -> Unit) = NOrGate().addTo(this, callback)
class NOrGate : FixedSizeContainer(160.0,160.0, true) {
    init {
        //Set graphics
        gateBodyGraphics(GateShape.NOR_GATE ,160.0, 30.0) {

        }
    }
}