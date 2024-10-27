package com.example.userregistration_dipti_ict_amad_l4_04_09

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface UserProfileDao_DIPTI_ICT_AMAD_L4_04_09 {
    @Insert
    suspend fun insert(userProfileDIPTIICTAMADL40409: UserProfile_DIPTI_ICT_AMAD_L4_04_09)

    @Update
    suspend fun update(userProfileDIPTIICTAMADL40409: UserProfile_DIPTI_ICT_AMAD_L4_04_09)

    @Delete
    suspend fun delete(userProfileDIPTIICTAMADL40409: UserProfile_DIPTI_ICT_AMAD_L4_04_09)

    @Query("SELECT * FROM user_profile")
    fun getAllUserProfiles(): LiveData<List<UserProfile_DIPTI_ICT_AMAD_L4_04_09>>
}