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
Every 200 ms, send a message to handler:
```kotlin
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_handler)

    Timer().schedule(object : TimerTask() {
      override fun run() {
        _handler.sendEmptyMessage(0x123)
      }
    }, 0, 200)
  }
```

## OK Http 

You can do http request with `okHttp` library. It also brings *Connection Pool* and *cache*, *Gzip*, etc. It helps improve http requests. You can do sync and async http requests with okHttp.

### Sync request
```kotlin
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
```