package com.example.pet_coctails

data class ApiResponse<T>(
    val data: T?,
    val metadata: MetaData?
)

data class MetaData(
    val code: Int?,
    val message: String?,
    val detail: String?
)