package link.standen.michael.website

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

	companion object {
		private const val WEBSITE = "https://michael.standen.link"
	}

	@SuppressLint("SetJavaScriptEnabled")
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
		setContentView(R.layout.activity_main)

		web_view.settings.javaScriptEnabled = true
		web_view.isVerticalScrollBarEnabled = true
		web_view.isHorizontalScrollBarEnabled = true

		web_view.loadUrl(WEBSITE)
	}
}
