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

    private val _tempList = MutableLiveData<List<String>>()
    val tempList: LiveData<List<String>> = _tempList

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
                "연인관계를 주변에 알리고 공개하는 것",
                "연인과의 사생활 공유",
                "이상적인 연애비용분담",
                "주말에 필요한 개인적인 시간",
                "애인이 다른 이성친구와 단둘이 만난다면?"
            )
    }

    private fun isPossibleCheck() {
        _isFindButtonActive.value =
            (requireNotNull(_isSimilarity.value) || requireNotNull(_isComplementary.value)) && !tempList.value.isNullOrEmpty()
    }
}
