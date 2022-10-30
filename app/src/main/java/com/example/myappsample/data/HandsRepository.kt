package com.example.myappsample.data

import com.squareup.moshi.Moshi

class HandsRepository : IHandsRepository {
    private val jsonRock:String = "{\"id\":1,\"name\":\"Rock\"}"
    private val jsonPaper:String = "{\"id\":2,\"name\":\"Paper\"}"
    private val jsonScissor:String = "{\"id\":3,\"name\":\"Scissor\"}"

    override fun loadHands(id: String?): Hands? {
        val moshi = Moshi.Builder().build()

        val json = when (id) {
            "1" -> jsonRock
            "2" -> jsonPaper
            "3" -> jsonScissor
            else -> null
        } ?: return null

        val jsonAdapter = moshi.adapter<Hands>(Hands::class.java)

        return jsonAdapter.fromJson(json)
    }

}