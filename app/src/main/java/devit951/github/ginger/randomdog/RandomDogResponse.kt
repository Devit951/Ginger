package devit951.github.ginger.randomdog

import devit951.github.ginger_json_parser.ParserableJson
import org.json.JSONObject

class RandomDogResponse: ParserableJson<RandomDogResponse.RandomDogJson> {
    override fun fromJson(json: String): RandomDogJson {
        return JSONObject(json).run {
            RandomDogJson(dogImgUrl = getString("message"))
        }
    }

    data class RandomDogJson(var dogImgUrl: String?)
}