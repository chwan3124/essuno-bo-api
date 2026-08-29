package org.essuno.global.response

data class ApiResponse<T>(
    val success: Boolean,
    val message: String? = null,
    val data: T? = null
) {

    companion object {

        fun <T> success(data: T): ApiResponse<T> {
            return ApiResponse(
                success = true,
                data = data
            )
        }

        fun success(): ApiResponse<Unit> {
            return ApiResponse(
                success = true
            )
        }

        fun <T> fail(message: String): ApiResponse<T> {
            return ApiResponse(
                success = false,
                message = message
            )
        }
    }
}