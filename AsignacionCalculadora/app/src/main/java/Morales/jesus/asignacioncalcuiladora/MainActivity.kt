package Morales.jesus.asignacioncalcuiladora

/**
 * Practica 5
 * Nombre: Jesus Morales
 * ID: 00000245335
 */
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var opcionDeOperacion = 0
    var resultado = 0.0
    var textoDePanelPrincipal = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val panelPrincipal: TextView = findViewById(R.id.PanelPrincipal) as TextView
        val btn0: Button = findViewById(R.id.btn0) as Button
        val btn1: Button = findViewById(R.id.btn1) as Button
        val btn2: Button = findViewById(R.id.btn2) as Button
        val btn3: Button = findViewById(R.id.btn3) as Button
        val btn4: Button = findViewById(R.id.btn4) as Button
        val btn5: Button = findViewById(R.id.btn5) as Button
        val btn6: Button = findViewById(R.id.btn6) as Button
        val btn7: Button = findViewById(R.id.btn7) as Button
        val btn8: Button = findViewById(R.id.btn8) as Button
        val btn9: Button = findViewById(R.id.btn9) as Button
        val btnPunto: Button = findViewById(R.id.btnPunto) as Button
        val btnIgual: Button = findViewById(R.id.btnIgual) as Button
        val btnDivision: Button = findViewById(R.id.btnDivision) as Button
        val btnMultiplicacion: Button = findViewById(R.id.btnMultiplicacion) as Button
        val btnSumar: Button = findViewById(R.id.btnSumar) as Button
        val btnResta: Button = findViewById(R.id.btnResta) as Button
        val btnCe: Button = findViewById(R.id.btnCe) as Button
        val btnAbs: Button = findViewById(R.id.btnAbs) as Button

        btn0.setOnClickListener {
            textoDePanelPrincipal += "0"
            panelPrincipal.text = textoDePanelPrincipal
        }
        btn1.setOnClickListener {
            textoDePanelPrincipal += "1"
            panelPrincipal.text = textoDePanelPrincipal
        }
        btn2.setOnClickListener {
            textoDePanelPrincipal += "2"
            panelPrincipal.text = textoDePanelPrincipal
        }
        btn3.setOnClickListener {
            textoDePanelPrincipal += "3"
            panelPrincipal.text = textoDePanelPrincipal
        }
        btn4.setOnClickListener {
            textoDePanelPrincipal += "4"
            panelPrincipal.text = textoDePanelPrincipal
        }
        btn5.setOnClickListener {
            textoDePanelPrincipal += "5"
            panelPrincipal.text = textoDePanelPrincipal
        }
        btn6.setOnClickListener {
            textoDePanelPrincipal += "6"
            panelPrincipal.text = textoDePanelPrincipal
        }
        btn7.setOnClickListener {
            textoDePanelPrincipal += "7"
            panelPrincipal.text = textoDePanelPrincipal
        }
        btn8.setOnClickListener {
            textoDePanelPrincipal+= "8"
            panelPrincipal.text = textoDePanelPrincipal
        }
        btn9.setOnClickListener {
            textoDePanelPrincipal+= "9"
            panelPrincipal.text = textoDePanelPrincipal
        }
        btnPunto.setOnClickListener {
            textoDePanelPrincipal+= "."
            panelPrincipal.text = textoDePanelPrincipal
        }
        btnIgual.setOnClickListener {
            resultado = hacerOperacion()
            textoDePanelPrincipal = resultado.toString()
            panelPrincipal.text = textoDePanelPrincipal
        }
        btnDivision.setOnClickListener {

            opcionDeOperacion = 2
            textoDePanelPrincipal += "/"
            panelPrincipal.text = textoDePanelPrincipal
        }
        btnMultiplicacion.setOnClickListener {

            opcionDeOperacion = 3
            textoDePanelPrincipal += "*"
            panelPrincipal.text = textoDePanelPrincipal
        }
        btnSumar.setOnClickListener {

            opcionDeOperacion = 4
            textoDePanelPrincipal += "+"
            panelPrincipal.text = textoDePanelPrincipal
        }
        btnResta.setOnClickListener {

            opcionDeOperacion = 5
            textoDePanelPrincipal += "-"
            panelPrincipal.text = textoDePanelPrincipal

        }
        btnCe.setOnClickListener {
            if (operadorYaEscrito()){
                hacerOperacion()
            }
            resultado = 0.0
            textoDePanelPrincipal = ""
            panelPrincipal.text = textoDePanelPrincipal
        }

    }

    fun operadorYaEscrito(): Boolean {
        return opcionDeOperacion == 0
    }

    fun hacerOperacion(): Double {
        val partes = textoDePanelPrincipal.split(Regex("[+*/-]"))
        return when{
            opcionDeOperacion == 2 -> {

                partes.get(0).toDouble() / partes.get(1).toDouble()
            }
            opcionDeOperacion == 3 -> {

                partes.get(0).toDouble() * partes.get(1).toDouble()
            }
            opcionDeOperacion == 4 -> {
                partes.get(0).toDouble() + partes.get(1).toDouble()
            }
            opcionDeOperacion == 5 -> {
                partes.get(0).toDouble() - partes.get(1).toDouble()
            }else -> {
                0.0
            }
        }
    }

}