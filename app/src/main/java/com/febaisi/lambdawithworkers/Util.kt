package com.febaisi.lambdawithworkers

import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream


fun serializeObject(any: Object): ByteArray {
    //Serialize request
    val bos = ByteArrayOutputStream()
    ObjectOutputStream(bos).apply {
        writeObject(any)
        flush()
    }
    return bos.toByteArray()
}



fun getByteInput(byteArray : ByteArray): Any? {
    val byteArrayInputStream = ByteArrayInputStream(byteArray)
    val objInputStream = ObjectInputStream(byteArrayInputStream)
    return objInputStream.readObject()
}
