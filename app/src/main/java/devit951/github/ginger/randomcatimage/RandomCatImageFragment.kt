package devit951.github.ginger.randomcatimage

import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import devit951.github.ginger.R
import devit951.github.ginger_ui.*
import devit951.github.gingerhttpclient.Async
import devit951.github.gingerhttpclient.GET
import devit951.github.gingerhttpclient.HttpRequest
import java.net.URL
import kotlin.concurrent.thread

class RandomCatImageFragment: Fragment() {


    private lateinit var ivCat: ImageView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return frameLayout {
            aVerticalLayout {
                imageView {
                    ivCat = this
                    linearParams(width = dpToPx(500), height = dpToPx(500))
                }
                button {
                    setText(R.string.next_cat)
                    setOnClickListener {
                        nextRandomCatImage(ivCat)
                    }
                }
                frameParams{
                    gravity = Gravity.CENTER
                }
            }

        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        nextRandomCatImage(ivCat)
    }

    private fun nextRandomCatImage(catImageView: ImageView){
        Async(
            GET("https://aws.random.cat/meow")
        ).request(HttpRequest()){ response ->
            catImageView.load(RandomCatResponse().fromJson(response.body).imgUrl.orEmpty())
        }
    }

}

fun ImageView.load(url: String){
    thread {
        val decodedStream = BitmapFactory.decodeStream(URL(url).openStream())
        post {
            setImageBitmap(decodedStream)
        }
    }

}