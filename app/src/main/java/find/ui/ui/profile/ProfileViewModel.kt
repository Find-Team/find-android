package find.ui.ui.profile

import android.content.Context
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import find.ui.R

class ProfileViewModel : ViewModel() {
    private val _introLength = MutableLiveData("0/500")
    val introLength: LiveData<String> = _introLength

    private val _pickerList = MutableLiveData<Array<String>>()
    val pickerList: LiveData<Array<String>> = _pickerList

    val introContent = ObservableField<String>()
    val infoContent = ObservableField<String>()
    private lateinit var list: Array<String>

    fun setPickerList(context: Context, title: String) {
        when (title) {
            context.getString(R.string.profile_info_edu) ->
                list = arrayOf("고등학교", "전문대", "대학교", "대학원", "석사", "박사", "기타")

            context.getString(R.string.profile_info_mbti) ->
                list = arrayOf(
                    "ENTJ", "ENTP", "INTJ", "INTP", "ESTJ", "ESFJ", "ISTJ", "ISFJ",
                    "ENFJ", "ENFP", "INFJ", "INFP", "ESTP", "ESFP", "ISTP", "ISFP"
                )

            context.getString(R.string.profile_info_tall) -> {
                val tall = (145..190).toList()
                val tallList = tall.map { it.toString() }
                list = tallList.toTypedArray()
            }

            context.getString(R.string.profile_info_form) ->
                list = arrayOf("마른", "슬림", "보통", "근육질", "통통", "우람", "다소 볼륨", "글래머")

            context.getString(R.string.profile_info_smoke) ->
                list = arrayOf("절대 안 핌", "사교적 흡연가", "자주 핌")

            context.getString(R.string.profile_info_religion) ->
                list = arrayOf("종교없음", "개신교", "천주교", "불교", "원불교", "기타")

            context.getString(R.string.profile_info_married) ->
                list = arrayOf("미혼", "재혼")

            context.getString(R.string.profile_info_drink) ->
                list = arrayOf("마시지 않음", "사교적 음주가", "어느정도 즐기는편", "술자리를 즐김")
        }
        _pickerList.value = list
    }
}
