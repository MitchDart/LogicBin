import com.soywiz.korge.scene.Module
import com.soywiz.korgw.GameWindow
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
    override val targetFps: Double
        get() = 144.0
    override val quality: GameWindow.Quality
        get() = GameWindow.Quality.AUTOMATIC

    override suspend fun AsyncInjector.configure() {
        mapInstance(EventBus(coroutineScope))
        mapPrototype { CanvasScene() }

        //Components
    }

    override val title: String
        get() = "Logic Bin"
}