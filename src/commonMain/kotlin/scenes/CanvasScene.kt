package scenes

import ChristiaanEvent
import EventBus
import com.soywiz.korge.input.onClick
import com.soywiz.korge.scene.Scene
import com.soywiz.korge.view.*
import com.soywiz.korim.color.Colors
import components.*

class CanvasScene(val bus: EventBus) : Scene() {
    override suspend fun Container.sceneInit() {
        container() {
            val halfContainerWidth = views.virtualWidth/2
            val halfContainerHeight = views.virtualHeight/2

            andGate(AndGate(),injector) {
                x = halfContainerWidth - (width /2) - 200
                y = halfContainerHeight - (height/2) - 100
                onClick {
                    bus.send(ChristiaanEvent())
                }
            }

            orGate() {
                x = halfContainerWidth - (width /2)
                y = halfContainerHeight - (height/2) - 100
                bus.register(ChristiaanEvent::class) {
                    scale+=2.0
                }
            }

            nandGate {
                x = halfContainerWidth - (width /2) + 200
                y = halfContainerHeight - (height/2) - 100
            }

            norGate {
                x = halfContainerWidth - (width /2) - 200
                y = halfContainerHeight - (height/2) + 100
            }

            xorGate {
                x = halfContainerWidth - (width /2)
                y = halfContainerHeight - (height/2) + 100
            }

            xnorGate {
                x = halfContainerWidth - (width /2) + 200
                y = halfContainerHeight - (height/2) + 100
            }
        }
    }
}