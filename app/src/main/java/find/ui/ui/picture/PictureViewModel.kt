package find.ui.ui.picture

import android.net.Uri
import androidx.core.net.toUri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PictureViewModel : ViewModel() {
    val itemPos = MutableLiveData<Int>()
    val itemImage = MutableLiveData<Uri>()

    private val _pictureList = MutableLiveData<List<ProfilePicture>>()
    val pictureList: LiveData<List<ProfilePicture>> = _pictureList

    fun setDefaultPicture() {
        _pictureList.value =
            listOf(
                ProfilePicture(false, DEFAULT_IMAGE),
                ProfilePicture(false, DEFAULT_IMAGE),
                ProfilePicture(false, DEFAULT_IMAGE)
            )
    }

    companion object {
        val DEFAULT_IMAGE =
            "https://user-images.githubusercontent.com/72931738/119366840-55a34800-bcec-11eb-8a86-f5ebbc181cd9.png".toUri()
    }
}