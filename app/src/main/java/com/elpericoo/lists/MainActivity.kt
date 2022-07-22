package com.elpericoo.lists

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.elpericoo.lists.config.ConfigService
import com.elpericoo.lists.databinding.ActivityMainBinding
import com.elpericoo.lists.views.listmanagement.JsonActivity
import com.elpericoo.lists.list.ListActivity
import com.elpericoo.lists.views.login.LoginActivity
import com.elpericoo.lists.storage.StorageTypes
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var _binding:ActivityMainBinding
    private val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val config = ConfigService(this)
        var defaultList: String? = null



        //when (config.getSelectedStorage()) {
            when (config.getSelectedStorage()) {
            StorageTypes.FIREBASE -> {
                //TODO//startActivity(Intent(this, LoginActivity::class.java))
                val defaultList = config.getDefaultFirebaseNode()

            }

            else -> {//StorageTypes.LOCAL
                defaultList= config.getDefaultFileName()

            }
        }
        if (defaultList.isNullOrBlank()) {
            startActivity(Intent(this, JsonActivity::class.java))
        } else {
            startActivity(Intent(this, ListActivity::class.java)
            )
        }
/*       val database = Firebase.database("https://vidales-lists-default-rtdb.europe-west1.firebasedatabase.app/")
        val reference = database.getReference("message")
        reference.setValue("Goodbye World!")
*/
    }
}
