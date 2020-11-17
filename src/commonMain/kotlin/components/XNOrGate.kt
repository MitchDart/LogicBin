package components

import com.soywiz.korge.input.draggable
import com.soywiz.korge.input.mouse
import com.soywiz.korge.view.Container
import com.soywiz.korge.view.ViewDslMarker
import com.soywiz.korge.view.addTo
import com.soywiz.korinject.AsyncInjector
import graphics.GateShape

fun Container.xNorGate(gate: XNOrGate, injector: AsyncInjector, callback: @ViewDslMarker XNOrGate.XNorGateView.() -> Unit = {}) = gate.XNorGateView(injector).addTo(this, callback)

class XNOrGate : LogicComponent() {

    inner class XNorGateView(injector: AsyncInjector) : LogicComponentView(injector, gateShape = GateShape.XNOR_GATE) {
        override suspend fun onLogicComponentViewInit() {
            mouse {
                draggable()
            }
        }
    }
}