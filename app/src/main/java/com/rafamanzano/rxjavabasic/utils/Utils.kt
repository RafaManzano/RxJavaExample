package com.rafamanzano.rxjavabasic

import android.util.Log
import com.rafamanzano.rxjavabasic.data.Blog
import com.rafamanzano.rxjavabasic.data.BlogDetail
import com.rafamanzano.rxjavabasic.data.User
import com.rafamanzano.rxjavabasic.data.UserProfile
import com.rafamanzano.rxjavabasic.utils.mBlogList
import com.rafamanzano.rxjavabasic.utils.mUserList
import com.rafamanzano.rxjavabasic.utils.mUserProfileList
import io.reactivex.rxjava3.core.Observable

fun getLocation() {
//    Thread.sleep(2000)
    Log.d(TAG, "Latitude: 102.43 Longitude: 34.321")
}

fun getUserProfile(id: Long): Observable<UserProfile> {
    return Observable.fromIterable(mUserProfileList)
        .filter {
            it.id == id
        }
}

fun getUser(): Observable<User> {
    return Observable.fromIterable(mUserList)
}

fun getUserProfile(): Observable<UserProfile> {
    return Observable.fromIterable(mUserProfileList)
}

fun getNums1To100(): Observable<Int> {
    return Observable.range(1, 100)
}

fun getNums101To150(): Observable<Int> {
    return Observable.range(101, 50)
}

fun getBlog(): Observable<Blog> {
    return Observable.fromIterable(mBlogList)
}

fun getBlogs(): Observable<List<Blog>> {
    return Observable.just(mBlogList)
}

fun getUsers(): Observable<List<User>> {
    return Observable.just(mUserList)
}

fun blogDetail(listUsers: List<User>, listBlogs: List<Blog>): List<BlogDetail> {
    val listBlogDetail = emptyList<BlogDetail>().toMutableList()
    listUsers.forEach { user ->
        listBlogs.forEach { blog ->
            if (blog.userId == user.id) {
                listBlogDetail.add(BlogDetail(blog.id, blog.userId, blog.title, blog.content, user))
            }
        }
    }

    return listBlogDetail
}