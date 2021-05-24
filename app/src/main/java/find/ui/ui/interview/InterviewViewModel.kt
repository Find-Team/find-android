package find.ui.ui.interview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InterviewViewModel : ViewModel() {
    val interviewFirstAnswer = MutableLiveData("")
    val interviewSecondAnswer = MutableLiveData("")
    val interviewThirdAnswer = MutableLiveData("")
    val interviewFourthAnswer = MutableLiveData("")

    private val _interviewLength = MutableLiveData("0/40")
    val interviewLength: LiveData<String> = _interviewLength
}
