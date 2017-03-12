package test.demo.myapplication.okHttp

import android.os.AsyncTask
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.TextView
import okhttp3.OkHttpClient
import okhttp3.Request
import test.demo.myapplication.R

class SyncActivity : AppCompatActivity(), View.OnClickListener {
  private val TAG = SyncActivity::class.java.simpleName

  private var _startButton: Button? = null
  private var _textView: TextView? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_sync)

    _startButton = findViewById(R.id.startButton) as Button
    _textView = findViewById(R.id.textView) as TextView
    _startButton!!.setOnClickListener(this)
  }

  override fun onClick(v: View?) {
    var okHttpTask = OKHttpTask(_textView!!)
    okHttpTask.execute("https://api.github.com/")
  }

  open class OKHttpTask(textView: TextView) : AsyncTask<String, Void, String>() {
    var client = OkHttpClient()
    private var httpTextView: TextView? = textView

    override fun doInBackground(vararg params: String?): String {
      var builder = Request.Builder()
      builder.url(params[0])
      var request = builder.build()

      try {
        var response = client.newCall(request).execute()
        return response.body().string()
      } catch (e: Exception) {
        e.printStackTrace()
      }

      return ""
    }

    override fun onPostExecute(result: String?) {
      super.onPostExecute(result)
      httpTextView!!.text = result
    }
  }
}
