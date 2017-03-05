package test.demo.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log

class HandlerActivity : AppCompatActivity() {
  private var _handler: Handler = object : Handler() {
    override fun handleMessage(msg: Message) = Unit
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_handler)
  }
}
