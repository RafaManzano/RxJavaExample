package com.rafamanzano.rxjavabasic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.rafamanzano.rxjavabasic.databinding.ActivityMainBinding
import com.rafamanzano.rxjavabasic.utils.mUserList
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.BackpressureStrategy
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.function.BiFunction

class MainActivity : AppCompatActivity() {

    val compositeDisposible = CompositeDisposable()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        region OPERATORS
//        justOperator()
//        fromOperator()
//        fromIterableOperator()
//        end region

//        rangeOperator().subscribe(
//            {
//                Log.d(TAG, "onNext: $it")
//            },
//            {
//                Log.d(TAG, "onError: $it")
//            },
//            {
//                Log.d(TAG, "onComplete")
//            }
//        )
//        repeatOperator().subscribe(
//            {
//                Log.d(TAG, "onNext: $it")
//            },
//            {
//                Log.d(TAG, "onError: $it")
//            },
//            {
//                Log.d(TAG, "onComplete")
//            }
//        )

//        intervalOperator().subscribe(
//            {
//                Log.d(TAG, "onNext: $it")
//                getLocation()
//            },
//            {
//                Log.d(TAG, "onError: $it")
//            },
//            {
//                Log.d(TAG, "onComplete")
//            }
//        )

//        timerOperator().subscribe(
//            {
//                Log.d(TAG, "onNext: $it")
//                getLocation()
//            },
//            {
//                Log.d(TAG, "onError: $it")
//            },
//            {
//                Log.d(TAG, "onComplete")
//            }
//        )
//
//        createOperator().subscribe(
//            {
//                Log.d(TAG, "onNext: $it")
//            },
//            {
//                Log.d(TAG, "onError: $it")
//            },
//            {
//                Log.d(TAG, "onComplete")
//            }
//        )

//        filterOperator()
//            .filter {
//                it.name == "demo1"
//            }
//            .subscribe(
//                {
//                    Log.d(TAG, "onNext: $it")
//                },
//                {
//                    Log.d(TAG, "onError: $it")
//                },
//                {
//                    Log.d(TAG, "onComplete")
//                }
//            )

//        lastOperator()
//            .last(User(0, "default", 0)) //Single
//            .lastElement() //Maybe
//            .lastOrError() //Single
//            .subscribe(
//                {
//                    Log.d(TAG, "onSuccess: $it")
//                },
//                {
//                    Log.d(TAG, "onError: $it")
//                }
//            )

//        distinctOperator()
////            .distinct { it.age }
//            .distinct()
//            .subscribe(
//                {
//                    Log.d(TAG, "onNext: $it")
//                },
//                {
//                    Log.d(TAG, "onError: $it")
//                },
//                {
//                    Log.d(TAG, "onComplete")
//                }
//            )

//        skipOperator()
//            .skip(2)
//            .distinct()
//            .skipLast(2)
//            .skip(1, TimeUnit.MILLISECONDS)
//            .subscribe(
//                {
//                    Log.d(TAG, "onNext: $it")
//                },
//                {
//                    Log.d(TAG, "onError: $it")
//                },
//                {
//                    Log.d(TAG, "onComplete")
//                }
//            )

//        bufferOperator()
//            .buffer(3)
//            .subscribe(
//                {
//                    Log.d(TAG, "onNext: $it")
//                },
//                {
//                    Log.d(TAG, "onError: $it")
//                },
//                {
//                    Log.d(TAG, "onComplete")
//                }
//            )

//        mapOperator()
////            .map { it.age * 2 }
//            .map {
//                UserProfile(it.id, it.name,it.age, "https://test.com/${it.id}")
//            }
//            .subscribe(
//                {
//                    Log.d(TAG, "onNext: $it")
//                },
//                {
//                    Log.d(TAG, "onError: $it")
//                },
//                {
//                    Log.d(TAG, "onComplete")
//                }
//            )

//        flatMapOperator()
//            .flatMap {
//                getUserProfile(it.id)
//            }
//            .subscribe(
//                {
//                    Log.d(TAG, "onNext: $it")
//                },
//                {
//                    Log.d(TAG, "onError: $it")
//                },
//                {
//                    Log.d(TAG, "onComplete")
//                }
//            )
//
//        flatMapOperatorTwo()
//            .flatMap {
//                Observable.fromIterable(it)
//            }
//            .flatMap {
//                getUserProfile(it.id)
//            }
//            .subscribe(
//                {
//                    Log.d(TAG, "onNext: $it")
//                },
//                {
//                    Log.d(TAG, "onError: $it")
//                },
//                {
//                    Log.d(TAG, "onComplete")
//                }
//            )

//        groupByOperator()
//            .groupBy {
//                it.age
//            }
//            .filter {
//                it.key == 15
//            }
//            .subscribe(
//                { group ->
//                    group.subscribe(
//                        {
//                            Log.d(TAG, "onSuccess")
//                            Log.d(TAG, "Key: ${group.key} - value: ${it}")
//                        },
//                        {
//                            Log.d(TAG, "onError: $it")
//                        }
//                    )
//
//                },
//                {
//                    Log.d(TAG, "onError: $it")
//                },
//                {
//                    Log.d(TAG, "onComplete")
//                }
//            )

//        groupByOperator()
//            .groupBy {
//                it.age
//            }
//            .flatMapSingle { group ->
//                group.toList()
//            }
//            .subscribe(
//                {
//                    Log.d(TAG, "onNext : $it")
//                },
//                {
//                    Log.d(TAG, "onError: $it")
//                },
//                {
//                    Log.d(TAG, "onComplete")
//                }
//            )

//        mergeOperator()
//            .subscribe(
//                {
//                    Log.d(TAG, "onNext: $it")
//                },
//                {
//                    Log.d(TAG, "onError: $it")
//                },
//                {
//                    Log.d(TAG, "onComplete")
//                }
//            )

//        concatOperator()
//            .subscribe(
//                {
//                    Log.d(TAG, "onNext: $it")
//                },
//                {
//                    Log.d(TAG, "onError: $it")
//                },
//                {
//                    Log.d(TAG, "onComplete")
//                }
//            )

//        startWithOperator()
//            .subscribe(
//                {
//                    Log.d(TAG, "onNext: $it")
//                },
//                {
//                    Log.d(TAG, "onError: $it")
//                },
//                {
//                    Log.d(TAG, "onComplete")
//                }
//            )

//        zipSimpleOperator()
//            .subscribe(
//                {
//                    Log.d(TAG, "onNext: $it")
//                },
//                {
//                    Log.d(TAG, "onError: $it")
//                },
//                {
//                    Log.d(TAG, "onComplete")
//                }
//            )
//
//        zipComplexOperator()
//            .subscribe(
//                {
//                    it.forEach {
//                        Log.d(TAG, "onNext: $it")
//                    }
//                },
//                {
//                    Log.d(TAG, "onError: $it")
//                },
//                {
//                    Log.d(TAG, "onComplete")
//                }
//            )
//        end region

//        region TYPES_OBSERVABLES
//        createObservable().subscribe(observerObservable())
//        createObservable().subscribe(
//            {
//                Log.d(TAG, "onNext: $it")
//            },
//            {
//                Log.d(TAG, "onError: $it")
//            },
//            {
//                Log.d(TAG, "onComplete")
//            }
//        )

//        createSingleObservable().subscribe(observerSingleObservable())
//        createSingleObservable().subscribe(
//            {
//                it.forEach {  user ->
//                    Log.d(TAG, "onSuccess: $user")
//                }
//            },
//            {
//                Log.d(TAG, "onError: $it")
//            }
//        )
//        createCompletableObservable().subscribe(observerCompletableObservable())
//
//        createFlowable()
//            .onBackpressureBuffer()
//            .observeOn(Schedulers.io(), false ,10)
//            .subscribe(
//            {
//                Log.d(TAG, "onNext: $it")
//            },
//            {
//                Log.d(TAG, "onError: $it")
//            },
//            {
//                Log.d(TAG, "onComplete")
//            }
//        )

        createFlowableObservable()
            .toFlowable(BackpressureStrategy.DROP)
            .observeOn(Schedulers.io(), false ,9)
            .subscribe(
                {
                    Log.d(TAG, "onNext: $it")
                },
                {
                    Log.d(TAG, "onError: $it")
                },
                {
                    Log.d(TAG, "onComplete")
                }
            )

//        end region

//        region SCHEDULERS

//        compositeDisposible.add(
//            createObservable()
//                .subscribeOn(Schedulers.io())
//                .subscribe(
//                {
//                    Log.d(TAG, "onNext: $it")
//                },
//                {
//                    Log.d(TAG, "onError: $it")
//                },
//                {
//                    Log.d(TAG, "onComplete")
//                }
//            )
//        )

//        compositeDisposible.add(
//            Observable.just(mUserList)
//                .flatMap {
//                    Log.d(TAG, "Upstream ThreadName: ${Thread.currentThread().name}")
//                    Observable.fromIterable(it)
//                }
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(
//                {
//                    binding.lbText.text = it.toString()
//                    Log.d(TAG, "onNext: $it ThreadName: ${Thread.currentThread().name}")
//                },
//                {
//                    Log.d(TAG, "onError: $it")
//                },
//                {
//                    Log.d(TAG, "onComplete")
//                }
//            )
//        )

//        end region

//        region COLD/hot OBSERVABLE
//        COLD
//        coldObservable().subscribe(coldObserver())
//        Thread.sleep(200)
//        coldObservable().subscribe(coldObserver())
//        Thread.sleep(300)
//        coldObservable().subscribe(coldObserver())

//        Hot
//        val hotObservable = hotObservable()
//        hotObservable.subscribe(
//                {
//                    Log.d(TAG, "onNext: $it")
//                },
//                {
//                    Log.d(TAG, "onError: $it")
//                },
//                {
//                    Log.d(TAG, "onComplete")
//                }
//            )
//
//        hotObservable.connect()

//        val hotObservable = hotObservableTwo()
//        hotObservable.connect()
//        hotObservable.subscribe(
//            {
//                Log.d(TAG, "onNext: $it")
//            },
//            {
//                Log.d(TAG, "onError: $it")
//            },
//            {
//                Log.d(TAG, "onComplete")
//            }
//        )
//        end region

//        region SUBJECT
//        asyncSubject()
//        asyncSubjectTwo()
//        behaviorSubject()
//        end region


    }

    override fun onDestroy() {
//        disposable.dispose()
        compositeDisposible.clear()
        Log.d(TAG, "onDestroy")
        super.onDestroy()
    }
}


