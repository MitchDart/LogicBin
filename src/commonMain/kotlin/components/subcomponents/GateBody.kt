package components.subcomponents

import EventBus
import com.soywiz.korge.input.mouse
import com.soywiz.korge.view.Container
import com.soywiz.korge.view.ViewDslMarker
import com.soywiz.korge.view.addTo
import components.LogicComponentView
import graphics.GateShape
import graphics.gateBodyGraphics

fun LogicComponentView.gateBody(shape: GateShape, size: Double, padding: Double, callback : @ViewDslMarker GateBody.() -> Unit = {}) = GateBody(shape, size, padding).addTo(this, callback)
class GateBody(shape: GateShape, size: Double, padding: Double) : Container() {
    init {
        gateBodyGraphics(shape ,size, padding)

        mouse {
            click {

            }
            move {

            }
        }
    }
}