package find.ui.ui.picture

import android.net.Uri
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object BindingAdapter {
    @BindingAdapter("image")
    @JvmStatic
    fun imageBinding(view: ImageView, uri: Uri) {
        Glide.with(view.context)
            .load(uri)
            .into(view)
    }
}
