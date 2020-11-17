package components.subcomponents

import EventBus
import com.soywiz.klock.TimeSpan
import com.soywiz.korge.input.mouse
import com.soywiz.korge.tween.easeOutBack
import com.soywiz.korge.tween.get
import com.soywiz.korge.tween.tween
import com.soywiz.korge.view.*
import com.soywiz.korim.color.Colors
import com.soywiz.korim.color.scale
import com.soywiz.korio.async.launchImmediately
import components.LogicComponentView
import graphics.GateShape
import graphics.Theme
import graphics.ioGraphics
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

fun LogicComponentView.ioPoint(bus: EventBus, callback : @ViewDslMarker IOPoint.() -> Unit = {}) = IOPoint(bus).addTo(this, callback)
class IOPoint(bus: EventBus): FixedSizeContainer(Theme.COMPONENT_IO_POINT_SIZE*2*1.3,Theme.COMPONENT_IO_POINT_SIZE*2*1.3) {
    var isHover = false
    private val animationContext = CoroutineScope(Dispatchers.Default)

    init {
        val gfxContainer = container {
            ioGraphics()
            x = Theme.COMPONENT_IO_POINT_SIZE*1.3
            y = Theme.COMPONENT_IO_POINT_SIZE*1.3
            mouse {
                over {
                    //check if already hovering
                    if(isHover) return@over
                    animationContext.launchImmediately {
                        tween(view::scale[1.0,1.2], time = TimeSpan(200.0))
                    }
                    isHover = true
                }
            }
        }

        mouse {
            click {

            }
            out {
                //Check if already not hovering
                if(!isHover) return@out
                animationContext.launchImmediately {
                    tween(gfxContainer::scale[1.2,1.0], time = TimeSpan(200.0))
                }
                isHover = false
            }
        }

    }
}