package devit951.github.gingerhttpclient


class HttpRequest {

    internal val headers: List<Header>
    internal val queries: List<Query>
    internal val paths: List<Path>

    constructor() {
        headers = listOf()
        queries = listOf()
        paths = listOf()
    }

    private constructor(headers: List<Header>, queries: List<Query>, paths: List<Path>) {
        this.headers = headers
        this.queries = queries
        this.paths = paths
    }

    fun add(header: Header): HttpRequest {
        return HttpRequest(
            headers = ArrayList(headers).plus(header),
            queries = queries,
            paths = paths
        )
    }

    fun add(query: Query): HttpRequest {
        return HttpRequest(
            headers = headers,
            queries = ArrayList(queries).plus(query),
            paths = paths
        )
    }

    fun add(path: Path): HttpRequest {
        return HttpRequest(
            headers = headers,
            queries = queries,
            paths = ArrayList(paths).plus(path)
        )
    }
}