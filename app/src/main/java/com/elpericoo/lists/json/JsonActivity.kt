package com.elpericoo.lists.json

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.elpericoo.lists.R
import com.elpericoo.lists.databinding.ActivityJsonBinding
import menu.MenuHandler

class JsonActivity : AppCompatActivity() {
    private var  _binding: ActivityJsonBinding? = null
    private val binding get() = _binding!!

    private lateinit var jsonListAdapter: JsonListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityJsonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val jsonList = JsonService(this).readFileList()
        jsonListAdapter = JsonListAdapter(
            jsonList,
            { jsonItem,pos -> itemHandler(jsonItem, pos) },
            { jsonItem, pos -> deleteHandler(jsonItem, pos) }
        )

        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        binding.fileListContainer.layoutManager = layoutManager
        binding.fileListContainer.adapter = jsonListAdapter

        binding.createJsonBtn.setOnClickListener {
            createJsonHandler()
        }
    }
    //Menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var menuHandler = MenuHandler(this,"json")
        menuHandler.intemHandler(item)
        if (menuHandler.intent != null) {
            startActivity(menuHandler.intent)
        }
        return super.onOptionsItemSelected(item)
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun itemHandler(jsonItem: JsonItem, pos: Int) {
        val jsonService = JsonService(this)
        val prev = jsonService.getSelectedIndex(jsonListAdapter.jsonList)
        jsonService.selectFile(jsonListAdapter.jsonList, jsonItem)
        jsonListAdapter.notifyItemChanged(prev)
        jsonListAdapter.notifyItemChanged(pos)

    }
    private fun deleteHandler(jsonItem: JsonItem, pos: Int) {
        var jsonService = JsonService(this)
        jsonService.deleteFile(jsonItem)
        jsonListAdapter.jsonList = jsonService.readFileList()
        jsonListAdapter.notifyItemRemoved(pos)

    }

    private fun createJsonHandler(){
        val jsonService= JsonService(this)
        jsonService.createJsonFile(
            binding.jsonName.text.toString(),
            binding.exampleCheck.isChecked
        )
        binding.jsonName.setText("")
        val lastPos = jsonListAdapter.itemCount
        jsonListAdapter.jsonList = jsonService.readFileList()
        jsonListAdapter.notifyItemInserted(lastPos)

    }
}