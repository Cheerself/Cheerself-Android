package com.cheerself.cheerself.utils.network

sealed class NetworkResponse<T>(
    val data: T? = null,
    val errMessage: String? = null
) {
    class SUCCESS<T>(data: T? = null, errMessage: String? = null): NetworkResponse<T>(data, errMessage)
    class ERROR<T>(errMessage: String? = null,data: T? = null): NetworkResponse<T>(data, errMessage)
    class LOADING<T>(): NetworkResponse<T>()
}
