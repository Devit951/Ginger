package devit951.github.ginger.randomdog

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import devit951.github.ginger.R
import devit951.github.ginger_image_downloader.load
import devit951.github.ginger_ui.*
import devit951.github.gingerhttpclient.Async
import devit951.github.gingerhttpclient.GET
import devit951.github.gingerhttpclient.HttpRequest

class RandomDogFragment : Fragment() {

    private lateinit var ivDog: ImageView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return frameLayout {
            aVerticalLayout {
                imageView {
                    ivDog = this
                    linearParams(width = dpToPx(500), height = dpToPx(500))
                }
                button {
                    setText(R.string.next_dog)
                    setOnClickListener {
                        nextRandomCatImage(ivDog)
                    }
                }
                frameParams {
                    gravity = Gravity.CENTER
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (savedInstanceState == null) {
            nextRandomCatImage(ivDog)
        }
    }

    private fun nextRandomCatImage(dog: ImageView) {
        Async(GET("https://dog.ceo/api/breeds/image/random")).request(HttpRequest()) {
            dog.load(RandomDogResponse().fromJson(it.body).dogImgUrl.orEmpty())
        }
    }
}