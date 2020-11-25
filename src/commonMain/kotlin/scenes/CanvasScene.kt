package scenes

import com.soywiz.korge.input.draggable
import com.soywiz.korge.input.mouse
import com.soywiz.korge.scene.Scene
import com.soywiz.korge.view.*
import com.soywiz.korge.view.camera.cameraContainer
import com.soywiz.korio.async.launchImmediately
import com.soywiz.korui.layout.MathEx
import components.*
import graphics.Theme
import graphics.wireGraphics
import kotlin.math.max
import kotlin.math.min

class CanvasScene : Scene() {

    private var movingComponent = false

    override suspend fun Container.sceneInit() {
        val text = text("")

        val camera = cameraContainer(1280.0,720.0) {
            mouse {
                moveAnywhere {
                    text.text = "${it.currentPosStage.x} ${it.currentPosStage.y}"
                }
            }
            launchImmediately {
                val halfContainerWidth = views.virtualWidth/2
                val halfContainerHeight = views.virtualHeight/2

                val andGateView = andGate(AndGate()) {
                    x = halfContainerWidth - (width /2) - 200
                    y = halfContainerHeight - (height/2) - 100
                    onDragStart {
                        movingComponent = true
                    }
                    onDragStop {
                        movingComponent = false
                    }
                }

                val xnorGateView = xNorGate(XNOrGate()) {
                    x = halfContainerWidth - (width /2) + 200
                    y = halfContainerHeight - (height/2) - 100
                    onDragStart {
                        movingComponent = true
                    }
                    onDragStop {
                        movingComponent = false
                    }

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

        var posX = 0.0
        var posY = 0.0
        var camX = camera.cameraX
        var camY = camera.cameraY
        var isDragging = false
        mouse {
            down {
                if(!movingComponent) {
                    posX = it.currentPosStage.x
                    posY = it.currentPosStage.y
                    camX = camera.cameraX
                    camY = camera.cameraY

                    isDragging = true
                }
            }

            upAnywhere {
                posX = 0.0
                posY = 0.0
                isDragging = false
            }

            scroll {
                text.text = "${camera.cameraZoom}"
                camera.cameraZoom = min(max(camera.cameraZoom - ((it.scrollDeltaY/60.0)*camera.cameraZoom), 0.2), 2.0)
            }

            move {
                if(isDragging && !movingComponent) {
                    val deltaX = (posX - it.currentPosStage.x) * 1/camera.cameraZoom
                    val deltaY = (posY - it.currentPosStage.y) * 1/camera.cameraZoom

                    camera.cameraX = camX + deltaX
                    camera.cameraY = camY + deltaY
                }
            }
        }
    }
}
