package devit951.github.gingerhttpclient

data class Path(val key: String, val value: String)

fun HttpRequest.pathed(originalUrl: String): String{
    var pathedUrl = originalUrl
    paths.forEach { path ->
        pathedUrl = originalUrl.replace("{${path.key}}", path.value)
    }
    return pathedUrl
}