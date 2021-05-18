package find.ui.ui.profile

import android.graphics.Color
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.BindingAdapter

object ProfileBinding {
    @BindingAdapter("changeColor")
    @JvmStatic
    fun changeColor(text: TextView, content: String?) {
        when (content?.length) {
            in 11..499 -> text.setTextColor(Color.BLUE)
            500 -> text.setTextColor(Color.RED)
            else -> text.setTextColor(Color.parseColor("#bdbdbd"))
        }
    }

    @BindingAdapter("textChangedListener")
    @JvmStatic
    fun textChangedListener(editText: EditText, textWatcher: TextWatcher?) {
        editText.addTextChangedListener(textWatcher)
    }
}
