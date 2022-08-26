package com.rafamanzano.rxjavabasic

import android.util.Log
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.AsyncSubject
import io.reactivex.rxjava3.subjects.BehaviorSubject
import java.util.concurrent.TimeUnit

fun asyncSubject() {
    val observable = Observable.interval(1, TimeUnit.SECONDS).takeWhile { it <= 5 }

    val subject = AsyncSubject.create<Long>()

    observable.subscribe(subject)

    subject.subscribe(
        {
            Log.d(TAG, "onNext1 $it")
        },
        {
            Log.d(TAG, "onError1 $it")
        },
        {
            Log.d(TAG, "onComplete1")
        }
    )

    subject.subscribe(
        {
            Log.d(TAG, "onNext2 $it")
        },
        {
            Log.d(TAG, "onError2 $it")
        },
        {
            Log.d(TAG, "onComplete2")
        }
    )
}

fun asyncSubjectTwo() {
    val subject = AsyncSubject.create<Int>()
    subject.onNext(1)

    subject.subscribe(
        {
            Log.d(TAG, "onNext $it")
        },
        {
            Log.d(TAG, "onError $it")
        },
        {
            Log.d(TAG, "onComplete")
        }
    )

    subject.onComplete()
}

fun behaviorSubject() {
    val observable = Observable.interval(1, TimeUnit.SECONDS).takeWhile { it <= 5 }

    val subject = BehaviorSubject.create<Long>()

    observable.subscribe(subject)

    subject.subscribe(
        {
            Log.d(TAG, "onNext1 $it")
        },
        {
            Log.d(TAG, "onError1 $it")
        },
        {
            Log.d(TAG, "onComplete1")
        }
    )

    subject.subscribe(
        {
            Log.d(TAG, "onNext2 $it")
        },
        {
            Log.d(TAG, "onError2 $it")
        },
        {
            Log.d(TAG, "onComplete2")
        }
    )


}

fun behaviorSubjectTwo() {
    val subject = BehaviorSubject.create<Int>()
    subject.onNext(1)

    subject.subscribe(
        {
            Log.d(TAG, "onNext $it")
        },
        {
            Log.d(TAG, "onError $it")
        },
        {
            Log.d(TAG, "onComplete")
        }
    )

    subject.onComplete()
}