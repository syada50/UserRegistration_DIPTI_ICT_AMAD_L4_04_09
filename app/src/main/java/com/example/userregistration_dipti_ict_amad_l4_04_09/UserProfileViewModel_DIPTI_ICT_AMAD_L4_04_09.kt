package com.example.userregistration_dipti_ict_amad_l4_04_09



import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserProfileViewModel_DIPTI_ICT_AMAD_L4_04_09(application: Application) : AndroidViewModel(application) {
    private val repository: UserProfileRepository_DIPTI_ICT_AMAD_L4_04_09

    init {
        val userProfileDao = UserDatabase_DIPTI_ICT_AMAD_L4_04_09.getDatabase(application).userProfileDao()
        repository = UserProfileRepository_DIPTI_ICT_AMAD_L4_04_09(userProfileDao)
    }

    fun getUserProfiles(): LiveData<List<UserProfile_DIPTI_ICT_AMAD_L4_04_09>> {
        return repository.getUserProfiles()
    }

    fun insertUserProfile(userProfileDIPTIICTAMADL40409: UserProfile_DIPTI_ICT_AMAD_L4_04_09) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insert(userProfileDIPTIICTAMADL40409)
        }
    }

    fun updateUserProfile(userProfileDIPTIICTAMADL40409: UserProfile_DIPTI_ICT_AMAD_L4_04_09) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.update(userProfileDIPTIICTAMADL40409)
        }
    }

    fun deleteUserProfile(userProfileDIPTIICTAMADL40409: UserProfile_DIPTI_ICT_AMAD_L4_04_09) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.delete(userProfileDIPTIICTAMADL40409)
        }
    }
}