package com.example.userregistration_dipti_ict_amad_l4_04_09



import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [UserProfile_DIPTI_ICT_AMAD_L4_04_09::class], version = 1)
abstract class UserDatabase_DIPTI_ICT_AMAD_L4_04_09 : RoomDatabase() {
    abstract fun userProfileDao(): UserProfileDao_DIPTI_ICT_AMAD_L4_04_09

    companion object {
        @Volatile
        private var INSTANCE: UserDatabase_DIPTI_ICT_AMAD_L4_04_09? = null

        fun getDatabase(context: Context): UserDatabase_DIPTI_ICT_AMAD_L4_04_09 {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase_DIPTI_ICT_AMAD_L4_04_09::class.java,
                    "user_profile_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}