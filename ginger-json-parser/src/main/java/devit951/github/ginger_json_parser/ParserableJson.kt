package devit951.github.ginger_json_parser


interface ParserableJson<T> {
    fun fromJson(json: String): T
}