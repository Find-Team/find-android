package find.ui.ui.profile

import android.text.Editable
import android.text.TextWatcher
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfileViewModel : ViewModel() {
    private val _introLength = MutableLiveData<String>()
    val introLength: LiveData<String>
        get() = _introLength

    init {
        _introLength.value = "0/500"
    }

    val introContent = ObservableField<String>()

    val watcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            _introLength.value = "${introContent.get()?.length}/500"
        }

        override fun afterTextChanged(s: Editable) {}
    }
}
