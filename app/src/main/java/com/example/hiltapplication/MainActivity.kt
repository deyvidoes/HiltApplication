package com.example.hiltapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.Provides
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    //field injection
    @Inject
    lateinit var someClass: SomeClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println(someClass.doAThing())
    }
}

//TODO: continue here https://www.youtube.com/watch?v=KI3L6d6Sm3Q
class SomeClass
@Inject
constructor(
    private val someInterfaceImplementation: SomeInterface //Cannot provide interface here
) {
    fun doAThing(): String {
        return "Look i got: ${someInterfaceImplementation.getAThing()}"
    }
}

class SomeInterfaceImplementation
@Inject
constructor() : SomeInterface {
    override fun getAThing(): String {
        return "A Thing"
    }
}

interface SomeInterface{
    fun getAThing(): String
}


//
//@AndroidEntryPoint
//class MyFragment: Fragment(){
//
//    @Inject
//    lateinit var someClass: SomeClass
//}
//
//
////dependency
//@ActivityScoped // if this was fragment code, it will give a compile time error because a fragment scoped cannot be injected to an activity
//class SomeClass
//@Inject
//constructor(
//    private val someOtherClass: SomeOtherClass //Constructor injection
//) {
//    fun doAThing(): String {
//        return "I did a thing"
//    }
//
//    fun doSomeOtherThing(): String {
//        return someOtherClass.doSomeOtherThing()
//    }
//}
//
////dependency
//class SomeOtherClass
//@Inject
//constructor() {
//
//    fun doSomeOtherThing(): String {
//        return "I did some other thing"
//    }
//}