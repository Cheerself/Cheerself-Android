package com.cheerself.cheerself.utils.auth

import android.content.ContentValues.TAG
import android.util.Log
import com.cheerself.cheerself.BuildConfig
import com.cheerself.cheerself.utils.await
import com.cheerself.cheerself.utils.network.NetworkResponse
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.actionCodeSettings
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class AuthRepoImpl(
    private val firebaseAuth: FirebaseAuth
) : AuthRepo {
    override val currentUser: FirebaseUser?
        get() = firebaseAuth.currentUser

    override suspend fun loginAEmployee(email: String): NetworkResponse<FirebaseUser> {
//        val packageName = BuildConfig.APPLICATION_ID
//
//        val actionCodeSettings = actionCodeSettings {
//            url = "changeIt.com"
//            handleCodeInApp = true
//            setAndroidPackageName(
//                packageName,
//                true,
//                "69"
//            )
//        }
//        try {
//            val result = Firebase.auth.sendSignInLinkToEmail(email, actionCodeSettings)
//                .addOnCompleteListener { task ->
//                    if (task.isSuccessful) {
//                        Log.d(TAG, "Email sent.")
//                    }
//                }.await()
//            NetworkResponse.SUCCESS(result)
//        } catch (e: Exception) {
//            e.printStackTrace()
//            NetworkResponse.ERROR(e)
//        }
        TODO("Not yet implemented")
    }

    override suspend fun loginAsEmployee(email: String): NetworkResponse<FirebaseUser> {
        val auth = Firebase.auth
        val emailLink = ""
        return try {
            val someEmail = ""
            val result =  auth.signInWithEmailLink(email, emailLink).addOnCompleteListener {
                Log.d(TAG, "Successfully signed in with email link!")
            }.await()
            NetworkResponse.SUCCESS(result.user!!)
        } catch (e: Exception) {
            e.printStackTrace()
            NetworkResponse.ERROR(e.localizedMessage)
        }


    }

    override suspend fun login(email: String, password: String): NetworkResponse<FirebaseUser> {
        TODO("Not yet implemented")
    }

    override suspend fun signup(email: String, password: String): NetworkResponse<FirebaseUser> {
        TODO("Not yet implemented")
    }

    override fun logout() {
        Firebase.auth.signOut()
    }
}