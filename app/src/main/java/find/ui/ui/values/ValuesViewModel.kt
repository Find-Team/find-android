package find.ui.ui.values

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ValuesViewModel : ViewModel() {
    private val _selectedTab = MutableLiveData(0)
    val selectedTab: LiveData<Int> = _selectedTab

    fun selectedTabButtonClick(diff: Int) {
        _selectedTab.value = requireNotNull(_selectedTab.value) + diff
    }

    fun selectedTabClick(position: Int) {
        _selectedTab.value = position
    }
}
