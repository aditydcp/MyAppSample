package com.example.myappsample.data

interface IDifficultiesRepository {
    fun loadDifficulties(id: String?): Difficulties?
}