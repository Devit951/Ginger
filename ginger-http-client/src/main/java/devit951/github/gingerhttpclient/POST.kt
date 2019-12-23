package devit951.github.gingerhttpclient

class POST(url: String): AbstractHttpMethod(url, "POST") {
    override fun request(req: HttpRequest): HttpResponse {
        return makeResponse(req)
    }
}