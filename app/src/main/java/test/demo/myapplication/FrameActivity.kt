package test.demo.myapplication

import android.os.Handler
import android.os.Message
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class FrameActivity : AppCompatActivity() {

  internal var _handler: Handler = object : Handler() {
    override fun handleMessage(msg: Message) {
      if (msg.what == 0x123) {
        Toast.makeText(this@FrameActivity, "message handler", Toast.LENGTH_SHORT).show()
      }
    }
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_frame)
  }
}
