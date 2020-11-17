package components

import com.soywiz.korge.view.*
import graphics.GateShape
import graphics.gateBodyGraphics

/**
 * And gate component with fixed size (Maybe dynamic size in the future?)
 */
fun Container.nandGate(callback : @ViewDslMarker NAndGate.() -> Unit) = NAndGate().addTo(this, callback)
class NAndGate : FixedSizeContainer(160.0,160.0, true) {
    init {
        //Set graphics
        gateBodyGraphics(GateShape.NAND_GATE ,160.0, 30.0) {

        }
    }
}