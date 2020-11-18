package components

import com.soywiz.korge.input.draggable
import com.soywiz.korge.input.mouse
import com.soywiz.korge.view.*
import com.soywiz.korim.color.Colors
import com.soywiz.korinject.AsyncInjector
import com.soywiz.korinject.injector
import com.soywiz.korinject.withInjector
import graphics.GateShape

/**
 * And gate component with fixed size (Maybe dynamic size in the future?)
 */
suspend fun Container.andGate(andGate: AndGate,callback : @ViewDslMarker AndGate.AndGateView.() -> Unit) = andGate.AndGateView(injector()).addTo(this,callback)

class AndGate() : LogicComponent() {
    val color = Colors.RED

    inner class AndGateView(injector: AsyncInjector) : LogicComponentView(injector, gateShape = GateShape.AND_GATE) {
        override suspend fun onLogicComponentViewInit() {
            mouse {
                draggable()
            }
        }
    }
}