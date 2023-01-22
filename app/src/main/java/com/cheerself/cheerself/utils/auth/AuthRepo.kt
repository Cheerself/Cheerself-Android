package com.cheerself.cheerself.utils.auth

import com.cheerself.cheerself.utils.network.NetworkResponse
import com.google.firebase.auth.FirebaseUser

interface AuthRepo {
    val currentUser: FirebaseUser?
    suspend fun loginAEmployee(email: String): NetworkResponse<FirebaseUser>
    suspend fun loginAsEmployee(email: String): NetworkResponse<FirebaseUser>
    suspend fun login(email: String, password: String): NetworkResponse<FirebaseUser>
    suspend fun signup(email: String, password: String): NetworkResponse<FirebaseUser>
    fun logout()
}