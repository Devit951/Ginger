package devit951.github.gingerhttpclient

import java.util.concurrent.Future

class Async(private val httpMethod: AbstractHttpMethod) {

    private var futureRequest: Future<*>? = null

    fun request(req: HttpRequest, onResponse: (HttpResponse) -> Unit) {
        request(req, onResponse){
            // ignore...
        }
    }

    fun request(req: HttpRequest, onResponse: (HttpResponse) -> Unit, onError: (Throwable) -> Unit) {
        futureRequest = ThreadPoolConfig.threadPool.submit {
            try {
                Thread.sleep(5_000)
                val response = httpMethod.request(req)
                onResponse(response)
            } catch (t: Throwable) {
                onError(t)
            }
        }
    }

    fun cancel(){
        futureRequest?.cancel(true)
    }
}