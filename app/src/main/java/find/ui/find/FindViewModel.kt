package find.ui.find

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FindViewModel : ViewModel() {
    private val _isSimilarity = MutableLiveData(false)
    val isSimilarity: LiveData<Boolean> = _isSimilarity

    private val _isComplementary = MutableLiveData(false)
    val isComplementary: LiveData<Boolean> = _isComplementary

    fun selectSimilarity() {
        _isSimilarity.value = !_isSimilarity.value!!
        _isComplementary.value = false
    }

    fun selectComplementary() {
        _isComplementary.value = !_isComplementary.value!!
        _isSimilarity.value = false
    }
}
