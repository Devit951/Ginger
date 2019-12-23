package devit951.github.gingerhttpclient

import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

abstract class AbstractHttpMethod(private val url: String, private val method: String): HttpMethod {

    protected fun makeResponse(request: HttpRequest): HttpResponse {
        val httpURLConnection = httpURLConnection(
            request.pathed(
                url
            ).plus(request.queries())
        )
        return HttpResponse(stringResponse(request, httpURLConnection), httpURLConnection.responseCode)
    }

    private fun stringResponse(request: HttpRequest, connection: HttpURLConnection): String {
        return connection.run {
            requestMethod = method
            request.addHeadersTo(this)
            StringBuilder().let { stringResponse ->
                BufferedReader(InputStreamReader(inputStream)).use { buffer ->
                    while (buffer.readLine()?.also { line ->
                            stringResponse.append(line)
                        } != null)
                        buffer
                }
                stringResponse.toString()
            }
        }
    }

    private fun httpURLConnection(formedUrl: String) = (URL(formedUrl).openConnection() as HttpURLConnection)
}