package graphics

import com.soywiz.korge.view.*
import com.soywiz.korim.vector.Context2d
import com.soywiz.korma.geom.vector.circle

fun Container.ioGraphics(callback : @ViewDslMarker IOGraphics.() -> Unit = {}) = IOGraphics().addTo(this, callback)
class IOGraphics : Graphics(true) {
    init {
        val s = Theme.COMPONENT_IO_POINT_SIZE
        fill(Theme.COMPONENT_BACKGROUND_COLOR) {
            circle(0.0,0.0, s)
        }
        stroke(Theme.COMPONENT_BORDER_COLOR, Context2d.StrokeInfo(thickness = 1.0)) {
            circle(0.0,0.0, s)
        }
    }
}