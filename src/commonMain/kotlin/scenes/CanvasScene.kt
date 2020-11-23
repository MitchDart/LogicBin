package scenes

import com.soywiz.korge.scene.Scene
import com.soywiz.korge.view.*
import com.soywiz.korio.async.launchImmediately
import components.*
import graphics.Theme
import graphics.wireGraphics

class CanvasScene : Scene() {
    override suspend fun Container.sceneInit() {
        container {
            launchImmediately {
                val halfContainerWidth = views.virtualWidth/2
                val halfContainerHeight = views.virtualHeight/2

                val andGateView = andGate(AndGate()) {
                    x = halfContainerWidth - (width /2) - 200
                    y = halfContainerHeight - (height/2) - 100
                }

                val xnorGateView = xNorGate(XNOrGate()) {
                    x = halfContainerWidth - (width /2) + 200
                    y = halfContainerHeight - (height/2) - 100
                }

                wireGraphics {
                    addUpdater {
                        startX = andGateView.x + andGateView.outputAX + Theme.COMPONENT_IO_POINT_SIZE*1.3
                        startY = andGateView.y + andGateView.outputAY + Theme.COMPONENT_IO_POINT_SIZE*1.3
                        finishX = xnorGateView.x + xnorGateView.inputAX + Theme.COMPONENT_IO_POINT_SIZE*1.3
                        finishY = xnorGateView.y + xnorGateView.inputAY + Theme.COMPONENT_IO_POINT_SIZE*1.3

                        draw()
                    }
                }

                     addChild(andGateView)
                addChild(xnorGateView)

            }
        }
    }
}
