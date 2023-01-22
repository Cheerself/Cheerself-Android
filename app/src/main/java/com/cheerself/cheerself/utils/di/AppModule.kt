package com.cheerself.cheerself.utils.di

import com.cheerself.cheerself.utils.auth.AuthRepoImpl
import com.google.firebase.auth.FirebaseAuth
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

//@InstallIn(SingletonComponent::class)
//object AppModule {
//
//    @Provides
//    fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()
//
//    @Provides
//    fun providesAuthRepo(impl: AuthRepoImpl): AuthRepoImpl = impl
//}