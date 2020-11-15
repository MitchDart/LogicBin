package graphics

import com.soywiz.korge.view.ViewDslMarker
import com.soywiz.korma.geom.vector.VectorBuilder

enum class GateShape {
    AND_GATE,
    OR_GATE,
    NAND_GATE,
    NOR_GATE,
    XOR_GATE,
    XNOR_GATE;

    companion object {
        fun getShapeVector(shape: GateShape, scale: Double) : @ViewDslMarker VectorBuilder.() -> Unit {
            return when (shape) {
                AND_GATE -> andGateShape(scale)
                OR_GATE -> orGateShape(scale)
                NAND_GATE -> nandGateShape(scale)
                NOR_GATE -> norGateShape(scale)
                XOR_GATE -> xorGateShape(scale)
                XNOR_GATE -> xnorGateShape(scale)
            }
        }

        private fun andGateShape(scale: Double) : @ViewDslMarker VectorBuilder.() -> Unit =  {
            //Base shape
            moveTo(0.1*scale, 0.2*scale)
            lineTo(0.4*scale,0.2*scale)
            quadTo(0.8*scale,0.2*scale, 0.8*scale, 0.5*scale)
            quadTo(0.8*scale, 0.8*scale, 0.4*scale, 0.8*scale)
            lineTo(0.1*scale, 0.8*scale)
            lineTo(0.1*scale,0.2*scale)
            close()
        }

        private fun nandGateShape(scale: Double) : @ViewDslMarker VectorBuilder.() -> Unit =  {
            moveTo(0.1*scale, 0.2*scale)
            lineTo(0.4*scale,0.2*scale)
            quadTo(0.8*scale,0.2*scale, 0.8*scale, 0.5*scale)
            quadTo(0.8*scale, 0.8*scale, 0.4*scale, 0.8*scale)
            lineTo(0.1*scale, 0.8*scale)
            lineTo(0.1*scale,0.2*scale)
            close()

            moveTo(0.8*scale, 0.5*scale)
            quadTo(0.8*scale, 0.45*scale, 0.85*scale, 0.45*scale)
            quadTo(0.9*scale, 0.45*scale, 0.9*scale, 0.5*scale)
            quadTo(0.9*scale, 0.55*scale, 0.85*scale, 0.55*scale)
            quadTo(0.8*scale, 0.55*scale, 0.8*scale, 0.5*scale)
            close()
        }

        private fun orGateShape(scale: Double) : @ViewDslMarker VectorBuilder.() -> Unit =  {
            moveTo(0.1*scale, 0.2*scale)
            lineTo(0.2*scale,0.2*scale)
            quadTo(0.6*scale,0.2*scale, 0.8*scale, 0.5*scale)
            quadTo(0.6*scale, 0.8*scale, 0.2*scale, 0.8*scale)
            lineTo(0.1*scale,0.8*scale)
            quadTo(0.25*scale, 0.7*scale, 0.25*scale, 0.5*scale)
            quadTo(0.25*scale, 0.3*scale, 0.1*scale, 0.2*scale)
            close()
        }

        private fun norGateShape(scale: Double) : @ViewDslMarker VectorBuilder.() -> Unit =  {
            moveTo(0.1*scale, 0.2*scale)
            lineTo(0.2*scale,0.2*scale)
            quadTo(0.6*scale,0.2*scale, 0.8*scale, 0.5*scale)
            quadTo(0.6*scale, 0.8*scale, 0.2*scale, 0.8*scale)
            lineTo(0.1*scale,0.8*scale)
            quadTo(0.25*scale, 0.7*scale, 0.25*scale, 0.5*scale)
            quadTo(0.25*scale, 0.3*scale, 0.1*scale, 0.2*scale)
            close()

            moveTo(0.8*scale, 0.5*scale)
            quadTo(0.8*scale, 0.45*scale, 0.85*scale, 0.45*scale)
            quadTo(0.9*scale, 0.45*scale, 0.9*scale, 0.5*scale)
            quadTo(0.9*scale, 0.55*scale, 0.85*scale, 0.55*scale)
            quadTo(0.8*scale, 0.55*scale, 0.8*scale, 0.5*scale)
            close()
        }

        private fun xorGateShape(scale: Double) : @ViewDslMarker VectorBuilder.() -> Unit =  {
            moveTo(0.1*scale, 0.2*scale)
            lineTo(0.2*scale,0.2*scale)
            quadTo(0.6*scale,0.2*scale, 0.8*scale, 0.5*scale)
            quadTo(0.6*scale, 0.8*scale, 0.2*scale, 0.8*scale)
            lineTo(0.1*scale,0.8*scale)
            quadTo(0.25*scale, 0.7*scale, 0.25*scale, 0.5*scale)
            quadTo(0.25*scale, 0.3*scale, 0.1*scale, 0.2*scale)
            close()

            moveTo(0.0*scale, 0.77*scale)
            quadTo(0.17*scale, 0.7*scale, 0.17*scale, 0.5*scale)
            quadTo(0.17*scale, 0.3*scale, 0.0*scale, 0.23*scale)
            quadTo(0.17*scale, 0.3*scale, 0.17*scale, 0.5*scale)
            quadTo(0.17*scale, 0.7*scale, 0.0*scale, 0.77*scale)
            close()
        }

        private fun xnorGateShape(scale: Double) : @ViewDslMarker VectorBuilder.() -> Unit =  {
            moveTo(0.1*scale, 0.2*scale)
            lineTo(0.2*scale,0.2*scale)
            quadTo(0.6*scale,0.2*scale, 0.8*scale, 0.5*scale)
            quadTo(0.6*scale, 0.8*scale, 0.2*scale, 0.8*scale)
            lineTo(0.1*scale,0.8*scale)
            quadTo(0.25*scale, 0.7*scale, 0.25*scale, 0.5*scale)
            quadTo(0.25*scale, 0.3*scale, 0.1*scale, 0.2*scale)
            close()

            moveTo(0.8*scale, 0.5*scale)
            quadTo(0.8*scale, 0.45*scale, 0.85*scale, 0.45*scale)
            quadTo(0.9*scale, 0.45*scale, 0.9*scale, 0.5*scale)
            quadTo(0.9*scale, 0.55*scale, 0.85*scale, 0.55*scale)
            quadTo(0.8*scale, 0.55*scale, 0.8*scale, 0.5*scale)
            close()

            moveTo(0.0*scale, 0.77*scale)
            quadTo(0.17*scale, 0.7*scale, 0.17*scale, 0.5*scale)
            quadTo(0.17*scale, 0.3*scale, 0.0*scale, 0.23*scale)
            quadTo(0.17*scale, 0.3*scale, 0.17*scale, 0.5*scale)
            quadTo(0.17*scale, 0.7*scale, 0.0*scale, 0.77*scale)
            close()
        }
    }
}