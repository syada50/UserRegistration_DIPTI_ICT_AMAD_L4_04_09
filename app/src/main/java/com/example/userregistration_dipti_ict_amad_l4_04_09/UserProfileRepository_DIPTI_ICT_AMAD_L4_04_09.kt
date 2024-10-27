package com.example.userregistration_dipti_ict_amad_l4_04_09



import androidx.lifecycle.LiveData

class UserProfileRepository_DIPTI_ICT_AMAD_L4_04_09(private val userProfileDaoDIPTIICTAMADL40409: UserProfileDao_DIPTI_ICT_AMAD_L4_04_09) {
    fun getUserProfiles(): LiveData<List<UserProfile_DIPTI_ICT_AMAD_L4_04_09>> {
        return userProfileDaoDIPTIICTAMADL40409.getAllUserProfiles()
    }

    suspend fun insert(userProfileDIPTIICTAMADL40409: UserProfile_DIPTI_ICT_AMAD_L4_04_09) {
        userProfileDaoDIPTIICTAMADL40409.insert(userProfileDIPTIICTAMADL40409)
    }


    suspend fun update(userProfileDIPTIICTAMADL40409: UserProfile_DIPTI_ICT_AMAD_L4_04_09) {
        userProfileDaoDIPTIICTAMADL40409.update(userProfileDIPTIICTAMADL40409)
    }

    suspend fun delete(userProfileDIPTIICTAMADL40409: UserProfile_DIPTI_ICT_AMAD_L4_04_09) {
        userProfileDaoDIPTIICTAMADL40409.delete(userProfileDIPTIICTAMADL40409)
    }
}
