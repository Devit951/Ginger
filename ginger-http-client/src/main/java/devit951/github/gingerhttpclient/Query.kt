package devit951.github.gingerhttpclient

import java.net.URLEncoder


data class Query(val key: String,
                 val value: String)

fun HttpRequest.queries() = buildString {
    if (queries.isNotEmpty()){
        append("?")
        queries.forEachIndexed { index, query ->
            if (index > 0) append("&")
            append("${URLEncoder.encode(query.key, "UTF-8")}=${URLEncoder.encode(query.value, "UTF-8")}")
        }
    }
}