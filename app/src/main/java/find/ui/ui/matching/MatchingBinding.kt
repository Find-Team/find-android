package find.ui.ui.matching

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import find.ui.R

object MatchingBinding {
    @BindingAdapter("setProfileImage")
    @JvmStatic
    fun setProfileImage(imageView: ImageView, url: String) {
        Glide.with(imageView.context)
            .load(url)
            .into(imageView)
    }

    @BindingAdapter("setIntroduceText", "setJobText", "setLocationText")
    @JvmStatic
    fun setIntroduceText(textView: TextView, age: Int, job: String, location: String) {
        textView.text = String.format(
            textView.context.getString(R.string.feeling_connected_introduce),
            age,
            job,
            location
        )
    }
}
