package com.example.cl.ejercicioindividual17kotlinmodulo5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.cl.ejercicioindividual17kotlinmodulo5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), IViewPresenter {
    private lateinit var binding: ActivityMainBinding
    private val divisas = listOf("USD", "CLP", "EUR")

    private lateinit var presenter: Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = Presenter(this)

        initSpinners()

        initListener()
    }

    private fun initSpinners() {
        binding.spinnerUno.adapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_item, divisas)
        binding.spinnerDos.adapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_item, divisas)
    }

    private fun initListener() {
        binding.btnConvert.setOnClickListener(View.OnClickListener {
            val monto = binding.textViewEntrada.text.toString().toInt()
            val divisaActual = binding.spinnerUno.selectedItem.toString()
            val divisaCambio = binding.spinnerDos.selectedItem.toString()
            presenter.convertirDivisas(monto.toDouble(), divisaActual, divisaCambio).toString()
        })

        binding.btnReset.setOnClickListener(View.OnClickListener {
            limpiar()
        })
    }

    private fun limpiar() {
        binding.txtnumeroFInal.text = ""
        binding.textViewEntrada.setText("")
    }

    override fun showResult(result: String) {
        binding.txtnumeroFInal.text = result
    }
}