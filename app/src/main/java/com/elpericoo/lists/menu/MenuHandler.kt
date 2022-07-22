package com.elpericoo.lists.menu

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.elpericoo.lists.R
import com.elpericoo.lists.databinding.ItemListBinding
import com.elpericoo.lists.views.config.ConfigActivity
import com.elpericoo.lists.views.listmanagement.JsonActivity
import com.elpericoo.lists.list.ListActivity
import com.elpericoo.lists.list.item.Item
import com.elpericoo.lists.views.login.LoginActivity

class MenuHandler constructor(val context:Context, val current: String) {
    var intent:Intent? = null

    fun itemHandler(item: MenuItem) {
        when (item.itemId) {
            R.id.configMenu -> openConfig(current)
            R.id.jsonMenu -> openJson(current)
            R.id.listMenu -> openList(current)
            R.id.loginMenu -> openLogin(current)
        }
    }

    private fun openConfig(current: String) {
        if (current == "config") {
            intent = null
        } else {
            intent = Intent(context, ConfigActivity::class.java)
        }
    }

    private fun openJson(current: String) {
        if (current == "json") {
            intent = null
        } else {
            intent = Intent(context, JsonActivity::class.java)
        }
    }

    private fun openList(current: String) {
        if (current == "list") {
            intent = null
        } else {
            intent = Intent(context, ListActivity::class.java)
        }
    }

    private fun openLogin(current: String) {
        if (current == "login") {
            intent = null
        } else {
            intent = Intent(context, LoginActivity::class.java)
        }
    }
}