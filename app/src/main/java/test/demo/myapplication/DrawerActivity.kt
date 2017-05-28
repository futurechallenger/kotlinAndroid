package test.demo.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class DrawerActivity : AppCompatActivity() {
  private var _listView: ListView? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_drawer)

    val datasource = listOf("Item 1", "Item 2", "Item 3")
    _listView = findViewById(R.id.listView) as ListView
    _listView!!.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datasource)
    _listView!!.setOnItemClickListener { _, _, position, _ ->
      Toast.makeText(this, datasource[position], Toast.LENGTH_SHORT).show()
    }
  }
}
