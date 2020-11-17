package components

import EventBus
import com.soywiz.korge.view.FixedSizeContainer
import com.soywiz.korge.view.solidRect
import com.soywiz.korim.color.Colors
import com.soywiz.korinject.AsyncInjector
import com.soywiz.korio.async.launchImmediately
import components.subcomponents.gateBody
import components.subcomponents.ioPoint
import graphics.GateShape
import graphics.Theme
import graphics.gateBodyGraphics
import graphics.wireGraphics

abstract class LogicComponentView(injector: AsyncInjector, size: Double = Theme.COMPONENT_DEFAULT_SIZE, gateShape: GateShape) : FixedSizeContainer(size,size, false) {
    protected lateinit var bus: EventBus

    public val inputAX = 3.0
    public val inputAY = size/3 - 5
    public val inputBX = 3.0
    public val inputBY = size/3*2 - 25
    public val outputAX = size - 35
    public val outputAY = size/2 - 16

    init {
        LogicBinModule.coroutineScope.launchImmediately {
            bus = injector.get()

            //Body
            gateBody(bus, gateShape, size, Theme.COMPONENT_DEFAULT_PADDING)

            //IO
            ioPoint(bus) {
                x = inputAX
                y = inputAY
            }

            ioPoint(bus) {
                x = inputBX
                y = inputBY

            }

            ioPoint(bus) {
                x = outputAX
                y = outputAY
            }

            onLogicComponentViewInit()
        }
    }

    protected abstract suspend fun onLogicComponentViewInit()

}