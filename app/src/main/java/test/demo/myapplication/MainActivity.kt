package test.demo.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView

import test.demo.myapplication.RelativeActivity
import test.demo.myapplication.FrameActivity
import test.demo.myapplication.DrawerActivity

class MainActivity : AppCompatActivity() {

  private var _listView: ListView? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    _listView = findViewById(R.id.listView) as ListView
    _listView!!.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayOf(
            "FrameLayout", "RelativeLayout", "ScrollView", "ListView", "Drawer"
    ))
    _listView!!.setOnItemClickListener { parent, view, position, id ->
      var t: Intent? = null
      when (position) {
        0 -> t = Intent(this, FrameActivity::class.java)
        1 -> t = Intent(this, RelativeActivity::class.java)
        2 -> t = Intent(this, ScrollActivity::class.java)
        3 -> t = Intent(this, ListViewActivity::class.java)
        4 -> t = Intent(this, DrawerActivity::class.java)
      }

      if (t != null) {
        startActivity(t)
      }
    }
  }
}
