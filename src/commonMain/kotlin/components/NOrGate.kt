package components

import com.soywiz.korge.view.*
import com.soywiz.korim.vector.Context2d
import graphics.GateShape
import graphics.Theme
import graphics.gateGraphics

/**
 * And gate component with fixed size (Maybe dynamic size in the future?)
 */
fun Container.norGate(callback : @ViewDslMarker NOrGate.() -> Unit) = NOrGate().addTo(this, callback)
class NOrGate : FixedSizeContainer(160.0,160.0, true) {
    init {
        //Set graphics
        gateGraphics(GateShape.NOR_GATE ,160.0, 30.0) {

        }
    }
}