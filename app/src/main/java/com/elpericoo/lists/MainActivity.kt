package com.elpericoo.lists

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.elpericoo.lists.config.ConfigService
import com.elpericoo.lists.databinding.ActivityMainBinding
import com.elpericoo.lists.json.JsonActivity
import com.elpericoo.lists.list.ListActivity
import com.elpericoo.lists.login.LoginActivity

class MainActivity : AppCompatActivity() {
    private lateinit var _binding:ActivityMainBinding
    private val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val config = ConfigService(this)
        
        if (config.getFirebaseActive()) {
            //TODO gestionar que hacer si está activo el modo Firebase
        } else {
            val defaultFile = config.getDefaultFileName()
            if (defaultFile.isNullOrBlank()) {
                startActivity(Intent(this, JsonActivity::class.java))
            } else {
                val intent = Intent(this, ListActivity::class.java)
                intent.putExtra("fileName", defaultFile)
                startActivity(intent)
            }
        }
  
    }
}
