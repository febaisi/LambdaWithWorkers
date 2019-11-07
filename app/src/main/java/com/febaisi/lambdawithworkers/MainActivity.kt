package com.febaisi.lambdawithworkers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.work.Data
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener {
            val sdf = SimpleDateFormat("yyyyMMdd__HH:mm:ss", Locale.getDefault())
            val requestTime = sdf.format(Date())

            val lambdaObject = LambdaSerializable { // LAMBDA FUNCTION
                Log.e("Lambda", "Request time was -> $requestTime")
            }
            val input = Data.Builder()
                .putByteArray(SimpleWorker.LAMBDA_OBJECT, serializeObject((lambdaObject as Object)))
                .build()

            val simpleWorker = OneTimeWorkRequest.Builder(SimpleWorker::class.java)
                .setInputData(input)
                .build()

            WorkManager.getInstance(applicationContext).enqueueUniqueWork("lambda_worker", ExistingWorkPolicy.KEEP, simpleWorker)
        }
    }
}
