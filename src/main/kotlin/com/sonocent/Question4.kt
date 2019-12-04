package com.sonocent

interface Structure {
    fun getArea(): Int
}

class Square(val height: Int, val width: Int) : Structure {
    override fun getArea() = height * width
}

class Triangle(val base: Int, val height: Int) : Structure {
    override fun getArea() = base * height / 2
}
