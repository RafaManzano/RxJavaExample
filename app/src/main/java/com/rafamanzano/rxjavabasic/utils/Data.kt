package com.rafamanzano.rxjavabasic.utils

import com.rafamanzano.rxjavabasic.data.Blog
import com.rafamanzano.rxjavabasic.data.User
import com.rafamanzano.rxjavabasic.data.UserProfile

val mListNum = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
val arraysNum = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
val arraysNum2 = arrayOf(10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120)
val mUserList = mutableListOf(
    User(1, "demo1", 15),
    User(2, "demo2", 18),
    User(3, "demo3", 20),
    User(4, "demo4", 21),
    User(5, "demo5", 23),
    User(6, "demo6", 22),

)
val mUserEmptyList = emptyList<User>()
val mRepeatUserList = mutableListOf(
    User(1, "demo1", 15),
    User(2, "demo2", 15),
    User(3, "demo3", 20),
    User(4, "demo4", 21),
    User(5, "demo5", 22),
    User(6, "demo6", 22),
    User(1, "demo1", 15),
)
val mUserProfileList = mutableListOf(
    UserProfile(1, "demo1", 15, "https://test.com/1"),
    UserProfile(2, "demo2", 15, "https://test.com/2"),
    UserProfile(3, "demo3", 20, "https://test.com/3"),
    UserProfile(4, "demo4", 21, "https://test.com/4"),
    UserProfile(5, "demo5", 22, "https://test.com/5"),
    UserProfile(6, "demo6", 22, "https://test.com/6"),
    UserProfile(1, "demo1", 15, "https://test.com/1"),
)

val mBlogList = mutableListOf(
    Blog(1, 1, "title1","content1"),
    Blog(2, 1, "title2", "content2"),
    Blog(3, 2, "title1", "content1"),
    Blog(4, 2, "title2","content2"),
    Blog(5, 2, "title3","content3"),
    Blog(6, 3, "title1","content1"),
    Blog(7, 13, "title1","content1"),
)