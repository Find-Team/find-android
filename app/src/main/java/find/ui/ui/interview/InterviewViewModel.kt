package find.ui.ui.interview

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import find.ui.R
import find.ui.ui.picture.ProfilePicture

class InterviewViewModel : ViewModel() {
    val interviewFirstAnswer = MutableLiveData("")
    val interviewSecondAnswer = MutableLiveData("")
    val interviewThirdAnswer = MutableLiveData("")
    val interviewFourthAnswer = MutableLiveData("")
    val itemPos = MutableLiveData<Int>()
    val itemPicture = MutableLiveData<ProfilePicture>()
    var list = mutableListOf<ProfilePicture>()

    private val _interviewLength = MutableLiveData("0/40")
    val interviewLength: LiveData<String> = _interviewLength

    private val _pictureList = MutableLiveData<List<ProfilePicture>>()
    val pictureList: LiveData<List<ProfilePicture>> = _pictureList

    fun setDefaultPicture() {
        list = arrayListOf(
            ProfilePicture(false, getUriResource(R.drawable.btn_add_image)),
            ProfilePicture(false, getUriResource(R.drawable.btn_add_image)),
            ProfilePicture(false, getUriResource(R.drawable.btn_add_image))
        )
        _pictureList.value = list
    }

    private fun getUriResource(resId: Int): Uri =
        Uri.parse("android.resource://find.ui/$resId")
}
