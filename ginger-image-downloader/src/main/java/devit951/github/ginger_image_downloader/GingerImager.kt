package devit951.github.ginger_image_downloader

import android.graphics.BitmapFactory
import android.widget.ImageView
import java.net.URL
import java.util.concurrent.Executors

internal val threadPool = Executors.newFixedThreadPool(4)


fun ImageView.load(url: String){
    threadPool.submit {
        val decodedStream = BitmapFactory.decodeStream(URL(url).openStream())
        post {
            setImageBitmap(decodedStream)
        }
    }
}