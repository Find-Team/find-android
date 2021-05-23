package find.ui.ui.profile

import android.widget.TextView
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfileViewModel : ViewModel() {
    private val _introLength = MutableLiveData("0/500")
    val introLength: LiveData<String> = _introLength

    val introContent = ObservableField<String>()
    val infoContent = ObservableField<String>()

    fun setTitle(textView: TextView, content: String) {
        textView.text = content
    }
}
