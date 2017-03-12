package test.demo.myapplication.okHttp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import okhttp3.*
import test.demo.myapplication.R
import java.io.IOException

class AsyncActivity : AppCompatActivity(), View.OnClickListener {
  private val TAG = AsyncActivity::class.java.simpleName
  private var _textView: TextView? = null
  private var _startButton: Button? = null

  private var _requestUrl = "https://api.github.com/"
  private var _client = OkHttpClient()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_async)

    _startButton = findViewById(R.id.startButton) as Button
    _textView = findViewById(R.id.textView) as TextView

    _startButton!!.setOnClickListener(this)
  }

  override fun onClick(v: View?) {
    try {
      startRequest()
    } catch(e: Exception) {
      e.printStackTrace()
    }
  }

  private fun startRequest() {
    var request = Request.Builder().url(_requestUrl).build()
    _client.newCall(request).enqueue(object : Callback {
      override fun onFailure(call: Call?, e: IOException?) {
        Log.i(TAG, "ERROR:- " + e!!.message)
        call!!.cancel()
      }

      override fun onResponse(call: Call?, response: Response?) {
        var gitResponse = response!!.body().string()
//        Log.i(TAG, "response :- " + response!!.body().string())
        this@AsyncActivity.runOnUiThread {
          this@AsyncActivity._textView!!.text = gitResponse + " " + response!!.code()
        }
      }
    })
  }
}
