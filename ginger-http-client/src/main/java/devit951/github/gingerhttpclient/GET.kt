package devit951.github.gingerhttpclient


class GET(url: String): AbstractHttpMethod(url, "GET") {
    override fun request(req: HttpRequest): HttpResponse {
        return makeResponse(req)
    }
}