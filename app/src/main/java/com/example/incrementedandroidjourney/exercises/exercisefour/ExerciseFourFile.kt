package com.example.incrementedandroidjourney.exercises.exercisefour

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Inject


interface MyInterface {
    fun doSomething(): String
}

class MyInterfaceImpl @Inject constructor(): MyInterface {
    override fun doSomething() = "doing something"
}

@Module
@InstallIn(ActivityComponent::class)
abstract class MyModule {

    @Binds
    abstract fun bindMyInterface(myInterfaceImpl: MyInterfaceImpl): MyInterface
}