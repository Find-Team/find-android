package find.ui.ui.picture

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import find.ui.R

class PictureViewModel : ViewModel() {
    val itemPos = MutableLiveData<Int>()
    val itemPicture = MutableLiveData<ProfilePicture>()
    var list = mutableListOf<ProfilePicture>()

    private val _pictureList = MutableLiveData<List<ProfilePicture>>()
    val pictureList: LiveData<List<ProfilePicture>> = _pictureList

    fun setDefaultPicture() {
        list = arrayListOf(
            ProfilePicture(true, getUriResource(R.drawable.btn_add_image)),
            ProfilePicture(false, getUriResource(R.drawable.btn_add_image)),
            ProfilePicture(false, getUriResource(R.drawable.btn_add_image))
        )
        _pictureList.value = list
    }

    fun add(position: Int, image: Uri) {
        if (checkMain(itemPicture.value!!)) {
            list.add(position, ProfilePicture(true, image))
        } else {
            list.add(position, ProfilePicture(false, image))
        }
        _pictureList.value = list
    }

    fun remove(position: Int) {
        list.removeAt(position)
        _pictureList.value = list
    }

    private fun checkMain(picture: ProfilePicture): Boolean = picture.main

    private fun getUriResource(resId: Int): Uri =
        Uri.parse("android.resource://find.ui/$resId")
}
