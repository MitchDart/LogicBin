package components

import EventBus
import com.soywiz.korge.view.FixedSizeContainer
import com.soywiz.korinject.AsyncInjector
import com.soywiz.korio.async.launchImmediately
import components.subcomponents.gateBody
import components.subcomponents.ioPoint
import graphics.GateShape
import graphics.Theme
import graphics.gateBodyGraphics

abstract class LogicComponentView(injector: AsyncInjector, size: Double = Theme.COMPONENT_DEFAULT_SIZE, gateShape: GateShape) : FixedSizeContainer(size,size, true) {
    protected lateinit var bus: EventBus

    init {
        LogicBinModule.coroutineScope.launchImmediately {
            bus = injector.get()

            //Body
            gateBody(bus, gateShape, size, Theme.COMPONENT_DEFAULT_PADDING)

            //IO
            ioPoint(bus) {
                x = 3.0
                y = size/3 - 5
            }

            ioPoint(bus) {
                x = 3.0
                y = size/3*2 - 25
            }

            ioPoint(bus) {
                x = size - 35
                y = size/2 - 16
            }

            onLogicComponentViewInit()
        }
    }

    protected abstract suspend fun onLogicComponentViewInit()

}