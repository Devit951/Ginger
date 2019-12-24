package devit951.github.ginger

import devit951.github.gingerhttpclient.*
import org.junit.Test

import org.junit.Assert.*

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
        assertNotNull(
            GET("http://api.icndb.com/jokes/random").request(
                HttpRequest()
                    .add(Query("firstName", "John"))
                    .add(Query("lastName", "Doe"))
            ).also { response -> println(response.body) }
        )
    }
}
