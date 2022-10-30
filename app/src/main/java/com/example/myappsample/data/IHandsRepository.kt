package com.example.myappsample.data

interface IHandsRepository {
    fun loadHands(id: String?): Hands?
}