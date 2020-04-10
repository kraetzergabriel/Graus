package org.senac.gabrielkraetzer.graus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import org.senac.gabrielkraetzer.graus.repository.Calc

class MainActivity : AppCompatActivity() {

    private lateinit var btC : Button
    private lateinit var edC : EditText
    private lateinit var edF : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edC = findViewById(R.id.edCelsius)
        edF = findViewById(R.id.edFahrenheit)

        btC = findViewById(R.id.btCelsius)
        btC.setOnClickListener() {
            val celsius = edC.text.toString().toDouble()
            val fahrenheit = edF.text.toString().toDouble()
            val c = Calc(celsius,fahrenheit)

            executeDialog("${getString(R.string.txCelsius)}: ${edC.text} / ${getString(R.string.txFahrenheit)} ${String.format("%.2f", c.getFahrenheit())}\n" +
                    "${getString(R.string.txFahrenheit)}: ${edF.text} / ${getString(R.string.txCelsius)}: ${String.format("%.2f", c.getCelsius())}")
        }
    }

    private fun executeDialog(message : String) {
        AlertDialog.Builder(this)
            .setTitle(R.string.titleAlertDialog)
            .setMessage(message)
            .setPositiveButton("OK") { dialog, which ->
                dialog.dismiss()
            }
            .show()
    }
}
