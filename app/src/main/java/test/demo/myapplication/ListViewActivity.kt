package test.demo.myapplication

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView

class ListViewActivity : AppCompatActivity() {

  private var _listView: ListView? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_list_view)

    _listView = findViewById(R.id.listView) as ListView
    _listView!!.adapter = CelebrityAdapter(arrayOf(
            Celebrity("Jack", "https://twitter/jack"),
            Celebrity("bruce", "https://twitter/bruce"),
            Celebrity("mike", "https://twitter/mike"),
            Celebrity("bill", "https://twitter/bill"),
            Celebrity("paul", "https://twitter/paul")
    ), this)
  }

  class CelebrityAdapter(var celebrityList: Array<Celebrity>, val context: Context) : BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
      var view: View? = null
      val viewHolder: ListRowHolder
      if (convertView == null) {
        view = LayoutInflater.from(context).inflate(R.layout.list_item, parent!!, false) as View
        viewHolder = ListRowHolder(view)
        view.tag = viewHolder
      } else {
        view = convertView
        viewHolder = view.tag as ListRowHolder
      }

      viewHolder.titleTextView.text = celebrityList.get(position).name
      viewHolder.subtitleTextView.text = celebrityList.get(position).twitter

      return view
    }

    override fun getItem(position: Int): Any {
      return celebrityList.get(position)
    }

    override fun getItemId(position: Int): Long {
      return position.toLong()
    }

    override fun getCount(): Int {
      return celebrityList.size
    }
  }

  private class ListRowHolder(row: View?) {
    public val titleTextView: TextView
    public val subtitleTextView: TextView

    init {
      this.titleTextView = row?.findViewById(R.id.textView) as TextView
      this.subtitleTextView = row?.findViewById(R.id.subtitleTextView) as TextView
    }
  }

  class Celebrity(var name: String, var twitter: String) {

  }
}
