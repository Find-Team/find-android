package find.ui.ui.find

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FindViewModel : ViewModel() {
    private val _isSimilarity = MutableLiveData(false)
    val isSimilarity: LiveData<Boolean> = _isSimilarity

    private val _isComplementary = MutableLiveData(false)
    val isComplementary: LiveData<Boolean> = _isComplementary

    private val _isFindButtonActive = MutableLiveData(false)
    val isFindButtonActive: LiveData<Boolean> = _isFindButtonActive

    private val _tempList = MutableLiveData<List<ResponsePickedValues>>()
    val tempList: LiveData<List<ResponsePickedValues>> = _tempList

    fun selectSimilarity() {
        _isSimilarity.value = !requireNotNull(_isSimilarity.value)
        _isComplementary.value = false
        isPossibleCheck()
    }

    fun selectComplementary() {
        _isComplementary.value = !requireNotNull(_isComplementary.value)
        _isSimilarity.value = false
        isPossibleCheck()
    }

    fun setTempList() {
        _tempList.value =
            listOf(
                ResponsePickedValues(1, "연인관계를 주변에 알리고 공개하는 것"),
                ResponsePickedValues(2, "연인관계를 주변에 알리고 공개하는 것"),
                ResponsePickedValues(3, "연인관계를 주변에 알리고 공개하는 것"),
                ResponsePickedValues(4, "연인관계를 주변에 알리고 공개하는 것"),
                ResponsePickedValues(5, "연인관계를 주변에 알리고 공개하는 것")
            )
    }

    private fun isPossibleCheck() {
        _isFindButtonActive.value =
            (requireNotNull(_isSimilarity.value) || requireNotNull(_isComplementary.value)) && !tempList.value.isNullOrEmpty()
    }
}
