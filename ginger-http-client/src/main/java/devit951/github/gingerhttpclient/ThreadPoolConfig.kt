package devit951.github.gingerhttpclient

import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

object ThreadPoolConfig {
    val threadPool: ExecutorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2 + 1)
}