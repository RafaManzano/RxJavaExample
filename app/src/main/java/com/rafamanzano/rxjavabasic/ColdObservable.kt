package com.rafamanzano.rxjavabasic

import android.util.Log
import com.rafamanzano.rxjavabasic.data.User
import com.rafamanzano.rxjavabasic.utils.mUserList
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable


fun coldObservable(): Observable<User> {
    return Observable.fromIterable(mUserList)
}

fun coldObserver(): Observer<User> {
    return object : Observer<User> {
        override fun onSubscribe(d: Disposable) {
            Log.d(TAG, "onSubscribe")
        }

        override fun onNext(t: User) {
            Log.d(TAG, "onNext: $t")
        }

        override fun onError(e: Throwable) {
            Log.d(TAG, "onError: $e")
        }

        override fun onComplete() {
            Log.d(TAG, "onComplete")
        }

    }
}