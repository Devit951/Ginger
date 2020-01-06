package devit951.github.ginger.jokes

import devit951.github.ginger_json_parser.ParserableJson
import org.json.JSONObject

class JokeResponse: ParserableJson<JokeResponse.JokeJson> {

    data class JokeJson(val joke: String?,
                        val explanation: String?)

    override fun fromJson(json: String): JokeJson {
        return JSONObject(json).run {
            JokeJson(
                joke = optString("setup"),
                explanation = optString("punchline")
            )
        }
    }
}