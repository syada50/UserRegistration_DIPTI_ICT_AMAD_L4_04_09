package com.example.userregistration_dipti_ict_amad_l4_04_09

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.userregistration_dipti_ict_amad_l4_04_09.R.layout.activity_loading_dipti_ict_amad_l4_04_09


class LoadingActivity_DIPTI_ICT_AMAD_L4_04_09 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_loading_dipti_ict_amad_l4_04_09)

        // Simulate loading or some processing time
        Handler(Looper.getMainLooper()).postDelayed({
            // Retrieve the target activity and user profile
            val targetActivityName = intent.getStringExtra("TARGET_ACTIVITY")
            val userProfileDIPTIICTAMADL40409 = intent.getSerializableExtra("USER_PROFILE") as UserProfile_DIPTI_ICT_AMAD_L4_04_09?

            // Navigate to the target activity
            val targetIntent = Intent()
            targetIntent.setClassName(this, targetActivityName ?: return@postDelayed)
            userProfileDIPTIICTAMADL40409?.let {
                targetIntent.putExtra("USER_PROFILE", it)
            }
            startActivity(targetIntent)
            finish() // Finish this activity so the user can't return to it
        }, 2000) // 3000 milliseconds = 3 seconds
    }
}