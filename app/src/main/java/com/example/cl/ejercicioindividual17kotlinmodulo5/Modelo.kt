package com.example.cl.ejercicioindividual17kotlinmodulo5

class Modelo {

    fun conversorDivisas(
        monto: Double,
        divisaActual: String,
        divisaCambio: String
    ): Double {

        var resultado = monto
        when (divisaActual) {
            "USD" -> if (divisaCambio == "CLP") {
                resultado = monto * 817; } else if (divisaCambio == "USD") {

                resultado = monto * 1
            } else {
                resultado = monto * 0.89
            }

            "CLP" -> if (divisaCambio == "CLP") {
                resultado = monto * 1
            } else if (divisaCambio == "USD") {
                resultado = monto * 0.001
            } else {
                resultado = monto * 0.001
            }

            "EUR" -> if (divisaCambio == "CLP") {
                resultado = monto * 910
            } else if (divisaCambio == "USD") {
                resultado = monto * 1.11
            } else if (divisaCambio == "EUR") {
                resultado = monto * 1
            }


        }
        return resultado
    }
}