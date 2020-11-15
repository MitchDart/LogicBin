package components

import EventBus
import com.soywiz.korge.view.FixedSizeContainer
import com.soywiz.korinject.AsyncInjector
import com.soywiz.korio.async.launchImmediately
import graphics.GateShape
import graphics.gateGraphics

abstract class LogicComponentView(injector: AsyncInjector) : FixedSizeContainer(160.0,160.0, true) {
    protected lateinit var bus: EventBus

    init {
        gateGraphics(GateShape.AND_GATE ,160.0, 30.0)

        LogicBinModule.coroutineScope.launchImmediately {
            bus = injector.get()
            onLogicComponentViewInit()
        }
    }

    abstract suspend fun onLogicComponentViewInit()
}