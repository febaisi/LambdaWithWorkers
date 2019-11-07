package com.febaisi.lambdawithworkers
import java.io.Serializable

class LambdaSerializable(val logRequestTime: () -> (Unit)): Serializable {
}