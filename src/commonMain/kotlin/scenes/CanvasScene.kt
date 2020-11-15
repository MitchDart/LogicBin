package scenes

import com.soywiz.korge.input.draggable
import com.soywiz.korge.input.mouse
import com.soywiz.korge.scene.Scene
import com.soywiz.korge.view.*
import components.*

class CanvasScene : Scene() {
    override suspend fun Container.sceneInit() {
        container() {
            val halfContainerWidth = views.virtualWidth/2
            val halfContainerHeight = views.virtualHeight/2

            andGate(AndGate(),injector) {
                x = halfContainerWidth - (width /2) - 200
                y = halfContainerHeight - (height/2) - 100
            }
        }
    }
}