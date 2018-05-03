package link.standen.michael.website

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.Window
import kotlinx.android.synthetic.main.activity_main.*
import link.standen.michael.website.helper.StickyWebViewClient

class MainActivity : AppCompatActivity() {

	companion object {
		const val HOST = "michael.standen.link"
		private const val WEBSITE = "https://$HOST"
	}

	@SuppressLint("SetJavaScriptEnabled")
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
		setContentView(R.layout.activity_main)

		web_view.settings.javaScriptEnabled = true
		web_view.isVerticalScrollBarEnabled = true
		web_view.isHorizontalScrollBarEnabled = true

		web_view.webViewClient = StickyWebViewClient(this)

		web_view.loadUrl(WEBSITE)
	}

	/**
	 * Handle back navigation
	 */
	override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
		if ((keyCode == KeyEvent.KEYCODE_BACK) && web_view.canGoBack()){
			web_view.goBack()
			return true
		}
		return super.onKeyDown(keyCode, event)
	}
}
