package com.example.kooassignment.data

data class DataList(
    val data: List<Data>,
    val meta: Meta
)

data class Data(
    val body: String,
    val id: Int,
    val title: String,
    val user_id: Int
)

data class Meta(
    val pagination: Pagination
)

data class Pagination(
    val limit: Int,
    val links: Links,
    val page: Int,
    val pages: Int,
    val total: Int
)

data class Links(
    val current: String,
    val next: String,
    val previous: Any
)

