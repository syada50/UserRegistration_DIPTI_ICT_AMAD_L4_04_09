package com.example.userregistration_dipti_ict_amad_l4_04_09



import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.userregistration_dipti_ict_amad_l4_04_09.R.layout.activity_main_dipti_ict_amad_l4_04_09

class MainActivity_DIPTI_ICT_AMAD_L4_04_09 : AppCompatActivity() {
    private lateinit var listButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main_dipti_ict_amad_l4_04_09)

        // Initialize the button for Profile List and set up the click event
        listButton = findViewById(R.id.profileListBtn)
        listButton.setOnClickListener {
            openLoadingActivity()
        }
    }

    // Open the loading activity and pass the target activity (ProfileListActivity)
    private fun openLoadingActivity() {
        val intent = Intent(this, LoadingActivity_DIPTI_ICT_AMAD_L4_04_09::class.java)
        intent.putExtra("TARGET_ACTIVITY", "com.example.userregistration_dipti_ict_amad_l4_04_09.ProfileListActivity_DIPTI_ICT_AMAD_L4_04_09")
        startActivity(intent)
    }
}