package test.demo.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ScrollView

class ScrollActivity : AppCompatActivity(), View.OnClickListener {

  private var _scrollView: ScrollView? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_scroll)

    _scrollView = findViewById(R.id.scrollView) as ScrollView
  }

  //TODO: later for ListView & ScrollView
  override fun onClick(v: View?) {

  }
}
