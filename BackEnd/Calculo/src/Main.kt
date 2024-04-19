import kotlin.math.*

fun main() {
    val epsilon = 1e-4
    val initialGuess = doubleArrayOf(1.5, 2.0)

    val solution = newtonMethodSystem(initialGuess, epsilon)
    println("A solução encontrada é: (${solution[0]}, ${solution[1]})")
}

fun newtonMethodSystem(initialGuess: DoubleArray, epsilon: Double): DoubleArray {
    var x = initialGuess.copyOf()
    var deltaX: DoubleArray

    do {
        val f = evaluateSystem(x)
        val jacobian = computeJacobian(x)
        val jacobianInverse = invertMatrix2x2(jacobian)

        deltaX = matrixVectorMultiply(jacobianInverse, f)

        // Atualiza os valores de x usando deltaX
        for (i in x.indices) {
            x[i] -= deltaX[i]
        }
    } while (norm(deltaX) > epsilon)

    return x
}


fun evaluateSystem(x: DoubleArray): DoubleArray {
    val fx = DoubleArray(2)
    fx[0] = x[0]*x[0] + x[1]*x[1] - 2.0
    fx[1] = exp(x[0] - 1) + x[1]*x[1]*x[1] - 2.0
    return fx
}

fun computeJacobian(x: DoubleArray): Array<DoubleArray> {
    val jacobian = Array(2) { DoubleArray(2) }
    jacobian[0][0] = 2.0 * x[0]
    jacobian[0][1] = 2.0 * x[1]
    jacobian[1][0] = exp(x[0] - 1)
    jacobian[1][1] = 3.0 * x[1] * x[1]
    return jacobian
}

fun invertMatrix2x2(matrix: Array<DoubleArray>): Array<DoubleArray> {
    val determinant = matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0]
    val inverse = Array(2) { DoubleArray(2) }
    inverse[0][0] = matrix[1][1] / determinant
    inverse[0][1] = -matrix[0][1] / determinant
    inverse[1][0] = -matrix[1][0] / determinant
    inverse[1][1] = matrix[0][0] / determinant
    return inverse
}

fun matrixVectorMultiply(matrix: Array<DoubleArray>, vector: DoubleArray): DoubleArray {
    val result = DoubleArray(2)
    result[0] = matrix[0][0] * vector[0] + matrix[0][1] * vector[1]
    result[1] = matrix[1][0] * vector[0] + matrix[1][1] * vector[1]
    return result
}

fun norm(vector: DoubleArray): Double {
    return sqrt(vector[0] * vector[0] + vector[1] * vector[1])
}
