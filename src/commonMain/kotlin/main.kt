import com.soywiz.klock.TimeSpan
import com.soywiz.korge.*
import com.soywiz.korge.view.addFixedUpdater
import com.soywiz.korim.color.*
import components.*

suspend fun main() = Korge(width = 1024, height = 1024, bgcolor = Colors["#AAAAAAAA"]) {
	andGate() {
		x = (1024/2) - (width /2) - 200
		y = (1024/2) - (height/2) - 100
	}

	orGate() {
		x = (1024/2) - (width /2)
		y = (1024/2) - (height/2) - 100
	}

	nandGate {
		x = (1024/2) - (width /2) + 200
		y = (1024/2) - (height/2) - 100
	}

	norGate {
		x = (1024/2) - (width /2) - 200
		y = (1024/2) - (height/2) + 100
	}

	xorGate {
		x = (1024/2) - (width /2)
		y = (1024/2) - (height/2) + 100
	}

	xnorGate {
		x = (1024/2) - (width /2) + 200
		y = (1024/2) - (height/2) + 100
	}
}