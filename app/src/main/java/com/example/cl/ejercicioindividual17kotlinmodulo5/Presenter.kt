package com.example.cl.ejercicioindividual17kotlinmodulo5

class Presenter(private val view: IViewPresenter) {

    private val modelo: Modelo = Modelo()

    fun convertirDivisas(
        monto: Double,
        divisaActual: String,
        divisaCambio: String
    ) {
        val result = modelo.conversorDivisas(monto, divisaActual, divisaCambio)
        view.showResult(result.toString())
    }
}