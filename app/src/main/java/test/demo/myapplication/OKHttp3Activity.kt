package test.demo.myapplication

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import test.demo.myapplication.okHttp.AsyncActivity
import test.demo.myapplication.okHttp.QParamActivity
import test.demo.myapplication.okHttp.SyncActivity

class OKHttp3Activity : AppCompatActivity() {
  private val TAG = OKHttp3Activity::class.java.simpleName
  private var _listView: ListView? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_okhttp3)

    _listView = findViewById(R.id.listView) as ListView
    _listView!!.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
            listOf("synchronous", "asynchronous", "query parameters"))
    _listView!!.setOnItemClickListener { _, _, position, _ ->
      Log.i("YO", "item clicked " + position)
      var t: Intent? = null
      when (position) {
        0 -> {
          t = Intent(this, SyncActivity::class.java)
        }
        1 -> {
          t = Intent(this, AsyncActivity::class.java)
        }
        2 -> {
          t = Intent(this, QParamActivity::class.java)
        }
      }
      if(t == null) {
        Log.d(TAG, "intent is null!!!")
      }
      startActivity(t)
    }
  }
}
