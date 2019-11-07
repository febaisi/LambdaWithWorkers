package com.febaisi.lambdawithworkers

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.text.SimpleDateFormat
import java.util.*

class SimpleWorker(context: Context, workerParams: WorkerParameters) :
    Worker(context, workerParams) {

    companion object {
       val LAMBDA_OBJECT = "LAMBDA_OBJECT"
    }

    override fun doWork(): Result {
        Log.e("Lambda", "Executing worker - Sleeping for 5 seconds - Compare request vs current time")
        val lambdaSerializable = inputData.getByteArray(LAMBDA_OBJECT)?.let{ getByteInput(it) }

        runBlocking {
            delay(5000)
            val sdf = SimpleDateFormat("yyyyMMdd__HH:mm:ss", Locale.getDefault())
            Log.e("Lambda", "Current time is -> ${sdf.format(Date())}")
            (lambdaSerializable as LambdaSerializable).logRequestTime() // High level - Calling Lambda
        }

        return Result.success()
    }
}