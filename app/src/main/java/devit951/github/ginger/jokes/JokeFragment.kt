package devit951.github.ginger.jokes

import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.setPadding
import androidx.fragment.app.Fragment
import devit951.github.ginger.JokeResponse
import devit951.github.ginger.R
import devit951.github.ginger_ui.*
import devit951.github.gingerhttpclient.Async
import devit951.github.gingerhttpclient.GET
import devit951.github.gingerhttpclient.HttpRequest

class JokeFragment: Fragment() {

    private lateinit var tvJoke: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return frameLayout {
            setPadding(
                dpToPx(16)
            )
            aVerticalLayout {
                tvJoke = textView {
                    textSize = 20f

                }
                button {
                    setText(R.string.next_joke)
                    setOnClickListener {
                        nextJoke()
                    }
                    frameParams(width = matchParent)
                }
                frameParams(width = matchParent){
                    gravity = Gravity.CENTER
                }
            }
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        nextJoke()
    }

    private fun nextJoke() {
        Async(
            GET("https://official-joke-api.appspot.com/random_joke")
        ).request(HttpRequest()) { response ->
            activity?.runOnUiThread {
                tvJoke.text = JokeResponse().fromJson(response.body).run {
                    joke.plus("\n").plus(explanation)
                }
            }
        }
    }
}