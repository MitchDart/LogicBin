package components

import EventBus
import EventIOHover
import com.soywiz.korge.input.mouse
import com.soywiz.korge.input.onClick
import com.soywiz.korge.view.*
import com.soywiz.korim.color.Colors
import com.soywiz.korinject.AsyncInjector
import com.soywiz.korinject.injector
import com.soywiz.korinject.withInjector
import com.soywiz.korio.async.launchImmediately
import graphics.GateShape
import graphics.gateGraphics
import kotlinx.coroutines.Dispatchers

/**
 * And gate component with fixed size (Maybe dynamic size in the future?)
 */
fun Container.andGate(andGate: AndGate,injector: AsyncInjector,callback : @ViewDslMarker AndGate.AndGateView.() -> Unit) = andGate.AndGateView(injector).addTo(this,callback)

class AndGate() : LogicComponent() {
    val color = Colors.RED

    inner class AndGateView(injector: AsyncInjector) : FixedSizeContainer(160.0,160.0, true) {
        init {
            gateGraphics(GateShape.AND_GATE ,160.0, 30.0) {}
            LogicBinModule.coroutineScope.launchImmediately {
                val bus = injector.get<EventBus>()
                mouse {
                    over {
                        bus.send(EventIOHover())
                    }
                }

                bus.register(EventIOHover::class) {
                    solidRect(width,height,color)
                }
            }
        }
    }
}