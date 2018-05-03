package link.standen.michael.website.helper

import android.content.Intent
import android.os.Build
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import link.standen.michael.website.MainActivity

class StickyWebViewClient(private val mainActivity: MainActivity) : WebViewClient() {

	override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			return if (request?.url?.host == MainActivity.HOST) {
				false
			} else {
				// Not my site, open browser
				mainActivity.startActivity(Intent(Intent.ACTION_VIEW, request?.url))
				true
			}
		}
		// Fallback
		return super.shouldOverrideUrlLoading(view, request)
	}

	/**
	 * Handle error loading
	 */
	override fun onReceivedError(view: WebView?, request: WebResourceRequest?, error: WebResourceError?) {
		mainActivity.showNoConnection()
		super.onReceivedError(view, request, error)
	}
}
