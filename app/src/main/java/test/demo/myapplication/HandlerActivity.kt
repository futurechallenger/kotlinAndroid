package test.demo.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import android.view.View
import java.util.*

class HandlerActivity : AppCompatActivity() {

  private var _timer = Timer()
  private var _handler: Handler = object : Handler() {
    override fun handleMessage(msg: Message) {
      if (msg.what == 0x123) {
        // do something
        Log.i("HandlerActivity", "handler message comes!")
      }
    }
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_handler)

    _timer.schedule(object : TimerTask() {
      override fun run() {
        _handler.sendEmptyMessage(0x123)
      }
    }, 0, 200)
  }

  public fun stopHandler(v: View?) {
    _timer.cancel()
  }
}
