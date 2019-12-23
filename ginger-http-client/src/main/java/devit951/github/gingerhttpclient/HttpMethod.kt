package devit951.github.gingerhttpclient

interface HttpMethod {
    fun request(req: HttpRequest): HttpResponse
}