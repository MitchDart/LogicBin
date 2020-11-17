package scenes

import com.soywiz.korge.input.mouse
import com.soywiz.korge.input.onMouseDrag
import com.soywiz.korge.scene.Scene
import com.soywiz.korge.view.*
import components.*
import graphics.Theme
import graphics.wireGraphics

class CanvasScene : Scene() {
    override suspend fun Container.sceneInit() {
        container() {
            val halfContainerWidth = views.virtualWidth/2
            val halfContainerHeight = views.virtualHeight/2

            val andGate = AndGate()

            val andGateView = andGate.AndGateView(injector)
            andGateView.x = halfContainerWidth - (width /2) - 200
            andGateView.y = halfContainerHeight - (height/2) - 100

            wireGraphics{
                addUpdater {
                    startX = andGateView.x + andGateView.outputAX + Theme.COMPONENT_IO_POINT_SIZE*1.3
                    startY = andGateView.y + andGateView.outputAY + Theme.COMPONENT_IO_POINT_SIZE*1.3
                    finishX = 500.0
                    finishY = 500.0

                    draw()
                }
            }
            addChild(andGateView)


            xNorGate(XNOrGate(), injector)
        }
    }
}