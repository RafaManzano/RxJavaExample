package com.rafamanzano.rxjavabasic

import android.util.Log
import com.rafamanzano.rxjavabasic.data.User
import com.rafamanzano.rxjavabasic.utils.mUserEmptyList
import com.rafamanzano.rxjavabasic.utils.mUserList
import io.reactivex.rxjava3.core.*
import io.reactivex.rxjava3.disposables.Disposable
import org.reactivestreams.Subscriber
import java.lang.Exception
import java.util.concurrent.Flow

lateinit var disposable: Disposable

fun createObservable(): Observable<Int> {
    return Observable.create { emitter ->
        try {
            if (!emitter.isDisposed) {
                for (num in 0..100000000) {
                    emitter.onNext(num)
                }
                emitter.onComplete()
            }
        } catch (e: Exception) {
            emitter.onError(e)
        }

    }
}

fun observerObservable(): Observer<Int> {
    return object : Observer<Int> {
        override fun onSubscribe(d: Disposable) {
            d?.let { disposable = d  }
            Log.d(TAG, "onSubscribe")
        }

        override fun onNext(t: Int) {
            Log.d(TAG, "onNext: $t")
        }

        override fun onError(e: Throwable) {
            Log.d(TAG, "onError")
        }

        override fun onComplete() {
            Log.d(TAG, "onComplete")
        }

    }
}

fun createSingleObservable(): Single<List<User>> {
    return Single.create { emitter ->
        try {
            if (!emitter.isDisposed) {
                emitter.onSuccess(mUserList)
            }
        } catch (e: Exception) {
            emitter.onError(e)
        }

    }
}

fun observerSingleObservable(): SingleObserver<List<User>> {
    return object : SingleObserver<List<User>> {
        override fun onSubscribe(d: Disposable) {
            Log.d(TAG, "onSubscribe")
        }

        override fun onSuccess(t: List<User>) {
            t.forEach {
                Log.d(TAG, "onSuccess: $it")
            }

        }

        override fun onError(e: Throwable) {
            Log.d(TAG, "onError")
        }


    }
}

fun createCompletableObservable(): Completable {
    return Completable.create { emitter ->
        try {
            if (!emitter.isDisposed) {
                getLocation()
                emitter.onComplete()
            }
        } catch (e: Exception) {
            emitter.onError(e)
        }

    }
}

fun observerCompletableObservable(): CompletableObserver {
    return object : CompletableObserver {
        override fun onSubscribe(d: Disposable) {
            Log.d(TAG, "onSubscribe")
        }

        override fun onComplete() {
            Log.d(TAG, "onComplete")
        }

        override fun onError(e: Throwable) {
            Log.d(TAG, "onError")
        }

    }
}

fun createFlowable(): Flowable<Int> {
    return Flowable.range(1, 100)
}

fun createFlowableObservable(): Observable<Int> {
    return Observable.range(1, 100)
}