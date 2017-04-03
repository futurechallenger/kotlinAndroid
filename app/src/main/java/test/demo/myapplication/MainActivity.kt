package test.demo.myapplication

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    private var _listView: ListView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        _listView = findViewById(R.id.listView) as ListView
        _listView!!.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayOf(
                "FrameLayout", "RelativeLayout", "ScrollView", "ListView", "Drawer",
                "Handler Message", "ok http", "share", "Light Sensor"
        ))
        _listView!!.setOnItemClickListener { _, _, position, _ ->
            var t: Intent? = null
            when (position) {
                0 -> t = Intent(this, FrameActivity::class.java)
                1 -> t = Intent(this, RelativeActivity::class.java)
                2 -> t = Intent(this, ScrollActivity::class.java)
                3 -> t = Intent(this, ListViewActivity::class.java)
                4 -> t = Intent(this, DrawerActivity::class.java)
                5 -> t = Intent(this, HandlerActivity::class.java)
                6 -> t = Intent(this, OKHttp3Activity::class.java)
                7 -> t = Intent(this, ShareActivity::class.java)
                8 -> t = Intent(this, LightSenorActivity::class.java)
            }

            if (t != null) {
                startActivity(t)
            }
        }
    }
}
