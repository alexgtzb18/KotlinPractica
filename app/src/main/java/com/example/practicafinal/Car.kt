package com.example.practicafinal

open class Car {
    var name: String?
    var model: Int?
    var color: String?
    var type: String?

    constructor(name: String?, model: Int?, color: String?, type: String?) {
        this.name = name
        this.model = model
        this.color = color
        this.type = type
    }
}