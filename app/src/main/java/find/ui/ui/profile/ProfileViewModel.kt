package find.ui.ui.profile

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfileViewModel : ViewModel() {
    private val _introLength = MutableLiveData<String>()
    val introLength: LiveData<String>
        get() = _introLength

    val introContent = ObservableField<String>()

    init {
        _introLength.value = "0/500"
    }
}
