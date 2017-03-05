#Kotlin Android
Demos for building android apps with kotlin.

## ListView
A list view with `BaseAdapter` as its adapter. And handle list item click handler.
```kotlin
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
}
```
Customized `BaseAdapter` `CelebrityAdapter`. Optimize the list view performance with a *Row Holder* `ListRowHolder`.

## Handler
```kotlin
  private var _handler: Handler = object : Handler() {
    override fun handleMessage(msg: Message) {
      if(msg.what == 0x123) {
        // do something
      }
    }
  }
```