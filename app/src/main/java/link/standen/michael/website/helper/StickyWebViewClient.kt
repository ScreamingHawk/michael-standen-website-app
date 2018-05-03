package link.standen.michael.website.helper

import android.content.Context
import android.content.Intent
import android.os.Build
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import link.standen.michael.website.MainActivity

class StickyWebViewClient(private val context: Context) : WebViewClient() {

	override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			return if (request?.url?.host == MainActivity.HOST) {
				false
			} else {
				// Not my site, open browser
				context.startActivity(Intent(Intent.ACTION_VIEW, request?.url))
				true
			}
		}
		// Fallback
		return super.shouldOverrideUrlLoading(view, request)
	}
}
