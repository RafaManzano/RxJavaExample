package com.rafamanzano.rxjavabasic

import android.util.Log
import com.rafamanzano.rxjavabasic.data.BlogDetail
import com.rafamanzano.rxjavabasic.data.User
import com.rafamanzano.rxjavabasic.utils.*
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.functions.BiFunction
import java.lang.Exception
import java.util.*
import java.util.concurrent.TimeUnit


fun justOperator() {
    val observable = Observable.just(mListNum)

    val observer = object : Observer<List<Int>> {
        override fun onSubscribe(d: Disposable) {
            Log.d(TAG, "onSubscribe")
        }

        override fun onNext(t: List<Int>) {
            Log.d(TAG, "onNext: $t")
        }

        override fun onError(e: Throwable) {
            Log.d(TAG, "onError: $e")
        }

        override fun onComplete() {
            Log.d(TAG, "onComplete")
        }


    }

    observable.subscribe(observer)
}

fun fromOperator() {
    val observable = Observable.fromArray(arraysNum, arraysNum2)

    val observer = object : Observer<Array<Int>> {
        override fun onSubscribe(d: Disposable) {
            Log.d(TAG, "onSubscribe")
        }

        override fun onNext(t: Array<Int>) {
            Log.d(TAG, "onNext: ${t.contentToString()}")
        }

        override fun onError(e: Throwable) {
            Log.d(TAG, "onError: $e")
        }

        override fun onComplete() {
            Log.d(TAG, "onComplete")
        }

    }

    observable.subscribe(observer)
}

fun fromIterableOperator() {
    val observable = Observable.fromIterable(mListNum)

    val observer = object : Observer<Int> {
        override fun onSubscribe(d: Disposable) {
            Log.d(TAG, "onSubscribe")
        }

        override fun onNext(t: Int) {
            Log.d(TAG, "onNext: $t")
        }

        override fun onError(e: Throwable) {
            Log.d(TAG, "onError: $e")
        }

        override fun onComplete() {
            Log.d(TAG, "onComplete")
        }

    }

    observable.subscribe(observer)

}

fun rangeOperator(): Observable<Int> {
    return Observable.range(5,10)
}

fun repeatOperator(): Observable<Int> {
    return Observable.range(1,10).repeat(2)
}

fun intervalOperator(): Observable<Long> {
    return Observable.interval(5,1, TimeUnit.SECONDS).takeWhile { value ->
        value <= 10
    }
}

fun timerOperator(): Observable<Long> {
    return Observable.timer(5, TimeUnit.SECONDS)
}

fun createOperator(): Observable<Int> {
    return Observable.create {
        try {
            for (num in mListNum) {
                it.onNext(num * 5)
            }

            it.onComplete()

        }
        catch (e: Exception) {
            it.onError(e)
        }
    }
}

fun filterOperator(): Observable<User> {
    return Observable.fromIterable(mUserList)
}

fun lastOperator(): Observable<User> {
    return Observable.fromIterable(mUserList)
}

fun distinctOperator(): Observable<User> {
    return Observable.fromIterable(mRepeatUserList)
}

fun skipOperator(): Observable<User> {
    return Observable.fromIterable(mRepeatUserList)
}

fun bufferOperator(): Observable<User> {
    return Observable.fromIterable(mUserList)
}

fun mapOperator(): Observable<User> {
    return Observable.fromIterable(mUserList)
}

fun flatMapOperator(): Observable<User> {
    return Observable.fromIterable(mUserList)
}

fun flatMapOperatorTwo(): Observable<List<User>> {
    return Observable.just(mUserList)
}

fun groupByOperator(): Observable<User> {
    return Observable.fromIterable(mRepeatUserList)
}

fun mergeOperator(): Observable<Any> {
    val listNum = listOf(1,2,3,4)
    val charList = listOf('a','b','c','d')
    return Observable.merge(Observable.just(listNum), Observable.just(charList))
}

fun concatOperator(): Observable<Int> {
    return getNums1To100().concatWith(getNums101To150())
}

fun startWithOperator(): Observable<User> {
//    return getNums101To150().startWith(getNums1To100())
    return getUser().startWith(Single.just(User(0, "demo0", 0)))
}

fun zipSimpleOperator(): Observable<Any> {
    val num = Observable.just(1,2,3,4,5)
    val char = Observable.just("a", "b", "c", "d")

    return Observable.zip(num, char) { valueNum, valueChar ->
        "$valueNum$valueChar"
    }
}

fun zipComplexOperator(): Observable<List<BlogDetail>> {
    return Observable.zip(getUsers(), getBlogs()) { t1, t2 ->
        blogDetail(t1, t2)
    }
}