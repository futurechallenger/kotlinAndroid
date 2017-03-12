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

class QParamActivity : AppCompatActivity(), View.OnClickListener {
  private val TAG = QParamActivity::class.java.simpleName

  private var _startButton: Button? = null
  private var _textView: TextView? = null

  private var _requestUrl = "https://api.github.com/"
  private val _httpClient = OkHttpClient()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_qparam)

    _textView = findViewById(R.id.textView) as TextView
    _startButton = findViewById(R.id.button) as Button
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
    // url with query parameter
    var urlBuilder = HttpUrl.parse(_requestUrl).newBuilder()
    urlBuilder.addQueryParameter("username", "octocat")
    var url = urlBuilder.build().toString()

    // headers & post
    var request = Request.Builder()
            .header("Content-Type", "application/json")
            .method("post", RequestBody.create(null, ""))
            .url(url)
            .build()


    _httpClient.newCall(request).enqueue(object : Callback {
      override fun onFailure(call: Call?, e: IOException?) {
        Log.d(TAG, "ERROR:- " + e!!.message)
        call!!.cancel()
      }

      override fun onResponse(call: Call?, response: Response?) {
        var res = response!!.body().string()
        this@QParamActivity.runOnUiThread {
          this@QParamActivity._textView!!.text = "code is - " + response!!.code() + " response is " + res
        }
      }
    })
  }
}
