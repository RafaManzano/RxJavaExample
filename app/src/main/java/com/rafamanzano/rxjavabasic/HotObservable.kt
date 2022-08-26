package com.rafamanzano.rxjavabasic

import android.util.Log
import com.rafamanzano.rxjavabasic.data.User
import com.rafamanzano.rxjavabasic.utils.mUserList
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.observables.ConnectableObservable
import java.util.concurrent.TimeUnit


fun hotObservable(): ConnectableObservable<User> {
    return Observable.fromIterable(mUserList).publish()
}

fun hotObservableTwo(): ConnectableObservable<Long> {
    return Observable.interval(1, TimeUnit.SECONDS).publish()
}

