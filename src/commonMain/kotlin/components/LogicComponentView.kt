package components

import EventBus
import com.soywiz.korge.input.mouse
import com.soywiz.korge.view.FixedSizeContainer
import com.soywiz.korinject.AsyncInjector
import com.soywiz.korio.async.launchImmediately
import com.soywiz.korma.geom.Point
import components.subcomponents.gateBody
import components.subcomponents.ioPoint
import graphics.GateShape
import graphics.Theme

abstract class LogicComponentView(injector: AsyncInjector, size: Double = Theme.COMPONENT_DEFAULT_SIZE, gateShape: GateShape) : FixedSizeContainer(size,size, false) {
    protected lateinit var bus: EventBus

    val inputAX = 3.0
    val inputAY = size/3 - 5
    val inputBX = 3.0
    val inputBY = size/3*2 - 25
    val outputAX = size - 35
    val outputAY = size/2 - 16

    private var isDragging = false
    private var posX = 0.0
    private var posY = 0.0
    private var startDragHandler : () -> Unit = { }
    private var stopDragHandler : () -> Unit = { }

    init {
        LogicBinModule.coroutineScope.launchImmediately {
            bus = injector.get()

            //Body
            gateBody(gateShape, size, Theme.COMPONENT_DEFAULT_PADDING) {
                mouse {
                    down {
                        isDragging = true
                        posX = this@LogicComponentView.mouse.currentPosLocal.x
                        posY = this@LogicComponentView.mouse.currentPosLocal.y

                        startDragHandler()
                    }

                    upAnywhere {
                        isDragging = false

                        stopDragHandler()
                    }

                    moveAnywhere {
                        if(isDragging) {
                            this@LogicComponentView.x = this@LogicComponentView.parent!!.mouse.currentPosLocal.x - posX
                            this@LogicComponentView.y = this@LogicComponentView.parent!!.mouse.currentPosLocal.y - posY
                        }
                    }
                }
            }

            mouse {
                move {
                    if(isDragging) {

                    }
                }
            }

            //IO
            ioPoint() {
                x = inputAX
                y = inputAY
            }

            ioPoint() {
                x = inputBX
                y = inputBY

            }

            ioPoint() {
                x = outputAX
                y = outputAY
            }


            onLogicComponentViewInit()
        }
    }

    fun onDragStart(handler : () -> Unit) {
        startDragHandler = handler
    }

    fun onDragStop(handler : () -> Unit) {
        stopDragHandler = handler
    }

    protected abstract suspend fun onLogicComponentViewInit()
}