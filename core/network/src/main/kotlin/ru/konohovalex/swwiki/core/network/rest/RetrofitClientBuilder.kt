package ru.konohovalex.swwiki.core.network.rest

import kotlinx.serialization.json.Json
import okhttp3.Call
import okhttp3.Dispatcher
import okhttp3.EventListener
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okio.IOException
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import java.util.concurrent.atomic.AtomicInteger
import java.util.logging.Logger

internal class RetrofitClientBuilder(
    private val baseUrl: String,
    private val json: Json,
) {
    fun build(): Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(getOkHttpClient())
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .build()

    private fun getOkHttpClient(): OkHttpClient {
//        val dispatcher = Dispatcher().apply {
//            maxRequestsPerHost = 1
//            maxRequests = 1
//        }
//        val eventListener = object : EventListener() {
//            private val logger = Logger.getLogger("OkHttpQueueMonitor")
//            private var callId: Int = 0
//            private val callCounter = AtomicInteger(0)
//
//            override fun callStart(call: Call) {
//                callId = callCounter.incrementAndGet()
//                val runningCallsCount = dispatcher.runningCallsCount()
//                val queuedCallsCount = dispatcher.queuedCallsCount()
//
//                // Логируем размеры очередей при старте каждого вызова
//                logger.info("[Call #$callId] START | ${call.request().url}")
//                logger.info("[Call #$callId] QUEUE STATE: Running = $runningCallsCount, Queued = $queuedCallsCount")
//            }
//
//            override fun callEnd(call: Call) {
//                logger.info("[Call #$callId] END | ${call.request().url}")
//            }
//
//            override fun callFailed(call: Call, ioe: IOException) {
//                logger.severe("[Call #$callId] FAILED | ${call.request().url} | Error: ${ioe.message}")
//            }
//        }
        // TODO(only for debug)
        return OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    setLevel(HttpLoggingInterceptor.Level.BODY)
                }
            )
//            .dispatcher(dispatcher)
//            .eventListener(eventListener)
            .build()
    }
}
