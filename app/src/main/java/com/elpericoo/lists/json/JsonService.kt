package com.elpericoo.lists.json

import android.content.ClipData
import android.content.Context
import android.util.Log
import com.elpericoo.lists.list.ListService
import com.elpericoo.lists.list.item.Item
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.json.JSONArray
import java.io.File

class JsonService(val context: Context) {
    val folderName = "JSONs"
    val fileExtension = ".json"

        fun createJsonFile(name: String, copyExample: Boolean) {
            Log.d("debug", "CREA NUEVO JSON" + name)
            //TODO crear un nuevo fichero JSON

            var list = mutableListOf<Item>()

            if (copyExample) {
                list = getListFromExample()
            }

            //TODO validate name, validate if file exist...
            val folder = File(context.filesDir, folderName)
            folder.mkdir()

            val file = File(folder, name + fileExtension)
            file.createNewFile()

            val gson = GsonBuilder().setPrettyPrinting().create()
            val json = Gson().toJson(list)
            file.writeText(json)

        }

        fun readFileList():List<JsonItem> {
            val files = mutableListOf<JsonItem>()
            val folder = File(context.filesDir, folderName)
            folder.walk().forEach{
                if (!it.isDirectory) {
                    val item = JsonItem(it.nameWithoutExtension)
                    files.add(item)
                }
            }
            return files
        }

        fun updateFile(jsonfile: JsonFile) {}

        fun deleteFile(fileName: String){
            val folder = File(context.filesDir, folderName)
            val file = File(folder, fileName + fileExtension)
            file.delete()
        }
        fun selectFile(list: List<JsonItem>, item:JsonItem) {
            list.forEach{
                it.selected = it.name == item.name
            }
        }
        fun getSelectedIndex(list: List<JsonItem>):Int {
            return list.indexOfFirst { jsonItem -> jsonItem.selected }
        }

        private fun getListFromExample():MutableList<Item> {
            val file = context.assets.open("example.json")
            val jsonArray = JSONArray(file.bufferedReader().use {
                it.readText()
            })
            val list = ListService(context).parseJson(jsonArray)
            return list
        }

    }
