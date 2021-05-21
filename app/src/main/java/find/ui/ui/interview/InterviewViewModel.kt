package find.ui.ui.interview

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InterviewViewModel : ViewModel() {
    val interviewContent = ObservableField<String>()

    private val _interviewLength = MutableLiveData("0/40")
    val interviewLength: LiveData<String> = _interviewLength
}