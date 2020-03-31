package devit951.github.ginger

import devit951.github.gingerhttpclient.*
import org.junit.Test

import org.junit.Assert.*
import java.util.*
import kotlin.collections.HashMap

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun path_is_correct() {
        assertNotNull(
            GET("http://api.icndb.com/jokes/{jokeId}").request(
                HttpRequest()
                    .add(Path("jokeId", "15"))
            ).also { response -> println(response.body) }
        )
    }

    @Test
    fun query_is_correct() {
        reverseString(charArrayOf('h', 'e', 'l', 'l', 'o'))
    }

    fun reverseString(s: CharArray) {
        var i = (s.size - 1) / 2
        while (i >= 0) {
            val temp = s[i]
            s[i] = (s[s.size - i - 1])
            s[s.size - i - 1] = temp
            i--
        }
        println(Arrays.toString(s))
    }

    fun uniqueOccurrences(arr: IntArray): Boolean {
        val uniqueMapInts = HashMap<Int, Int>()
        for (i in arr.indices) {
            val value = uniqueMapInts.get(arr[i])
            if (value == null) {
                uniqueMapInts.put(arr[i], 1)
            } else {
                uniqueMapInts.put(arr[i], value + 1)
            }
        }
        println(uniqueMapInts)
        val uniqueValues = HashMap<Int, Int>()
        for (current in uniqueMapInts.values) {
            println("Cu $current ")
            if (uniqueValues.get(current) == null){
                uniqueValues.put(current, 0)
            } else {
                return false
            }
        }
        return true
    }

    fun humanReadable(words: Array<String>): String {
        val humanReadAbleString = StringBuilder("")
        val filteredWords = words.filter{ item ->  item.isNotEmpty() }
        filteredWords.forEachIndexed { i, item ->
            if (i != filteredWords.size - 1){
                humanReadAbleString.append(item).append(", ")
            } else {
                humanReadAbleString.append(item)
            }
        }
        val lastComaIndex = humanReadAbleString.lastIndexOf(",")
        if (lastComaIndex != -1){
            return humanReadAbleString.replace(lastComaIndex, lastComaIndex + 1, " и").toString()
        } else {
            return humanReadAbleString.toString()
        }
    }
}
