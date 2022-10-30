package com.example.myappsample.data

import com.squareup.moshi.Moshi

class DifficultiesRepository : IDifficultiesRepository{
    private val jsonNormal:String = "{\"id\":1,\"name\":\"Normal\"}"
    private val jsonImpossible:String = "{\"id\":2,\"name\":\"Impossible\"}"

    override fun loadDifficulties(id: String?): Difficulties? {
        val moshi = Moshi.Builder().build()

        val json = when (id) {
            "1" -> jsonNormal
            "2" -> jsonImpossible
            else -> null
        } ?: return null

        val jsonAdapter = moshi.adapter<Difficulties>(Difficulties::class.java)

        return jsonAdapter.fromJson(json)
    }
}