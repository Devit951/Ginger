package devit951.github.gingerhttpclient

import java.net.HttpURLConnection

data class Header(val key: String,
                  val value: String)

fun HttpRequest.addHeadersTo(connection: HttpURLConnection){
    headers.forEach { header ->
        connection.setRequestProperty(header.key, header.value)
    }
}