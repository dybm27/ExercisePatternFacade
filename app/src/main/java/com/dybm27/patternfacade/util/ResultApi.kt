package com.dybm27.patternfacade.util

data class ResultApi<out T>(
    val status: Status,
    val data: T?,
    val message: String?
) {

    enum class Status {
        SUCCESS,
        LOADING
    }

    companion object {
        fun <T> success(data: T?): ResultApi<T> {
            return ResultApi(Status.SUCCESS, data, null)
        }

        fun <T> loading(data: T? = null): ResultApi<T> {
            return ResultApi(Status.LOADING, data, null)
        }
    }

    override fun toString(): String {
        return "Result(status=$status, data=$data, message=$message)"
    }
}