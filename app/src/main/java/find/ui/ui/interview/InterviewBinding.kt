package find.ui.ui.interview

import android.annotation.SuppressLint
import android.widget.TextView
import androidx.databinding.BindingAdapter
import find.ui.R

object InterviewBinding {
    @BindingAdapter("changeInterviewColor")
    @JvmStatic
    fun changeInterviewColor(text: TextView, content: String?) {
        when (content?.length) {
            40 -> text.setTextColor(text.context.getColor(R.color.red_eb57))
            else -> text.setTextColor(text.context.getColor(R.color.gray_bd))
        }
    }

    @SuppressLint("SetTextI18n")
    @BindingAdapter("setLengthText")
    @JvmStatic
    fun setLengthText(textView: TextView, content: String?) {
        textView.text = "${content?.length}/40"
    }

    @BindingAdapter("setQuestion")
    @JvmStatic
    fun setQuestion(textView: TextView, content: String) {
        textView.text = content
    }
}
