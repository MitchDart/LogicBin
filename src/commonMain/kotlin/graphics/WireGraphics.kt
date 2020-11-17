package graphics

import com.soywiz.korge.view.*
import com.soywiz.korim.color.Colors
import com.soywiz.korim.vector.Context2d
import com.soywiz.korma.geom.vector.circle
import com.soywiz.korma.geom.vector.cubic

fun Container.wireGraphics(callback: @ViewDslMarker WireGraphics.() -> Unit = {}) = WireGraphics().addTo(this, callback)
class WireGraphics() : Graphics() {
    val tension = 70.0
    var startX = 0.0
    var startY = 0.0
    var finishX = 0.0
    var finishY = 0.0

    fun draw() {
        clear()
        stroke(Colors.BLACK, Context2d.StrokeInfo(thickness = 10.0)) {
            cubic(this@WireGraphics.startX, this@WireGraphics.startY, this@WireGraphics.startX + this@WireGraphics.tension, this@WireGraphics.startY, this@WireGraphics.finishX - this@WireGraphics.tension, this@WireGraphics.finishY, this@WireGraphics.finishX, this@WireGraphics.finishY)
        }

        stroke(Colors.WHITE, Context2d.StrokeInfo(thickness = 5.0)) {
            cubic(this@WireGraphics.startX, this@WireGraphics.startY, this@WireGraphics.startX + this@WireGraphics.tension, this@WireGraphics.startY, this@WireGraphics.finishX - this@WireGraphics.tension, this@WireGraphics.finishY, this@WireGraphics.finishX, this@WireGraphics.finishY)
        }
    }
}