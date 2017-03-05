#Kotlin Android
Demos for building android apps with kotlin.

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