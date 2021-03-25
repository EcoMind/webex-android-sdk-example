package com.ciscowebex.androidsdk.kitchensink.auth

import android.webkit.WebView
import com.ciscowebex.androidsdk.Webex
import com.ciscowebex.androidsdk.auth.JWTAuthenticator
import com.ciscowebex.androidsdk.auth.OAuthWebViewAuthenticator
import com.ciscowebex.androidsdk.CompletionHandler
import com.ciscowebex.androidsdk.auth.OAuthAuthenticator
import io.reactivex.Observable
import io.reactivex.Single

class LoginRepository() {
    fun authorizeOAuth(loginWebview: WebView, oAuthAuthenticator: OAuthWebViewAuthenticator): Observable<Boolean> {
        return Single.create<Boolean> { emitter ->
            oAuthAuthenticator.authorize(loginWebview, CompletionHandler { result ->
                if (result.error != null) {
                    emitter.onError(Throwable(result.error?.errorMessage))
                } else {
                    emitter.onSuccess(result.isSuccessful)
                }
            })
        }.toObservable()
    }

    fun attemptToLoginWithCachedUser(webex: Webex): Observable<Boolean> {
        return Single.create<Boolean> { emitter ->
            webex.attemptToLoginWithCachedUser(CompletionHandler { result ->
                if (result.error != null) {
                    emitter.onError(Throwable(result.error?.errorMessage))
                } else {
                    emitter.onSuccess(result.isSuccessful)
                }
            })
        }.toObservable()
    }

    fun loginWithJWT(token: String, jwtAuthenticator: JWTAuthenticator): Observable<Boolean> {
        return Single.create<Boolean> { emitter ->
            jwtAuthenticator.authorize(token, CompletionHandler { result ->
                if (result.error != null) {
                    emitter.onError(Throwable(result.error?.errorMessage))
                } else {
                    emitter.onSuccess(result.isSuccessful)
                }
            })
        }.toObservable()
    }

    fun authorizeOAuthCode(code: String, oAuthAuthenticator: OAuthAuthenticator): Observable<Boolean> {
        return Single.create<Boolean> { emitter ->
            oAuthAuthenticator.authorize(code, CompletionHandler { result ->
                if (result.error != null) {
                    emitter.onError(Throwable(result.error?.errorMessage))
                } else {
                    emitter.onSuccess(result.isSuccessful)
                }
            })
        }.toObservable()
    }
}