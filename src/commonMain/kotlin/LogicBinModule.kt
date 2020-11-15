import com.soywiz.korge.scene.Module
import com.soywiz.korim.color.Colors
import com.soywiz.korim.color.RGBA
import com.soywiz.korinject.AsyncInjector
import com.soywiz.korma.geom.SizeInt
import components.AndGate
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.coroutineScope
import scenes.CanvasScene
import kotlin.coroutines.coroutineContext

object LogicBinModule : Module() {
    val coroutineScope = MainScope()

    override val bgcolor: RGBA
        get() = Colors.LIGHTGREY
    override val mainScene = CanvasScene::class
    override val size = SizeInt(1280, 720) // Virtual Size
    override val windowSize = SizeInt(1280, 720) // Window Size

    override suspend fun AsyncInjector.configure() {
        mapInstance(EventBus(coroutineScope))
        mapPrototype { CanvasScene(get()) }

        //Components
    }

    override val title: String
        get() = "Logic Bin"
}