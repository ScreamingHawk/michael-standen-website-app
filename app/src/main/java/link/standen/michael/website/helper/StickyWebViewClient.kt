package link.standen.michael.website.helper

import android.os.Build
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import link.standen.michael.website.MainActivity

class StickyWebViewClient : WebViewClient() {

	override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			if (request?.url?.host == MainActivity.HOST) {
				return false
			}
		}
		return super.shouldOverrideUrlLoading(view, request)
	}
}
