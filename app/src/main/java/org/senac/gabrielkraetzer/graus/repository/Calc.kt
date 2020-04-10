package org.senac.gabrielkraetzer.graus.repository

class Calc(val C : Double, val F : Double) {

    fun getCelsius() : Double {
        return (F -32) / 1.8000
    }

    fun getFahrenheit() : Double{
        return  C * 1.8 + 32

    }

}