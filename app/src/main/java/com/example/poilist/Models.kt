package com.example.poilist

import java.io.Serializable

class AllStores(val stores: List<Store>)

class Store(val name: String, val phone: String, val storeLogoURL: String, val city: String, val state: String, val latitude: Double, val longitude: Double) : Serializable