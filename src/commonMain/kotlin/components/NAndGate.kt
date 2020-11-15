package components

import com.soywiz.korge.view.*
import com.soywiz.korim.vector.Context2d
import graphics.GateShape
import graphics.Theme
import graphics.gateGraphics

/**
 * And gate component with fixed size (Maybe dynamic size in the future?)
 */
fun Container.nandGate(callback : @ViewDslMarker NAndGate.() -> Unit) = NAndGate().addTo(this, callback)
class NAndGate : FixedSizeContainer(160.0,160.0, true) {
    init {
        //Set graphics
        gateGraphics(GateShape.NAND_GATE ,160.0, 30.0) {

        }
    }
}