package devit951.github.ginger.randomcatimage

import devit951.github.ginger_json_parser.ParserableJson
import org.json.JSONObject

class RandomCatResponse: ParserableJson<RandomCatResponse.RandomCatJson> {
    override fun fromJson(json: String): RandomCatJson {
        return JSONObject(json).run {
            RandomCatJson(imgUrl = getString("file"))
        }
    }

    class RandomCatJson(val imgUrl: String?)
}